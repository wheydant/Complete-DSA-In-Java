
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileHandling {
    public static void TerminalIpOp(){
            try(InputStreamReader isr = new InputStreamReader(System.in)){
            //Taking data as byte and putting it out as character
            System.out.print("Enter letters ");
            int letters = isr.read();
            while(isr.ready()){
                System.out.println((char) letters);
                letters = isr.read();
            }
            // No need to add this try catch auto-closes it.
            // isr.close();
            System.out.println();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    public static void FileIpOp(){
        try(FileReader fr = new FileReader("C:\\Users\\vkarleka\\Documents\\Personal_Growth\\Java DSA Kunal Kushwaha\\Code\\52-54LargeData\\Notes\\Notes.md")){
            //Taking data as byte and putting it out as character
            //This throws error as read returns a byte.
            // char letters = fr.read();
            int letters = fr.read();
            while(fr.ready()){
                System.out.print((char) letters);
                letters = fr.read();
            }
            // No need to add this try catch auto-closes it.
            // isr.close();
            System.out.println();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    public static void ByteToChar(){
        //Keyboard is a byte stream which is converted to char stream using InputStreamReader for reading char Stream
        try( BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("You typed: "+br.readLine());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
        
        
        try(BufferedReader br1 = new BufferedReader(new FileReader("C:\\Users\\vkarleka\\Documents\\Personal_Growth\\Java DSA Kunal Kushwaha\\Code\\52-54LargeData\\Notes\\Notes.md"))){
            while(br1.ready()){
                System.out.println(br1.readLine());
            }
            
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    static void FileCreator(){
        try {
            File fo = new File("C:\\Users\\vkarleka\\Documents\\Personal_Growth\\Java DSA Kunal Kushwaha\\Code\\52-54LargeData\\Janmauddesh.txt");
            fo.createNewFile();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            File fo = new File("C:\\Users\\vkarleka\\Documents\\Personal_Growth\\Java DSA Kunal Kushwaha\\Code\\52-54LargeData\\Random.txt");
            fo.createNewFile();
            fo.delete();
            System.out.println("Deleted file - "+fo.getName());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    static void Writer(){
        try(OutputStreamWriter osw = new OutputStreamWriter(System.out)) {
            osw.write("Hello World");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //Specifying true indicates appended 
        try(FileWriter fw = new FileWriter("C:\\Users\\vkarleka\\Documents\\Personal_Growth\\Java DSA Kunal Kushwaha\\Code\\52-54LargeData\\Janmauddesh.txt")) {
            fw.write("कर्मण्येवाधिकारस्ते मा फलेषु कदाचन।");;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\vkarleka\\Documents\\Personal_Growth\\Java DSA Kunal Kushwaha\\Code\\52-54LargeData\\Janmauddesh.txt", true))) {
            bw.write("\nमा कर्मफलहेतुर्भूर्मा ते सङ्गोऽस्त्वकर्मणि॥");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        // FileIpOp();
        // ByteToChar();
        FileCreator();
        Writer();
    }
}
