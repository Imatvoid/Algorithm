package leetcode.bitmanipulation;

public class UTF8Validation {


    public boolean validUtf8(int[] data) {
        int cnt = 0;
        for(int d : data){
            if(cnt == 0){
                if((d>>5) == 0b110) cnt = 1; // 2 byte, followed by 1 more byte
                else if((d>>4) == 0b1110) cnt=2; // 3byte, followed by 2 more bytes
                else if((d>>3) == 0b11110) cnt=3; // 4 byte, followed by 3 more bytes
                else if((d>>7) != 0) return false;// 1 byte ASCII code, check it not big than 128
            }else{
                if((d>>6) != 0b10) return false;
                cnt--;
            }
        }
        return cnt == 0;
    }
}
