package leetcode.MicorsoftOnSite;

import java.util.*;

// Microsoft 11-19-21 phone interview
// written by Trevor
public class Solution {
    public static boolean[][][] SAFE_CONFIGURATIONS;
    int row;
    int col;

    public boolean checkSwitches(boolean[][] current, boolean[][] requested) {
        if (current == null || requested == null || current.length == 0 || current[0].length == 0 || requested.length == 0 || requested[0].length == 0)
            return false;

        row = current.length; col = current[0].length;
        Set<List<List<Boolean>>> safeConfigSet = generateSafeConfig();
        List<List<Boolean>> listCurrent = convertStatus(current);
        List<List<Boolean>> listRequest = convertStatus(requested);
        Set<List<List<Boolean>>> visited = new HashSet<>();

        return dfs(listCurrent, listRequest, safeConfigSet, visited);
    }

    private boolean dfs(List<List<Boolean>> listCurrent, List<List<Boolean>> listRequest, Set<List<List<Boolean>>> safeConfigSet, Set<List<List<Boolean>>> visited) {
        if (checkSame(listCurrent, listRequest)) return true;

        visited.add(listCurrent);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                listCurrent.get(i).set(j, !listCurrent.get(i).get(j)); // reverse a switch to get a new status
                if (safeConfigSet.contains(listCurrent) && !visited.contains(listCurrent) && dfs(listCurrent, listRequest, safeConfigSet, visited))
                    return true;
                listCurrent.get(i).set(j, !listCurrent.get(i).get(j));
            }
        }

        return false;
    }

    // check if the current status equals to request status
    private boolean checkSame(List<List<Boolean>> listCurrent, List<List<Boolean>> listRequest) {
        for(int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!listCurrent.get(i).get(j).equals(listRequest.get(i).get(j))) return false;
            }
        }

        return true;
    }

    // add all safe config status to hashset
    private Set<List<List<Boolean>>> generateSafeConfig() {
        Set<List<List<Boolean>>> set = new HashSet<>();

        for (boolean[][] configs: SAFE_CONFIGURATIONS) {
            List<List<Boolean>> listConfigs = convertStatus(configs);
            set.add(listConfigs);
        }

        return set;
    }
    // convert 2d boolean array to 2d array list for set to compare
    private List<List<Boolean>> convertStatus(boolean[][] status) {
        List<List<Boolean>> list = new ArrayList<>();

        for (boolean[] row: status) {
            List<Boolean> tmp = new ArrayList<>();
            for (boolean ele: row) {
                tmp.add(ele);
            }
            list.add(tmp);
        }

        return list;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        // SAFE_CONFIGURATIONS = new boolean[][][] {{{true, false}, {false, true}}, {{true, false}, {false, false}}, {{false, false}, {false, false}}, {{false, true}, {false, false}}};
        SAFE_CONFIGURATIONS = new boolean[][][] {{{true, false}, {false, true}}, {{true, false}, {false, false}}, {{false, true}, {false, false}}};
        boolean[][] current = new boolean[][] {{true, false}, {false, true}};
        boolean[][] request = new boolean[][] {{false, true}, {false, false}};

        System.out.println(sol.checkSwitches(current, request));
    }
}
