import java.util.ArrayList;
import java.util.Arrays;

public class MazeAllDir {
    public static void main(String[] args) {
        boolean[][] maze = {
            {true, true, true},
            {true, true, true},
            {true, true, true}
        };

        int[][] path = new int[maze.length][maze[0].length];

        // System.out.println("--------------");

        System.out.println(allDirMaze("", 0,0,maze));

        allDirMazePrint("", 0, 0, maze, path, 1);
    }

    static ArrayList<String> allDirMaze(String p, int r, int c, boolean[][] maze){
        ArrayList<String> list = new ArrayList<>();
        if(r == maze.length - 1 && c == maze[0].length - 1){
            // System.out.println(p);
            list.add(p);
            return list;
        }
        if(!maze[r][c]){
            // list.add(p);
            return list;
        }

        //This function has visited this cell
        maze[r][c] = false;

        if(r < maze.length - 1){
            list.addAll(allDirMaze(p + 'D',r + 1, c, maze));
        }
        if(c < maze[0].length - 1){
            list.addAll(allDirMaze(p + 'R',r, c + 1, maze));
        }
        if(r > 0){
            list.addAll(allDirMaze(p + 'U',r - 1, c, maze));
        }
        if(c > 0){
            list.addAll(allDirMaze(p + 'L',r, c - 1, maze));
        }

        //Now free this cell for rest of the function calls.
        maze[r][c] = true;

        return list;
    }

    static void allDirMazePrint(String p, int r, int c, boolean[][] maze,int[][] path,int step){
        // ArrayList<String> list = new ArrayList<>();
        if(r == maze.length - 1 && c == maze[0].length - 1){
            // System.out.println(p);
            // list.add(p);
            path[r][c] = step;
            for(int[] arr : path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println("--------------");
            System.out.println(p);
            System.out.println("--------------");
            return;
        }
        if(!maze[r][c]){
            // list.add(p);
            return ;
        }

        //This function has visited this cell
        maze[r][c] = false;
        path[r][c] = step;

        if(r < maze.length - 1){
            allDirMazePrint(p + 'D',r + 1, c, maze, path, step + 1);
        }
        if(c < maze[0].length - 1){
            allDirMazePrint(p + 'R',r, c + 1, maze, path, step + 1);
        }
        if(r > 0){
            allDirMazePrint(p + 'U',r - 1, c, maze, path, step + 1);
        }
        if(c > 0){
            allDirMazePrint(p + 'L',r, c - 1, maze, path, step + 1);
        }

        //Now free this cell for rest of the function calls.
        maze[r][c] = true;
        path[r][c] = 0;
    }

}
