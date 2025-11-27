package KunalKushwaha.Assignments.String;
/*
A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...

Example 1:

Input: columnNumber = 1
Output: "A"

Example 2:
Input: columnNumber = 28
Output: "AB"

Example 3:
Input: columnNumber = 701
Output: "ZY"
*/

public class ExcelSheetColumnTitle {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while(columnNumber != 0){
            columnNumber--;
            int charIndex = columnNumber%26;
            sb.insert(0, (char)('A' + charIndex));
            columnNumber = columnNumber/26;
        }

        return sb.toString();

        // StringBuilder res = new StringBuilder();

        // while (columnNumber > 0) {
        //     columnNumber--;
        //     res.insert(0, (char) ((columnNumber % 26) + 'A'));
        //     columnNumber /= 26;
        // }
        
        // return res.toString(); 
    }
    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumnTitle().convertToTitle(701));

    }
}
