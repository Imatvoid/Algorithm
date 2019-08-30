`76. Minimum Window Substring`

<https://leetcode.com/problems/minimum-window-substring/>

`76. 最小覆盖子串`

<https://leetcode-cn.com/problems/minimum-window-substring/>

### Desc

Given a leetcode.string S and a leetcode.string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

**Example:**

```
Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
```

**Note:**

- If there is no such window in S that covers all characters in T, return the empty leetcode.string `""`.
- If there is such window, you are guaranteed that there will always be only one unique minimum window in S.


### 描述

最小窗口子串

这道题给了我们一个原字符串S，还有一个目标字符串T，让我们在S中找到一个最短的子串，使得其包含了T中的所有的字母，并且限制了时间复杂度为 O(n)



### 思路

Tips:

将在"FHDACB"中查找包含"ABC"的区间,可以把他们都映射到数组，也就是hash操作.查看是否包含即可

demo

```java

 int[] map(String s) {
        int[] map = new int[128];
        for (char c : s.toCharArray()) {
            map[c - 'A']++;
        }
        return map;

    }

    boolean contains(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] - b[i] < 0) {
                return false;
            }
        }
        return true;
    }
```

这道题本身的难度不大

使用滑动窗口，先向右拓展直到满足条件，再从左压缩就可以。

问题是需要O(n)的复杂度,所以如果我们把一个区间Temp,与T(target)区间比较,查看是否覆盖,这个比较操作的复杂度就是O(n).

显然不满足。所以我们加入一个found计数。

```java
 /**
     * o(n)
     *
     * @param S
     * @param T
     * @return
     */
    public String minWindow(String S, String T) {
        if (S == null || S.isEmpty() || T == null || T.isEmpty() || S.length() < T.length()) return "";

        int i = 0, j = 0;
        int[] Tmap = new int[128];
        int[] Smap = new int[128];
        for (int k = 0; k < T.length(); k++) {
            Tmap[T.charAt(k)]++;
        }
        int found = 0;
        int length = Integer.MAX_VALUE;
        String res = "";
        while (j < S.length()) {

            if (Tmap[S.charAt(j)] > 0) {
                Smap[S.charAt(j)]++;
                if (Smap[S.charAt(j)] <= Tmap[S.charAt(j)]) {
                    found++;
                }

                while (found == T.length()) {
                    if (j - i + 1 < length) {
                        length = j - i + 1;
                        res = S.substring(i, j + 1);
                    }
                    if (Tmap[S.charAt(i)] > 0) {
                        Smap[S.charAt(i)]--;
                        if (Smap[S.charAt(i)] < Tmap[S.charAt(i)]) {
                            found--;
                        }
                    }
                    i++;
                }
            }
            j++;

        }
        return res;
    }
```

