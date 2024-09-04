package Task;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MissingNumberGame {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter a series of numbers separated by spaces (or 'x' to exist): ");
        while (true){
            String input=scanner.nextLine().trim();
            if(input.equalsIgnoreCase("x")){
                System.out.println("Exiting the program.");
                break;
            }
            try{
                int[] numbers=parseInput(input);
                findMissingNumbers(numbers);
                System.out.println("Enter a series of numbers separated by spaces (or 'x' to exist): ");
            }catch (NumberFormatException e){
                System.out.println("Invalid input. Please enter a valid series of numbers or 'x' to exit : ");
            }
        }
        scanner.close();
    }
    public static int[] parseInput(String input)throws NumberFormatException{
        String[] parts=input.split("\\s+");
        int[] numbers=new int[parts.length];
        for (int i=0;i< parts.length;i++){
            numbers[i] = Integer.parseInt(parts[i]);
        }
        return numbers;
    }
    public static void findMissingNumbers(int[] numbers){
        Arrays.sort(numbers);
        int min=numbers[0];
        int max=numbers[numbers.length -1];
        Set<Integer> numberSet=new HashSet<>();
        for(int number:numbers){
            numberSet.add(number);
        }
        System.out.print("Missing numbers: ");
        boolean missing=false;
        for(int i=min; i<=max ;i++){
            if(!numberSet.contains(i)){
                System.out.print(i + " ");
                missing=true;
            }
        }
        if(!missing){
            System.out.print("None");
        }
        System.out.println();
    }
}
