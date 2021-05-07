package week05;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class LadderLengthTest {
    LadderLength l = new LadderLength();

    @Test
    public void ladderLength() {
        List<String> wordLists = Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"});

        assertEquals(5, l.ladderLength("hit", "cog", wordLists));

    }


    @Test
    public void ladderLength2() {
        List<String> wordLists = Arrays.asList(new String[]{"hot",  "dog"});

        assertEquals(0, l.ladderLength("hot", "dog", wordLists));

    }
}