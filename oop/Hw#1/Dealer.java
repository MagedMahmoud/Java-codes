
import java.util.ArrayList;
import java.util.Arrays;

class Dealer {
ArrayList<PlayingCard> hand;
private int dealerHand=0; 
private PlayingCard[] dealing;
private int DealerAce;
Dealer(DeckofCards deck)
{
    hand = new ArrayList<>();
    dealing = new PlayingCard[]{};
    int DealerAce=0;
    for(int i=0; i<2; i++)
    {
        hand.add(deck.drawCard());
    }
    dealing = hand.toArray(dealing);
    for(int i=0; i<dealing.length; i++)
    {
        dealerHand += dealing[i].getValue();
        if(dealing[i].getValue()==11)
        {
            DealerAce++;
        }
        while(DealerAce>0 && dealerHand>21)
        {
            dealerHand-=10;
            DealerAce--;
        }
    }
}

public void showCard()
{
    PlayingCard[] firstCard = new PlayingCard[]{};
    firstCard = hand.toArray(firstCard);
    System.out.println("{"+firstCard[0]+"}");
}

public void Hit(DeckofCards deck)
{
    hand.add(deck.drawCard());
    dealing = hand.toArray(dealing);
    dealerHand = 0;
    for(int i=0; i<dealing.length; i++)
    {
        dealerHand += dealing[i].getValue();
        if(dealing[i].getValue()==11)
        {
            DealerAce++;
        }
        while(DealerAce>0 && dealerHand>21)
        {
            dealerHand-=10;
            DealerAce--;
        }
    }
}

public boolean ToHit()
{
    if(dealerHand<17)
    {
        return true;
    }
    return false;
}

public boolean hasBlackJack()
{
    if(hand.size()==2 && dealerHand==21)
    {
        System.out.println("The dealer has blackjack!");
        return true;
    }
    return false;
}

public void showHand()
{
    System.out.println(hand);
}

public int getdealerHand()
{
    return dealerHand;
}

public boolean Lost(int dealerHand)
{
    if(dealerHand>21)
    {
        System.out.println("The dealer lost!");
        return true;
    }
    return false;
}

public int takeTurn(DeckofCards deck)
{
    while(ToHit())
    {
        System.out.println("The dealer hits");
        Hit(deck);
        if(Lost(dealerHand))
        {
            break;
        }
    }
    if(dealerHand<=21)
    {
    	
    	
        System.out.print("The dealer stands.");
    }
    return dealerHand;
}
}



