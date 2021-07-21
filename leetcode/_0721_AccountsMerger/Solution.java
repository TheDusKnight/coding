package leetcode._0721_AccountsMerger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

public class Solution {
    private static class UnionFind {
        private int[] parents;
        private int[] sizes;
        
        public UnionFind(int capacity) {
            parents = new int[capacity];
            sizes = new int[capacity];
            
            for (int i = 0; i < capacity; i++) {
                parents[i] = i;
                sizes[i] = 1;
            }
        }
        
        public boolean find(int user1, int user2) {
            return getRoot(user1) == getRoot(user2);
        }
        
        public void union(int user1, int user2) {
            int root1 = getRoot(user1);
            int root2 = getRoot(user2);
            
            if (sizes[root1] > sizes[root2]) {
                parents[root2] = root1;
                sizes[root1] += sizes[root2];
            } else {
                parents[root1] = root2;
                sizes[root2] += sizes[root1];
            }
        }
        
        public int getRoot(int user) {
            int cur = user;
            
            while (parents[cur] != cur) {
                parents[cur] = parents[parents[cur]];
                cur = parents[cur];
            }
            
            parents[user] = cur;
            return cur;
        }
    }
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        if (accounts == null) {
            throw new IllegalArgumentException();
        }
        
        int len = accounts.size();
        UnionFind uf = new UnionFind(len);
        
        HashMap<String, Integer> emailToUserMap = new HashMap<>();
        
        for (int i = 0; i < len; i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                Integer user = emailToUserMap.get(email);
                if (user == null) {
                    emailToUserMap.put(email, i);
                } else { // 之前有user使用过相同的email，开始union两个user
                    uf.union(i, user);
                }
            }
        }
        
        HashMap<Integer, HashSet<String>> userToEmailsMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int root = uf.getRoot(i);
            if (!userToEmailsMap.containsKey(root)) {
                userToEmailsMap.put(root, new HashSet<>());
            }
            
            for (int j = 1; j < accounts.get(i).size(); j++) {
                userToEmailsMap.get(root).add(accounts.get(i).get(j));
            }
        }
        List<List<String>> res = new ArrayList<>();
        for (Entry<Integer, HashSet<String>> e: userToEmailsMap.entrySet()) {
            List<String> list = new LinkedList<>();
            list.addAll(e.getValue());
            Collections.sort(list);
            list.add(0, accounts.get(e.getKey()).get(0));
            res.add(list);
        }
        return res;
    }
}

// O(n*k*log(n) + O(n*k*log(k)))