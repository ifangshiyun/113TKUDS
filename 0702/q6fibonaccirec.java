import java.util.Scanner;

public class q6fibonaccirec {
    static int ops = 0;

    public static int fib(int n) {
        ops++;  // Count the number of times fib() is called
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ops = 0;  // Make sure to reset ops before computing
        int result = fib(n);
        System.out.println(result);  // Output Fibonacci number
        System.out.println(ops);     // Output number of recursive calls
    }
}


/*output
 * PS C:\Users\AA\Documents\GitHub\113TKUDS>  c:; cd 'c:\Users\AA\Documents\GitHub\113TKUDS'; & 'C:\Program Files\Eclipse Adoptium\jdk-21.0.7.6-hotspot\bin\java.exe' '-XX:+ShowCodeDetailsInExceptionMessages' '-cp' 'C:\Users\AA\AppData\Roaming\Code\User\workspaceStorage\12d761af529bf1b66908d656711dc408\redhat.java\jdt_ws\113TKUDS_817be11f\bin' 'q6fibonaccirec'
6 
8
25
 */