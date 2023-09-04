import java.util.Arrays;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }

        if ((a.length == 1) && (b.length == 1) && (a[0]==b[0])){
            System.out.println("YES");
            return;
        }
        if (Arrays.stream(a).sum() != Arrays.stream(b).sum()) {
            System.out.println("NO");
            return;
        }
        int firstDiff = -1;
        int lastDiff = -1;

        for (int i = 0; i < n; i++) {
            if (a[i] != b[i]) {
                if (firstDiff == -1) {
                    firstDiff = i;
                }
                lastDiff = i;
            }
        }
        Arrays.sort(a,firstDiff,lastDiff+1);
        for (int i = 0; i < n; i++) {
            if (a[i] != b[i]) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
