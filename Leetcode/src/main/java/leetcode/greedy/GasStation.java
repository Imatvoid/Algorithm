package leetcode.greedy;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total =0;
        int sum =0;
        int start = 0;
        for (int i = 0; i <gas.length ; i++) {

            total += gas[i]-cost[i];
            sum += gas[i]-cost[i];
            if(sum<0){
                // 从start 到  i  能在加油站获得的少于支出的。起点在后面
                start = i+1;
                sum = 0;
            }

        }

        // 总数小于0说明 能在加油站获得的少于支出的，一定不能走完。
        // 总数大于等于0 说明获得的更多。 从后面走完的，剩下的，大于前面的消耗
        return  total<0?-1:start;
    }
}
