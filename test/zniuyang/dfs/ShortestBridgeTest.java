package zniuyang.dfs;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShortestBridgeTest {
    ShortestBridge s = new ShortestBridge();

    @Test
    public void shortestBridge() {
        s.shortestBridge(new int[][]{{0, 1}, {1, 0}});
    }
}