import java.util.Arrays;

public class String2 implements Comparable<String> {
    private String s;

    public int compareTo(String o) {
        // return 1;大于

        // return -1 小于

        // 等于
        return 0;
    }

    public static void main(String[] args) {
        String[] ss = new String[7];

        ss[0] = "a";
        ss[1] = "ab";
        ss[2] = "y";
        ss[3] = "c";
        ss[4] = "abb";
        ss[5] = "bbbb";
        ss[6] = "z";


        System.out.println(getMaxAlphaBetOrderString(ss));

        Arrays.sort(ss);

        System.out.println(ss[0]);

    }

    private static String getMaxAlphaBetOrderString(String[] ss) {

        if (ss.length == 0) {
            return "";
        }
        if (ss.length == 1) {
            return ss[0];
        }
        String maxString = ss[0];

        for (int i = 1; i < ss.length; i++) {

            int res = ss[i].compareTo(maxString);
            maxString = res < 0 ? ss[i] : maxString;

        }
        return maxString;


    }


}
