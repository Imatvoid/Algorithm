package leetcode.string.easy;

/**
 * @Author: yangxu
 * @Date: 2019/8/28 上午8:57
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length ==0) return "";

        if(strs.length ==1 )return strs[0];

        String pre = strs[0];
        int i=1;
        while(i<strs.length){

            for(;i<strs.length;i++){
                if(!strs[i].startsWith(pre)){
                    pre = pre.substring(0,pre.length()-1);
                    break;
                }
            }

        }
        return pre;

    }
}
