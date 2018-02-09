
class PlayingCard {

private int level;
private int suit;
private int values;
private static String[] types = {"Joker","Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
private static String[] suits = {"Clubs","Diamonds","Hearts","Spades"};

PlayingCard(int suits, int values)
{
    this.level=values;
    this.suit=suits;
}

public String toString()
{
    return types[level]+" of "+suits[suit];
}

public int getlevel()
{
    return level;
}

public int getSuit()
{
    return suit;
}

public int getValue()
{
    if(level>10)
    {
        values=10;
    }
    else if(level==1)
    {
        values=11;
    }
    else
    {
        values=level;
    }
    return values;
}

public void setValue(int set)
{
    values = set;
}
}






