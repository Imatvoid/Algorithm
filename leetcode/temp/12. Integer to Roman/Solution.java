class Solution {
    public String intToRoman(int num) {

        int temp = num;
        String out = "";
        while (temp!=0){
            if(temp>=1000){
                out+="M";
                temp -=1000;
            }else if(temp>=900){
                out+="CM";
                temp -=900;
            }else if(temp>=500){
                out+="D";
                temp -=500;
            }else if(temp>=400){
                out+="CD";
                temp -=400;
            }else if(temp>=100){
                out+="C";
                temp -=100;
            }else if(temp>=90){
                out+="XC";
                temp -=90;
            }else if(temp>=50){
                out+="L";
                temp -=50;
            }else if(temp>=40){
                out+="XL";
                temp -=40;
            }else if(temp>=10){
                out+="X";
                temp -=10;
            }else if(temp>=9){
                out+="IX";
                temp -=9;
            }else if(temp>=5){
                out+="V";
                temp -=5;
            }else if(temp>=4){
                out+="IV";
                temp -=4;
            }else if(temp>=1){
                out+="I";
                temp -=1;
            }
        }
        return  out;

    }
}