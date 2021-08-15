package leetcode._0133_CloneGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

// 建图
// 无向连接图可以传graph node
// 这道题没有查环只有check visited，因为建图没有路径的概念，只要每个node都有neighbors即可
class Solution {
    private Map<Node, Node> memo = new HashMap<>(); // map防止visited过的node重复visit
    public Node cloneGraph(Node node) { // return Node代表input node的clone node
        if (node == null) return node;
        
        // If the node was already visited before.
        // Return the clone from the visited dictionary.
        if (memo.containsKey(node))
            return memo.get(node);
        
        Node cloneNode = new Node(node.val, new ArrayList<>());
        memo.put(node, cloneNode);
        
        List<Node> neighbors = node.neighbors;
        for (Node neighbor: neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }
}

// n是点的个数，m是边的个数，H是栈的高度也就是graph的高度
// time: O(n + m); space: O(n + H) = O(n);
