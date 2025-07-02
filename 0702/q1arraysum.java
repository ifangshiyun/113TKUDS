import java.util.Scanner;

public class q1arraysum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int sum = 0;
        int ops = 0;
        
        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            sum += num;
            ops++; // one addition per element
        }
        
        System.out.println(sum);
        System.out.println(ops);
    }
}

/* output
PS C:\Users\AA\Documents\GitHub\113TKUDS>  & 'C:\Program Files\Eclipse Adoptium\jdk-21.0.7.6-hotspot\bin\java.exe' '-XX:+ShowCodeDetailsInExceptionMessages' '-cp' 'C:\Users\AA\AppData\Roaming\Code\User\workspaceStorage\12d761af529bf1b66908d656711dc408\redhat.java\jdt_ws\113TKUDS_817be11f\bin' 'q1arraysum' 
5
1 2 3 4 5 
15
5 */