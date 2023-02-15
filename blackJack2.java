import java.util.Random;
import java.util.Scanner;
public class blackJack2 
{
    public static void main (String[] args)
    {
        String[] cards = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", 
                            "Eight", "Nine", "Ten","Jack","Queen","King"};

        int money = 100;
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        int loopCounter = 0;
        while(money>0 && loopCounter<5)
        {
            boolean pWin = false, dWin = false;
            System.out.println("You have $" + money);
            System.out.println("Place your bet:(Type 0 to EXIT): ");
            int bet = input.nextInt();
        if (bet==0)
            {
            System.out.println("Thanks for playing. ");
            break;
            }
            int count = 0;
         while(true)
         {
            System.out.println("Hit or Stand");
            String choice = input2.nextLine();
            if (choice.equalsIgnoreCase("Hit"))
            {
              
                Random random = new Random();
                int value = random.nextInt(13)+1;
                count+=value;
                System.out.println("You got " + cards[value-1] + " Your total is now: " + count);
                if (count==21)
                {
                    System.out.println("You win.");
                    pWin = true;
                    break;
                }
                if(count>21)
                {
                    System.out.println("You lose.");
                    dWin = true;
                    break;
                }
                

            }
            else if(choice.equalsIgnoreCase("Stand"))
            {
                int dealerCount = 0;
                for(int i=0;i<3;i++)
                {
                Random random = new Random();
                int value = random.nextInt(13)+1;
                System.out.println("The dealer flipped a "  + cards[value-1]);
                dealerCount += value;
                System.out.println("Dealer total is now: " + dealerCount);
                }
                if (dealerCount > 21)
                {
                    System.out.println("Dealer lost.");
                    pWin = true;
                    break;
                }
                if (dealerCount==21)
                {
                    System.out.println("Dealer won.");
                    dWin = true;
                    break;
                }
            }
         }
         if (dWin)
         {
             money-=bet;
             System.out.println(money);
         }
         if(pWin)
         {
             money+=bet;
             System.out.println(money);
         }
         loopCounter++;
        }
        
    }
}