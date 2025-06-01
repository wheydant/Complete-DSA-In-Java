
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
//For Better use BitSet can be used its like and array but with a bit at each index
public class HuffmanCoder {
    HashMap<Character, String> encoder;
    HashMap< String, Character> decoder;

    private class Node implements Comparable<Node>{
        Character data;
        int cost;
        Node left;
        Node right;

        public Node(Character data, int cost){
            this.data = data;
            this.cost = cost;
            this.left = null;
            this.right = null;
        }

        @Override
        public int compareTo(Node other) {
            return this.cost - other.cost;
        }
    }

    //1. Pass the string
    public HuffmanCoder(String feeder) throws Exception {
        //2. Make freq map
        HashMap<Character, Integer> freqMap = new HashMap<>();

        for(int i = 0; i < feeder.length(); i++){
            char cc = feeder.charAt(i);
            if(freqMap.containsKey(cc)){
                int ov = freqMap.get(cc);
                ov+=1;
                freqMap.put(cc, ov);
            }else{
                freqMap.put(cc, 1);
            }
        }

        //3. Min Heap
        PriorityQueue<Node> minHeap = new PriorityQueue<>();
        //Map.Entry<Character, Integer> Is considered as an object of pair of key and value
        Set<Map.Entry<Character, Integer>> entrySet = freqMap.entrySet();

        for(Map.Entry<Character, Integer> entry : entrySet){
            Node node = new Node(entry.getKey(), entry.getValue());
            minHeap.add(node);
        }

        //4. Remove 2 elements while size != 1
        while(minHeap.size() != 1){
            Node first = minHeap.remove();
            Node second = minHeap.remove();

            Node newNode = new Node('\0', first.cost + second.cost);
            newNode.left = first;
            newNode.right = second;

            minHeap.add(newNode);
        }

        //5. Build tree and fill encoder and decoder
        Node ft = minHeap.remove();

        this.encoder = new HashMap<>();
        this.decoder = new HashMap<>();

        this.initEncodeDecoder(ft, "");
    }

    private void initEncodeDecoder(Node node, String outputSoFar){
        if(node == null)return;
        //All the characters are leaf node.
        if(node.left == null && node.right == null){
            this.encoder.put(node.data, outputSoFar);
            this.decoder.put(outputSoFar, node.data);
        }
        //6. Find path
        initEncodeDecoder(node.left, outputSoFar + "0");
        initEncodeDecoder(node.right, outputSoFar + "1");
    }

    //7. Encode and Decode
    public String encode(String source){
        //Use String builder for efficiency
        String ans = "";
        for(int i = 0; i < source.length(); i++){
            ans += encoder.get(source.charAt(i));
        }
        return ans;
    }
    public String decode(String codedString){
        String ans = "";
        String key = "";
        for(int i = 0; i < codedString.length(); i++){
            key = key + codedString.charAt(i);
            if(decoder.containsKey(key)){
                ans += decoder.get(key);
                key = "";
            }
        }
        return ans;
    }
    public static void main(String[] args) throws Exception {
        String str = "abbccda";
        HuffmanCoder hf = new HuffmanCoder(str);
        System.out.println(str);
        String codedString = hf.encode(str);
        System.out.println(codedString);
        String decodedString = hf.decode(codedString);
        System.out.println(decodedString);
    }    
}
