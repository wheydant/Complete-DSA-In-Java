package Striver.Tries;

public class CompleteString {
    static class Node{
        Node links[] = new Node[26];
        boolean flag = false;

        boolean containsKey(char ch){
            return (links[ch - 'a'] != null);
        }

        void put(char ch, Node node){
            links[ch - 'a'] = node;
        }

        Node get(char ch){
            return links[ch - 'a'];
        }

        void setEnd(){
            this.flag = true;
        }

        boolean isEnd(){
            return this.flag;
        }
    }
    static class Trie{
        private static Node root;
        public Trie() {
            root = new Node();
        }
        
        public void insert(String word) {
            Node node = root;
            for(int i = 0; i < word.length(); i++){
                if(!node.containsKey(word.charAt(i))){
                    node.put(word.charAt(i), new Node());
                }

                node = node.get(word.charAt(i));
            }
            node.setEnd();
        }

        boolean chechIfPrefixExist(String word){
            Node node = root;
            boolean flag = true;
            for(int i = 0; i < word.length(); i++){
                if(!node.containsKey(word.charAt(i))){
                    return false;
                }
                node = node.get(word.charAt(i));
                flag = flag & node.isEnd();
            }
            return flag;
        }
    }

    public static void main(String[] args) {;
        int n = 5;
        String[] a = {"n", "nin", "ninja", "ni", "ninga"};

        Trie obj = new Trie();
        for(int i = 0; i < 5; i++){
            obj.insert(a[i]);
        }

        String longest = "";
        for(int i = 0; i < n; i++){
            if(obj.chechIfPrefixExist(a[i])){
                if(a[i].length() > longest.length()){
                    longest = a[i];
                }else if(a[i].length() == longest.length() && a[i].compareTo(longest) < 0){
                    longest = a[i];
                }
            }
        }

        System.out.println(longest);

    }
}
