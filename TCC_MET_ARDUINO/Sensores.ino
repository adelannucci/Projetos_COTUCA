
//Retorna a temperatura em graus celsius
void sensorTemperatura(){
  
  float temp = analogRead(TEMP_PIN_LM35);
  temp = analogRead(TEMP_PIN_LM35) * 0.09765625;
  dados.temperatura = temp; 
  //return temp; 
}

void sensorRadiacao(){
  dados.radiacaoSolar = analogRead(LDR_PIN);
}

void sensorHumidade(){
  
  float rh;
  
  //Get Frequency
  FreqCounter::f_comp= 8;             // Set compensation to 12
  FreqCounter::start(1000);            // Start counting with gatetime of 1000ms
  while (FreqCounter::f_ready == 0)         // wait until counter ready 
    hz.freq=FreqCounter::f_freq;            // read result
    
  //Calculate RH
  
  rh = (hz.offset-hz.freq); 
  rh = rh * hz.sens; 
  rh = (rh/4096);
  
  //corecao do calculo da rh
  //rh = rh*10 - 500;
  //rh = (hz.offset - hz.freq)*hz.sens/4096;
  dados.humidade = rh;
  //return rh;
}

int i2cRead2bytes(int deviceaddress, byte address)  
{
   // SET ADDRESS
   Wire.beginTransmission(deviceaddress);
   Wire.write(address); // address for sensitivity
   Wire.endTransmission();
  
   // REQUEST RETURN VALUE
   Wire.requestFrom(deviceaddress, 2);
   // COLLECT RETURN VALUE
   int rv = 0;
   for (int c = 0; c < 2; c++ )
   if (Wire.available()) rv = rv * 256 + Wire.read();
   return rv;
 }


//Realiza a leitura dos sensores 
void coletorDeDados(){
  getDataHora();
  sensorHumidade();
  sensorTemperatura();
  sensorRadiacao();
}


//Gera o buffer que contem as informações a serem salvas
String gerarBuff(){
  char buffData[17];
  char buffDado[17];
  char buff[33];
  int inteiro;
  int decimal;
  
  //Salva a data e hora no buff
  snprintf(buffData, sizeof(buffData), "%02u/%02u/%d;%02u:%02u:%02u",
  dados.dataHora.data.dia,
  dados.dataHora.data.mes,
  dados.dataHora.data.ano,
  dados.dataHora.time.hora,
  dados.dataHora.time.minuto,
  dados.dataHora.time.seg
  );
  
  snprintf(dados.dataInfo, sizeof(dados.dataInfo), "%s\0",buffData);
  // pega a parte inteira
  inteiro = (int)dados.temperatura;
  
  //Se a temperatura for positiva
  if(dados.temperatura>0){
    //pega a parte decimal
    decimal = (dados.temperatura - inteiro)*100;
  }
  else{
    //pega a parte decimal
    decimal = (dados.temperatura - inteiro)*(-100);
  }
  
  //Pega somente duas casas decimais
  if(decimal>99){
    decimal = (int)decimal/10;
  }
  
  //coloca no buff a parte inteira
  snprintf(buffDado, sizeof(buffDado), "%d",inteiro);

  //Se a temperatura for positiva
  if(dados.temperatura>0){
    //se a parte decimal for menor que 0.1 temos que adicionar um zero antes do valor decimal
    if((dados.temperatura - inteiro)<0.1){
      snprintf(buffDado, sizeof(buffDado), "%s.0%d",buffDado,decimal);
    }
    else{
      snprintf(buffDado, sizeof(buffDado), "%s.%d",buffDado,decimal);
    }
  }
  //Se a temperatura for negativa
  else{
    //se a parte decimal for menor que 0.1 temos que adicionar um zero antes do valor decimal
    if((dados.temperatura*(-1) - inteiro*(-1))<0.1){
      snprintf(buffDado, sizeof(buffDado), "%s.0%d",buffDado,decimal);
    }
    else{
      snprintf(buffDado, sizeof(buffDado), "%s.%d",buffDado,decimal);
    }
  }

  //adiciona \0 no final do buff
  snprintf(buffDado, sizeof(buffDado), "%s;%d",buffDado, (int)dados.humidade);
  snprintf(buffDado, sizeof(buffDado), "%s;%d\0",buffDado, (int)dados.radiacaoSolar);
  snprintf(dados.dadoInfo, sizeof(dados.dadoInfo), "%s",buffDado);
  snprintf(buff, sizeof(buff), "%s;%s",buffData,buffDado);
  
  return buff;
}

