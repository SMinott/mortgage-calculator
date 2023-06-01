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

    public static double readInputs(String prompt, double minValue, double maxValue){
        Scanner num = new Scanner(System.in);
        double valueInputted;

        while(true){
            System.out.print(prompt);  //Example "What is your Principal amount? "
             valueInputted = num.nextFloat();
            if (valueInputted >= minValue && valueInputted <= maxValue) // Example 1000 - 1_000_000
                break;
            else
                System.out.println("Enter value between " + minValue + " and " + maxValue);
        }
        return valueInputted;
    }
    public static void main(String[] args) {
        int p = (int)readInputs("What is your Principal? ",1000, 1_000_000);
        float r = (float)readInputs("What is your Annual Interest Rate? ",0, 30);
        int n = (int)readInputs("What is your mortgage Period(years)? ", 0, 30);

//        So the monthly mortgage amount me be formatted as currency:
        String mortgage = NumberFormat.getCurrencyInstance().format(mortgageNum(p, r, n));

        System.out.println("Your monthly mortgage payment is: " + mortgage);
    }
}