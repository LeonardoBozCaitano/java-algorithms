package algorithms.cardgame;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        testIfPlayerCanPurchase();
        testIfPlayerCantPurchase();
        testPlayerCardPurchase();
        testPlayerCardCantPurchase();
    }

    private static void testIfPlayerCanPurchase() {
        Map<Gem, Integer> playerGems = new HashMap<>();
        playerGems.put(Gem.R, 3);
        playerGems.put(Gem.Y, 3);
        playerGems.put(Gem.B, 3);
        Player player = new Player(playerGems);

        Map<Gem, Integer> cardGems = new HashMap<>();
        cardGems.put(Gem.R, 3);
        cardGems.put(Gem.Y, 3);
        cardGems.put(Gem.B, 3);
        Card card = new Card(cardGems, Gem.R);

        boolean response  = player.canPurchase(card);
        System.out.println("Test must return true: " + response);
    }

    private static void testIfPlayerCantPurchase() {
        Map<Gem, Integer> playerGems = new HashMap<>();
        playerGems.put(Gem.R, 3);
        playerGems.put(Gem.B, 3);
        Player player = new Player(playerGems);

        Map<Gem, Integer> cardGems = new HashMap<>();
        cardGems.put(Gem.R, 3);
        cardGems.put(Gem.Y, 3);
        cardGems.put(Gem.B, 3);
        Card card = new Card(cardGems, Gem.R);

        boolean response  = player.canPurchase(card);
        System.out.println("Test must return false: " + response);
    }

    private static void testPlayerCardPurchase() {
        List<Card> playerCards = new ArrayList<>();
        playerCards.add(new Card(null, Gem.R));
        Map<Gem, Integer> playerGems = new HashMap<>();
        playerGems.put(Gem.R, 1);
        playerGems.put(Gem.B, 2);
        playerGems.put(Gem.Y, 2);
        Player player = new Player(playerGems, playerCards);

        Map<Gem, Integer> cardGems = new HashMap<>();
        cardGems.put(Gem.R, 2);
        cardGems.put(Gem.B, 2);
        cardGems.put(Gem.Y, 2);
        Card card = new Card(cardGems, Gem.R);

        boolean response  = player.purchase(card);
        System.out.println("Test must return true: " + response + ". And have 0 R Gem: " + player.getWallet().get(Gem.R) + ". And 2 card: " + player.getCards().size());
    }

    private static void testPlayerCardCantPurchase() {
        Map<Gem, Integer> playerGems = new HashMap<>();
        playerGems.put(Gem.R, 3);
        playerGems.put(Gem.Y, 3);
        Player player = new Player(playerGems);

        Map<Gem, Integer> cardGems = new HashMap<>();
        cardGems.put(Gem.R, 2);
        cardGems.put(Gem.B, 2);
        cardGems.put(Gem.Y, 2);
        Card card = new Card(cardGems, Gem.R);

        boolean response  = player.purchase(card);
        System.out.println("Test must return false: " + response + ". And have 3 R Gem: " + player.getWallet().get(Gem.R) + ". And 0 cards: " + player.getCards().size());
    }
}
