import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] inputData = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] allPrices = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Optional<Integer> answer =
                Optional.of(Arrays.stream(allPrices)
                        .filter(m -> m <= inputData[1])
                        .summaryStatistics().getMax());
        System.out.println(answer.filter(p -> p >= 0).orElse(0));

    }
}
