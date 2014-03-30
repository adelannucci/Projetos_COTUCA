void printDados()
{
  lcd.clear();
  lcd.setCursor(0, 0);
  lcd.print(dados.dataInfo);
  lcd.setCursor(0, 1);
  lcd.print(dados.dadoInfo);
}
