import java.util.Scanner;

public class q5matrixmul {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] A = new int[n][n];
        int[][] B = new int[n][n];
        int[][] C = new int[n][n];
        int ops = 0;

        // Read matrix A
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                A[i][j] = sc.nextInt();

        // Read matrix B
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                B[i][j] = sc.nextInt();

        // Matrix multiplication: C = A × B
        for (int i = 0; i < n; i++) {          // row of A
            for (int j = 0; j < n; j++) {      // column of B
                C[i][j] = 0;
                for (int k = 0; k < n; k++) {  // column of A / row of B
                    C[i][j] += A[i][k] * B[k][j];
                    ops += 2; // one multiplication + one addition
                }
            }
        }

        // Output matrix C
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(C[i][j]);
                if (j < n - 1) System.out.print(" ");
            }
            System.out.println();
        }

        // Output ops
        System.out.println(ops);
    }
}

/* output
 * PS C:\Users\AA\Documents\GitHub\113TKUDS>  & 'C:\Program Files\Eclipse Adoptium\jdk-21.0.7.6-hotspot\bin\java.exe' '-XX:+ShowCodeDetailsInExceptionMessages' '-cp' 'C:\Users\AA\AppData\Roaming\Code\User\workspaceStorage\12d761af529bf1b66908d656711dc408\redhat.java\jdt_ws\113TKUDS_817be11f\bin' 'q5matrixmul' 
2
1 2
3 4
5 6
7 8
19 22
43 50
16
 */