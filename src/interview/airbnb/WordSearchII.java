package interview.airbnb;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tyh on 2017/9/12.
 */
public class WordSearchII {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        String[] words = new String[]{"oath","pea","eat","rain"};
        List<String> res = findWords(board, words);
    }
    public static List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if(board == null || board.length == 0 || board[0].length == 0 || words == null){
            return res;
        }
        //build trie
        TrieNode root = new TrieNode();
        for(String word : words){
            insertWord(root, word);
        }
        //dfs search
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    private static void dfs(char[][] board, int i, int j, TrieNode root, List<String> res){
        char c = board[i][j];
        //visited before or no match letter
        if(c == '#' || root.children[c - 'a'] == null){
            return;
        }
        root = root.children[c - 'a'];
        //found one
        if(root.word != null){
            res.add(root.word);
            root.word = null;//de-duplicate
        }
        board[i][j] = '#';
        if(i > 0){
            dfs(board, i - 1, j, root, res);
        }
        if(i < board.length - 1){
            dfs(board, i + 1, j, root, res);
        }
        if(j > 0){
            dfs(board, i, j - 1, root, res);
        }
        if(j < board[0].length - 1){
            dfs(board, i, j + 1, root, res);
        }
        board[i][j] = c;
    }

    private static void insertWord(TrieNode root, String word){
        if(word == null){
            return;
        }
        for(char c : word.toCharArray()){
            if(root.children[c - 'a'] == null){
                root.children[c - 'a'] = new TrieNode();
            }
            root = root.children[c - 'a'];
        }
        root.word = word;
    }

    static class TrieNode{
        TrieNode[] children;
        String word;
        TrieNode(){
            this.children = new TrieNode[26];
            this.word = null;
        }
    }
}
