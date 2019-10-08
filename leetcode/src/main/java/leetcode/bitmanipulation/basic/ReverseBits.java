package leetcode.bitmanipulation.basic;

public class ReverseBits {

    // you need treat n as an unsigned value
    /**
     * 这里有个不熟悉的地方时bit<<(31-i) 是将bit右移,(31-i)<<bit 这个可不对
     * @param n
     * @return
     */
    public int reverseBits(int n) {

        int res =0;
        for(int i=0;i<32;i++){
            int bit = (n>>i)&1;
            res |= bit<<(31-i);
        }
        return res;

    }
    public static void main(String[] args) {
        new ReverseBits().reverseBits(43261596);
        System.out.println(((~(123455))>>31)&1);
    }
}
