package leetcode.hashmap;

public class MaxPointsonaLine {

    public int maxPoints(int[][] points) {
        int res =0;


        for (int i = 0; i < points.length; i++) {
            int dup = 1;
            for (int j = i + 1; j < points.length; j++) {
                int cnt = 0;
                long x1 = points[i][0];
                long y1 = points[i][1];
                long x2 = points[j][0];
                long y2 = points[j][1];
                // [[1,1],[1,1] 无法确定直线的不往下走。直接continue
                if (x1 == x2 && y1 == y2) {
                    dup++; continue;
                }
                // k =0 because [[1,1],[1,1],[2,3]]   1,1 和 2，3 确定一条直线 然后遍历数组 得到3
                for (int k = 0; k < points.length; k++) {
                    int x3 = points[k][0];
                    int y3 = points[k][1];

                    if (x1 * y2 + x2 * y3 + x3 * y1 - x3 * y2 - x2 * y1 - x1 * y3 == 0) {
                        ++cnt;
                    }
                }

                res = Math.max(res,cnt);


            }
            res = Math.max(res,dup);


        }
        return  res;

    }

    public static void main(String[] args) {

        int i = 65535;
        System.out.println(i*i);
    }



}
