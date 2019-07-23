package leetcode.bitmanipulation;

public class FindtheDifference {

    /**
     * 本质和Single Number是一样的
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        char[] comb = (s+t).toCharArray();
        int output = 0;
        for(char c:comb){
            output = output^c;
        }
        //return (char)output;
        return Character.toChars(output)[0];

    }

    public static void main(String[] args) {

        System.out.println(
                new FindtheDifference().findTheDifference("abcd","abcde")
        );
    }
}
