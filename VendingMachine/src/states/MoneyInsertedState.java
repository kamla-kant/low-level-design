package states;

import entities.Coin;
import vendingmachine.VendingMachine;

public class MoneyInsertedState extends State {

    public MoneyInsertedState(VendingMachine vendingMachine) {
        super(vendingMachine);
    }
    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Money already added");
    }

    @Override
    public void selectItem(String code) {
        System.out.println("Item already selected");
    }

    @Override
    public void dispense() {
        vendingMachine.setState(new DispensingState(vendingMachine));
        vendingMachine.dispenseItem();
    }

    @Override
    public void refund() {
        vendingMachine.refundBalance();
        vendingMachine.reset();
        vendingMachine.setState(new IdleState(vendingMachine));
    }
}
