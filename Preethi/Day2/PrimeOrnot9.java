import java.util.Scanner;

public class PrimeOrnot9 {
	public static void main(String[] args) {
        int num;
       System.out.println("Enter any number...");
       Scanner scanner = new Scanner(System.in);
       num = scanner.nextInt();
        boolean flag = false;
        for(int i = 2; i <= num/2; ++i)
        {
            if(num % i == 0)
            {
                flag = true;
                break;
            }
        }
        if (!flag)
            System.out.println(num + " is a prime number.");
        else
            System.out.println(num + " is not a prime number.");
    }
}
