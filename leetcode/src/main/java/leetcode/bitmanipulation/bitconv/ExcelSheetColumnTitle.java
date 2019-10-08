package leetcode.bitmanipulation.bitconv;

public class ExcelSheetColumnTitle {

    /**
     * 实质是26进制转换,但26=Z 需特殊处理
     * @param n
     * @return
     */
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            int a = n % 26;
            if(a == 0) {
                sb.append('Z');
                n = n / 26 - 1;
            }
            else {
                // 这里要小心,不转换成char类型的话会变成数字
                sb.append((char)(n % 26 -1 + 'A'));
                n = n / 26;
            }
        }
        return sb.reverse().toString();
    }
}
