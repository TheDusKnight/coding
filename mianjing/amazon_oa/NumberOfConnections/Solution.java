package mianjing.amazon_oa.NumberOfConnections;

import java.util.List;

public class Solution {
    public static int numberOfConnections(List<List<Integer>> gridOfNodes) {
        // cc

        int connections = 0;
        int preCount = 0;
        for (List<Integer> list: gridOfNodes) {
            int levelCount = 0;
            for (int i: list) levelCount += i;
            if (levelCount == 0) continue;
            connections += preCount * levelCount;;
            preCount = levelCount;
        }
        return connections;
    }
    
}
