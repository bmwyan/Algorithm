package week10;

import org.junit.Test;

import static org.junit.Assert.*;

public class IsIsomorphicTest {
    IsIsomorphic i = new IsIsomorphic();

    @Test
    public void isIsomorphic() {
        assertEquals(true,i.isIsomorphic("egg","add"));
    }
}