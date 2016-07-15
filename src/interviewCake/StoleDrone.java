package interviewCake;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by awalker on 7/14/16.

 https://www.interviewcake.com/question/python/find-unique-int-among-duplicates?utm_source=weekly_email

 Your company delivers breakfast via autonomous quadcopter drones. And something mysterious has happened.
 Each breakfast delivery is assigned a unique ID, a positive integer. When one of the company's 100 drones takes off with
 a delivery, the delivery's ID is added to a list, delivery_id_confirmations. When the drone comes back and lands, the ID
 is again added to the same list.

 After breakfast this morning there were only 99 drones on the tarmac. One of the drones never made it back from a delivery.
 We suspect a secret agent from Amazon placed an order and stole one of our patented drones. To track them down, we need to
 find their delivery ID.

 Given the list of IDs, which contains many duplicate integers and one unique integer, find the unique integer.

 The IDs are not guaranteed to be sorted or sequential. Orders aren't always fulfilled in the order they were received,
 and some deliveries get cancelled before takeoff.
 */

public class StoleDrone {

    public static int getUnique(List<Integer> numsToCheck) {
        int uniqueNum = 0;

        for (int i=0; i < numsToCheck.size(); i++) {
            uniqueNum ^= numsToCheck.get(i);
        }

        return uniqueNum;
    }

    public static void main(String[] args) {
        // build up the list of ids
        List<Integer> idsToCheck = new ArrayList<Integer>();
        Random random = new Random();
        int testIdx = random.nextInt(100 - 1) + 1;
        int uniqueVal = random.nextInt(100 - 10) + 10;
        System.out.println("test idx = " + testIdx + ", uniqueVal = " + uniqueVal);
        Integer[] availIds = {1, 2, 3, 4, 5, 6};
        int idx = 0;
        while(idsToCheck.size() < 100) {
            idsToCheck.add(availIds[idx]);
            idx++;
            if (idx >= availIds.length) {
                idx = 0;
            }

            if (idsToCheck.size() == testIdx) {
                idsToCheck.add(uniqueVal);
            }
        }

        System.out.println("unique number = " + StoleDrone.getUnique(idsToCheck));
    }

}
