class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationSum(0, candidates, new ArrayList<>(), result, target);
        return result;
    }
    public void combinationSum(int index,int candidates[], List<Integer> current, List<List<Integer>> result, int target) {
        if(target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i=index;i<candidates.length;i++) {
           if(candidates[i] <= target) {
                current.add(candidates[i]);
                combinationSum(i, candidates,current, result, target - candidates[i]);
                current.remove(current.size()-1);
           }
        }
        
    }
}
