class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        return combinationSum2(0, candidates, new ArrayList<>(), result, target);
    }
    public List<List<Integer>> combinationSum2(int index, int candidates[], List<Integer> current, List<List<Integer>> result, int target) {
        if(target == 0) {
            result.add(new ArrayList<>(current));
            return result;
        }
        for(int i=index;i<candidates.length && candidates[i] <= target;i++) {
            if(i > index && candidates[i] == candidates[i-1]) {
                continue;
            }
            current.add(candidates[i]);
            combinationSum2(i+1, candidates, current, result, target - candidates[i]);
            current.remove(current.size()-1);
            
        }

        return result;
    }
}
