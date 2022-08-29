//................Mahesh Dhanawade,SE-IT,A-03.................................//
package Amount;

import java.util.Scanner;

class AmountInWords
{

    public void Amtconvert(int n, String ch)
    {
        String one[] =
        {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
            "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
        };
        String tens[] =
        {
            "", "", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
        };
        if (n > 19)
        {
            System.out.print(tens[n / 10] + " " + one[n % 10]);
        }//end of if 
        else
        {
            System.out.print(one[n]);
        }//end of else 
        if (n > 0)
        {
            System.out.print(ch);
        }//end of if 
    }//end of Amtconvert() 
}//end of class 	 	 

public class Word_Amount
{

    public static void main(String[] args)
    {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter amount : ");
        n = sc.nextInt();
        if (n >= 1000)
        {
            System.out.println("Please enter amount less than 1000");
            System.exit(0);
        }//end of if  	 	
        if (n <= 0)
        {
            System.out.print("Enter Amount greater than zero");
        }//end of if 
        else
        {
            AmountInWords a = new AmountInWords();
            a.Amtconvert((n / 100) % 10, " Hundred ");
            a.Amtconvert((n % 100), "");
        }//end of else 
    }//end of main() 
}//end of class 
