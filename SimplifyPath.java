import java.util.Stack;

public class SimplifyPath {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();

        char ch;
        for (int i = 0; i < path.length(); i++) {
            ch = path.charAt(i);
            if (ch == '/') {
                if (stringBuilder.length() > 0) {
                    if (stringBuilder.toString().equals("..")) {
                        if (stack.size() > 0)
                            stack.pop();
                    } else if (!stringBuilder.toString().equals(".")) {
                        stack.push(stringBuilder.toString());
                    }
                    stringBuilder = new StringBuilder();
                }
            } else {
                stringBuilder.append(ch);
            }
        }
        StringBuffer p = new StringBuffer("/");
        for (int i = 0; i  < stack.size()-1; i++) {
            p.append(stack.get(i)).append("/");
        }
        return p.append(stack.get(stack.size()-1)).toString();
    }
}
