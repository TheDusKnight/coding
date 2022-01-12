package leetcode._0399_EvaluateDivision;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    class V {
        String name;
        V parent;
        int size;
        double val;
        
        public V(String name) {
            this.name = name;
            parent = this;
            size = 1;
            val = 1.0;
        }
    }
    
    private V getRoot(V p) {
        V cur = p;
        double d = 1.0;
        while (cur.parent != cur) {
            cur.val *= cur.parent.val;
            // 注意cur的下一个不是cur.parent而是cur.parent.paretn
            // d要保证乘以所有cur.val所以一轮乘以cur.val和cur.parent.val
            d *= cur.val;
            cur.parent = cur.parent.parent;
            cur = cur.parent;
        }
        p.val = d;
        p.parent = cur;
        
        return cur;
    }
    
    public boolean find(V p, V q) {
        return getRoot(p) == getRoot(q);
    }
    
    public void union(V p, V q, double d) { // d is v1, v2 division
        V rootP = getRoot(p), rootQ = getRoot(q);
        if (rootP.size > rootQ.size) {
            rootQ.val = p.val * d / q.val;
            rootQ.parent = rootP;
            rootP.size += rootQ.size;
        } else {
            rootP.val = q.val / (p.val * d);
            rootP.parent = rootQ;
            rootQ.size += rootP.size;
        }
    }
    
    private double division(V p, V q) {
        // v1.val = |p|/|v1|; v2.val = |p|/|v2|;
        // v2.val / v1.val = |v1| / |v2|
        return q.val / p.val;
    }
    
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        // cc
        int equLen = equations.size(), queLen = queries.size();
        Map<String, V> map = new HashMap<>();
        // construct UF
        for (int i = 0; i < equLen; i++) {
            List<String> equ = equations.get(i);
            String s0 = equ.get(0), s1 = equ.get(1);
            double val = values[i];
            
            V v0 = map.get(s0), v1 = map.get(s1);
            if (v0 == null) {
                v0 = new V(s0);
                map.put(s0, v0);
            }
            if (v1 == null) {
                v1 = new V(s1);
                map.put(s1, v1);
            }
            if (!find(v0, v1)) {
                union(v0, v1, val);
            }
        }
        // cal query
        double[] res = new double[queLen];
        for (int i = 0; i < queLen; i++) {
            List<String> que = queries.get(i);
            String q0 = que.get(0), q1 = que.get(1);
            V v0 = map.get(q0), v1 = map.get(q1);
            if (v0 == null || v1 == null) {
                res[i] = -1.0;
                continue;
            }
            if (find(v0, v1)) {
                res[i] = division(v0, v1);
            } else {
                res[i] = -1.0;
            }
        }
        
        return res;
    }
}

// O(m*log(m) + n*log(m)). m is length of equations, n is length of queries