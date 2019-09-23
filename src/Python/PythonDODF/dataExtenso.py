# coding: utf-8

'''
Elaborado por Marceo Magalhães Silva de Sousa em Abril de 2019. 
Permitida a utilização deste código, desde que citada expressamente a autoria.

@autor: Marcelo Magalhães Silva de Sousa
'''

import datetime

Diasemana = ('segunda-feira','terça-feira','quarta-feira','quinta-feira','sexta-feira','sábado','domingo')
Meses = ('janeiro','fevereiro','março','abril','maio','junho','julho','agosto','setembro','outubro','novembro','dezembro')

def transformaDataPorExtenso(numeroDiario, dia, mes, ano):
    data = datetime.date(int(ano),int(mes),int(dia))
    diadasemana = datetime.date.weekday(data)
    mes = data.month - 1
    
    
    #print(data.strftime('%d'))
    #print(Diasemana[diadasemana])
    #print(Meses[mes])
    
    #print('Nº ' + str(numeroDiario) + ', ' + Diasemana[diadasemana] + ', ' + data.strftime('%d') + ' de ' + Meses[mes] + ' de ' + data.strftime('%Y'))
    #return 'Nº ' + str(numeroDiario) + ', ' + Diasemana[diadasemana] + ', ' + str(int(data.strftime('%d'))) + ' de ' + Meses[mes] + ' de ' + data.strftime('%Y')
    return Diasemana[diadasemana] +'.*' + Meses[mes] + '.*' #+ data.strftime('%Y')

#x = transformaDataPorExtenso('210','11','07','2018')
#print(x)

Meses = ('01_Janeiro','02_Fevereiro','03_Março','04_Abril','05_Maio','06_Junho','07_Julho','08_Agosto','09_Setembro','10_Outubro','11_Novembro','12_Dezembro')