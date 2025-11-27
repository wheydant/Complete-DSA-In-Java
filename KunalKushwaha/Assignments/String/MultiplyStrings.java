package KunalKushwaha.Assignments.String;

public class MultiplyStrings {

    class MySolution {
        String multiplyChar(String num1, char num2) {
            StringBuilder ans = new StringBuilder();
            int i = num1.length() - 1;
            int carry = 0;
            int num = num2 - '0';
            while (i >= 0) {
                int currNum = num1.charAt(i) - '0';
                int currMul = currNum * num + carry;
                ans.insert(0, currMul % 10 + "");
                carry = currMul / 10;

                i--;
            }

            while (carry != 0) {
                ans.insert(0, carry % 10 + "");
                carry = carry / 10;
            }
            return ans.toString();
        }

        String addString(String num1, String num2) {
            StringBuilder ans = new StringBuilder();

            int i = num1.length() - 1;
            int j = num2.length() - 1;

            int carry = 0;
            while (i >= 0 || j >= 0) {
                int n1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
                int n2 = (j >= 0) ? num2.charAt(j) - '0' : 0;

                int sum = n1 + n2 + carry;

                ans.insert(0, sum % 10 + "");

                carry = sum / 10;
                i--;
                j--;
            }

            if (carry > 0) {
                ans.insert(0, carry + "");
            }

            return ans.toString();
        }

        public String multiply(String num1, String num2) {
            if (num1.equals("0") || num2.equals("0")) {
                return "0";
            }
            String ans = "0";
            int m = num2.length();

            for (int i = m - 1; i >= 0; i--) {
                String currMultiply = multiplyChar(num1, num2.charAt(i));

                // Need to append zeros to each multiplication
                int zero = m - 1 - i;

                for (int z = 0; z < zero; z++)
                    currMultiply += "0";
                ans = addString(ans, currMultiply);
            }
            return ans;
        }
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int m = num1.length();
        int n = num2.length();
        int[] result = new int[m + n]; // max possible length

        // Multiply each digit
        for (int i = m - 1; i >= 0; i--) {
            int d1 = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int d2 = num2.charAt(j) - '0';

                int mul = d1 * d2;
                int sum = mul + result[i + j + 1]; // add to existing value

                result[i + j + 1] = sum % 10; // current place
                result[i + j] += sum / 10; // carry to next place
            }
        }

        // Convert result array to string
        StringBuilder sb = new StringBuilder();
        int i = 0;
        // Skip leading zeros
        while (i < result.length && result[i] == 0) {
            i++;
        }
        while (i < result.length) {
            sb.append(result[i++]);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new MultiplyStrings().multiply("1234", "5678"));
    }
}
