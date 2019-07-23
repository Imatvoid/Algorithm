package leetcode.easy;

public class ReverseWordsInAStringIII {

    /**
     * 使用正则库
     * @param s
     * @return
     */
    public String reverseWords(String s) {


        String[] words = s.trim().split("\\s+");

        StringBuilder res = new StringBuilder();

        String place = "";
        for (int i = 0; i < words.length; i++) {

           res.append(reverseString(words[i],0,words[i].length()-1)).append(" ");

        }
        return res.toString().trim();

    }
    /**
     * 不使用正则库
     * @param s
     * @return
     */
    public String reverseWordsBetter(String s) {
        s=s+" ";
        char [] cs = s.toCharArray();
        int start =0;
        for (int i = 0; i < cs.length; i++) {
            if(cs[i]==' '){
                reverseString(cs,start,i-1);
                start = i+1;

            }

        }

        return  new String(cs).trim();

    }


    /**
     * 逆转字符串
     * @param  s
     * @param start
     * @param end
     */
    public void reverseString(char []s,int start,int end) {

        int mid =start+(end+1-start)/2;
        for(int i=start;i<mid;i++){
            char temp = s[i];
            s[i]=s[end-(i-start)];
            s[end-(i-start)] = temp;

        }

    }

    /**
     * 逆转字符串
     * @param s1
     * @param start
     * @param end
     */
    public String reverseString(String s1,int start,int end) {
        char []s =s1.toCharArray();
        int mid =start+(end+1-start)/2;
        for(int i=start;i<mid;i++){
            char temp = s[i];
            s[i]=s[end-(i-start)];
            s[end-(i-start)] = temp;

        }

        return  new String(s);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWordsInAStringIII().reverseWords("abcde"));
        System.out.println(new ReverseWordsInAStringIII().reverseWords("abc1de"));
        System.out.println(new ReverseWordsInAStringIII().reverseWordsBetter("Let's take LeetCode contest"));
    }
}
