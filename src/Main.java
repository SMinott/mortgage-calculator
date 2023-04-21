import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
//    Create a mortgage calculator to calculate the monthly mortgage payment.
//    Input the Principal, Annual Int. Rate, & Period.
//    M = P * [r(1+r)^n] / [(1+r)^n -1]
//    M = Mortgage must be expressed as a dollar amount with sign & decimal (Math method)
//    P = total amount owed.
//    n = number of payments P * 12
//    r = Annual Int. Rate must be divided by 12 and 100 to get the monthly rate.

    static double mortgageNum(int p, float r, int n ){
        double power = Math.pow((1 + r), n);
        double mthlyMortgage  = p * (r * power) / (power - 1);
        return mthlyMortgage;
    }
    public static void main(String[] args) {

        Scanner num = new Scanner(System.in);

        System.out.print("What is your Principal? ");
        int p = num.nextInt();

        System.out.print("What is your Annual Interest Rate? ");
        float r = num.nextFloat() /12 /100;

        System.out.print("What is your mortgage Period? ");
        int n = num.nextInt() * 12;

//        So the monthly mortgage amount me be formatted as currency.
        String mortgage = NumberFormat.getCurrencyInstance().format(mortgageNum(p, r, n));

        System.out.println("Your monthly mortgage payment is: " + mortgage);
    }
}