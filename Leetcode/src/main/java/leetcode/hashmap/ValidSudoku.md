##  36. Valid Sudoku



### desc





### 描述


### 思路

```
 HashMap<Integer, HashSet<Character>> rowMap = new HashMap<>();
 HashMap<Integer, HashSet<Character>> colMap = new HashMap<>();
 HashMap<Integer, HashSet<Character>> regionMap = new HashMap<>();
```

