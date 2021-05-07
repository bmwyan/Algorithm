package week06;

import org.junit.Test;

import static org.junit.Assert.*;

public class JumpIITest {
    JumpII j = new JumpII();

    @Test
    public void jump() {
        assertEquals(0, j.jump(new int[]{0}));
    }
}