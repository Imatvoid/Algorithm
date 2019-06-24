package leetcode.math;

public class StatisticsFromALargeSample {

    public double[] sampleStats(int[] count) {

        int n =count.length;

        double[] res =new double[5];
        res[0] = 0;
        boolean min =false;

        res[1] = 0;

        int num = 0;
        long sum = 0L;


        int maxCount =0;


        for (int i = 0; i <n ; i++) {

            if(count[i]!=0 && !min){
                res[0]=i;
                min = true;
            }
            if(count[i]!=0){
                res[1]=i;
            }
            if(count[i]!=0){
                num+=count[i];
                sum+= count[i]*i;
            }
            if(count[i]>maxCount){
                maxCount = count[i];
                res[4] = i;
            }


        }
        res[2] = (sum+0.0)/num;
        res[3] = (find(count,(num+1)/2) + find(count,(num+2)/2))/2.0;

        return  res;


    }

    int find(int [] count,int index){
        int i = 0;
        while (index>0){
            index = index - count[i];
            i++;
        }
        return i-1;

    }

}
