class Solution {
    public int romanToInt(String s) {
        int out = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') {
                if (i+1<s.length()&&s.charAt(i + 1) == 'V') {
                    out += 4;
                    i++;
                } else if (i+1<s.length()&&s.charAt(i + 1) == 'X') {
                    out += 9;
                    i++;
                } else {
                    out += 1;
                }
                continue;
            }
            if (s.charAt(i) == 'V') {
                out += 5;
                continue;
            }

            if (s.charAt(i) == 'X') {
                if (i+1<s.length()&&s.charAt(i + 1) == 'L') {
                    out += 40;
                    i++;
                } else if (i+1<s.length()&&s.charAt(i + 1) == 'C') {
                    out += 90;
                    i++;
                } else {
                    out += 10;
                }
                continue;

            }
            if (s.charAt(i) == 'L') {
                out += 50;
                continue;
            }

            if (s.charAt(i) == 'C') {
                if (i+1<s.length()&&s.charAt(i + 1) == 'D') {
                    out += 400;
                    i++;
                } else if (i+1<s.length()&&s.charAt(i + 1) == 'M') {
                    out += 900;
                    i++;
                } else {
                    out += 100;
                }
                continue;
            }

            if (s.charAt(i) == 'D') {
                out += 500;
                continue;
            }
            if (s.charAt(i) == 'M') {
                out += 1000;
                continue;
            }


        }
        return  out;

    }
}