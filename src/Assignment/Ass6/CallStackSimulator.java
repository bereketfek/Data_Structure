package Assignment.Ass6;

import java.util.*;

public class CallStackSimulator {

    public static void main(String[] args) {
        /**
         * Lesson2.Array → for splitting input (String[] parts)
         * ArrayList → for storing the call stack (ArrayList<String> stack)
         */
        Scanner sc = new Scanner(System.in);
        ArrayList<String> stack = new ArrayList<>();

        System.out.println("enter command:");// prompt prints only once: outside the loop

        while (sc.hasNextLine()) {
            String rt = sc.nextLine().trim();
            if (rt.isEmpty()) continue;//If entered blank, ignore it & ask next command

            String[] part = rt.split("\\s+");
            String command = part[0].toUpperCase();

            // Executes commands to manipulate the call stack
            switch (command) {

                case "CALL":
                    if (part.length < 2)// only allowed > two words
                        break;
                    stack.add(part[1]);
                    System.out.println("CALL OK");
                    break;

                case "RETURN":
                    if (stack.isEmpty()) {
                        System.out.println("RETURN ERROR (no function to return from)");
                    } else {
                        String returned = stack.remove(stack.size() - 1); // pop
                        System.out.println("RETURN OK (" + returned + ")");
                    }
                    break;

                case "WHERE":
                    if (stack.isEmpty()) {
                        System.out.println("CURRENT FUNCTION: GLOBAL");
                    } else {
                        System.out.println("CURRENT FUNCTION: " + stack.get(stack.size() - 1));
                    }
                    break;

                case "TRACE":
                    System.out.println("STACK TRACE (top -> bottom)");
                    for (int i = stack.size() - 1; i >= 0; i--) {
                        System.out.println(stack.get(i));
                    }
                    break;

                case "THROW":
                    if (part.length < 2) break;
                    String exception = part[1];
                    System.out.println("Exception in thread \"main\" " + exception);
                    for (int i = stack.size() - 1; i >= 0; i--) {
                        System.out.println("    at " + stack.get(i) + "()");
                    }
                    System.out.println("Program terminated due to uncaught exception");
                    return;

                case "QUIT":
                    System.out.println("BYE");
                    return;

                default:
                    System.out.println("UNKNOWN COMMAND");
            }
        }
    }
}
