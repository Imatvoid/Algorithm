class Solution {
   public List<String> generateParenthesis(int n) {


          List<String> res = new ArrayList<>();
           dfs(res,n,0,0,"");

           return  res;


    }

    public void dfs(List<String> res,int n , int left,int right,String s){
        if(s.length()==n*2){
            res.add(s);
            return;
        }

        if(left<n){
            dfs(res,n,left+1,right,s+"(");
            if(right<left){
                dfs(res,n,left,right+1,s+")");
            }
        }else{
            dfs(res,n,left,right+1,s+")");
        }

    }
}