class Solution {
    public String destCity(List<List<String>> paths) {
         Map<String, String> map = new HashMap<>();
        for(List<String> path : paths) {
            String from = path.get(0);
            String to = path.get(1);
            map.put(from, to);
        }
        
        String destination = paths.get(0).get(1); 
        while(map.containsKey(destination)) {
            destination = map.get(destination);
        }
        
        return destination;
    }
}
