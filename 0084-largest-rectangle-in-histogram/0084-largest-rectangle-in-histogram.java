class Solution {
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;

        int[] leftbounds = new int[n];
        int[] rightbounds = new int[n];

        Stack<Integer> s = new Stack<>();

        // Right boundary
        for (int i = n - 1; i >= 0; i--) {

            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }

            rightbounds[i] = s.isEmpty() ? n : s.peek();

            s.push(i);
        }

        s.clear();

        // Left boundary
        for (int i = 0; i < n; i++) {

            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }

            leftbounds[i] = s.isEmpty() ? -1 : s.peek();

            s.push(i);
        }

        int max = 0;

        for (int i = 0; i < n; i++) {

            int width = rightbounds[i] - leftbounds[i] - 1;

            int area = width * heights[i];

            max = Math.max(max, area);
        }

        return max;
    }
}