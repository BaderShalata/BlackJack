import java.util.Random;
import java.util.Scanner;
public class blackJack {
    public static void main (String[] args)
    {
        String[] cards = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", 
                            "Eight", "Nine", "Ten","Jack","Queen","King"};
        
        int money = 100;
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner(System.in);
        while (money > 0)
        {
            System.out.println("Your balanace is "+ money);
            System.out.println("Place your bet:(type 0 to exit) ");
            int bet = input.nextInt();
            if (bet == 0)
            {
                System.out.println("Thanks for playing.");
                break;
            }
            int count = 0;
            if(bet>money|| bet<0)
            {
                System.out.println("Please try again: ");
                continue;
            }
            boolean dWin = false, pWin = false;
            while (true)
            {
                System.out.println("Hit or Stand?: ");
                String choice = input2.nextLine();
                // PLAYER TURN
                if (choice.equalsIgnoreCase("hit"))
                {
                    Random random = new Random();
                    int value = random.nextInt(13)+1;
                    System.out.println("You flipped a " + cards[value-1]);
                    count += value;
                    System.out.println("Your total is now: " + count);
                    if (count==21)
                    {
                        pWin = true;
                        break;
                    }
                    if (count>21) 
                    {
                        dWin = true;
                        break;
                    }
                }
                else if(choice.equalsIgnoreCase("Stand"))
                {
                    // DEALER TURN
                    int dealerCount = 0;
                    for (int t = 0; t<4; t++)
                {
                         Random random = new Random();
                         int value = random.nextInt(13)+1;
                        System.out.println("The dealer flipped a "  + cards[value-1]);
                        dealerCount += value;
                        System.out.println("Dealer total is now: " + dealerCount);
                        if (dealerCount >21) 
                        {
                            pWin = true;
                            break;
                        }
                        if (dealerCount==21)
                        {
                            dWin = true;
                            break;
                        }
                        if (dealerCount>count)
                        {
                            dWin = true;
                            break;
                        }
                        try {
                            Thread.sleep(1000);
                        }
                        catch(InterruptedException ex)
                        {
                            Thread.currentThread().interrupt();
                        }
                    } 
                }
                if (dWin)
                {
                    System.out.println("You lost");
                    money-=bet;
                }
                if (pWin)
                {
                    System.out.println("Good job");
                    money+=bet;
                }
            }
        }

    }
}
