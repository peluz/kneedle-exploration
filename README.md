# Inferring the source of official texts: can SVM beat ULMFiT?

This repo holds the dataset and source code described in the paper below:

* [Pedro H. Luz de Araujo](http://buscatextual.cnpq.br/buscatextual/visualizacv.do?metodo=apresentar&id=K2742607J6), [Teófilo E. de Campos](https://cic.unb.br/~teodecampos/), Marcelo M. Silva de Sousa  
_Inferring the source of official texts: can SVM beat ULMFiT?_  
[International Conference on the Computational Processing of Portuguese (PROPOR), March 2-4, Évora, Portugal, 2020.](https://propor.di.uevora.pt/)  
Download: [ [paper](https://cic.unb.br/~teodecampos/KnEDLe/propor2020/luz_de_araujo_etal_propor2020.pdf) | [slides](https://cic.unb.br/~teodecampos/KnEDLe/propor2020/luz_de_araujo_etal_propor2020_slides.pdf) | [bib](https://cic.unb.br/~teodecampos/KnEDLe/propor2020/luz_de_araujo_etal_propor2020.bib) ]

We kindly request that users cite our paper in any publication that is generated as a result of the use of our code or our dataset.

## Update (27/05/20)
The pre-trained language model used in this work was not originally released with its tokenizer model and vocabulary data, so our fine-tuned model and classifier were not able to leverage subword embeddings trained on general domain portuguese data. This has been amended, so we re-ran all experiments using the pre-trained vocab data. This repo contains the  updated ULMFiT training notebook and the updated results.

## Requirements
* [Python 3](https://www.python.org/downloads/)
* [pandas](https://pandas.pydata.org/)
* [matplotlib](https://matplotlib.org/)
* [fastai](https://docs.fast.ai/install.html)
* [scikit-learn](https://scikit-learn.org/stable/install.html)
* [Pre-trained language model](https://github.com/piegu/language-models/tree/master/models)

## Reproducing results
* Download the pretrained language model and place it in a model directory at the root
* Run train_ulmfit.ipynb
* Run train_baseline.ipynb