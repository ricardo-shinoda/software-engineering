from random import shuffle

def random(name):
    a = list(name)
    shuffle(a)
    a = ''.join(a)
    print(a.lower())
name = input('Digite uma palavra: ')

random(name)