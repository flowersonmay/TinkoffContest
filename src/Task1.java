import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] data = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] price = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        //cash[0] = кол-во
        //cash[1] = кол-во денег
        int max = 0;
        Optional<Integer> ans =
                Optional.of(Arrays.stream(price)
                        .filter(m -> m <= data[1])
                        .summaryStatistics().getMax());
        System.out.println(ans.filter(p -> p >= 0).orElse(0));

    }
}
