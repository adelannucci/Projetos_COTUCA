
#include <SD.h>
#include <Wire.h>
#include <LiquidCrystal.h>
#include <FreqCounter.h>
#include "RTClib.h"

#define SD_CARD_PIN_SS 53
#define TEMP_PIN_LM35 53
#define LDR_PIN 1

#define SEG 1000
#define MIN 60000
#define HOR 3600000

/*Variaveis para Controle Data*/
RTC_DS1307 RTC;
LiquidCrystal lcd(12, 11, 5, 4, 3, 2);

typedef struct
{
  unsigned short ano;
  unsigned short mes;
  unsigned short dia; 
}Data;
 
typedef struct
{
  unsigned short hora;
  unsigned short minuto;
  unsigned short seg;
}Time;
 
typedef struct
{
  Data data;
  Time time;  
}DataHora;
 
typedef struct
{
  DataHora dataHora;
  float humidade;
  float radiacaoSolar;
  float temperatura;
  char dataInfo[16];
  char dadoInfo[16];
}Dados;

typedef struct
{
  int sens;
  int freq;
  int offset;
}Frequencia;
 
Frequencia hz;
Time alarme;
Time contador;
Dados dados;
 
void setup()
{
   // Abre a porta serial, espera ate que ela esteja disponivel:
   Serial.begin(9600);
   Wire.begin();
   lcd.begin(16, 2);
   
   inicializarRTC();
   hz.sens    =  i2cRead2bytes(81, 10); //Read sensitivity from EEPROM
   hz.offset  =  i2cRead2bytes(81, 12); //Same for offset
   //ajustarDataHora(2012,10,23,01,58,0);
   inicializarSDCard();
   coletorDeDados();
   
}


//Loop Principal
void loop()
{

  coletorDeDados();
  salvarNoArquivo(gerarBuff());
  Serial.println(gerarBuff());
  printDados();

  delay(MIN);
}











