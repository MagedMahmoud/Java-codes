
import java.util.ArrayList;
import java.util.List;


public class User {
	
	public static int money; 
	public static int betting;
	public static int countsOfAce;
	public static ArrayList<PlayingCard> userHand;
	public static int usersHand;
	


public static void Losing() {
	System.out.println("Ah!! You lost, better luck next time! ");
	money = money - betting;
	System.out.println("Cash now $ " + money);
}

public static void Win() {
	System.out.println("Winner!");
	money = money + betting;
	System.out.println("Cash now $ " + money);
}

	
public boolean TwentyOne(int usersHand) {
	if (usersHand > 21) {
		System.out.println("Your hand is over 21, you lost!");
		Losing(); 
		return true;
	}
	return false;
}
public static boolean hasBlackJack(int usersHand) {
	if (usersHand == 21) {
		Win();
		return true;
	}
	return false;
}
public static int totalHandValue(List<PlayingCard> hand) {
	PlayingCard[] dealing = new PlayingCard[] {};
	dealing = hand.toArray(dealing);
	int usersHand = 0;
	for (int i = 0; i < dealing.length; i++) {
		usersHand += dealing[i].getValue();
		if (dealing[i].getValue() == 11) {
			countsOfAce++;
		}
		while (countsOfAce > 0 && usersHand > 21) {
			usersHand -= 10;
			countsOfAce--;
		}
	}
	return countsOfAce;

}
public void Push() {

	System.out.println("Cash back $ " + money);
}
public static void Hit(DeckofCards deck, List<PlayingCard> hand, int countsOfAce) {
	hand.add(deck.drawCard());
	PlayingCard[] dealing = new PlayingCard[] {};
	dealing = hand.toArray(dealing);
	usersHand = 0;
	for (int i = 0; i < dealing.length; i++) {
		usersHand += dealing[i].getValue();
		if (dealing[i].getValue() == 11) {
			countsOfAce++;
		}
		while (countsOfAce > 0 && usersHand > 21) {
			usersHand -= 10;
			countsOfAce--;
		}
	}
}

}




