class Solution {
     public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        if (s.length() % 2 == 0) {
            String in = s.substring(0, s.length() / 2);
            StringBuffer out = new StringBuffer(s.substring(s.length() / 2, s.length()));
            if (in.equals(out.reverse().toString())) {
                return true;
            }
            return false;
        } else {
            String in = s.substring(0, s.length() / 2);
            StringBuffer out = new StringBuffer(s.substring(s.length() / 2 + 1, s.length()));
            if (in.equals(out.reverse().toString())) {
                return true;
            }
            return false;
        }


    }

}