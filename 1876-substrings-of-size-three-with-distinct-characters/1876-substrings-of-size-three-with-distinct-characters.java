class Solution {
    public int countGoodSubstrings(String s) {
        int count = 0;
        int frq[] = new int[26];
        if(s.length()<3) return 0;
        for(int i=0; i<3; i++){
            frq[s.charAt(i) - 'a']++;
            
        }
        if(isDistinct(frq)){
            count++;
        }
        for(int i = 3; i<s.length(); i++){
            frq[s.charAt(i) - 'a']++;
            frq[s.charAt(i-3) - 'a']--;
            if(isDistinct(frq)){
            count++;
            }
        
        }

        
        
     return count;
        
    }
    public boolean isDistinct(int[] freq) {

        for (int i = 0; i < 26; i++) {

            if (freq[i] > 1) {
                return false;
            }
        }

        return true;
    }
}