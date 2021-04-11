package week02;

import org.junit.Test;

import static org.junit.Assert.*;

public class AddDigitsTest {

    AddDigits a = new AddDigits();

    @Test
    public void addDigits() {
        assertEquals(2,a.addDigits(38));
    }
}