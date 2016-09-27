from wordfreq import word_frequency
from wordfreq import zipf_frequency
from wordfreq import top_n_list
import matplotlib.pyplot as plt

dest = "/home/bernardo/Documents/MestradoCripto/wordlists"

de = top_n_list('de', 1e5, wordlist='large')
en = top_n_list('en', 1e5, wordlist='large')
es = top_n_list('es', 1e5, wordlist='large')
fr = top_n_list('fr', 1e5, wordlist='large')
it = top_n_list('it', 1e5, wordlist='large')
nl = top_n_list('nl', 1e5, wordlist='large')
pt = top_n_list('pt', 1e5, wordlist='large')

#---------------------------------------------------------------
dePopular = open(dest + '/dePopular.words', 'w')
deLongTail = open(dest + '/deLongTail.words', 'w')

integral100 = 0
for i in range(len(de)):
    integral100 += word_frequency(de[i], 'de', wordlist='large')

print(integral100)

integral80 = 0
for i in range(len(de)):
    integral80 += word_frequency(de[i], 'de', wordlist='large')
    if (integral80 <= 0.80*integral100):
        dePopular.write(de[i] + '\n')
    else:
        deLongTail.write(de[i] + '\n')

dePopular.close()
deLongTail.close()

#---------------------------------------------------------------
enPopular = open(dest + '/enPopular.words', 'w')
enLongTail = open(dest + '/enLongTail.words', 'w')

integral100 = 0
for i in range(len(en)):
    integral100 += word_frequency(en[i], 'en', wordlist='large')

integral80 = 0
for i in range(len(en)):
    integral80 += word_frequency(en[i], 'en', wordlist='large')
    if (integral80 <= 0.80*integral100):
        enPopular.write(en[i] + '\n')
    else:
        enLongTail.write(en[i] + '\n')

enPopular.close()
enLongTail.close()

#---------------------------------------------------------------
esPopular = open(dest + '/esPopular.words', 'w')
esLongTail = open(dest + '/esLongTail.words', 'w')

integral100 = 0
for i in range(len(es)):
    integral100 += word_frequency(es[i], 'es', wordlist='large')

integral80 = 0
for i in range(len(es)):
    integral80 += word_frequency(es[i], 'es', wordlist='large')
    if (integral80 <= 0.80*integral100):
        esPopular.write(es[i] + '\n')
    else:
        esLongTail.write(es[i] + '\n')

esPopular.close()
esLongTail.close()

#---------------------------------------------------------------
frPopular = open(dest + '/frPopular.words', 'w')
frLongTail = open(dest + '/frLongTail.words', 'w')

integral100 = 0
for i in range(len(fr)):
    integral100 += word_frequency(fr[i], 'fr', wordlist='large')

integral80 = 0
for i in range(len(fr)):
    integral80 += word_frequency(fr[i], 'fr', wordlist='large')
    if (integral80 <= 0.80*integral100):
        frPopular.write(fr[i] + '\n')
    else:
        frLongTail.write(fr[i] + '\n')

frPopular.close()
frLongTail.close()

#---------------------------------------------------------------
itPopular = open(dest + '/itPopular.words', 'w')
itLongTail = open(dest + '/itLongTail.words', 'w')

integral100 = 0
for i in range(len(it)):
    integral100 += word_frequency(it[i], 'it', wordlist='large')

integral80 = 0
for i in range(len(it)):
    integral80 += word_frequency(it[i], 'it', wordlist='large')
    if (integral80 <= 0.80*integral100):
        itPopular.write(it[i] + '\n')
    else:
        itLongTail.write(it[i] + '\n')

itPopular.close()
itLongTail.close()

#---------------------------------------------------------------
nlPopular = open(dest + '/nlPopular.words', 'w')
nlLongTail = open(dest + '/nlLongTail.words', 'w')

integral100 = 0
for i in range(len(nl)):
    integral100 += word_frequency(nl[i], 'nl', wordlist='large')

integral80 = 0
for i in range(len(nl)):
    integral80 += word_frequency(nl[i], 'nl', wordlist='large')
    if (integral80 <= 0.80*integral100):
        nlPopular.write(nl[i] + '\n')
    else:
        nlLongTail.write(nl[i] + '\n')

nlPopular.close()
nlLongTail.close()

#---------------------------------------------------------------
ptPopular = open(dest + '/ptPopular.words', 'w')
ptLongTail = open(dest + '/ptLongTail.words', 'w')

integral100 = 0
for i in range(len(pt)):
    integral100 += word_frequency(pt[i], 'pt', wordlist='large')

integral80 = 0
for i in range(len(pt)):
    integral80 += word_frequency(pt[i], 'pt', wordlist='large')
    if (integral80 <= 0.80*integral100):
        ptPopular.write(pt[i] + '\n')
    else:
        ptLongTail.write(pt[i] + '\n')

ptPopular.close()
ptLongTail.close()


integralList = []
integral = 0
f = []
for i in range(0, len(pt)):
    f.insert(i, word_frequency(de[i], 'pt', wordlist='large')/word_frequency(de[0], 'pt', wordlist='large'))
    integral += word_frequency(pt[i], 'pt', wordlist='large')
    integralList.insert(i, integral)

plt.plot(integralList)
#plt.plot(f)
#plt.xscale('log')
#plt.yscale('log')
plt.show()


