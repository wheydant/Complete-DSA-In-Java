package Striver.Tries;
//Crazy solution.
public class MaximumXor {
    class Node{
        Node[] links = new Node[2];

        boolean contains(int bit){
            return links[bit] != null;
        }

        void add(int bit, Node node){
            this.links[bit] = node;
        }

        Node get(int bit){
            return this.links[bit];
        }
    }
    class Trie{
        private static Node root;

        public Trie() {
            this.root = new Node();
        }
        void insert(int number){
            Node node = root;
            //32 bits
            for(int i = 31; i >= 0; i--){
                //Important
                int bit = (number >> i) & 1;
                if(!node.contains(bit)){
                    node.add(bit, new Node());
                }
                node = node.get(bit);
            }
        }

        int max(int number){
            int XOR = 0;
            Node node = root;
            for(int i = 31; i >= 0; i--){
                int bit = (number >> i) & 1;
                //1 - 0 does the same where if its 0 its 1 and if 1 then 1-1=0
                int desiredBit = (bit == 0)? 1 : 0;
                if(node.contains(1 - bit)){
                    //important
                    XOR = XOR | (1<<i);
                    node = node.get(1 - bit);
                }else{
                    node = node.get(bit);
                }
            }
            return XOR;
        }
    }
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        int maxXOR = 0;
        for(int i = 0; i < nums.length; i++){
            trie.insert(nums[i]);
        }

        for(int i = 0; i < nums.length; i++){
            int xor = trie.max(nums[i]);
            maxXOR = Math.max(maxXOR, xor);
        }
        return maxXOR;
    }
    public int findMaximumXORBrute(int[] nums) {
        int maxXOR = 0;
        for(int i = 0; i < nums.length; i++){
            for(int j = i; j < nums.length; j++){
                maxXOR = Math.max(nums[i] ^ nums[j], maxXOR);
            }
        }
        return maxXOR;
    }
}
