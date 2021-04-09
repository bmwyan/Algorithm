package week02;

import org.junit.Test;

import static org.junit.Assert.*;

public class GetHintTest {
    GetHint hint = new GetHint();

    @Test
    public void getHint() {
        String act = hint.getHint("1807","7810");
        assertEquals(act,"1A3B");
    }

    @Test
    public void getHint2() {
        String act = hint.getHint("1123","0111");
        assertEquals(act,"1A1B");
    }

    @Test
    public void getHint3() {
        String act = hint.getHint("1234","6666");
        assertEquals(act,"0A0B");
    }

    @Test
    public void getHint4() {
        String act = hint.getHint("2234","6626");
        assertEquals(act,"0A1B");
    }
}