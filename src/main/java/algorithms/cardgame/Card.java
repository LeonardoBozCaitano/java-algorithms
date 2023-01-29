package algorithms.cardgame;

import java.util.Map;

public class Card {
    private Map<Gem, Integer> cost;
    private Gem type;

    public Card(Map<Gem, Integer> cost, Gem type) {
        this.cost = cost;
        this.type = type;
    }

    public Map<Gem, Integer> getCost() {
        return cost;
    }

    public Gem getType() {
        return this.type;
    }

    public void givePlayerDiscount(long discount) {
        long newCost = this.cost.getOrDefault(this.type, 0) - discount;
        if (newCost < 0) {
            this.cost.put(this.type, 0);
        } else {
            this.cost.put(this.type, (int) newCost);
        }
    }
}
