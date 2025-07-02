// file: countloops.java
public class countloops {
    public static void main(String[] args) {
        int n = 5;
        int sum = 0;
        int count = 0;

        for (int i = 1; i <= n; i++) {
            System.out.println("it's " + i + " times loops, sum = " + sum  );
            sum += i;
            count++;
        }

        System.out.println("the sum is: " + sum);
        System.out.println("the addition has been executed" + count + "times");
    }
}
