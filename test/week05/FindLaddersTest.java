package week05;

import org.junit.Test;
import week05.binarysearch.FindLadders;

import java.util.Arrays;
import java.util.List;

public class FindLaddersTest {
    FindLadders f = new FindLadders();

    @Test
    public void findLadders() {
        List<String> wordLists = Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        f.findLadders("hit", "cog", wordLists);
    }

    @Test
    public void findLadders2() {
        List<String> wordLists = Arrays.asList(new String[]{"a", "b", "c"});
        f.findLadders("a", "b", wordLists);
    }
}