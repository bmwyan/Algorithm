package week07;

import org.junit.Test;

import static org.junit.Assert.*;

public class Day45WordSearchIITest {
    Day45WordSearchII w = new Day45WordSearchII();
    char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'h', 'k', 'r'}};
    char[][] board1 = {{'a', 'a'}};
    char[][] board2 = {{'a','b','c','e'},{'x','x','c','d'},{'x','x','b','a'}};


    @Test
    public void findWords() {
        w.findWords(board, new String[]{"oath", "pea", "eat", "rain"});
    }

    @Test
    public void findWords2() {
        w.findWords(board1, new String[]{"aaa"});
    }


    @Test
    public void findWords3() {
        w.findWords(board2, new String[]{"abc","abcd"});
    }
}