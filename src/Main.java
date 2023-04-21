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

        Scanner num = new Scanner(System.in);

        System.out.print("What is your Principal amount? ");
        int p = num.nextInt();

        System.out.print("What is your Annual Interest Rate? ");
        float r = num.nextFloat();

        System.out.print("What is your mortgage Period(years)? ");
        int n = num.nextInt();

//        So the monthly mortgage amount me be formatted as currency.
        String mortgage = NumberFormat.getCurrencyInstance().format(mortgageNum(p, r, n));

        System.out.println("Your monthly mortgage payment is: " + mortgage);
    }
}