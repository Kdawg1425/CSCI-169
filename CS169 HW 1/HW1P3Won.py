#Input: list
#Output: prints out list
def prt(input):
    print(input)


#Input: Input list, p, r
#Output: Partitioned list
def partition(input,p,r):
    pivot = input[r]
    while p < r:
        while input[p] < pivot:
            p += 1
        while input[r] > pivot:
            r -= 1
        if input[p] == input [r]:
            p += 1
        elif p < r:
            tmp = input[p]
            input[p] = input [r]
            input[r] = tmp
    return r

#Input: input list, int p and int r
#Output: Sorted input list
def quicksort(input,p,r):
    first = p
    last = r
    if p < r:
        j = partition(input, first, last)
        quicksort(input,p,j-1)
        quicksort(input,j+1,r)

input = [500, 700, 800, 100, 300, 200, 900, 400, 1000, 600]
print("Input:",end=" ")
prt(input)
quicksort(input, 0, 9)
print("Output:",end=" ")      #end=" " to get the prt function to print on same line
prt(input)

#INPUT_SIZE and print c++ function do not need to be translated to python
#since python's print prints out the whole list without needing a for loop
