import java.util.*;  

public class ATMInterface 
{    
    public static void main(String args[] ){  

        int balance = 100000;
        int withdraw;
        int deposit;

        try (Scanner sc = new Scanner(System.in)) {
            while(true)  
            {  
                System.out.println("ATM Machine");  
                System.out.println("Choose 1 for Withdraw");  
                System.out.println("Choose 2 for Deposit");  
                System.out.println("Choose 3 for Check Balance");  
                System.out.println("Choose 4 for EXIT");  
                System.out.print("Choose the option you want to do:");  

                int choice = sc.nextInt();  
                switch(choice)  
                {  
                    case 1:  
                        System.out.print("Enter how much amount you want to withdrawn : ");  
                        withdraw = sc.nextInt();  
                        if(balance >= withdraw)  
                        {  
                            balance = balance - withdraw;  
                            System.out.println("Please collect your money");  
                        }  
                        else  
                        {  
                            System.out.println("Insufficient Balance");  
                        }     
                    System.out.println("");  
                    break;  
   
                    case 2:    
                        System.out.print("Enter how much amount you want to deposit : ");  
                        deposit = sc.nextInt();  
                        balance = balance + deposit;  
                        System.out.println("Your Money has been Successfully deposited");  
                        System.out.println("");  
                        break;  
   
                    case 3:   
                    System.out.println("Current Balance : "+balance);  
                    System.out.println("");  
                    break;  
   
                    case 4:  
                    System.exit(0);  
                }  
            }
        }  
       
    }  
   
}  

