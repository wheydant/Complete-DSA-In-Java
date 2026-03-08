from collections import deque
from typing import List


class Solution:
    def snakesAndLadders(self, board: List[List[int]]) -> int:
        def intToIndex(val:int):
            n = len(board)
            # Row counting from the bottom of the board
            row_from_bottom = (val - 1) // n
            row = n - 1 - row_from_bottom

            # Column depends on the direction of the current row
            col_in_row = (val - 1) % n
            #Original rows position matters
            if row_from_bottom % 2 == 0:          # left → right
                col = col_in_row
            else:                                 # right → left
                col = n - 1 - col_in_row
            return row, col
        
        # Value of col, rolls to reach
        bfsQueue = deque()
        vis = set()
        
        bfsQueue.append([1, 0])
        while bfsQueue:
            square, rolls = bfsQueue.popleft()
            for i in range(1, 7):
                nextSquare = square + i
                r,c = intToIndex(nextSquare)
                
                if board[r][c] != -1:
                    nextSquare = board[r][c]
                
                if nextSquare == len(board)*len(board):
                    return rolls + 1
                
                if nextSquare not in vis:
                    bfsQueue.append([nextSquare, rolls + 1])
                    vis.add(nextSquare)
        
        return -1

if __name__ == '__main__':
    executor = Solution()
    print(executor.snakesAndLadders([[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]))