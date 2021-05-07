package zniuyang.buckets;

import org.junit.Test;

import static org.junit.Assert.*;

public class LeastIntervalTest {
    LeastInterval l = new LeastInterval();

    @Test
    public void leastInterval() {
        assertEquals(8, l.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
    }
}