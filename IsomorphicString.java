class Solution {
    public boolean isIsomorphic(String s, String t) {
         if (s.length() != t.length())
            return false;

        Map<Character, Character> sToTMap = new HashMap<>();
        Map<Character, Character> tToSMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (sToTMap.containsKey(sChar)) {
                if (sToTMap.get(sChar) != tChar)
                    return false;
            } else {
                sToTMap.put(sChar, tChar);
            }

            if (tToSMap.containsKey(tChar)) {
                if (tToSMap.get(tChar) != sChar)
                    return false;
            } else {
                tToSMap.put(tChar, sChar);
            }
        }

        return true;
    }
}
