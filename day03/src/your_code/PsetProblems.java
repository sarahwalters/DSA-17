package your_code;

import ADTs.StackADT;
import java.util.HashMap;

public class PsetProblems {

    public static int longestValidSubstring(String s) {
        int height = 0; // an open paren will increment height, a close paren will decrement height
        int longestValidLength = 0;
        HashMap<Integer, Integer> heightMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            // Build a map of the indices at which heights first occur
            if (height >= 0 && !heightMap.containsKey(height)) {
                heightMap.put(height, i);
            }

            // Keep track of height
            if (s.charAt(i) == '(') {
                height++;
            } else if (s.charAt(i) == ')') {
                height--;
            } else {
                throw new Error("Invalid input string.");
            }

            if (height >= 0 && heightMap.containsKey(height)) {
                // Compute distance between this index and the first index
                // at which we saw the current height -- this is the length
                // of a valid substring
                int validLength = i + 1 - heightMap.get(height);
                if (validLength > longestValidLength) {
                    longestValidLength = validLength;
                }
            } else if (height < 0) {
                // Not a valid substring if we've seen more close parens than open parens
                // Clear out "first occurrence of each height" map and start over
                heightMap = new HashMap<>();
            }
        }

        return longestValidLength;
    }

    public static StackADT<Integer> sortStackLimitedMemory(StackADT<Integer> s) {
        MyStack<Integer> helperStack = new MyStack<>();

        Integer current;
        while (!s.isEmpty()) {
            current = s.pop();

            // Figure out where to add current to stack
            while (!(helperStack.isEmpty() || current <= helperStack.peek())) {
                s.push(helperStack.pop());
            }
            helperStack.push(current);
        }

        return helperStack;
    }
}
