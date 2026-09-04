class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) {
            return result;
        }

        int[] pFreq = new int[26];
        int[] windowFreq = new int[26];

        for (char c : p.toCharArray()) {
            pFreq[c - 'a']++;
        }

        int k = p.length();

        for (int i = 0; i < s.length(); i++) {
            windowFreq[s.charAt(i) - 'a']++;

            if (i >= k) {
                windowFreq[s.charAt(i - k) - 'a']--;
            }

            if (i >= k - 1 && Arrays.equals(pFreq, windowFreq)) {
                result.add(i - k + 1);
            }
        }

        return result;
    }
}