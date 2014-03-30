/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

/**
 *
 * @author
 */
public class GestureRecognizer {
    // constants returned from getGesture()
    private static final int NONE        = 0;
    public static final int TAP          = 1;
    public static final int TAP_N_HOLD   = 2;
    public static final int DRAG_UP      = 3;
    public static final int DRAG_DOWN    = 4;
    public static final int DRAG_LEFT    = 5;
    public static final int DRAG_RIGHT   = 6;
    public static final int CIRCLE_CLOCK = 7;
    public static final int CIRCLE_ANTI  = 8;
    public static final int UNKNOWN      = 9;
 
    // any movement smaller than this is ignored (treated as "tap" not "drag")
    private static final int DRAG_THRESHOLD = 4;
 
    // minimum milliseconds for a "hold"
    private static final int HOLD_THRESHOLD = 500;
 
    // PDX = positive delta X, NDY = negative delta Y, etc.
    private static final int SEEN_PDX_PDY = 1 << 0;
    private static final int SEEN_NDX_PDY = 1 << 1;
    private static final int SEEN_NDX_NDY = 1 << 2;
    private static final int SEEN_PDX_NDY = 1 << 3;
    private static final int SEEN_PDX     = 1 << 4;
    private static final int SEEN_NDX     = 1 << 5;
    private static final int SEEN_PDY     = 1 << 6;
    private static final int SEEN_NDY     = 1 << 7;
 
    private static final int SEEN_ALL = SEEN_PDX | SEEN_NDX | SEEN_PDY | SEEN_NDY;
 
    private long startTime;
    private int startX;
    private int startY;
    private int lastX;
    private int lastY;
    private int minX;
    private int minY;
    private int maxX;
    private int maxY;
    private int seen;
    private int[] sequence = new int[4];
    private int sequenceIndex;
    private int gesture;
 
    /** Create recognizer, with starting (x,y) */
    public GestureRecognizer(int x, int y) {
        startTime = System.currentTimeMillis();
        startX = lastX = minX = maxX = x;
        startY = lastY = minY = maxY = y;
    }
 
    /** Add (x,y) position to gesture sequence */
    public void addMotion(int newX, int newY) {
        checkIncomplete();
 
        int dx = newX - lastX;
        int dy = newY - lastY;
 
        int seenThisTime = 0;
 
        if (dx < -DRAG_THRESHOLD) {
            seenThisTime |= SEEN_NDX;
            lastX = newX;
            if (newX < minX) {
                minX = newX;
            }
        } else if (dx > DRAG_THRESHOLD) {
            seenThisTime |= SEEN_PDX;
            lastX = newX;
            if (newX > maxX) {
                maxX = newX;
            }
        }
 
        if (dy < -DRAG_THRESHOLD) {
            seenThisTime |= SEEN_NDY;
            lastY = newY;
            if (newY < minY) {
                minY = newY;
            }
        } else if (dy > DRAG_THRESHOLD) {
            seenThisTime |= SEEN_PDY;
            lastY = newY;
            if (newY > maxY) {
                maxY = newY;
            }
        }
 
        switch (seenThisTime) {
        case SEEN_PDX | SEEN_PDY:
            seenThisTime |= SEEN_PDX_PDY;
            addToSequence(SEEN_PDX_PDY);
            break;
        case SEEN_PDX | SEEN_NDY:
            seenThisTime |= SEEN_PDX_NDY;
            if (sequenceIndex > 0) {
                addToSequence(SEEN_PDX_NDY);
            }
            break;
        case SEEN_NDX | SEEN_PDY:
            seenThisTime |= SEEN_NDX_PDY;
            addToSequence(SEEN_NDX_PDY);
            break;
        case SEEN_NDX | SEEN_NDY:
            seenThisTime |= SEEN_NDX_NDY;
            if (sequenceIndex > 0) {
                addToSequence(SEEN_NDX_NDY);
            }
            break;
        }
 
        if (seenThisTime != 0) {
            seen |= seenThisTime;
        }        
    }
 
