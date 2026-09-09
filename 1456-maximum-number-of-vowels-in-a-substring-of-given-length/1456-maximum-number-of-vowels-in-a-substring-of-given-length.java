class Solution {
    public int maxVowels(String s, int k) {
        int count = 0;
        for(int i = 0; i<k; i++){
            if(isVowel(s.charAt(i))){
                count++;
            }

        }
        int maxCount = count;
        for(int right = k; right<s.length(); right++){
            if(isVowel(s.charAt(right))){
                count++;
            }

             if(isVowel(s.charAt(right-k))){
                count--;
            }

            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
        
    }

    public boolean isVowel(char c){
         return c == 'a' || c == 'e' || c == 'i' ||
               c == 'o' || c == 'u';
    }
}