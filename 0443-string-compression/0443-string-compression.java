class Solution {
    public int compress(char[] chars) {
        int write = 0;   // position where we write
        int read = 0;    // position where we read

        while (read < chars.length) {
            char current = chars[read];
            int count = 0;

            // Count same characters
            while (read < chars.length && chars[read] == current) {
                read++;
                count++;
            }

            // Write the character
            chars[write++] = current;

            // Write count only if greater than 1
            if (count > 1) {
                String s = String.valueOf(count);

                for (char c : s.toCharArray()) {
                    chars[write++] = c;
                }
            }
        }

        return write;
    }
}