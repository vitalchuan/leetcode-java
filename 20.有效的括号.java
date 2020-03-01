import java.util.Stack;

/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    private HashMap<Character, Character> mappings;
    public Solution() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
      }
    
    public boolean isValid(String s) {
        // Stack<String> stack = new Stack<>();
        // while(!s.equals(""))
        // {
        //     String subStr = s.substring(0,1);
        //     if("([{".contains(subStr))
        //         stack.push(subStr);
        //     else if(")]}".contains(subStr))
        //     {
        //         if(stack.isEmpty()) return false;
        //         switch(subStr){
        //             case ")":
        //                 if(stack.peek().equals("("))    stack.pop();
        //                 else return false;
        //                 break;
        //             case "]":
        //                 if(stack.peek().equals("["))    stack.pop();
        //                 else return false;
        //                 break;
        //             case "}":
        //                 if(stack.peek().equals("{"))    stack.pop();
        //                 else return false;
        //                 break;
        //         }
        //     }
        //     s = s.substring(1);
        // }

        // if(stack.isEmpty())
        //     return true;
        // else
        //     return false;
  
    Stack<Character> stack = new Stack<Character>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (this.mappings.containsKey(c)) {
        char topElement = stack.empty() ? '#' : stack.pop();
        if (topElement != this.mappings.get(c)) {
          return false;
        }
      } else
        stack.push(c);
    }
    return stack.isEmpty();
  }
}
// @lc code=end
