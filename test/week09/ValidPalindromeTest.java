package week09;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidPalindromeTest {

    ValidPalindrome  v = new ValidPalindrome();

    @Test
    public void isPalindrome() {
        assertEquals(true,v.isPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    public void isPalindrome2() {
        assertEquals(true,v.isPalindrome("0P"));
    }
}