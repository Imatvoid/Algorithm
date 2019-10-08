package leetcode.bitmanipulation.bitconv;

public class ExcelSheetColumnNumber {


        public int titleToNumber(String s) {
                 char[] cs = s.toCharArray();
                 int len = cs.length;

                 int res = 0;
                 int temp = 1;
                 for(int i = cs.length-1;i>=0;i--){
                     int t = cs[i]-'A'+1;
                     res += t * temp;
                     temp *= 26;
                 }
                 return  res;
        }

    public static void main(String[] args) {
        System.out.println(  new ExcelSheetColumnNumber().titleToNumber("A"));
    }

}
