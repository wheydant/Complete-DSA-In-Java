
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Random;

public class StringBufferDemo {
    static class RandomString{
        public String generate(int size){
            StringBuffer sb = new StringBuffer(size);

            Random random = new Random();

            for(int i = 0; i < size; i++){
                int randomChar = 97 + (int)(random.nextFloat() * 26);

                sb.append((char)randomChar);
            }
            return sb.toString();
        }
    }
    public static void main(String[] args) {
        //Constructor 1 - 16 is the initial space assigned to empty constructor
        StringBuffer sb = new StringBuffer();
        System.out.println(sb.capacity());
        sb.append("Hello World");

        //Constructor 2
        StringBuffer sb2 = new StringBuffer("Hello World");

        //Constructor 3
        StringBuffer sb3 = new StringBuffer(20);

        sb.append(" Hello");

        sb.insert(6, "new ");

        sb.replace(15, 19, "Welcome");

        String str = sb.toString();
        System.out.println(str);

        RandomString rs = new RandomString();
        System.out.println(rs.generate(5));

        //Remove white spaces
        String sentence = "Hi          Vedant";

        System.out.println(sentence);
        System.out.println(sentence.replaceAll("\\s", ""));

        String arr = "A B C D E";
        String[] names = arr.split(" ");
        System.out.println(Arrays.toString(names));

        //Rounding off
        DecimalFormat df = new DecimalFormat("0.0000");
        System.out.println(df.format(7.2));
    }
}
