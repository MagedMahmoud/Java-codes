
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


	public static void main(String[] args) {
		User user = new User();
		System.out.println("Let's play some BlackJack!");
		System.out.println("How much money will you be playing with?");
		Scanner cash = new Scanner(System.in);
		user.money = cash.nextInt();
		System.out.println("You're starting with $ " + user.money);
		System.out.println("You can play up to 10 rounds");
		int counter = 1;
		do {
			System.out.println("You are now playing round " + counter);
			DeckofCards deck = new DeckofCards();
			deck.shuffle();
			user.countsOfAce = 0;
			Dealer dealer = new Dealer(deck);
			List<PlayingCard> hand = new ArrayList<>();
			hand.add(deck.drawCard());
			System.out.println("How much would you like to bet?");
			user.betting = Bet(user.money);
			System.out.println("Cash now $ " + (user.money - user.betting));
			System.out.println("Money on the table $ " + user.betting);
			System.out.println("Card in hand " + hand);
			int valueHand = user.totalHandValue(hand);
			System.out.println("The dealer's cards  ");
			dealer.showCard();
			if (user.hasBlackJack(user.usersHand) && dealer.hasBlackJack()) {
				((User) user).Push();
			} else if (user.hasBlackJack(user.usersHand)) {
				System.out.println("You have BlackJack!");
				user.money = user.money + user.betting;
				user.Win();
			} else if (dealer.hasBlackJack()) {
				System.out.println("Dealer's hand ");
				dealer.showHand();
				user.Losing();
			} else {
				if (2 * user.betting < user.money) {
					System.out.println("If you would like to double down enter double, if you don't enter no?");
					Scanner doubledown = new Scanner(System.in);
					String doubled = doubledown.nextLine();
					while (!Bool.isDouble(doubled)) {
						System.out.println("Please enter double or no.");
						doubled = doubledown.nextLine();
					}
					if (doubled.equals("double")) {
						System.out.println("You doubled down!");
						user.betting = 2 * user.betting;
						System.out.println("Cash you have now $ " + (user.money - user.betting));
						System.out.println("Money on the table $ " + user.betting);
					} 
				}
				System.out.println("Hit or stand?");
				Scanner hitStand = new Scanner(System.in);
				String player = hitStand.nextLine();
				while (!Bool.HitStand(player)) {
					System.out.println("Only bv  enter Hit or Stand?");
					player = hitStand.nextLine();
				}
				while (player.equals("hit")) {
					user.Hit(deck, hand, valueHand);
					System.out.print("You now have ");
					System.out.println(hand);
					user.usersHand = User.totalHandValue(hand);
					if (user.TwentyOne(user.usersHand)) {
						user.Losing();
						break;
					}
				
					System.out.println("Hit or stand?");
					
					player = hitStand.nextLine();
				}
				if (player.equals("stand")) {
					int dealerhand = dealer.takeTurn(deck);
					System.out.println("Dealer's hand ");
					dealer.showHand();
					if (dealerhand > 21) {
						user.Win();
					} else {
						int player1 = 21 - valueHand;
						int dealer1 = 21 - dealerhand;
						if (player1 == dealer1) {
							user.Push();
						} else if (player1 < dealer1) {
							user.Win();
						} else {
							user.Losing();
						}
					}
				}
			}
			System.out.println("Play again?");
			Scanner Choice = new Scanner(System.in);
			String answer = Choice.nextLine();

			while (!Bool.isChoice(answer)) {
				System.out.println("Please only enter yes or no");
				answer = Choice.nextLine();
			}
			counter++;
		} while (user.money > 0 && counter <= 10);
		System.out.println("the cash you have now " + user.money);
		if (user.money == 0) {
			System.out.println("No more cash!");
			System.out.println("Game over!");
		} 
		if( counter > 10) {
			System.out.println("You played 10 rounds already, sorry.");
			System.out.println("Game over!");
		}
	

	}

	public static int Bet(int money) {
		Scanner scanning = new Scanner(System.in);
		int betting = scanning.nextInt();
		while (betting > money) {
			System.out.println("You do not have that much money.");
			break;
		}
		return betting;
	}

}


