import java.util.ArrayList;

public class MazeRightDown {
    /*
     *  | S |   |   | right and down allowed
     *  |   |   |   |
     *  |   |   | E |
     */
    public static void main(String[] args) {
        System.out.println(countMaze(3,3,0,0,0));
        maze(2,2,0,0,"");
        System.out.println(countMazeKK(4, 4));
        mazeKK("", 3, 3);

        System.out.println(retMazeKK("", 3, 3));

        System.out.println(retDiagMazeKK("", 3, 3));

        boolean[][] maze = {
            {true, false, true},
            {true, true, true},
            {true, true, true}
        };

        System.out.println("--------------");

        System.out.println(retTrapMazeKK("", 0,0,maze));
    }
    static int countMaze(int x, int y, int currX, int currY, int count){
        if(currX == x && currY == y){
            return 0;
        }
        if((currX == x - 1 && currY == y) || (currX == x && currY == y - 1)){
            return 1;
        }
        int right = 0;
        int down = 0;
        //right movement
        if(currX < x){
            right = count + countMaze(x, y, currX + 1, currY, count);
        }

        //down movement
        if(currY < y){
            down = count + countMaze(x, y, currX, currY + 1, count);
        }

        return (right + down);
    }

    static void maze(int x, int y, int currX, int currY, String path){
        if(currX == x && currY == y){
            return;
        }
        if(currX == x - 1 && currY == y){
            System.out.println(path + "R");
            return;
        }
        if(currX == x && currY == y - 1){
            System.out.println(path + "D");
            return;
        }
        //right movement
        if(currX < x){
            maze(x, y, currX + 1, currY, path + "R");
        }

        //down movement
        if(currY < y){
            maze(x, y, currX, currY + 1, path + "D");
        }
    }
    /*
     *  |  1,1  |  2,1  |  3,1  | right and down allowed
     *  |  1,2  |  2,2  |  3,2  |
     *  |  1,3  |  2,3  |  3,3  |
     */
    static int countMazeKK(int r, int c){
        if(r == 1 || c == 1){
            return 1;
        }
        int left = countMazeKK(r - 1, c);
        int right = countMazeKK(r, c - 1);
        return left + right;
    }

    static void mazeKK(String p, int r, int c){
        if(r == 1 && c == 1){
            System.out.println(p);
            return;
        }
        if(r > 1)mazeKK(p + 'D',r - 1, c);
        if(c > 1)mazeKK(p + 'R',r, c - 1);
    }

    static ArrayList<String> retMazeKK(String p, int r, int c){
        if(r == 1 && c == 1){
            // System.out.println(p);
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();
        if(r > 1)list.addAll(retMazeKK(p + 'D',r - 1, c));
        if(c > 1)list.addAll(retMazeKK(p + 'R',r, c - 1));

        return list;
    }
    static ArrayList<String> retDiagMazeKK(String p, int r, int c){
        if(r == 1 && c == 1){
            // System.out.println(p);
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }

        ArrayList<String> list = new ArrayList<>();
        if(r > 1)list.addAll(retDiagMazeKK(p + 'D',r - 1, c));
        if(r > 1 && c > 1)list.addAll(retDiagMazeKK(p + 'C', r - 1, c - 1));
        if(c > 1)list.addAll(retDiagMazeKK(p + 'R',r, c - 1));

        return list;
    }

    static ArrayList<String> retTrapMazeKK(String p, int r, int c, boolean[][] maze){
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
        if(r < maze.length - 1){
            list.addAll(retTrapMazeKK(p + 'D',r + 1, c, maze));
        }
        if(c < maze[0].length - 1){
            list.addAll(retTrapMazeKK(p + 'R',r, c + 1, maze));
        }

        return list;
    }
}
