public class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for(String str : tokens) {
            if (str.equals("+")) {
                stack.offerFirst(stack.pollFirst() + stack.pollFirst());
            } else if (str.equals("-")) {
                int a = stack.pollFirst();
                int b = stack.pollFirst();
                stack.offerFirst(b - a);
            } else if (str.equals("*")) {
                stack.offerFirst(stack.pollFirst() * stack.pollFirst());
            } else if (str.equals("/")) {
                int a = stack.pollFirst();
                int b = stack.pollFirst();
                stack.offerFirst(b / a);
            } else {
                stack.offerFirst(Integer.parseInt(str));
            }
            
        }
        return stack.pollFirst();
    }
}
