package ir.maktab56.airline.util.menu;

import ir.maktab56.airline.util.input.Input;

public class Menu {
    public  String[] items;



    public Menu(String[] items) {

        this.items = items;
    }

    public  void print() {
        for (int i = 1; i <= items.length; i++) {
            System.out.printf("%d - %s \n", i, items[i - 1]);
        }
    }

    public  int chooseOperation() {
        return new Input(
                "Enter your Item :",
                items.length ,
                1 ,
                null).getInputInt();
    }

    public  String[] getItems() {
        return items ;
    }

    public void setItems(String[] items) {
        this.items = items;
    }
}
