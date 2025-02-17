public class PascalsTriangle {
    public static void main(String[] args) {
        int row = 4;
        System.out.println(sumPascalsTriangle(row));
    }
    public static int sumPascalsTriangle(int row){
        return 1 << (row - 1);
    }
}


