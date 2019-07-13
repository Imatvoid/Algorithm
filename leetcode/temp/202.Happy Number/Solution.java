class Solution {
    public boolean isHappy(int n) {

        Set<Integer> set= new HashSet<Integer>();

        String s = String.valueOf(n);
        int res;
        while (true){
            if(set.contains((res=stringSum(s)))){
                return false;
            }

            if(res==1){
                return true;
            }else{
                s =  String.valueOf(res);
            }
            set.add(res);

        }

    }
    public int stringSum(String s){
        int sum = 0;
        for(int i =0 ;i<s.length(); i++){
            sum += Math.pow(s.charAt(i)-48,2);
        }
        return  sum;
    }
}