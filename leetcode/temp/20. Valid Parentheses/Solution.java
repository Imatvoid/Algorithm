class Solution {
//     public boolean isValid(String s) {
// 	Stack<Character> leetcode.stack = new Stack<Character>();
// 	for (char c : s.toCharArray()) {
// 		if (c == '(')
// 			leetcode.stack.push(')');
// 		else if (c == '{')
// 			leetcode.stack.push('}');
// 		else if (c == '[')
// 			leetcode.stack.push(']');
// 		else if (leetcode.stack.isEmpty() || leetcode.stack.pop() != c)
// 			return false;
// 	}
// 	return leetcode.stack.isEmpty();
// }
  
         public boolean isValid(String s) {

            Stack<Character> st =new Stack<>();
            for(int i = 0 ;i<s.length();i++){
                if(s.charAt(i)=='{'||s.charAt(i)=='['||s.charAt(i)=='('){
                    st.add(s.charAt(i));
                }else{
                    if(st.isEmpty()) {
                    return  false;
                    }
                        if (s.charAt(i) == ')' && st.peek() == '(') {
                            st.pop();
                            continue;
                        }
                        if (s.charAt(i) == '}' && st.peek() == '{') {
                            st.pop();
                            continue;
                        }
                        if (s.charAt(i) == ']' && st.peek() == '[') {
                            st.pop();
                            continue;
                        }
                         return  false;
                    
                }
            }
            if(st.size()==0){
                return  true;
            }else {
                return  false;
            }

        }
}