
import java.util.HashMap;

class Solution {
    public int maxNumberOfBalloons(String text) {

        HashMap<Character, Integer> map = new HashMap<>();

        // Count each character
        for (char ch : text.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int count = 0;

        while (true) {
            char[] balloon = {'b', 'a', 'l', 'l', 'o', 'o', 'n'};

            // Check whether one complete balloon can be formed
            HashMap<Character, Integer> needed = new HashMap<>();

            for (char ch : balloon) {
                needed.put(ch, needed.getOrDefault(ch, 0) + 1);
            }

            boolean possible = true;

            for (char ch : needed.keySet()) {
                if (map.getOrDefault(ch, 0) < needed.get(ch)) {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                return count;
            }

            // Use characters for one balloon
            for (char ch : balloon) {
                map.put(ch, map.get(ch) - 1);
            }

            count++;
        }
    }
}
