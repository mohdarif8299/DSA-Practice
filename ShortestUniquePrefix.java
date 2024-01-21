public class Solution {
    public static class TrieNode {
        TrieNode[] children;
        int count;
        TrieNode() {
            this.children = new TrieNode[26];
            this.count = 0;
        }
    }
    public String[] prefix(String[] A) {
        TrieNode root =new TrieNode();
        String S[] = new String[A.length];

        for(int i=0;i<A.length;i++) 
            insert(root, A[i]);

        for(int i=0;i<S.length;i++) 
            S[i] = search(root, A[i]);

        return S;
    }

    public void insert(TrieNode root, String word) {
        TrieNode temp = root;
        for(int i=0;i<word.length();i++) {
            if(temp.children[word.charAt(i)-'a'] == null) {
                TrieNode node = new TrieNode();
                temp.children[word.charAt(i)-'a'] = node;
            }
            temp.count += 1;
            temp = temp.children[word.charAt(i)-'a'];
        } 
    }

    public String search(TrieNode root, String word) {
        TrieNode temp = root;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<word.length();i++) {
            if(temp.children[word.charAt(i)-'a'] == null) return sb.toString();
            sb.append(word.charAt(i));
            temp = temp.children[word.charAt(i)-'a'];
            if(temp.count == 1) return sb.toString(); 
        }
        return sb.toString();
    }
    public TrieNode getNode() {
        TrieNode node = new TrieNode();
        node.count = 0;
        return node;
    }
}