    /** End the gesture, with terminating (x,y) */
    public void endGesture(int endX, int endY) {
        addMotion(endX, endY);
 
        if (seen == 0) {
            if (System.currentTimeMillis() > startTime + HOLD_THRESHOLD) {
                gesture = TAP_N_HOLD;
            } else {
                gesture = TAP;
            }
        } else if ((seen & SEEN_ALL) != SEEN_ALL) {
            int dx = maxX - minX;
            int dy = maxY - minY;
 
            if ((seen & SEEN_NDY) != 0 && (seen & SEEN_PDY) == 0 && (dy > dx)) {
                gesture = DRAG_UP;
            }
 
            if ((seen & SEEN_PDY) != 0 && (seen & SEEN_NDY) == 0 && (dy > dx)) {
                gesture = DRAG_DOWN;
            }
 
            if ((seen & SEEN_NDX) != 0 && (seen & SEEN_PDX) == 0 && (dx > dy)) {
                gesture = DRAG_LEFT;
            }
 
            if ((seen & SEEN_PDX) != 0 && (seen & SEEN_NDX) == 0 && (dx > dy)) {
                gesture = DRAG_RIGHT;
            }
        } else {
            if (sequenceEquals(new int[] {SEEN_PDX_PDY, SEEN_NDX_PDY, SEEN_NDX_NDY, SEEN_PDX_NDY})) {
                gesture = CIRCLE_CLOCK;
            } else if (sequenceEquals(new int[] {SEEN_NDX_PDY, SEEN_PDX_PDY, SEEN_PDX_NDY, SEEN_NDX_NDY})) {
                gesture = CIRCLE_ANTI;
            }
        }
 
        if (gesture == NONE) {
            gesture = UNKNOWN;
        }
    }
 
    /** @return the gesture type */
    public int getGesture() {
        checkComplete();
        return gesture;
    }
 
    /** @return the "x" position for "tap" gestures */
    public int getTapX() {
        checkTap();
        return startX;
    }
 
    /** @return the "y" position for "tap" gestures */
    public int getTapY() {
        checkTap();
        return startY;
    }
 
    /** @return the left-x position for the area of a circular gesture */
    public int getAreaX() {
        checkArea();
        return minX;
    }
 
    /** @return the top-y position for the area of a circular gesture */
    public int getAreaY() {
        checkArea();
        return minY;
    }
 
    /** @return the width of the area of a circular gesture */
    public int getAreaWidth() {
        checkArea();
        return maxX - minX;
    }
 
    /** @return the height of the area of a circular gesture */
    public int getAreaHeight() {
        checkArea();
        return maxY - minY;
    }
 
    private void checkIncomplete() {
        if (gesture != NONE) {
            throw new IllegalStateException("gesture complete");
        }
    }
 
    private void checkComplete() {
        if (gesture == NONE) {
            throw new IllegalStateException("gesture not complete");
        }
    }
 
    private void checkTap() {
        checkComplete();
        if (gesture != TAP && gesture != TAP_N_HOLD) {
            throw new IllegalStateException("gesture not a tap");
        }
    }
 
    private void checkArea() {
        checkComplete();
        if (gesture != CIRCLE_CLOCK && gesture != CIRCLE_ANTI) {
            throw new IllegalStateException("gesture not an area");
        }
    }
 
    private boolean sequenceContains(int n) {
        boolean contains = false;
        for (int i = 0; i < sequenceIndex; i++) {
            if (sequence[i] == n) {
                contains = true;
            }
        }
        return contains;
    }
 
    private void addToSequence(int n) {
        if (!sequenceContains(n) && sequenceIndex < sequence.length) {
            System.out.println(sequenceIndex + ": " + n);
            sequence[sequenceIndex] = n;
            sequenceIndex++;
        }
    }
 
    private boolean sequenceEquals(int[] a) {
        boolean equals;
        if (sequenceIndex == a.length) {
            equals = true;
            for (int i = 0; i < sequenceIndex; i++) {
                if (sequence[i] != a[i]) {
                    equals = false;
                }
            }
        } else {
            equals = false;
        }
        return equals;
    }
}