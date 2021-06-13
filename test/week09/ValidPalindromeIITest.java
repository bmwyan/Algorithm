package week09;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidPalindromeIITest {
    ValidPalindromeII v =new ValidPalindromeII();

    @Test
    public void validPalindrome() {

        assertEquals(true,v.validPalindrome("ebcbbececabbacecbbcbe"));
    }

    @Test
    public void validPalindrome2() {

        assertEquals(true,v.validPalindrome("ececabbacec"));
    }
}