package com.bmywan.backtracking;

import org.junit.Test;

import static org.junit.Assert.*;

public class PartitionTest {
    Partition p = new Partition();

    @Test
    public void partition() {
        p.partition("aab");
    }
}