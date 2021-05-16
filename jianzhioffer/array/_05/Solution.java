package jianzhioffer.array._05;

/**
 * 替换空格
 */
public class Solution {
    public String replaceSpace(String s) {
        String newUrlString = s.replaceAll(" ", "%20");
        return newUrlString;
    }
}