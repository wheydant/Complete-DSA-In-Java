package Striver.Tries;

public class ImplementTrieII {
    static class Node{
        Node links[] = new Node[26];
        int cntEndWith = 0;
        //Keeps the count of word it is associated with 
        int cntPrefix = 0;

        boolean containsKey(char ch){
            return (links[ch - 'a'] != null);
        }

        void put(char ch, Node node){
            links[ch - 'a'] = node;
        }

        Node get(char ch){
            return links[ch - 'a'];
        }

        void increaseEnd(){
            this.cntEndWith++;
        }

        void increasePrefix(){
            this.cntPrefix++;
        }

        void deleteEnd(){
            this.cntEndWith--;
        }

        void reducePrefix(){
            this.cntPrefix--;
        }

        int getEnd(){
            return this.cntEndWith;
        }

        int getPrefix(){
            return this.cntPrefix;
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
                node.increasePrefix();
            }
            node.increaseEnd();
        }
        
        int countWordsEqualTo(String word){
            Node node = root;
            for(int i = 0; i < word.length(); i++){
                if(!node.containsKey(word.charAt(i))){
                    return 0;
                }
                node = node.get(word.charAt(i));
            }
            return node.getEnd();
        }

        int countWordsStartingWith(String word){
            Node node = root;
            for(int i = 0; i < word.length(); i++){
                if(!node.containsKey(word.charAt(i))){
                    return 0;
                }
                node = node.get(word.charAt(i));
            }
            return node.getPrefix();
        }

        void erase(String word){
            Node node = root;
            for(int i = 0; i < word.length(); i++){
                if(!node.containsKey(word.charAt(i))){
                    return;
                }
                node = node.get(word.charAt(i));
                node.reducePrefix();
            }
            node.deleteEnd();
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("apple");
        trie.insert("apps");
        trie.insert("apps");
        System.out.println(trie.countWordsEqualTo("apple"));
        System.out.println(trie.countWordsStartingWith("app"));
        trie.erase("apps");

        System.out.println(trie.countWordsEqualTo("apps"));
    }
}
