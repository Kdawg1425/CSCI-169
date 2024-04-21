def findSolution(chessBoard, col):
    def isSafe(chessBoard, i, j):
        for x in range(j):                                          # look for queens in same row
            if chessBoard[i][x] == 1:
                return False
            
        x = i + 1                                                   # look for queens in the lower left diagonal
        y = j - 1
        while(x < queens and y >= 0):                               
            if chessBoard[x][y] == 1:
                return False
            x = x + 1
            y = y - 1
            
        x = i - 1                                                   # look for queens in the upper left diagonal
        y = j - 1
        while(x >= 0 and y >= 0):                                  
            if chessBoard[x][y] == 1:
                return False
            x = x - 1
            y = y - 1
        return True                                                 # return True if spot is safe
    
    if col >= queens:                                               # return True if queens have been placed in all 8 columns
        return True
    
    for row in range(queens):
        if isSafe(chessBoard, row, col):                            # check if spot is safe
            chessBoard[row][col] = 1                                # put queen in spot
            
            if findSolution(chessBoard, col + 1):                   # place the rest of the queens recursively
                return True
            
            chessBoard[x][col] = 0                                  # take off the board if no solution is found with that placement
    return False                                                    # return False if no solution is found

queens = 8
chessBoard = [[0 for i in range(queens)] for j in range(queens)]    # set up board
if findSolution(chessBoard, 0):                                     # look for a solution
    for x in chessBoard:
        print(x)
else:
    print("Error. Could not solve.")

