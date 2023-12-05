public class lc1888 {

    public int minFlips(String s) {
        int n = s.length();
        StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
        for (int i = 0; i < 2 * n; i++) {
            sb1.append(i % 2 == 0 ? '0' : '1');
            sb2.append(i % 2 == 0 ? '1' : '0');
        }
        String alt1 = sb1.toString(), alt2 = sb2.toString();
        s += s; // Append the string to itself to simulate rotations
        int[] flips1 = new int[2 * n], flips2 = new int[2 * n];

        for (int i = 0; i < 2 * n; i++) {
            flips1[i] = (s.charAt(i) != alt1.charAt(i) ? 1 : 0) + (i == 0 ? 0 : flips1[i - 1]);
            flips2[i] = (s.charAt(i) != alt2.charAt(i) ? 1 : 0) + (i == 0 ? 0 : flips2[i - 1]);
        }

        int minFlips = Integer.MAX_VALUE;
        for (int i = n - 1; i < 2 * n; i++) {
            minFlips = Math.min(minFlips, Math.min(flips1[i] - (i == n - 1 ? 0 : flips1[i - n]), flips2[i] - (i == n - 1 ? 0 : flips2[i - n])));
        }
        return minFlips;
    }
//Create two alternating strings of length 2n, where n is the length of the input string (to simulate all rotations).
//Extend the input string to 2n by appending it to itself.
//For each position in the extended string, calculate the number of flips needed to match both alternating strings.
//Use a sliding window of size n to find the minimum number of flips needed to make a substring of length n alternating.
// The window simulates the effect of all possible rotations.
}
