import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    final static byte MONTHS_IN_YEAR = 12;
    final static byte PERCENT = 100;
    public static double mortgageNum(int principal, float annualIntRate, int period ){

        double mthlyIntRate = annualIntRate / MONTHS_IN_YEAR / PERCENT;
        int numberOfPayments = period * MONTHS_IN_YEAR;

        //      Equation: M = p * (r(1+r)^n) / (1+r)^n -1
        double powerMethod = Math.pow((1 + mthlyIntRate), numberOfPayments);
        double mthlyMortgageCalculation  = principal * (mthlyIntRate * powerMethod) / (powerMethod - 1);
        return mthlyMortgageCalculation;
    }
    public static double balanceCal(int principal, float annualIntRate, int period, int numberOfPaymentsMade){

        double mthlyIntRate = annualIntRate / MONTHS_IN_YEAR / PERCENT;
        int numberOfPayments = period * MONTHS_IN_YEAR;

        //      Equation: B = p * [(1 + r)^n - (1 + r)^s] / [(1 + r)^n - 1]
        double powerMethod = Math.pow((1 + mthlyIntRate), numberOfPayments);
        double powerMethodBalance = Math.pow((1 + mthlyIntRate), numberOfPaymentsMade);
        double balanceCalculation = principal * (powerMethod - powerMethodBalance) / (powerMethod - 1 );
        return balanceCalculation;
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
        float r = (float)readInputs("What is your Annual Interest Rate? (Ex. 3.92) ",0, 30);
        int n = (int)readInputs("What is your mortgage Period (years)? ", 0, 30);

//        So the monthly mortgage amount may be formatted as currency:
        String mortgage = NumberFormat.getCurrencyInstance().format(mortgageNum(p, r, n));
        System.out.println("Your monthly mortgage payment is: " + mortgage);

        System.out.println();
        System.out.println("Your amortization schedule: ");
        for(short month = 1; month <= n * MONTHS_IN_YEAR; month++){
            String balance = NumberFormat.getCurrencyInstance().format(balanceCal(p, r, n, month));
            System.out.println(balance);
        }
    }
}