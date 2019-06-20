func lengthOfLongestSubstring(s leetcode.string) int {
    lastOccurIndex := make(map[byte]int)
	start := 0
	maxLength := 0
	

	for i ,value := range []byte(s){
		if lastI,ok := lastOccurIndex[value]; ok && lastI >= start {
			start =  lastI + 1
		}

		if i-start+1 > maxLength{
			maxLength =  i-start+1
		}

		lastOccurIndex[value]=i

	}
	return  maxLength
    
}