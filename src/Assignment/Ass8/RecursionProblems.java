package Assignment.Ass8;

public class RecursionProblems {

    // 1. Print digits in reverse order
    public static void printReverseDigits(int n) {
        if (n == 0) return;
        System.out.print(n % 10);
        printReverseDigits(n / 10);
    }

    // 2. Count the number of digits
    public static int countDigits(int n) {
        if (n < 10) return 1;
        return 1 + countDigits(n / 10);
    }

    // 3. Sum of digits
    public static int sumDigits(int n) {
        if (n == 0) return 0;
        return n % 10 + sumDigits(n / 10);
    }

    // 4. Decimal to Binary

    private static void  decimalToBinary(int num) {
        if (num == 0) return;
        decimalToBinary(num / 2);
        System.out.print(num % 2);
    }

    // 5. Count vowels in a string
    public static int countVowels(String s) {
        if (s.length() == 0) return 0;
        return ("aeiouAEIOU".indexOf(s.charAt(0)) != -1 ? 1 : 0)
                + countVowels(s.substring(1));
    }

    // 6. Sum of integers in an array
    public static int sum(int[] arr) {
        return sumHelper(arr, 0);
    }

    private static int sumHelper(int[] arr, int index) {
        if (index == arr.length) return 0;
        return arr[index] + sumHelper(arr, index + 1);
    }

    // 7. Maximum number in an array
    public static int max(int[] arr) {
        return maxHelper(arr, 0);
    }

    private static int maxHelper(int[] arr, int index) {
        if (index == arr.length) return Integer.MIN_VALUE;//-2,147,483,648 smallest int number
        return Math.max(arr[index], maxHelper(arr, index + 1));
    }


    // Test all methods
    public static void main(String[] args) {

        System.out.println("Reverse digits of 12345:");
        RecursionProblems.printReverseDigits(12345);
        System.out.println("\n");

        System.out.println("Number of digits in 12345:");
        System.out.println(RecursionProblems.countDigits(12345));

        System.out.println("Sum of digits of 12345:");
        System.out.println(RecursionProblems.sumDigits(12345));


        System.out.println("Count vowels in 'JavaProgramming':");
        System.out.println(RecursionProblems.countVowels("JavaProgramming"));

        int[] arr = {2, 7, 1, 9, 5};

        System.out.println("Sum of array elements:");
        System.out.println(sum(arr));

        System.out.println("Maximum number in array:");
        System.out.println(max(arr));

        System.out.println("decimal number 20 in to binary:");
        decimalToBinary(20);
    }
}
