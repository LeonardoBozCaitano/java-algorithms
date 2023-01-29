package algorithms.cardgame;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class Player {
    private Map<Gem, Integer> wallet;
    private List<Card> cards;

    public Player(Map<Gem, Integer> startingWallet) {
        wallet = startingWallet;
        cards = new ArrayList<>();
    }

    public Player(Map<Gem, Integer> wallet, List<Card> cards) {
        this.wallet = wallet;
        this.cards = cards;
    }

    public void setWalletGem(Gem gem, int number) {
        this.wallet.put(gem, number);
    }

    public boolean canPurchase(Card card) {
        card.givePlayerDiscount(this.getCards().stream().filter(c -> c.getType() == card.getType()).count());
        Map<Gem, Integer> cardCost = card.getCost();
        for (var gem: cardCost.entrySet()) {
            Integer gemCardCost = gem.getValue();
            Integer playerGemInWallet = this.wallet.getOrDefault(gem.getKey(), 0);
            if (gemCardCost > playerGemInWallet) {
                return false;
            }
        }
        return true;
    }

    public boolean purchase(Card card) {
        boolean canPurchase = canPurchase(card);
        if (canPurchase) {
            this.cards.add(card);
            for (Map.Entry<Gem, Integer> gem: card.getCost().entrySet()) {
                int gemCardCost = gem.getValue();
                setWalletGem(gem.getKey(), this.wallet.get(gem.getKey()) - gemCardCost);
            }
        }
        return canPurchase;
    }
}