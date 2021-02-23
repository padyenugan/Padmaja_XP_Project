import java.time.temporal.ValueRange;
import java.util.Scanner;
import javax.lang.model.util.ElementScanner6;
public class EntryKata 
{
// Gloabl Variables
    public static Scanner s = new Scanner (System.in);
    public static boolean IsValid;
    public static String user_option;
    public static void InputAndValidateMenuOption() 
    {
        do 
        {
            System.out.println("1. Addition\n2. Subtraction\n3. Multiplication\n4. Division\n5. Exit\nPlease enter your choice: ");
            user_option = s.next(); 
            IsValid = true;
            try 
            {
                IsValid = IsInputOptionValid(user_option);  
            } catch (NumberFormatException e) 
            { IsValid = false; }  
            if (IsValid == false)
                System.out.println("Invalid option entered");
        } while(IsValid == false);
    }    
    public static boolean IsInputOptionValid(String user_option)
    {
        if (Integer.parseInt(user_option) <= 0 || Integer.parseInt(user_option) > 5)
           return false;
        else
            return true;
    }
    public static String InputAndValidateNumber(int NumIndex) 
    {
        String num;
        do
        {
            System.out.println("Please enter Number " + NumIndex);
            num = s.next();
            IsValid = true;
            try {
                Double.parseDouble(num);
            } catch (NumberFormatException e) 
            { IsValid = false;
              System.out.println("Invalid number entered"); }
        } while(!IsValid);
        return num;
    }
    public static Double calculate(String num1, String num2)
    {
        Double n1 = Double.parseDouble(num1);
        Double n2 = Double.parseDouble(num2);
        switch(Integer.parseInt(user_option))
        { 
            case 1:
                return (n1+n2);
            case 2:
                return (n1-n2);
            case 3:
                return (n1*n2);
            case 4:
                if (n2 == 0)
                { IsValid = false; 
                return 0.0;  }
                else return (n1/n2);      
            default:
                return 0.0;
        }
    }
    public static void main(String[] args) 
    {
        String num1;
        String num2;
        double result;
        do
        {
            InputAndValidateMenuOption();
            if (Integer.parseInt(user_option) == 5) 
               System.exit(0);
            else{
                num1 = InputAndValidateNumber(1);
                num2 = InputAndValidateNumber(2);
                result = calculate(num1,num2); 
                if (IsValid == false)
                   System.out.println("Can't divide by Zero");
                else
                   System.out.println("Result is " + result); }
        } while (Integer.parseInt(user_option) != 5);
    }
}
