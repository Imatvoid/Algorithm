## SearchInRotatedSortedArrayII

 这道题与之前Search in Rotated Sorted
 Array类似，问题只在于存在dupilcate。那么和之前那道题的解法区别就是，不能通过比较A[mid]和边缘值来确定哪边是有序的，会出现A[mid]与边缘值相等的状态。所以，解决方法就是对于A[mid]==A[low]和A[mid]==A[high]单独处理。
 当中间值与边缘值相等时，让指向边缘值的指针分别往前移动，忽略掉这个相同点，再用之前的方法判断即可。
 这一改变增加了时间复杂度，试想一个数组有同一数字组成{1，1，1，1，1}，target=2,
 那么这个算法就会将整个数组遍历，时间复杂度由O(logn)升到O(n)