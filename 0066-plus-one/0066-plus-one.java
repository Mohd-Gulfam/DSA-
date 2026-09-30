class Solution {
    public int[] plusOne(int[] digits) {

        // Right se left traverse karenge
        for (int i = digits.length - 1; i >= 0; i--) {

            // Agar digit 9 nahi hai
            if (digits[i] < 9) {

                // Simply 1 add kar do
                digits[i]++;

                // Kaam complete
                return digits;
            }

            // Agar digit 9 hai
            // 9 + 1 = 10
            // Current digit 0 ban jayega
            digits[i] = 0;
        }

        // Agar yahan aaye hain,
        // iska matlab saare digits 9 the

        // Example: [9,9,9] -> [1,0,0,0]
        int[] result = new int[digits.length + 1];

        result[0] = 1;

        return result;
    }
}