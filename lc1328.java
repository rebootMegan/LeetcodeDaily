public class lc1328 {
    public String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1) return "";
        int length = palindrome.length();
        char[] palindromArr = palindrome.toCharArray();
        for (int i = 0; i < length / 2; i++) {
            if (palindromArr[i] != 'a') {
                palindromArr[i] = 'a';
                return String.valueOf(palindromArr);
            }
        }
        palindromArr[length - 1] = 'b';
        return String.valueOf(palindromArr);
    }
}
