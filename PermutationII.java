class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(0, nums, new ArrayList<>(), result, new boolean[nums.length]);
        return result;
    }
    public static void permute(int idx, int nums[], List<Integer> list, List<List<Integer>> result, boolean[] used) {
        if(idx == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        Set<Integer> seen = new HashSet<>();
        for(int j=0;j<nums.length;j++) {
            if(!used[j] && seen.add(nums[j])) {
                used[j] = true;
                list.add(nums[j]);
                permute(idx+1, nums, list, result, used);
                used[j] = false;
                list.remove(list.size()-1);
            }
        }
    }
}
