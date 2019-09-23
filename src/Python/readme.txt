1 - Rodar o arquivo "downloadDODF_GUI.py" com as configurações padrões para baixar todos os DODFs relativos à Janeiro de 2019 (outros meses podem ocorrer problemas)

--> Os pdfs serão baixados na seguinte estrutura de pastas: "C:\TesteOCR\DODF\DODF downloads\2019\01"
--> Para cada pdf será gerado um arquivo .xlsx com a estrutura de linha por linha do DODF 

2 - Depois de copiados os arquivos no passo 1, copiar e colar o arquivo modelo OCR.xlsx (que será o resultado do programa) em: C:\TesteOCR\DODF\Test

3 - Com isso, por default, o programa "montaDODF.py" irá estruturar todos os DODFs referente ao mês de Janeiro de 2019, com resultado em C:\TesteOCR\DODF\Test\OCR.xlsx

obs: 	Se for utilizado outros meses ou outra estrutura de pasta, alterar a última linha do arquivo "montaDODF.py" que tem como default 
	--> run_program(None,"C:/TesteOCR/DODF/DODF downloads/2019/01")
	para fazer refletir o período 

4 - Rodar o arquivo "montaDODF.py" (verificar se há necessidade de alterar o mês, como descrito no passo anterior)

5 - Os resultados da leitura estrutura do DODF estará disponível em C:\TesteOCR\DODF\Test\OCR.xlsx


Desenvolido por Marcelo Magalhães Silva de Sousa - TCDF