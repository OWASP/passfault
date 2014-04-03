import operator
import time
# First, read through files and store info
table={}
# we'll only load the last 80 years as that will get the majority of the population
for i in range(2011, 2013):
	filename = 'es-' + str(i) + '.txt'
	timestamp = time.asctime(time.localtime(time.time()))
	print timestamp, ': ', filename
	file = open(filename)
	while 1:
		line = file.readline()
		# print line
		if not line:
			break
		else:
			name, count = line.split(',')
			name = name.strip().lower()
			if name in table.values():
				table[name] += count
			else:
				table[name] = count
	file.close()

# Second, sort the data
sort = sorted(table.iteritems(), key = lambda item: int(item[1]), reverse=True)

# Third, write the data into a file
file = open('list.txt', 'w')
length = len(sort)
for i in range(0, length):
	name, rank = sort[i]
	file.write(name + ',' + rank)
file.close()
