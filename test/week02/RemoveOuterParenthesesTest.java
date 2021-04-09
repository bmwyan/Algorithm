package week02;

import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveOuterParenthesesTest {
    RemoveOuterParentheses r = new RemoveOuterParentheses();

    @Test
    public void removeOuterParentheses() {
        String act = r.removeOuterParentheses("(()())(())");
        assertEquals("()()()",act);
    }
}