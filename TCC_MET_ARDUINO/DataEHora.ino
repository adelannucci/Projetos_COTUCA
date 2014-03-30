
/* 
   RTC DS1307 The circuit:
   SDA - pin A4
   SCL - pin A5
   VTG - 5.0V	 
 */

void inicializarRTC(){
  RTC.adjust(DateTime(__DATE__, __TIME__));
}

void ajustarDataHora(int ano, int mes, int dia, int hora, int minuto, int segundo){
  RTC.adjust(DateTime(ano,mes,dia,hora,minuto,segundo)); 
}

void getDataHora(){
    DateTime now = RTC.now();
    //byte var;
    dados.dataHora.data.ano = (unsigned int)   now.year();
    dados.dataHora.data.mes = (unsigned short) now.month();
    dados.dataHora.data.dia = (unsigned short) now.day();
    
    dados.dataHora.time.hora   = (unsigned short) now.hour();
    dados.dataHora.time.minuto = (unsigned short) now.minute();
    dados.dataHora.time.seg    = (unsigned short) now.second();
}

//Define em qual horario sera realizada a proxima medicao dos sensores
void setAlarme()
{
  getDataHora();
  int up = 0;
  
  if(dados.dataHora.time.seg + contador.seg > 59)
  {
    //Se a soma dos segundos lidos do rtc com contador definido for maior que 60
    //Aciona a flag up que aumenta um minuto e guarda a diferenca no alarme.
    alarme.seg = dados.dataHora.time.seg + contador.seg - 60; 
    up = 1;
  }
  else
  {
    //Caso contrario somente guarda o lido no alarme
    alarme.seg  = dados.dataHora.time.seg + contador.seg; 
  }
  
  if(dados.dataHora.time.minuto + contador.minuto > 59)
  {
    alarme.minuto = dados.dataHora.time.minuto + contador.minuto - 60;
    if(up == 1)
    {
      alarme.minuto++;   
    }
    up = 1;
  }
  else
  {
    alarme.minuto = dados.dataHora.time.minuto + contador.minuto;
    if(up == 1)
    {
      alarme.minuto++;
      up = 0;   
    }
  }
  if(dados.dataHora.time.hora + contador.hora > 23)
  {
    alarme.hora = dados.dataHora.time.hora + contador.hora - 24; 
    if(up == 1)
    {
      alarme.hora++;   
    }
    up = 0;
  }
  else
  {
    alarme.hora = dados.dataHora.time.hora + contador.hora;
    if(up == 1)
    {
      alarme.hora++;   
    }
    up = 0;
  }
  //Serial.println("estou aqui");
}

char tocar()
{
  Serial.println("ALARME");
  Serial.print(alarme.hora);
  Serial.print(":");
  Serial.print(alarme.minuto);
  Serial.print(":");
  Serial.println(alarme.seg);
  Serial.println("Hora");
  Serial.print(dados.dataHora.time.hora);
  Serial.print(":");
  Serial.print(dados.dataHora.time.minuto);
  Serial.print(":");
  Serial.println(dados.dataHora.time.seg);
  
  if( dados.dataHora.time.hora == alarme.hora && dados.dataHora.time.minuto == alarme.minuto && dados.dataHora.time.seg == alarme.seg)
  {
    setAlarme();
    return 'S';
  }
  
  return 'N';
}







