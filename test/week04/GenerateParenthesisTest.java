package week04;

import org.junit.Test;

import static org.junit.Assert.*;

public class GenerateParenthesisTest {

    GenerateParenthesis g = new GenerateParenthesis();

    @Test
    public void generateParenthesis() {
        g.generateParenthesis(3);
    }
}