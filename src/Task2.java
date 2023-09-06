import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //sheriff
        HashMap<Character,Integer> countOfLetters = new HashMap<>();
        {
            countOfLetters.put('s',0);
            countOfLetters.put('h',0);
            countOfLetters.put('e',0);
            countOfLetters.put('r',0);
            countOfLetters.put('i',0);
            countOfLetters.put('f',0);
        }
        String inputString = in.next();
        for (int i = 0; i < inputString.length(); i++){
            char tmp = inputString.charAt(i);
            if (countOfLetters.containsKey(tmp)){
                countOfLetters.replace(tmp,countOfLetters.get(tmp)+1);
            }
        }
        countOfLetters.replace('f',(countOfLetters.get('f'))/2);
        ArrayList<Integer> arrayCountOfLetters = new ArrayList<>(countOfLetters.values());
        Optional<Integer> answer = arrayCountOfLetters.stream().min(Integer::compareTo);
        System.out.println(answer.orElse(0));
    }
}
