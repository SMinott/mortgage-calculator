# mortgage-calculator

STEP 1:
Create a mortgage calculator to calculate the monthly mortgage payment.
    Input the Principal (p), Annual Interest Rate (r), & Period (n).
    
    M = Mortgage must be expressed as a dollar amount with sign & decimal (Math method(s))
    Equation: M = p * [r(1+r)^n] / [(1+r)^n -1]
    
    p = total amount owed.
    
    n = number of payments. This takes the period of the loan (Ex. 30 year loan) and multiply it by 12 to get the total number of months to pay off loan
    Equation: n * 12
    
    r = Annual Interest Rate. Rate provided is divided by # of months in a year and then by 100 to get the percentage value.
    Equation: r / 12 / 100.
    
    Note: Changes will be made incrementally by refacturing the code.
STEP 2:
Add error handling for each input

    Principal must be between $1K - $1M

    Rate greater than 0 less than or equal 30

    Period between 0 and 30
Note: Utilized control flow (loops, conditionals, & operators.)

STEP 3:
Refactor - Remove repetitive code

    Refactored main method by removing the multiple/repetitive while loops.

    Created a separate method (readInputs), with parameters, to handle the input 
    with only 1 while loop that may be used interchageable for each input.

STEP 4: Amortization schedule.  That is, balance (B) after each payment.
Input the Principal (p), Annual Interest Rate (r), & Period (n), Payments made (s)

    B = p * [(1 + r)^n - (1 + r)^s] / [(1 + r)^n - 1]
Many of the variables used in the mortgageNum method is needed. So:
1. Move the FINAL variables to the class level & added a static modifier 
since methods that use them are static.


