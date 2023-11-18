package blind75;

import java.util.ArrayList;
import java.util.*;

public class lc212 {
    //word search 2
    /**
     * Given an m x n board of characters and a list of strings words, return all words on the board.
     *
     * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
     *
     */
    char[][] board = null;
    ArrayList<String> result = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (Character letter : word.toCharArray()) {
                if (node.children.containsKey(letter)) {
                    node = node.children.get(letter);
                }else {
                    TrieNode newNode = new TrieNode();
                    node.children.put(letter, newNode);
                    node = newNode;
                }
            }
            node.word = word;
        }
        this.board= board;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (root.children.containsKey(board[row][col])) {
                    backtracking(row, col, root);
                }
            }
        }
        return this.result;
    }

    private void backtracking(int row, int col, TrieNode parent) {
        Character letter = this.board[row][col];
        TrieNode currNode = parent.children.get(letter);
        if (currNode.word != null) {
            this.result.add(currNode.word);
            currNode.word = null;
        }
        this.board[row][col] = '#';
        int[] rowoffset = {-1,0,1,0};
        int[] coloffset = {0,1,0,-1};
        for (int i = 0; i < 4; i++) {
            int newrow = row + rowoffset[i];
            int newcol = col + coloffset[i];
            if (newrow < 0 || newrow >= this.board.length || newcol < 0 || newcol >= this.board[0].length)
                continue;
            if (currNode.children.containsKey(this.board[newrow][newcol])) {
                backtracking(newrow, newcol, currNode);
            }
        }
        this.board[row][col] = letter;
        if (currNode.children.isEmpty()) {
            parent.children.remove(letter);
        }
    }
}
class TrieNode{
    HashMap<Character, TrieNode> children = new HashMap<>();
    String word = null;
    public TrieNode() {}
}
