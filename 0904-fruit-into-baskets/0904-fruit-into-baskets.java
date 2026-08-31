class Solution {
    public int totalFruit(int[] fruits) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int max = 0;

        for (int right = 0; right < fruits.length; right++) {

            // fruit ko window me add karo
            map.put(fruits[right],
                    map.getOrDefault(fruits[right], 0) + 1);

            // agar 2 se zyada fruit types hain
            while (map.size() > 2) {

                map.put(fruits[left], map.get(fruits[left]) - 1);

                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }

                left++;
            }

            // current valid window
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}