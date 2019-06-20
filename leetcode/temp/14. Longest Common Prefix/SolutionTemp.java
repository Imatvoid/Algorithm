class SolutionTemp {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length<=0){
            return "";
        }
        int minP = -1;
        int min = Integer.MAX_VALUE;
        String out = "";
        for(int i = 0;i<strs.length;i++){
            if(strs[i].length()<min){
                min =  strs[i].length();
                minP = i;
            }
        }
        boolean isContinue = true;
        for(int i = 0 ;i<strs[minP].length();i++){
            for(int j = 0 ;j<strs.length;j++){
                if(strs[j].charAt(i)!=strs[minP].charAt(i)){
                    isContinue =false;
                    break;
                }
            }
            if(isContinue){
                out+=strs[minP].charAt(i);
            }else {
                break;
            }
        }
        return  out;
    }

}