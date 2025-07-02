import java.util.Scanner;

public class q2seqsearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        // Read the array
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        int key = sc.nextInt();
        int ops = 0;
        boolean found = false;

        // Sequential search
        for (int i = 0; i < n; i++) {
            ops++;
            if (arr[i] == key) {
                found = true;
                break;
            }
        }

        // Output result
        System.out.println(found ? "Yes" : "No");
        System.out.println(ops);
    }
}

/* output
 * PS C:\Users\AA\Documents\GitHub\113TKUDS>  & 'C:\Program Files\Eclipse Adoptium\jdk-21.0.7.6-hotspot\bin\java.exe' '-XX:+ShowCodeDetailsInExceptionMessages' '-cp' 'C:\Users\AA\AppData\Roaming\Code\User\workspaceStorage\12d761af529bf1b66908d656711dc408\redhat.java\jdt_ws\113TKUDS_817be11f\bin' 'q2seqsearch' 
7 
1 3 5 7 9 11 13
9
4
3

 7
1 3 5 7 9 10 12
8
No
7
 */