package leetcode.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangxu
 * @Date: 2019/9/2 上午8:32
 */
public class GenerateParentheses {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {

        dfs(n,0,0,"");

        return  res;


    }

    public void dfs(int n , int left,int right,String s){
        if(s.length()==n*2){
            res.add(s);
            return;
        }

        if(left<n){
            dfs(n,left+1,right,s+"(");
        }
        if(right<left){
            dfs(n,left,right+1,s+")");
        }

    }
}
