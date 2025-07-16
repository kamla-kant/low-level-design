package vendingmachine;

import entities.Coin;
import entities.Inventory;
import entities.Item;
import states.IdleState;
import states.State;

public class VendingMachine {
    private final static VendingMachine instance = new VendingMachine();
    private State currentState;
    private final Inventory inventory = new Inventory();
    private String selectedItemCode;
    private int balance;

    private VendingMachine(){
        currentState = new IdleState(this);
    }

    public static VendingMachine getInstance() {
        return instance;
    }

    public void selectItem(String code) {
        currentState.selectItem(code);
    }

    public void insertCoin(Coin coin){
        currentState.insertCoin(coin);
    }

    public void dispense(){
        currentState.dispense();
    }

    public void refund(){
        currentState.refund();
    }

    public void addItem(String code, String name, int price, int quantity) {
        Item item = new Item(code, name, price);
        inventory.addItem(code, item, quantity);
    }

    public void dispenseItem() {
        Item item = inventory.getItem(selectedItemCode);
        if(balance >= item.getPrice()) {
            inventory.reduceStock(selectedItemCode);
            balance-= item.getPrice();
            System.out.println("Dispensing item: "+ item.getName());
            if(balance>0){
                System.out.println("Returning change: "+ balance);
            }
        }
        reset();
        setState(new IdleState(this));
    }

    public void refundBalance(){
        System.out.println("Refunding: "+balance);
        balance=0;
    }

    public void reset(){
        selectedItemCode=null;
        balance=0;
    }
    public void setState(State state){
        currentState=state;
    }

    public void setSelectedItemCode(String code){
        selectedItemCode=code;
    }

    public void addBalance(int value){
        balance+=value;
    }

    public Item getSelectedItem(){
        return inventory.getItem(selectedItemCode);
    }

    public Inventory getInventory() {
        return inventory;
    }

    public int getBalance(){
        return balance;
    }
}
