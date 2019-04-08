package palo.mantu.practice.dailycodingproblem.dcp063;

/*
This problem was asked by Microsoft.

Given a 2D matrix of characters and a target word,
write a function that returns whether the word can be found in the matrix by going left-to-right, or up-to-down.

For example, given the following matrix:
[['F', 'A', 'C', 'I'],
 ['O', 'B', 'Q', 'P'],
 ['A', 'N', 'O', 'B'],
 ['M', 'A', 'S', 'S']]
and the target word 'FOAM', you should return true, since it's the leftmost column.
Similarly, given the target word 'MASS', you should return true, since it's the last row.
*/
public class MatrixWordSearch {
    public boolean search(char[][] words, String word) {
        if (words == null || word == null) {
            return false;
        }
        for (int i = 0; i < words.length; i++) {
            if (word.charAt(0) != words[i][0] || word.length() != words[i].length) {
                continue;
            }
            if (word.equals(String.valueOf(words[i]))) {
                return true;
            }
        }
        if (word.length() != words.length) {
            return false;
        }
        for (int j = 0; j < words[0].length; j++) {
            if (word.charAt(0) != words[0][j]) {
                continue;
            }
            char[] colWord = new char[words.length];
            for (int i = 0; i < words.length; i++) {
                colWord[i] = words[i][j];
            }
            if (word.equals(String.valueOf(colWord))) {
                return true;
            }
        }
        return false;
    }
}