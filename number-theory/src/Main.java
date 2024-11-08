import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        NumberTheory x = new NumberTheory();
        Scanner sc = new Scanner(System.in);
        System.out.println("Select The Operation\n" +
                "1. prime checker (check if positive integer is prime)\n" +
                "2. prime factorisation (get prime factors of a positive integer)\n" +
                "3. euclidean gcd and lcm (uses the euclidean algorithm to calculate the gcd and lcm of two positive integers)\n" +
                "4. factorisation gcd and lcm (uses prime factors of two positive integers to find gcd and lcm)\n" +
                "5. chinese remainder theorem (solves a system of linear congruences)");
        int operation = sc.nextInt();
        while ( (operation < 1) || (operation > 5) )
        {
            System.out.println("Invalid option, please try again");
            operation = sc.nextInt();
        }
        switch (operation)
        {
            case 1:
                System.out.println("Please enter your positive integer");
                int num = sc.nextInt();
                while (num < 1)
                {
                    System.out.println("Invalid input, number must be positive");
                    num = sc.nextInt();
                }
                boolean isPrime = x.isPrime(num);
                if (isPrime)
                {
                    System.out.println("The number " + num + " is prime.");
                }
                else
                {
                    System.out.println("The number " + num + " is not prime.");
                }
                break;
            case 2:
                System.out.println("Please enter your positive integer");
                num = sc.nextInt();
                while (num < 1)
                {
                    System.out.println("Invalid input, number must be positive");
                    num = sc.nextInt();
                }
                ArrayList<Integer> factors = x.primeFactors(num);
                if (factors != null)
                {
                    System.out.print("The prime factors of " + num + " are: ");
                    for (int i = 0; i < factors.size(); i++)
                    {
                        System.out.print(factors.get(i));
                        if ( (i + 1) != factors.size() )
                        {
                            System.out.print(",");
                        }
                    }
                }
                else
                {
                    System.out.println("Invalid number: No prime factors");
                }
                break;
            case 3:
                System.out.println("Please enter first number");
                int a = sc.nextInt();
                while (a < 1)
                {
                    System.out.println("Invalid input, number must be positive");
                    a = sc.nextInt();
                }
                System.out.println("Please enter second number");
                int b = sc.nextInt();
                while (b < 1)
                {
                    System.out.println("Invalid input, number must be positive");
                    b = sc.nextInt();
                }
                int[] euclid = x.euclidean(a, b);
                System.out.println("The Greatest Common Divisor of " + a + " and " + b + " is: " + euclid[0] + "\n" +
                        "The Least Common Multiple of " + a + " and " + b + " is: " + euclid[1]);
                break;
            case 4:
                System.out.println("Please enter first number");
                a = sc.nextInt();
                while (a < 1)
                {
                    System.out.println("Invalid input, number must be positive");
                    a = sc.nextInt();
                }
                System.out.println("Please enter second number");
                b = sc.nextInt();
                while (b < 1)
                {
                    System.out.println("Invalid input, number must be positive");
                    b = sc.nextInt();
                }
                int[] factorise = x.factoriser(a, b);
                System.out.println("The Greatest Common Divisor of " + a + " and " + b + " is: " + factorise[0] + "\n" +
                        "The Least Common Multiple of " + a + " and " + b + " is: " + factorise[1]);
                break;
            case 5:
                System.out.println("Please enter the number of congruences");
                int congruences = sc.nextInt();
                int[] arbitrary = new int[congruences];
                int[] moduli = new int[congruences];
                System.out.println("Please enter your system of congruences");
                for (int i = 0; i < congruences; i++)
                {
                    // x = 2 (mod 3)
                    String sin = sc.next();
                    sin = sin.replaceAll(" ", "");
                    sin = sin.replaceAll("x=", "");
                    sin = sin.replaceAll("\\(", "");
                    sin = sin.replaceAll("\\)", "");
                    String[] s = sin.split("mod");
                    int[] array = new int[s.length];
                    if (s.length == 1 && s[0].isEmpty())
                    {
                        array = new int[]{};
                    }
                    else
                    {
                        arbitrary[i] = Integer.parseInt(s[0]);
                        moduli[i] = Integer.parseInt(s[1]);
                    }
                }
                int N = 1;
                for (int i = 0; i < congruences; i++)
                {
                    N = N * moduli[i];
                }
                int systemResult = x.chineseRemainder(arbitrary, moduli);
                if (systemResult == Integer.MIN_VALUE)
                {
                    System.out.println("Cannot apply Chinese Remainder Theorem: The moduli are not pairwise prime");
                }
                else
                {
                    System.out.println("The result of your system is: " + systemResult + "(mod " + N + ")");
                }
                break;
        }
    }
}