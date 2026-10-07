class Solution {

    public static void generat(int n, int left, int right,
                               String s, List<String> ans) {

        // All opening brackets are used
        if (right == n) {
            ans.add(s);
            return;
        }

        // Add '(' if we still have opening brackets available
        if (left < n) {
            generat(n, left + 1, right, s + "(", ans);
        }

        // Add ')' only when an unmatched '(' exists
        if (right < left) {
            generat(n, left, right + 1, s + ")", ans);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();

        generat(n, 0, 0, "", ans);

        return ans;
    }
}