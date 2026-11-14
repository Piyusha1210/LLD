import entity.Coin;

import java.util.Map;

public class CashBox {
    Map<Coin, Integer> cashBox;

    public void addMoney(Coin coin, Integer quantity) {
        Integer newQuantity = cashBox.get(coin) + quantity;
        cashBox.put(coin, newQuantity);
    }

    public void despenseMoney(Coin coin, Integer quantity) {
        Integer quantityPresent = cashBox.get(coin);
        if(quantityPresent < quantity) {
            System.out.println("Not enough money in cash box");
            return;
        }
        Integer newQuantity = cashBox.get(coin) - quantity;
        cashBox.put(coin, newQuantity);
    }
}
