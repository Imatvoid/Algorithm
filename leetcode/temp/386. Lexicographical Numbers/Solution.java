class Solution {

    public List<Integer> lexicalOrder(int n) {

        ArrayList<Integer> list =new ArrayList<Integer>();



        for(int  i = 1 ;i<=n; i++){
            list.add(i);

        }
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer v, Integer i) {
                if (v.equals(i)) {
                    return 0;
                }

                String vStr = String.valueOf(v);
                String iStr = String.valueOf(i);


                int len = Math.min(vStr.length(), iStr.length());
                for (int index = 0; index < len; index++) {
                    if (vStr.charAt(index) < iStr.charAt(index)) {
                        return -1;
                    }
                    if (vStr.charAt(index) > iStr.charAt(index)) {
                        return 1;
                    }
                }

                if(vStr.length()>iStr.length()) return 1;
                if(vStr.length()<iStr.length()) return -1;

                return 0;
            }
        });


        return list;


    }


}

//     public List<Integer> lexicalOrder(int n) {

//         ArrayList<MyInteger> list =new ArrayList<MyInteger>();

//         ArrayList<Integer> l =new ArrayList<Integer>();

//         for(int  i = 1 ;i<=n; i++){
//             list.add(new MyInteger(i));

//         }
//         Collections.leetcode.sort(list);


//         ArrayList<Integer> res = new ArrayList<Integer>();

//         for(int i = 0 ;i<list.size();i++){
//             res.add(list.get(i).getV());
//         }



//         return res;


//     }

//     class MyInteger implements Comparable<MyInteger> {
//         Integer v;

//         public MyInteger(int v){
//             this.v=v;
//         }

//         public Integer getV() {
//             return v;
//         }


//         public int compareTo(MyInteger i) {
//             if (v.equals(i.getV())) {
//                 return 0;
//             }

//             String vStr = String.valueOf(v);
//             String iStr = String.valueOf(i.getV());


//             int len = Math.min(vStr.length(), iStr.length());
//             for (int index = 0; index < len; index++) {
//                 if (vStr.charAt(index) < iStr.charAt(index)) {
//                     return -1;
//                 }
//                 if (vStr.charAt(index) > iStr.charAt(index)) {
//                     return 1;
//                 }
//             }

//             if(vStr.length()>iStr.length()) return 1;
//             if(vStr.length()<iStr.length()) return -1;

//             return 0;


//         }
//     }
