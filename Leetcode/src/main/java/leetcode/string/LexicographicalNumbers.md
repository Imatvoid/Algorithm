`386. Lexicographical Numbers`

<https://leetcode.com/problems/lexicographical-numbers/>

`386. 字典序排数`

<https://leetcode-cn.com/problems/lexicographical-numbers/>

### 描述

给定一个整数 n, 返回从 1 到 n 的字典顺序。

例如，

给定 n =1 3，返回 `[1,10,11,12,13,2,3,4,5,6,7,8,9]` 。

请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。


### 思路1

字典序排列,也就是实现string的compareTo()

```java
 public List<Integer> lexicalOrder(int n) {
         ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer one, Integer another) {

                String oneStr = String.valueOf(one);
                String anotherStr = String.valueOf(another);
                int len1=oneStr.length();
                int len2=anotherStr.length();
                int len = Math.min(len1,len2);

                int k = 0;
                while (k < len) {
                    if (oneStr.charAt(k) != anotherStr.charAt(k)) {
                        return oneStr.charAt(k) - anotherStr.charAt(k);
                    }
                    k++;
                }

                return len1-len2;
            }
        });
        return list;
    }
```

### 思路2 
dfs

The idea is pretty simple. If we look at the order we can find out we just keep adding digit from 0 to 9 to every digit and make it a tree.
Then we visit every listNode in pre-order. 
       1        2        3    ...
      /\        /\       /\
   10 ...19  20...29  30...39   ....


```java
 public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i=1;i<10;++i){
            dfs(i, n, res);
        }
        return res;
    }

    public void dfs(int cur, int n, List<Integer> res){
        if(cur>n)
            return;
        else{
            res.add(cur);
            for(int i=0;i<10;++i){
                if(10*cur+i>n)
                    return;
                dfs(10*cur+i, n, res);
            }
        }
    }
```
