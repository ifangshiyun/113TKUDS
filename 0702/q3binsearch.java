import java.util.Scanner;

public class q3binsearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        // Read the sorted array
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int key = sc.nextInt();
        int ops = 0;
        int left = 0, right = n - 1;
        int result = -1;

        // Binary search
        while (left <= right) {
            ops++;
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) {
                result = mid;
                break;
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
        System.out.println(ops);
    }
}

/* output
 * PS C:\Users\AA\Documents\GitHub\113TKUDS>  c:; cd 'c:\Users\AA\Documents\GitHub\113TKUDS'; & 'C:\Program Files\Eclipse Adoptium\jdk-21.0.7.6-hotspot\bin\java.exe' '-XX:+ShowCodeDetailsInExceptionMessages' '-cp' 'C:\Users\AA\AppData\Roaming\Code\User\workspaceStorage\12d761af529bf1b66908d656711dc408\redhat.java\jdt_ws\113TKUDS_817be11f\bin' 'q3binsearch' 
8
2 4 6 8 10 12 14 16
10
4
3

7 
1 3 5 7 9 11 13
9
4
3

8
1 3 5 7 9 12 14 16 
10
-1
3

 */