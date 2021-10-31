import java.util.Scanner;

public class CodingAssessment {
   //Static  strings to store tens and ones place values in words
   //ones place values
    static String[] Ones = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine",
                                        "Ten", "Eleven", "Twelve", "Thirteen","Fourteen", "Fifteen", "Sixteen",
                                        "Seventeen", "Eighteen", "Nineteen" };
    //tens place values
    static String[] Tens = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty","Sixty", "Seventy", "Eighty", "Ninety"};
    //Function to convert a number to words
    public static String numToWord(final int n) 
    {
        if (n < 20)
        {
            return Ones[n];
        }
        if (n < 100)
        {
            return Tens[n / 10] + ((n % 10 != 0) ? " " : "") + Ones[n % 10];
        }
        if (n < 1000)
        {
            return Ones[n / 100] + " Hundred" + ((n % 100 != 0) ? " And " : "") + numToWord(n % 100);
        }
        if (n < 100000)
        {
            return numToWord(n / 1000) + " Thousand" + ((n % 10000 != 0) ? " " : "") + numToWord(n % 1000);
        }
        if (n < 10000000)
        {
            return numToWord(n / 100000) + " Lakh" + ((n % 100000 != 0) ? " " : "") + numToWord(n % 100000);
        }
        return numToWord(n / 10000000) + " Crore" + ((n % 10000000 != 0) ? " " : "") + numToWord(n % 10000000);
    }
    //Main function(main logic)
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        double number ;
        int no ;
        String beforeDecimal ;
        String afterDecimal = null;
        String input ;
        String output ;
        while(true)
        {
            System.out.println("Please Enter your number: ");
            input = sc.nextLine();
            //validating if the input is a number.
            if(!input.matches("(\\d+([.]([0-9]{0,2}))?)"))
            {
                System.out.println("Please enter valid number. ");
                continue;
            }
            //validating if the input is a greater than or equal to 0.
            number = Double.parseDouble(input);
            if(number < 0)
            {
                System.out.println("Only 0 and greater than 0 digits are allowed. Re-enter the input.");
                continue;
            }
            //checking if the input is exeeding the max limit or not.
            if(number > 99999999.99 )
            {
                System.out.println("NUMBER LIMIT (1 to 99999999.99) EXEEDED. Re-enter the input.");
                continue;
            }
            //checking if the input is empty or not.
            if(input.length() <= 0 )
            {
                System.out.println("Empty input,Please give the input.");
                continue;
            }
            break;
        }
        //if conditions  to print the numbers after the decimal point as a fraction of 100.
        if(input.contains("."))
        {
            afterDecimal = input.substring(input.indexOf("."));
            no = Integer.parseInt(input.substring(0, input.indexOf('.')));
            if(afterDecimal.length() == 1)
            {
                afterDecimal = "";
            } else {
                afterDecimal = afterDecimal.substring(1);
                afterDecimal = afterDecimal + "/100";
            }
        } 
        else 
        {
            no = Integer.parseInt(input);
        }
        //calling the function to convert the number to words.
        beforeDecimal =  numToWord(no);
        //Connecting the dots by.
        if(afterDecimal !=null && !afterDecimal.equals(""))
        {
            beforeDecimal = beforeDecimal + " " + afterDecimal;
        }
        output = "Rs "+ beforeDecimal + " ONLY";
        //printing the output.
        System.out.println(output);
        sc.close();
    }
}
