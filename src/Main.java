import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj operacje do obliczenia np(2+2*2)");
        String numery = scanner.nextLine();
        char[] chars = numery.toCharArray();
        List<Integer> numbers = getNumbers(numery);
        List<Character> operations = new ArrayList<>();

        for (int i = 0; i < numery.length(); i++) {
            if (!Character.isDigit(chars[i])) {
                operations.add(chars[i]);
            }
        }

        if(numery.charAt(0) == '-'){
            if (numery.charAt(0) == '-') {
                int tmp = numbers.get(0);
                numbers.set(0, -tmp);
                operations.remove(0);
            }
        }

        System.out.println(result(numbers, operations));
    }
    private static List<Integer> result(List<Integer> listOfNumbers, List<Character> operations){
        int count = 0;
        int tmp = 0;
        List<Integer> getNumbers = listOfNumbers;
        List<Character> getOperations = operations;
        if(listOfNumbers.size() != 1) {
            for (int i = 0; i < operations.size(); i++) {
                if (getOperations.get(i) == '*' && count == 0) {
                    tmp = getNumbers.get(i) * getNumbers.get(i + 1);
                    getNumbers.set(i, tmp);
                    getNumbers.remove(i + 1);
                    getOperations.remove(i);
                    count++;
                } else if (getOperations.get(i) == '/' && count == 0) {
                    tmp = getNumbers.get(i) / getNumbers.get(i + 1);
                    getNumbers.set(i, tmp);
                    getNumbers.remove(i + 1);
                    getOperations.remove(i);
                    count++;
                }
            }
            for (int i = 0; i < operations.size(); i++) {

                if (getOperations.get(i) == '+' && count == 0) {
                    tmp = getNumbers.get(i) + getNumbers.get(i + 1);
                    getNumbers.set(i, tmp);
                    getNumbers.remove(i + 1);
                    getOperations.remove(i);
                    count++;
                } else if (getOperations.get(i) == '-' && count == 0) {
                    tmp = getNumbers.get(i) - getNumbers.get(i + 1);
                    getNumbers.set(i, tmp);
                    getNumbers.remove(i + 1);
                    getOperations.remove(i);
                    count++;
                }
            }
            return result(getNumbers, getOperations);
        }

        return getNumbers;
    }

    private static List<Integer> getNumbers(String s) {
        List<Integer> listOfNumbers = new ArrayList<Integer>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                String num = "";
                while (i < chars.length && Character.isDigit(chars[i])) {
                    num += chars[i++];
                }
                listOfNumbers.add(Integer.parseInt(num));
            }
        }
        return listOfNumbers;
    }
    private static List<Character> getOperations(String operations){
        List<Character> operationsList = new ArrayList<>();
        char[] operacje = operations.toCharArray();
        for (int i = 0; i < operations.length(); i++) {
            if(Character.isLetter(operacje[i])){
                operationsList.add(operacje[i]);
            }
        }
        return operationsList;
    }
}
