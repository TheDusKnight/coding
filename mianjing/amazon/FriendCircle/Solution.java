package mianjing.amazon.FriendCircle;

import java.util.Arrays;
import java.util.List;

// dfs. Similar to lc547
public class Solution {
    static int row, col;
    public static int findSubscriberGroups(List<String> arrayList) {
        // cc

        row = arrayList.size(); col = arrayList.get(0).length();
        int[][] matrix = new int[row][col];

        for (int i = 0; i < row; i++) {
            String s = arrayList.get(i);
            for (int  j = 0; j < col; j++) {
                matrix[i][j] = (s.charAt(j) - '0');
            }
        }

        int count = 0;
        boolean visited[] = new boolean[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            if (!visited[i]) {
                dfs(matrix, visited, i);
                count++;
            }
        }

        return count;
    }

    private static void dfs(int[][] matrix, boolean[] visited, int i) {
        for (int j = 0; j < matrix[0].length; j++) {
            if (!visited[j] && matrix[i][j] == 1) {
                visited[j] = true;
                dfs(matrix, visited, j);
            }
        }
    }

    public static void main(String[] args) {

        String given1[] = {"110", "110", "011"}; //2
        String given2[] = {"1100", "1101", "0010", "0010", "0001"}; //2
        String given3[] = {"110", "111", "011"}; //1
    
    
        String arr1[] = {"1100", "1110", "0110", "0001"};//2
        String arr2[] = {"10000", "01000", "00100", "00010", "00001"};//5
        String arr5[] = {"11100", "11001", "10100", "00011", "01011"};//1
        String arr6[] = {"11100", "11100", "11100", "00011", "00011"};//2
        String arr7[] = {"10100", "01010", "10100", "01010", "00001"};//3
    
        List<String> arrayList = Arrays.asList(arr7);
        int result = Solution.findSubscriberGroups(arrayList);
        System.out.println(result);
    
    }
}

// time: O(n^2). touch every node at most twice, node number is n^2; space: O(n ~ n^2)