import operator
import time
import sys
# First, read through files and store info
table={}
# we'll only load the last 80 years as that will get the majority of the population
filename = sys.argv[1]
timestamp = time.asctime(time.localtime(time.time()))
print timestamp, ': ', filename
file = open(filename)
while 1:
	line = file.readline()
	# print line
	if not line:
		break
	else:
		name = line.strip()
		name = name.translate(None, "?,.;")
	try:
		int(name)
	except:
		print("processing ", name)
	else:
		print("ignoring number", name)
		continue

	if len(name) == 0:
		continue
	
	if name in table:
		table[name] += 1
	else:
		table[name] = 1
file.close()

# Second, sort the data
sort = sorted(table.iteritems(), key = lambda item: int(item[1]), reverse=True)

# Third, write the data into a file
file = open('list.txt', 'w')
length = len(sort)
for i in range(0, length):
	name, rank = sort[i]
	file.write(name)
	file.write(",")
	file.write(str(rank))
	file.write("\n");
file.close()
