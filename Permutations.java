class Solution {
    public List<List<Integer>> permute(int[] nums) {
        Set<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        permute(0, nums, list, ans, new HashSet<>());
        return ans;
    }
    public static void permute(int index, int nums[], List<Integer> list, List<List<Integer>> ans, Set<Integer> set) {
        if(index == nums.length) {
            ans.add(list);
            return;
        }
        for(int j=0;j<nums.length;j++) {
            if(!set.contains(nums[j])) {
                list.add(nums[j]);
                set.add(nums[j]);
                permute(index+1, nums, new ArrayList<>(list), ans, set);
                set.remove(nums[j]);
                list.remove(list.size()-1);
            }
        }
    }
}
