package zniuyang.dfs;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindItineraryTest {
    FindItineraryDFS f = new FindItineraryDFS();

    @Test
    public void findItinerary() {
        List<List<String>> list = new ArrayList<>();
        List<String > list1 = Arrays.asList(new String[]{"JFK","KUL"});
        List<String > list2 = Arrays.asList(new String[]{"JFK","NRT"});
        List<String > list3 = Arrays.asList(new String[]{"NRT","JFK"});
        list.add(list1);
        list.add(list2);
        list.add(list3);
        f.findItinerary(list);
    }
}