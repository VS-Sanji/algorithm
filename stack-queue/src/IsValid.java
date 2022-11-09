import java.util.Stack;

/**
 * 括号匹配
 * 利用栈结构来解决的经典问题
 */

public class IsValid {
    public static boolean isValid(String s) {

        int i = 0;
        Stack stack = new Stack();

        while (i < s.length()) {

            if (s.charAt(i) == '(') {
                stack.push(')');
            } else if (s.charAt(i) == '[') {
                stack.push(']');
            } else if (s.charAt(i) == '{') {
                stack.push('}');
            } else {
                //当扫描到 ')' ']' '}'时，并且此时的栈已经空了，说明这是多余的右括号，直接返回false
                if (stack.isEmpty()) {
                    return false;
                }
                //非空栈，弹出栈顶元素与当前元素比较，相同则 i++ 进入下轮循环
                if ((char) stack.pop() == s.charAt(i)) {
                    i++;
                    continue;
                } else {
                    //没匹配上直接返回false
                    return false;
                }
            }

            i++;
        }

        //最终栈如果是空的，说明是有效字串，否则就是多了左括号
        return stack.isEmpty();
    }

}
