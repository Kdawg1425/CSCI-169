#Input: list containing strings that are names and int which are the score of the people
#Output: A string with everyone's first name and middle name and the average score
def report(xs):
    sum = 0
    count = 0
    name = []
    namelist = []
    result = ""
    temp = 1
    
    for i in xs:
        if type(i) == str:                               #checks to see it element in xs is a string
            name.append(i)                               #and appends element if it is a string
        else:
            sum = sum + (int(i))                         #Adds score of person to total sum
            count = count + 1                            #Adds 1 to number of people
            name.pop()                                   #removes last name from the name list
            namelist.append(name)                        #Adds name list to the namelist list
            name = []                                    #Clears name list
    for j in namelist:
        for k in j:
            if len(j) > 1:                               #Checks if name has a middle name
                if len(result) == 0:                     #Checks to see if it is the first name in the result
                    result = k                           #if it is then name is added to result string without any spacing
                elif temp < 2:                           #Check if element from namelist is the first name, if so
                    result = result + " " + k            #the name would be added to result string with this spacing
                    temp = 2
                else:
                    result = result + " " + k + ","      #If the element is the middle name then it would be added
                    temp = 1                             #the result string with this spacing and comma to seperate people
            else:                                        #If the name is just the first name then the name is added to
                 if len(result) == 0:                    #the result string with a space and a comma. If it is the first name in the string
                    result = k + ","                     #name in the string then it is added with just a comma                                                                      
                else:
                    result = result + " " + k + ","
    print (result + " averaged", (sum/count))            #prints result string with "averaged" and average score

report(["Jill","Johnson",87,"Billy","Ray","Cyrus",78,"Rita","Yeats",94,"Bobbie","Sue","Palmer",72])


