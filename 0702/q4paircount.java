import java.util.Scanner;

public class q4paircount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr = new int[n];

        // Read array
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int pairCount = 0;
        int ops = 0;

        // Count pairs (i, j) where i < j
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                pairCount++;
                ops++;
            }
        }

        System.out.println(pairCount);
        System.out.println(ops);
    }
}

/*output
 * PS C:\Users\AA\Documents\GitHub\113TKUDS>  & 'C:\Program Files\Eclipse Adoptium\jdk-21.0.7.6-hotspot\bin\java.exe' '-XX:+ShowCodeDetailsInExceptionMessages' '-cp' 'C:\Users\AA\AppData\Roaming\Code\User\workspaceStorage\12d761af529bf1b66908d656711dc408\redhat.java\jdt_ws\113TKUDS_817be11f\bin' 'q4paircount' 
4
5 2 7 9
6
6

 */