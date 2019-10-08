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



}
