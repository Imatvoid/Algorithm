package leetcode.add;

public class AddStrings {

    public String addStrings(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();

        int i = len1 - 1, j = len2 - 1;
        int over = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? num1.charAt(i--) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j--) - '0' : 0;
            int bit = (n1 + n2 + over) % 10;
            over = (n1 + n2 + over) / 10;
            sb.append(bit);
        }
        // 9 + 9 =18 进位最大是1
        if (over > 0) sb.append(1);
        return sb.reverse().toString();

    }


    public static void main(String[] args) {
        System.out.println(new AddStrings().addStrings("1", "9"));
    }
}
