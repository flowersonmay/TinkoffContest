import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //sheriff
        HashMap<Character,Integer> letterCount = new HashMap<>();
        {
            letterCount.put('s',0);
            letterCount.put('h',0);
            letterCount.put('e',0);
            letterCount.put('r',0);
            letterCount.put('i',0);
            letterCount.put('f',0);
        }
        String inputString = in.next();
        for (int i = 0; i < inputString.length(); i++){
            char tmp = inputString.charAt(i);
            if (letterCount.containsKey(tmp)){
                letterCount.replace(tmp,letterCount.get(tmp)+1);
            }
        }
        letterCount.replace('f',(letterCount.get('f'))/2);
        ArrayList<Integer> count = new ArrayList<>(letterCount.values());
        Optional<Integer> result = count.stream().min(Integer::compareTo);
        System.out.println(result.orElse(0));
    }
}
