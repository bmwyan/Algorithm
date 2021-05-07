package zniuyang.others;

import org.junit.Test;

import static org.junit.Assert.*;

public class GetTaskOrderTest {
    GetTaskOrder order =new GetTaskOrder();

    @Test
    public void getOrder() {
        int[][] task={{1,2},{2,4},{3,2},{4,1}};
        order.getOrder(task);
    }
}