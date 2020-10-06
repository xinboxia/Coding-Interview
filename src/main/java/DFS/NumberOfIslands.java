package DFS;

/**
 * LeetCode 200 : Number of Islands
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 */
public class NumberOfIslands {
    private int row, col;
    public int numIslands(char[][] grid) {
        int count = 0;
        row = grid.length;
        if(row == 0) return 0;
        col = grid[0].length;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == '1') {
                    //first check the complete island
                    //then count++
                    dfsCheck(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfsCheck(char[][] grid, int i, int j) {
        //if exceed boundaries or no more islands, stop the function and return
        if(i < 0 || j < 0 || i >= row || j >= col || grid[i][j] != '1') return;
        //set visited island to water
        grid[i][j]='0';
        dfsCheck(grid, i+1, j);
        dfsCheck(grid, i-1, j);
        dfsCheck(grid, i, j+1);
        dfsCheck(grid, i, j-1);
    }
}
