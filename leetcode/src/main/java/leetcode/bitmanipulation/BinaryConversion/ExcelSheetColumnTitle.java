package leetcode.bitmanipulation.BinaryConversion;

public class ExcelSheetColumnTitle {

    /**
     * 实质是26进制转换,但26=Z 需特殊处理
     * @param n
     * @return
     */
    public String convertToTitle(int n) {
        String result = "";
        while(n > 0) {
            int a = n % 26;
            if(a == 0) {
                result = 'Z' + result;
                n = n / 26 - 1;
            }
            else {
                // 这里要小心,不转换成char类型的话会变成数字
                result = (char)(n % 26 -1 + 'A') + result;
                n = n / 26;
            }
        }
        return result;
    }
}
