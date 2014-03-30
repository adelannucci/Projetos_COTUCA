
/* 
   SD card datalogger The circuit: UNO/MEGA2560
   MOSI - pin 11/51
   MISO - pin 12/50
   SCK  - pin 13/52
   SS   - pin 4/53
   VTG  - 3.3V	 
 */

//Inicializa o cartao de memoria
void inicializarSDCard(){
   lcd.print("Initializing SD card...");
   Serial.print("Initializing SD card...");
  //define o pin de output do sdcard
  pinMode(SD_CARD_PIN_SS, OUTPUT);
  
  // se o cartao nao estiver presente ou nao for possivel inicializa-lo
  lcd.setCursor(0, 1);
  if (!SD.begin(SD_CARD_PIN_SS)) {
    Serial.println("Card failed, or not present");
    lcd.print("Card failed, or not present");
    return;
  }
  Serial.println("card initialized."); 
  lcd.print("card initialized."); 
}

//Salva a informação no cartao de memoria
void salvarNoArquivo(String info)
{
  //Abre o Arquivo para leitura
  File dataFile = SD.open("dados.csv", FILE_WRITE);

  // verifica se o arquivo esta disponivel para escrita
  if (dataFile) {
    dataFile.println(info);
    dataFile.close();
  }  
  //Se nao tiver mostra a mensagem de erro
  else {
    lcd.setCursor(0, 1);
    lcd.println("error opening file");
    Serial.println("error opening file");
    //Serial.println(info);
  } 
}
