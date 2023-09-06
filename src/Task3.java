import java.util.Arrays;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int inputData = scanner.nextInt();
        int[] joesConsistency = new int[inputData];
        int[] winnerConsistency = new int[inputData];

        for (int i = 0; i < inputData; i++) {
            joesConsistency[i] = scanner.nextInt();
        }
        for (int i = 0; i < inputData; i++) {
            winnerConsistency[i] = scanner.nextInt();
        }

        if ((joesConsistency.length == 1) && (winnerConsistency.length == 1) && (joesConsistency[0]==winnerConsistency[0])){
            System.out.println("YES");
            return;
        }
        if (Arrays.stream(joesConsistency).sum() != Arrays.stream(winnerConsistency).sum()) {
            System.out.println("NO");
            return;
        }
        int leftDifferences = -1;
        int rightDifferences = -1;

        for (int i = 0; i < inputData; i++) {
            if (joesConsistency[i] != winnerConsistency[i]) {
                if (leftDifferences == -1) {
                    leftDifferences = i;
                }
                rightDifferences = i;
            }
        }
        Arrays.sort(joesConsistency,leftDifferences,rightDifferences+1);
        for (int i = 0; i < inputData; i++) {
            if (joesConsistency[i] != winnerConsistency[i]) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }
}
