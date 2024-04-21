inFile = open("inFile.txt")
outFile = open("outFile.txt", 'w')

for x in inFile:
    if x != '\n':
        outFile.write(x)

inFile.close()
outFile.close()
