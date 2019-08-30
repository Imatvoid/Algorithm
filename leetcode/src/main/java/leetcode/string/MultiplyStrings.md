`43. Multiply Strings`

<https://leetcode.com/problems/multiply-strings/>

`43. 字符串相乘`

<https://leetcode-cn.com/problems/multiply-strings/>

#### 描述

Given two non-negative integers `num1` and `num2` represented as strings, return the product of `num1` and `num2`, also represented as a leetcode.string.

**Example 1:**

```
Input: num1 = "2", num2 = "3"
Output: "6"
```

**Example 2:**

```
Input: num1 = "123", num2 = "456"
Output: "56088"
```

**Note:**

1. The length of both `num1` and `num2` is < 110.
2. Both `num1` and `num2` contain only digits `0-9`.
3. Both `num1` and `num2` do not contain any leading zero, except the number 0 itself.
4. You **must not use any built-in BigInteger library** or **convert the inputs to integer** directly.

#### 中文描述

字符串乘法


#### 思路

把乘法转换为加法

```java

    public String multiply(String num1, String num2) {

        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }

        StringBuilder res = new StringBuilder().append(0);
        StringBuilder temp = new StringBuilder();
        for(int i =num2.length()-1;i>=0;i--){
            res =addString(res.toString(),multiplyString(num1,num2.charAt(i)-'0').append(temp).toString());
            temp.append("0");
        }
        return  res.toString();


    }

    StringBuilder multiplyString(String num1,int num2){

        int i = num1.length()-1;
        StringBuilder sb = new StringBuilder();
        int  over = 0;
        while (i>=0){
            int a = (num1.charAt(i--)-'0');
            int b = num2;
            int mul = (a*b+over)%10;
            over = (a*b+over)/10;
            sb.append(mul);
        }

        if(over>0){
            sb.append(over);
        }
        return  sb.reverse();

    }

    StringBuilder addString(String num1,String num2){

        if(num2.length()==0){
            return  new StringBuilder(num1);
        }

        if(num1.length()==0){
            return  new StringBuilder(num2);
        }

        StringBuilder sb = new StringBuilder();
        int i = num1.length()-1;
        int j = num2.length()-1;
        int over =0;
        while (i>=0||j>=0){
            int a = i>=0 ? num1.charAt(i--)-'0':0;
            int b = j>=0 ? num2.charAt(j--)-'0':0;
            int sum = (a + b+ over)%10;
            over = (a + b+ over)/10;
            sb.append(sum);
        }
        if(over==1){
            sb.append(1);
        }
        return  sb.reverse();

    }
    public static void main(String[] args) {
        new MultiplyStrings().multiply("2","3");
    }
```



