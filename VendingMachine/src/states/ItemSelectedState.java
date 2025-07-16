package states;

import entities.Coin;
import vendingmachine.VendingMachine;

public class ItemSelectedState extends State {

    public ItemSelectedState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }
    @Override
    public void insertCoin(Coin coin) {
        vendingMachine.addBalance(coin.getValue());
        System.out.println("Coin Inserted: " + coin.getValue());
        if(vendingMachine.getBalance()>= vendingMachine.getSelectedItem().getPrice()) {
            vendingMachine.setState(new MoneyInsertedState(vendingMachine));
        }
    }

    @Override
    public void selectItem(String code) {
        System.out.println("Item already selected");
    }

    @Override
    public void dispense() {
        System.out.println("Please insert sufficient money.");
    }

    @Override
    public void refund() {
        vendingMachine.reset();
        vendingMachine.setState(new IdleState(vendingMachine));
    }
}
