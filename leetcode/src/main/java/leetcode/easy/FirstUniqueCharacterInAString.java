package leetcode.easy;

import java.util.*;

public class FirstUniqueCharacterInAString {

    /**
     * 寻找第一个不重复的元素  HashMap
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {

        Map<Character,Integer> map =new LinkedHashMap<Character, Integer>();


        for(int i =0 ;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
            }else{
                map.put(s.charAt(i), -1);
            }
        }

        for( Map.Entry<Character,Integer> e :  map.entrySet()){
            if(e.getValue()!=-1){
                return e.getValue();
            }
        }
        return  -1;

    }

    /**
     * 映射
     * @param s
     * @return
     */
    public int firstUniqChar2(String s) {
        if(s == null){
            return -1;
        }
        int len = s.length();
        if(len == 0) {
            return -1;
        }

        int[] freq = new int[26];
        char[] chars = s.toCharArray();
        for(char c : chars) {
            freq[c - 'a']++;
        }
        for(int i=0; i < chars.length; i++) {
            // 按照原来字母顺序
            if(freq[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;

    }



    public static void main(String[] args) {
        System.out.println(new FirstUniqueCharacterInAString().firstUniqChar("leetcode"));
    }


    /**
     * 寻找第一个重复的元素
     * @param s
     * @return
     */
    public int firstRepeatChar(String s) {

        Map<Character,Integer> map =new LinkedHashMap<Character, Integer>();

        int res = -1 ;

        for(int i =0 ;i<s.length();i++){
            if(!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), i);
            }else{
                res= map.get(s.charAt(i));
            }
        }
        return  res;

    }
}
