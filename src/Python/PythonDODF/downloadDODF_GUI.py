# coding: utf-8

'''
Cridado em abril de 2019

Elaborado por Marceo Magalhães Silva de Sousa em Abril de 2019. 
Permitida a utilização deste código, desde que citada expressamente a autoria.

@autor: Marcelo Magalhães Silva de Sousa
'''

import tkinter as tk
import tkinter.ttk as ttk
import downloadDODF
#from time import sleep



def on_select(event=None):
    pass

def buttonClick():
    infos = []
    for x in all_comboboxes:
        infos.append(x.get())  
    #sleep(0.1)
    root.quit()
    #sleep(0.1)
    downloadDODF.run_program(infos)
    

root = tk.Tk()
root.geometry('500x100')

frm = tk.Frame(root)
frm.grid()


anos_possiveis = []
lista_meses = []

for ano in range(2001,2020):
    anos_possiveis.append(ano)

for mes in range(1,13):
    lista_meses.append(mes)

all_comboboxes = []

labelTop = tk.Label(frm,
                    text = "Ano Inicial:")
labelTop.grid(row=0, column=0)

cb1 = ttk.Combobox(frm, values=(anos_possiveis))
cb1.set("2019")
cb1.grid(row=0, column=1)
cb1.bind('<<ComboboxSelected>>', on_select)

all_comboboxes.append(cb1)

labelTop = tk.Label(frm,
                    text = "Ano Final:")
labelTop.grid(row=0, column=2)

cb2 = ttk.Combobox(frm, values=(anos_possiveis))
cb2.set("2019")
cb2.grid(row=0, column=3)
cb2.bind('<<ComboboxSelected>>', on_select)

all_comboboxes.append(cb2)

frm2 = tk.Frame(root)
frm2.grid()

labelTop = tk.Label(frm,
                    text = "Mês Inicial:")
labelTop.grid(row=1, column=0)

cb3 = ttk.Combobox(frm, values=(lista_meses))
cb3.set("1")
cb3.grid(row=1, column=1)
cb3.bind('<<ComboboxSelected>>', on_select)

all_comboboxes.append(cb3)

labelTop = tk.Label(frm,
                    text = "Mês Final:")
labelTop.grid(row=1, column=2)

cb4 = ttk.Combobox(frm, values=(lista_meses))
cb4.set("1")
cb4.grid(row=1, column=3)
cb4.bind('<<ComboboxSelected>>', on_select)

all_comboboxes.append(cb4)


b = tk.Button(root, text="Baixar DODFs do período", command=buttonClick)
b.grid(row=5, column=0)

root.mainloop()

