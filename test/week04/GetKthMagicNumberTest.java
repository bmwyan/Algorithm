package week04;

import org.junit.Test;

import static org.junit.Assert.*;

public class GetKthMagicNumberTest {
    GetKthMagicNumber g =new GetKthMagicNumber();

    @Test
    public void getKthMagicNumber() {
        assertEquals(21,g.getKthMagicNumber(7));
    }
}