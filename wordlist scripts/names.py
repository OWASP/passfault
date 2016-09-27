import glob
import operator
from collections import OrderedDict
import matplotlib.pyplot as plt

files = glob.glob("/home/bernardo/Documents/MestradoCripto/names/*")

names = {}
integral100 = 0

for file in files:
    f = open(file, 'r')
    lines = f.readlines()
    f.close()

    for line in lines:
        line = line.split(",")
        name = line[0]
        count = int(line[2].replace("\n", ""))

        integral100 += count

        if (name in names):
            names[name] = names[name]+count
        else:
            names[name] = count

names = OrderedDict(reversed(sorted(names.items(), key=operator.itemgetter(1))))

integral = 0
countList = []
i = 0

usNamesPopular = open('usNamesPopular.words', 'w')
usNamesLongTail = open('usNamesLongTail.words', 'w')

for name, count in names.items():
    i += 1
    integral += count
    countList.insert(i, count)
    if (integral <= 0.8*integral100):
        usNamesPopular.write(name)
    else:
        usNamesLongTail.write(name)

usNamesLongTail.close()
usNamesPopular.close()

# plt.plot(countList)
# plt.xscale('log')
# plt.yscale('log')
# plt.show()
