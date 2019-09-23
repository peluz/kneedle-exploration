# coding: utf-8
'''
Elaborado por Marceo Magalhães Silva de Sousa em Abril de 2019. 
Permitida a utilização deste código, desde que citada expressamente a autoria.

@autor: Marcelo Magalhães Silva de Sousa
'''

import requests
import os
import re
from bs4 import BeautifulSoup
#from tkinter import messagebox
import urllib
import subprocess
#import montaDODF4
import time


def createFolder(directory):
    try:
        if not os.path.exists(directory):
            os.makedirs(directory)
    except OSError:
        print ('Error: Creating directory. ' +  directory)

def run_program(infos):
    #Meses = ('01_Janeiro','02_Fevereiro','03_Marï¿½o','04_Abril','05_Maio','06_Junho','07_Julho','08_Agosto','09_Setembro','10_Outubro','11_Novembro','12_Dezembro')
    Meses = ('Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro')
    #url = "http://www.buriti.df.gov.br/ftp/"
    
    #ano_inicial = 2018
    #ano_inicial = int(input("Digite o ano de iníco para cópias do DODF (ex: 2018):"))
    #ano_final = 2018
    #ano_final = int(input("Digite até que ano deseja cópias do DODF (ex: 2018):"))
    #mes_inicial = 1
    #mes_inicial = int(input("Digite o mês de início para cópias do DODF (ex: 1 para Janeiro):"))
    #mes_final = 2
    #mes_final = int(input("Digite  até que mês deseja cópias do DODF (ex: 2 para Fevereiro):"))
    
    #print(infos)
    ano_inicial = int(infos[0])
    ano_final = int(infos[1])
    mes_inicial = int(infos[2])
    mes_final = int(infos[3])
    copias = 0
        
    meses_interesse = []
    
    lista_arquivos = []
    
    for index, each in enumerate(range(mes_inicial,mes_final + 1)):
        i = mes_inicial + index - 1
        meses_interesse.append(Meses[i])
    
    #print(meses_interesse)
       
    numero_mes = 0
    string_mes = ''
    string_mes_completo = ''
    label_nome_arquivo = ''
    file_name_path = ''
    file_name = ''
    
    for ano in range(ano_inicial, ano_final + 1):
        #print(ano)
        
        for index, mes in enumerate(meses_interesse):
            numero_mes = mes_inicial + index
            if len(str(numero_mes)) == 1:
                string_mes = "0" + str(numero_mes)
                string_mes_completo = string_mes + "_" + mes
            else:
                string_mes = str(numero_mes)
                string_mes_completo = string_mes + "_" + mes
         
            
            createFolder("C:/TesteOCR/DODF/DODF downloads/")            
            dir_ano = "C:/TesteOCR/DODF/DODF downloads/" + str(ano)
            dir_mes = "C:/TesteOCR/DODF/DODF downloads/" + str(ano) + "/" + string_mes
            createFolder(dir_ano)
            createFolder(dir_mes)
                        
            url = "http://www.buriti.df.gov.br/ftp/default.asp?ano=" + str(ano) + "&mes=" + string_mes_completo
            #print(url)
            url = urllib.parse.quote(url, safe =':/?=&')
            url = url.replace('%C2', '')
            url = url.replace('3%8', '')
            url = url.replace('%C3%A7', '%E7') 
            #print(url)                  
                        
          
            #headers = {'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.95 Safari/537.36'}
            headers = {'User-Agent': 'Chrome/71.0.3578.80'}
            response = requests.get(url, headers=headers)
            #response = requests.get(url, headers=headers)
            soupLinkDownload1 = BeautifulSoup(response.text, "html.parser")
            
            url = "http://www.buriti.df.gov.br/ftp/"
            
            
            for a in soupLinkDownload1.find_all('a', href=True):
                url1 = url + a['href']    
                url1 = urllib.parse.quote(url1, safe =':/?=&')
                url1 = url1.replace('%C2', '')
                url1 = url1.replace('3%8', '')
                url1 = url1.replace('%C3%A7', '%E7')                                
                #print(url1)

                #response = requests.get(url1, headers=headers)
                response = requests.get(url1, headers=headers)
                soupLinkDownload2 = BeautifulSoup(response.text, "html.parser")
                for a in soupLinkDownload2.find_all('a', href=True):
                    #print(a)
                    download_url = url + a['href']
                    download_url = urllib.parse.quote(download_url, safe =':/?=&')
              
                    #print(download_url)
    
                    if not re.compile('LinkID').search(str(download_url)):
                        
                        contadorBarras = download_url.count("/") + 1
                        if contadorBarras > 2:
                            file_name = download_url.split("/")[-1]
                            #file_name = urllib.parse.unquote(file_name)    
                            file_name = urllib.parse.unquote(file_name, encoding='utf-8', errors='replace')             
                            #print(file_name)
                                                    
                            DODF_name = download_url.split("/")[-2]
                            #DODF_name = urllib.parse.unquote(DODF_name)
                            DODF_name = urllib.parse.unquote(DODF_name, encoding='utf-8', errors='replace')                                  
                            #print(DODF_name)                                                                        
                            
                            
                            #city = 'Ribeirão Preto'
                            #Str = city.encode('utf-8')
                            #print(Str.decode('unicode-escape').encode('cp1252').decode('utf-8'))
                            #print(city.encode('utf-8').decode('unicode-escape').encode('cp1252').decode('utf-8'))
                            
                            if re.compile('pdf').search(str(file_name)):                                
                                if re.compile('Seç|Sec|seç|sec').search(str(file_name)) and ano < 2017:                                   
                                    if  soupLinkDownload2.find_all('b'):
                                        label_nome_arquivo = soupLinkDownload2.find_all('b')[0]
                                        label_nome_arquivo = label_nome_arquivo.text, label_nome_arquivo.next_sibling
                                        label_nome_arquivo = label_nome_arquivo[0]
                                        if label_nome_arquivo not in DODF_name:
                                            if label_nome_arquivo.startswith("--"):
                                                label_nome_arquivo = label_nome_arquivo.replace("--", "DODF ")
                                                label_nome_arquivo = label_nome_arquivo.replace("EDI", "DODF EDI")
                                                DODF_name = label_nome_arquivo
                                            else:                                                                        
                                                DODF_name = label_nome_arquivo    
                                                
                                        if  re.compile('dodf|DODF[ -_]?[ -_]?[ -_]?\d*').search(str(file_name)):
                                            subst = re.findall('dodf|DODF[ -_]?[ -_]?[ -_]?\d*',file_name)[0]
                                            file_name = file_name.replace(subst,'')                                           
                                    file_name_path  = dir_mes + "/" + DODF_name + " " + file_name                                    
                                else:
                                    if  soupLinkDownload2.find_all('b'):
                                        label_nome_arquivo = soupLinkDownload2.find_all('b')[0]
                                        label_nome_arquivo = label_nome_arquivo.text, label_nome_arquivo.next_sibling
                                        label_nome_arquivo = label_nome_arquivo[0]
                                        if label_nome_arquivo not in file_name:
                                            if label_nome_arquivo.startswith("--"):
                                                label_nome_arquivo = label_nome_arquivo.replace("--", "DODF ")
                                                label_nome_arquivo = label_nome_arquivo.replace("EDI", "DODF EDI")
                                                file_name = label_nome_arquivo + ".pdf"
                                            else:                                                                        
                                                file_name = label_nome_arquivo + ".pdf"  
                                                             
                                    if re.compile('SECAO|SEÇÃO|SEÇAO|SECÃO').search(str(file_name)) and ano > 2016:
                                        file_name = file_name.replace('SECAO1','INTEGRA')
                                        file_name = file_name.replace('SECÃO1','INTEGRA')                                        
                                        file_name = file_name.replace('SEÇAO1','INTEGRA')                     
                                        file_name = file_name.replace('SEÇÃO1','INTEGRA')
                                        file_name_path  = dir_mes + "/" + file_name
                                    else:
                                        file_name_path  = dir_mes + "/" + file_name       
                                                                        

                        try:
                            #r = requests.get(download_url, stream = True, headers=headers)
                            #r = requests.get(download_url, stream = True, headers=headers) 
                            #download_url = download_url.replace('%C2', '')
                            #download_url = download_url.replace('3%8', '')                            
                            
                            get_response = requests.get(download_url,stream=True, headers=headers, timeout=30)
                                                                                                                                              
                            if not os.path.exists(file_name_path):
                                #print(download_url)
                                #print(file_name_path.split("/")[-1])                            
                                with open(file_name_path, 'wb') as f:
                                    for chunk in get_response.iter_content(chunk_size=256):
                                        if chunk: # filter out keep-alive new chunks
                                            f.write(chunk)
                                print(file_name_path + ";ok")
                                copias = copias + 1
                                if re.findall('SE[ÇC][AÃ]O|INTEGRA', file_name, re.IGNORECASE):
                                    #print("achou")                                
                                    lista_arquivos.append([file_name_path, file_name])
                                                
                        except:
                            print(download_url)
                            print(file_name_path + ";erro")
                            if os.path.exists(file_name_path):
                                os.remove(file_name_path)
                                print("file deleted!")
                                                            
    if copias > 0:
        #messagebox.showinfo("Cópias concluídas!", "Verifique o diretório C:/TesteOCR/DODF/DODF downloads/")
        print(lista_arquivos)
        for each in lista_arquivos:
            #print(each) 
            #subprocess.call(['java', '-jar', 'LeituraDODF.jar', each[0]])     
            #subprocess.call(['java', '-Xms1024M -Xmx1024M -Dfile.encoding=UTF-8', '-jar','LeituraDODF.jar', each[0]])
            #subprocess.call(['java', '-Dfile.encoding=UTF-8', '-Xms1024m', '-Xmx1024m', '-jar', 'LeituraDODF.jar',  each[0]])      
            subprocess.call(['java', '-Dfile.encoding=UTF-8', '-Xms512m', '-Xmx512m', '-jar', 'LeituraDODF.jar',  each[0]])
        #montaDODF4.run_program(lista_arquivos)
        #time.sleep(5)        
        #import buscaSimilaridades
        #buscaSimilaridades.run()
    else:
        print("Base de dados atualizada: nenhum novo arquivo do DODF foi localizado nem copiado!")
        #messagebox.showinfo("Base de dados atualizada!", "Nenhum novo arquivo do DODF foi localizado nem copiado!")      
    

    
    