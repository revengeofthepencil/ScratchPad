package permutePalindrome;

import java.util.ArrayList;

/**
 * Created by alexwalker on 7/13/16.

 Write an efficient function that checks whether any permutation ↴ of an input string is a palindrome ↴ .
 Examples:

 "civic" should return True
 "ivicc" should return True
 "civil" should return False
 "livci" should return False

 */
public class PermutationPal {
    public boolean checkForPal(String palCheck) {
        int palCheckLength = palCheck.length();

        for (int i = 0; i < palCheckLength; i++) {
            int endIdx = palCheckLength - i - 1;
            char c1 = palCheck.charAt(i);
            char c2 = palCheck.charAt(endIdx);
            if (c1 != c2) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        PermutationPal pp = new PermutationPal();
        String palsToCheck[] = {"civic","ivicc","civil", "livci"};
        for (String palCheck : palsToCheck) {
            boolean isPal = pp.checkForPal(palCheck);
            System.out.println("'" + palCheck + "' = " + isPal);
        }

    }
}
