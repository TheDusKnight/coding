package mianjing.amazon_oa.CaesarCipher;

public class Solution {
    public static String simpleCipher(String encrypted, int k) {
        char[] _encrypted = encrypted.toCharArray();
        for (int i = 0; i < encrypted.length(); i++) {
            char x = _encrypted[i];
            // if the previous kth element is greater than 'A'
            if (x - k >= 65) {
                _encrypted[i] = (char) (x - k);
            }
            // if ascii code of kth previous element if less than that of A add 26 to it
            else {
                _encrypted[i] = (char) (x - k + 26);
            }
        }
        return new String(_encrypted);
    }
}
