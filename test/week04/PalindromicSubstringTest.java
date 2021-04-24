package week04;

import org.junit.Test;

import static org.junit.Assert.*;

public class PalindromicSubstringTest {
    PalindromicSubstring p = new PalindromicSubstring();

    @Test
    public void countSubstrings() {
        assertEquals(6, p.countSubstrings("aaa"));
    }
}