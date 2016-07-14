package interviewCake;

/**
 * Created by awalker on 7/14/16.
 *
 * "Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing."

 Write a function that, given a sentence like the one above, along with the position of an opening parenthesis, finds the corresponding closing parenthesis.

 Example: if the example string above is input with the number 10 (position of the first parenthesis), the output should be 79 (position of the last parenthesis).
 */

public class ParenMatch {

    public static int getClosingIdx(String testString, int checkIdx) {
        int parenCount = 0;
        if (testString.charAt(checkIdx) == '(') {
            parenCount++;

            while(parenCount > 0 && checkIdx < (testString.length() -1)) {
                checkIdx++;
                if (testString.charAt(checkIdx) == ')') {
                    parenCount--;
                } else if (testString.charAt(checkIdx) == '(') {
                    parenCount++;
                }
            }

            return checkIdx < testString.length() ? checkIdx : -1;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        final String testString = "Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing.";
        final int firstIdx = 10;
        int closingIdx = ParenMatch.getClosingIdx(testString, firstIdx);

        if (closingIdx > -1) {
            System.out.println("closing idx = " + closingIdx + ", character = " + testString.charAt(closingIdx));
        } else {
            System.out.println("no closing idx found... perhaps you passed an invalid character?");
        }
    }
}
