package interviewCake;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by alexwalker on 7/13/16.

 Write an efficient function that checks whether any permutation of an input string is a palindrome .
 Examples:

 "civic" should return True
 "ivicc" should return True
 "civil" should return False
 "livci" should return False

 */
public class PermutationPal {

    public boolean isPalPermute(String permuteString) {
        permuteString = permuteString.toLowerCase().replaceAll(" ", "");
        int allowedUneven = permuteString.length() % 2 == 0 ? 0 : 1;

        System.out.println("string = '" + permuteString + "', length = '" + permuteString.length() + "', allowedUneven = " + allowedUneven);

        Map<Character, Integer> charCounts = new HashMap<Character, Integer>();
        for(char c : permuteString.toCharArray()) {
            if (charCounts.containsKey(c)) {
                charCounts.put(c, charCounts.get(c) + 1);
            } else {
                charCounts.put(c, 1);
            }
        }

        int foundUneven = 0;
        for (Map.Entry<Character, Integer> entry : charCounts.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                foundUneven++;
            }

            if (foundUneven > allowedUneven) {
                break;
            }
        }

        return  foundUneven == allowedUneven;
    }


    public static void main(String[] args) {
        PermutationPal pp = new PermutationPal();
        String palsToCheck[] = {"civic", "ivicc","civil", "livci", "civici", "a man a plan a canal panama",
                "a man a plan panama a canal", "a panamas man a plan  a canal"};
        for (String palCheck : palsToCheck) {
            System.out.println("\nchecking '" + palCheck + "' ....");
            boolean isPal = pp.isPalPermute(palCheck);
            System.out.println("'" + palCheck + "' = " + isPal);
        }

    }
}
