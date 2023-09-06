import java.util.*;

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputData = scanner.nextLine().split(" ");
        String[] nominalBanknotes = scanner.nextLine().split(" ");

        int cash = Integer.parseInt(inputData[0]);
        List<Integer> nominalValue = new ArrayList<>();

        for (String num : nominalBanknotes) {
            nominalValue.add(Integer.parseInt(num));
            nominalValue.add(Integer.parseInt(num));
        }
        //проверка что сумма > сумма что хочет Джо
        if (nominalValue.stream().mapToInt(v -> v).sum() < cash) {
            System.out.println(-1);
            return;
        }
        List<Integer> result = allCombination(nominalValue, cash);
        int billCount = result.size();
        if (result.isEmpty()) {
            System.out.println("-1");
        } else {
            System.out.println(billCount);
            System.out.println(result.toString().replaceAll("[\\[\\],]", ""));
        }
    }

    public static List<Integer> allCombination(List<Integer> startArray, int sum) {
        int totalSum = 0;
        if (!startArray.isEmpty())
            totalSum = startArray.stream().mapToInt(v -> v).sum();

        if (totalSum == sum) {
            return startArray;
        }
        List<Integer> workArray = new ArrayList<>();
        for (int num : startArray) {
            if (num <= sum) {
                workArray.add(num);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!workArray.isEmpty()) {
            int num = workArray.remove(workArray.size() - 1);
            if (sum - num == 0) {
                result.add(num);
                return result;
            }
            if (sum - num > 0) {
                List<Integer> combinations = allCombination(workArray, sum - num);
                if (!combinations.isEmpty()) {
                    for (int item : combinations) {
                        result.add(item);
                    }
                    result.add(num);
                    return result;
                }
            }
        }
        return result;
    }

}
