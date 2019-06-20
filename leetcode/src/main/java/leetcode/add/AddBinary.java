package leetcode.add;

public class AddBinary {

    public String addBinary(String a, String b) {

        int i =a.length()-1,j =b.length()-1;
        StringBuffer sb =new StringBuffer();

        int carry = 0;
        while (i>=0 || j>=0){
            int n1 = i>=0? a.charAt(i--)-'0': 0;
            int n2 = j>=0? b.charAt(j--)-'0': 0;

            sb.append((n1 + n2 +carry)%2);
            carry = (n1 + n2 +carry)/2;

        }
        if(carry == 1){
            sb.append(1);
        }
        return  sb.reverse().toString();

    }

    public String old(String a, String b){

        int temp = 0;
        int la= a.length();
        int lb= b.length();


        if (la > lb) {

            for (int i = 0; i < la - lb; i++)
                b = "0" + b;
        }

        if (la < lb) {
            for (int i = 0; i < lb- la; i++)
                a = "0" + a;

        }

        String s = "";
        for (int i = a.length()-1; i >= 0; i--) {
            int res = a.charAt(i) - 48 + b.charAt(i) - 48 + temp;
            if (res >= 2) {
                temp = 1;
            } else {
                temp = 0;
            }
            s = (res & 1) + "" + s;
        }

        if(temp == 1){

            s = "1" + s;
        }
        return s;

    }

}
