class Solution {

    public static void solve(int[] nums, int idx, List<Integer> current, List<List<Integer>> ans){
        if(idx == nums.length){
            ans.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[idx]);
        solve(nums,idx+1,current,ans);
        current.remove(current.size()-1);
        solve(nums,idx+1,current,ans);



    }


    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int idx = 0;
        solve(nums, idx , new ArrayList<>(), ans);
        return ans;
        
    }
}