package leetcode.medium;

class RobotReturnToOrigin {

    public boolean judgeCircle(String moves) {

        int u = 0, d = 0, l = 0, r = 0;
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'U') {
                u++;
            }
            if (moves.charAt(i) == 'D') {
                d++;
            }
            if (moves.charAt(i) == 'L') {
                l++;
            }
            if (moves.charAt(i) == 'R') {
                r++;
            }
        }

        return u==d && l==r;

    }
}
