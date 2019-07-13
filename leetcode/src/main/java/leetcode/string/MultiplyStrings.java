package leetcode.string;

public class MultiplyStrings {

    public String multiply(String num1, String num2) {

        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }

        StringBuilder res = new StringBuilder().append(0);
        StringBuilder temp = new StringBuilder();
        for(int i =num2.length()-1;i>=0;i--){
            res =addString(res.toString(),multiplyString(num1,num2.charAt(i)-'0').append(temp).toString());
            temp.append("0");
        }
        return  res.toString();


    }

    StringBuilder multiplyString(String num1,int num2){

        int i = num1.length()-1;
        StringBuilder sb = new StringBuilder();
        int  over = 0;
        while (i>=0){
            int a = (num1.charAt(i--)-'0');
            int b = num2;
            int mul = (a*b+over)%10;
            over = (a*b+over)/10;
            sb.append(mul);

        }

        if(over>0){
            sb.append(over);
        }
        return  sb.reverse();

    }

    StringBuilder addString(String num1,String num2){

        if(num2.length()==0){
            return  new StringBuilder(num1);
        }

        if(num1.length()==0){
            return  new StringBuilder(num2);
        }

        StringBuilder sb = new StringBuilder();
        int i = num1.length()-1;
        int j = num2.length()-1;
        int over =0;
        while (i>=0||j>=0){
            int a = i>=0 ? num1.charAt(i--)-'0':0;
            int b = j>=0 ? num2.charAt(j--)-'0':0;
            int sum = (a + b+ over)%10;
            sb.append(sum);
            over = (a + b+ over)/10;
        }
        if(over==1){
            sb.append(1);
        }
        return  sb.reverse();


    }
    public static void main(String[] args) {
        new MultiplyStrings().multiply("2","3");
    }
}
