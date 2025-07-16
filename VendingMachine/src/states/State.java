package states;

import entities.Coin;
import vendingmachine.VendingMachine;
public abstract class State {
    protected VendingMachine vendingMachine;

    State(VendingMachine vendingMachine){
        this.vendingMachine = vendingMachine;
    }

    public abstract void insertCoin(Coin coin);
    public abstract void selectItem(String code);
    public abstract void dispense();
    public abstract void refund();
}
