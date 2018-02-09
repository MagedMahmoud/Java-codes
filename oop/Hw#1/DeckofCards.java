 
import java.util.ArrayList;
import java.util.Random;


public class DeckofCards {
private ArrayList<PlayingCard> deck;
DeckofCards()
{
    deck = new ArrayList<PlayingCard>();
    for(int i=0; i<4; i++)
    {
        for(int j=1; j<=13; j++)
        {
            deck.add(new PlayingCard(i,j));
        }
    }
}

public void shuffle()
{
    Random random = new Random();
    PlayingCard temp;
    for(int i=0; i<300; i++)
    {
        int index1 = random.nextInt(deck.size()-1);
        int index2 = random.nextInt(deck.size()-1);
        temp = deck.get(index2);
        deck.set(index2, deck.get(index1));
        deck.set(index1, temp);
    }
}

public PlayingCard drawCard()
{
    return deck.remove(0);
}
}







