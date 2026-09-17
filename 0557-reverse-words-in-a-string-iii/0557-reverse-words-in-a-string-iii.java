class Solution {
    public String reverseWords(String s) {
        char[] ch = s.toCharArray();
        int j = 0;

        for (int i = 0; i < ch.length; i++) {

            if (ch[i] == ' ' || i == ch.length - 1) {

                int left = j;
                int right = i - 1;

                if (i == ch.length - 1) {
                    right = i;
                }

                while (left < right) {
                    char temp = ch[left];
                    ch[left] = ch[right];
                    ch[right] = temp;

                    left++;
                    right--;
                }

                
                j = i + 1;
            }
        }

        return new String(ch);
    }
}