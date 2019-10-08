package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();

        HashMap<String,List<String>> map =new HashMap<String, List<String>>();

        for(int i =0;i<strs.length;i++){

            if( map.get(getIndex(strs[i])) != null){
                map.get(getIndex(strs[i])).add(strs[i]);
            }else{
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(strs[i]);
                map.put(getIndex(strs[i]),temp);
            }

        }

        for(String i : map.keySet()){
            res.add(map.get(i));
        }
        return  res;

    }

    String getIndex(String s){
        int  [] index = new int[26];
        for(int i = 0;i<s.length();i++){
            index[s.charAt(i)-'a']++;
        }

        StringBuilder strb =new StringBuilder();
        for(int x:index) {
            strb.append(x);
        }
        return strb.toString();
    }

    // public static void main(String[] args) {
    //    new GroupAnagrams().groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"});
    // }

}
