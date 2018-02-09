public class DeckOfCardsTest {
    public static void main(String[] args) {
        DeckOfCards cards = new DeckOfCards();
        cards.shuffle();
        
        for(int i = 1; i <= 52; i++) {
            System.out.printf("%-19s", cards.dealCard());
            if(i % 4 == 0)
                System.out.println();
        }
    }
}