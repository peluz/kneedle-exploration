1 - Rodar o arquivo "downloadDODF_GUI.py" com as configura��es padr�es para baixar todos os DODFs relativos � Janeiro de 2019 (outros meses podem ocorrer problemas)

--> Os pdfs ser�o baixados na seguinte estrutura de pastas: "C:\TesteOCR\DODF\DODF downloads\2019\01"
--> Para cada pdf ser� gerado um arquivo .xlsx com a estrutura de linha por linha do DODF 

2 - Depois de copiados os arquivos no passo 1, copiar e colar o arquivo modelo OCR.xlsx (que ser� o resultado do programa) em: C:\TesteOCR\DODF\Test

3 - Com isso, por default, o programa "montaDODF.py" ir� estruturar todos os DODFs referente ao m�s de Janeiro de 2019, com resultado em C:\TesteOCR\DODF\Test\OCR.xlsx

obs: 	Se for utilizado outros meses ou outra estrutura de pasta, alterar a �ltima linha do arquivo "montaDODF.py" que tem como default 
	--> run_program(None,"C:/TesteOCR/DODF/DODF downloads/2019/01")
	para fazer refletir o per�odo 

4 - Rodar o arquivo "montaDODF.py" (verificar se h� necessidade de alterar o m�s, como descrito no passo anterior)

5 - Os resultados da leitura estrutura do DODF estar� dispon�vel em C:\TesteOCR\DODF\Test\OCR.xlsx


Desenvolido por Marcelo Magalh�es Silva de Sousa - TCDF