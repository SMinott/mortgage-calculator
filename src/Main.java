import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    static double mortgageNum(int principal, float annualIntRate, int period ){
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;
        double mthlyIntRate = annualIntRate / MONTHS_IN_YEAR / PERCENT;
        int numberOfPayments = period * MONTHS_IN_YEAR;

        //      Equation: M = P * (r(1+r)^n) / (1+r)^n -1
        double powerMethod = Math.pow((1 + mthlyIntRate), numberOfPayments);
        double mthlyMortgageCalculation  = principal * (mthlyIntRate * powerMethod) / (powerMethod - 1);

        return mthlyMortgageCalculation;
    }
    public static void main(String[] args) {
        int p = 0;
        float r = 0;
        int n = 0;
        Scanner num = new Scanner(System.in);

        while(true){
            System.out.print("What is your Principal amount? ");
            p = num.nextInt();
            if (p >= 1000 && p <= 1_000_000)
                break;
            else
                System.out.println("Principal must be between $1K - $1M.");
        }

        while(true){
            System.out.print("What is your Annual Interest Rate? ");
            r = num.nextFloat();
            if(r > 0 && r <= 30)
                break;
            else
                System.out.println("Rate must be greater than zero or less/equal 30.");
        }

        while(true){
            System.out.print("What is your mortgage Period(years)? ");
            n = num.nextInt();
            if(n > 0 && n <= 30)
                break;
            else
                System.out.println("Period must be between 0 and 30.");
        }

//        So the monthly mortgage amount me be formatted as currency:
        String mortgage = NumberFormat.getCurrencyInstance().format(mortgageNum(p, r, n));

        System.out.println("Your monthly mortgage payment is: " + mortgage);
    }
}