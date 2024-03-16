class Solution {
    public String findDifferentBinaryString(String[] nums) {
          Set<String> set = new HashSet<>();
        for (String num : nums) {
            set.add(num);
        }
        
        int n = nums[0].length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append('0'); 
        }
        
        String candidate = sb.toString();
        while (set.contains(candidate)) {
            candidate = incrementBinary(candidate);
        }
        
        return candidate;
    }

     private String incrementBinary(String s) {
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == '0') {
                chars[i] = '1';
                break;
            } else {
                chars[i] = '0';
            }
        }
        return new String(chars);
    }
}
