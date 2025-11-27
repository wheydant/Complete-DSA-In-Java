package KunalKushwaha.Assignments.Bitwise;

public class AddBinary{
    String calculate(char a, char b, char c){
        if(a == '1'){
            if(b == '1'){
                if(c == '1'){
                    return "11";
                }else{
                    return "10";
                }
            }else{
                if(c == '1'){
                    return "10";
                }else{
                    return "1";
                }
            }
        }else{
            if(b == '1'){
                if(c == '1'){
                    return "10";
                }else{
                    return "1";
                }
            }else{
                if(c == '1'){
                    return "1";
                }else{
                    return "0";
                }
            }
        }
    }
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        char carry = '0';
        while(i >= 0 && j >= 0){
            char aChar = a.charAt(i);
            char bChar = b.charAt(j);
            String ans = calculate(aChar, bChar, carry);
            if(ans.length() > 1){
                carry = '1';
                ans = ans.charAt(1) + "";
            } else {
                carry = '0';
            }
            sb.append(ans);
            i--; j--;
        }

        while(i >= 0){
            char aChar = a.charAt(i);
            String ans = calculate(aChar, '0', carry);
            if(ans.length() > 1){
                carry = '1';
                ans = ans.charAt(1) + "";
            } else {
                carry = '0';
            }
            sb.append(ans);
            i--;
        }

        while(j >= 0){
            char bChar = b.charAt(j);
            String ans = calculate('0', bChar, carry);
            if(ans.length() > 1){
                carry = '1';
                ans = ans.charAt(1) + "";
            } else {
                carry = '0';
            }
            sb.append(ans);
            j--;
        }

        if(carry == '1'){
            sb.append("1");
        }

        return sb.reverse().toString();
    }
    public String addBinaryEasySolution(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while(i >= 0 || j >= 0 || carry == 1){
            if(i >= 0)
                carry += a.charAt(i--) - '0';
            if(j >= 0)
                carry += b.charAt(j--) - '0';
            sb.append(carry % 2);
            carry = carry / 2;
        }
        return sb.reverse().toString();
    }
    public static void main(String[] args) {
        System.out.println(new AddBinary().addBinary("1110", "1110"));
    }
}