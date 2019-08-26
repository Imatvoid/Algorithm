```12. Integer to Roman`

<https://leetcode.com/problems/integer-to-roman/>

`12. 整数转罗马数字`

<https://leetcode-cn.com/problems/integer-to-roman/>

## 描述
罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。

字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。

通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：

I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。

示例 1:
````
输入: 3
输出: "III"
````
示例 2:
````
输入: 4
输出: "IV"
````
示例 3:
````
输入: 9
输出: "IX"
````
示例 4:
````
输入: 58
输出: "LVIII"
解释: L = 50, V = 5, III = 3.
````
示例 5:
````
输入: 1994
输出: "MCMXCIV"
解释: M = 1000, CM = 900, XC = 90, IV = 4.
````

## 思路 

没太大意思,从上到下判断条件就行

```java
public String intToRoman(int num) {

        int temp = num;
        String out = "";
        while (temp!=0){
            if(temp>=1000){
                out+="M";
                temp -=1000;
            }else if(temp>=900){
                out+="CM";
                temp -=900;
            }else if(temp>=500){
                out+="D";
                temp -=500;
            }else if(temp>=400){
                out+="CD";
                temp -=400;
            }else if(temp>=100){
                out+="C";
                temp -=100;
            }else if(temp>=90){
                out+="XC";
                temp -=90;
            }else if(temp>=50){
                out+="L";
                temp -=50;
            }else if(temp>=40){
                out+="XL";
                temp -=40;
            }else if(temp>=10){
                out+="X";
                temp -=10;
            }else if(temp>=9){
                out+="IX";
                temp -=9;
            }else if(temp>=5){
                out+="V";
                temp -=5;
            }else if(temp>=4){
                out+="IV";
                temp -=4;
            }else if(temp>=1){
                out+="I";
                temp -=1;
            }
        }
        return  out;

    }
```