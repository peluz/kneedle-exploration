# coding: utf-8

'''
Elaborado por Marceo Magalhães Silva de Sousa em Abril de 2019. 
Permitida a utilização deste código, desde que citada expressamente a autoria.

@autor: Marcelo Magalhães Silva de Sousa
'''


import os
import re 
import subprocess
#import montaDODF4 

path = 'C:\\TesteOCR\\DODF\\DODF downloads\\2019\\01'

listaArquivosPDF = []
# r=root, d=directories, f = files
for root, directories, files in os.walk(path):
    for file in files:
        if '.pdf' in file:
            listaArquivosPDF.append([os.path.join(root, file), file])
            #if re.findall('SE[ÇC][AÃ]O|INTEGRA', file, re.IGNORECASE):
                #listaArquivosPDF.append([os.path.join(root, file), file])                

for arquivoPDF in listaArquivosPDF:
    pathArquivoPDF = arquivoPDF[0]
    #print("achou")                                
    print(pathArquivoPDF)
    subprocess.call(['java', '-Dfile.encoding=UTF-8', '-Xms1024m', '-Xmx1024m', '-jar', 'LeituraDODF.jar',  pathArquivoPDF])
    #subprocess.call(['java', '-Dfile.encoding=UTF-8', '-Xms512m', '-Xmx512m', '-jar', 'LeituraDODF.jar',  pathArquivoPDF])

#montaDODF4.run_program(listaArquivosPDF)