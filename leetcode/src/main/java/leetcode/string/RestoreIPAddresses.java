package leetcode.string;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

    List<String> res = new ArrayList<String>();

    public List<String> restoreIpAddresses(String s) {


        recursion(s, "", 0, 0);

        return res;

    }


    void recursion(String s, String temp, int start, int count) {
        // 这也是一个终止条件 对于 111111111111111111111111111111111111111111
        if (count == 4) {
            if (start == s.length()) {
                res.add(temp);
            }
            return;
        }


        for (int i = 1; i <= 3 && start + i <= s.length(); i++) {
            String s1 = s.substring(start, start + i);
            if (Integer.valueOf(s1) > 255 || (s1.charAt(0) == '0' && s1.length() > 1)) {
                break;
            }
            recursion(s, temp.equals("") ? s1 : temp + "." + s1, start + i, count + 1);
        }


    }

    public static void main(String[] args) {
        System.out.println(new RestoreIPAddresses().restoreIpAddresses("0000"));
    }
}
