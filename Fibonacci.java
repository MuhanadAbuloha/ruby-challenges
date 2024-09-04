import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String input;
        while (true){
            System.out.println("Enter the number of Fibonacci numbers to generate or 'x' to exist: ");
            input=scanner.nextLine();
            if(input.equalsIgnoreCase("x")){
                System.out.println("Exiting the program.");
                break;
            }
            try{
                int n=Integer.parseInt(input);

                if(n>0){
                    generateFibonacci(n);
                }else{
                    System.out.println("Please enter a positive Integer.");
                }
            }catch (NumberFormatException e){
                System.out.println("Invalid input. Please enter a valid number for the Fibonacci sequence or 'x' to exist.");
            }
        }
        scanner.close();
    }
    public static void generateFibonacci(int n){
        int num1=0,num2=1;
        System.out.print("Fibonacci Sequence: "+num1+", "+num2);

        for(int i=2;i<n;i++){
            int nextNum=num1+num2;
            System.out.print(", "+nextNum);
            num1=num2;
            num2=nextNum;
        }
        System.out.println();
    }
}
