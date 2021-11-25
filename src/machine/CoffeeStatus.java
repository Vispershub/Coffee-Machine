package machine;

public class CoffeeStatus {
    public static int water = 400;
    public static int milk = 540;
    public static int coffeeBeans = 120;
    public static int cups = 9;
    public static int money = 550;

    public static void variantCoffee(String input) {
        switch (input) {
            case "1":
                if (water < 250) {
                    System.out.println("Sorry, not enough water!\n");
                } else if (coffeeBeans < 16) {
                    System.out.println("Sorry, not enough coffee beans!\n");
                } else if (cups < 1) {
                    System.out.println("Sorry, not enough disposable cups!\n");
                } else {
                    water -= 250;
                    coffeeBeans -= 16;
                    money += 4;
                    cups--;
                    System.out.println("I have enough resources, making you a coffee!");
                }
                break;
            case "2":
                if (water < 350) {
                    System.out.println("Sorry, not enough water!\n");
                } else if (milk < 75) {
                    System.out.println("Sorry, not enough milk!\n");
                } else if (coffeeBeans < 20) {
                    System.out.println("Sorry, not enough coffee beans!\n");
                } else if (cups < 1) {
                    System.out.println("Sorry, not enough disposable cups!\n");
                } else {
                    water -= 350;
                    milk -= 75;
                    coffeeBeans -= 20;
                    money += 7;
                    cups--;
                    System.out.println("I have enough resources, making you a coffee!");
                }
                break;
            case "3":
                if (water < 200) {
                    System.out.println("Sorry, not enough water!\n");
                } else if (milk < 100) {
                    System.out.println("Sorry, not enough milk!\n");
                } else if (coffeeBeans < 12) {
                    System.out.println("Sorry, not enough coffee beans!\n");
                } else if (cups < 1) {
                    System.out.println("Sorry, not enough disposable cups!\n");
                } else {
                    water -= 200;
                    milk -= 100;
                    coffeeBeans -= 12;
                    money += 6;
                    cups--;
                    System.out.println("I have enough resources, making you a coffee!");
                }
                break;
            case "back":
                CoffeeMachine.state = CoffeeMachine.currentState.choosingAction;
                break;
        }
        CoffeeMachine.state = CoffeeMachine.currentState.choosingAction;
        CoffeeMachine.questions();
    }

    public static void money() {
        System.out.printf("I gave you $%d", money);
        money = 0;
        CoffeeMachine.state = CoffeeMachine.currentState.choosingAction;
        CoffeeMachine.questions();
    }

    public static void info() {
        System.out.printf("The coffee machine has:\n" +
                "%d ml of water\n" +
                "%d ml of milk\n" +
                "%d g of coffee beans\n" +
                "%d disposable cups\n" +
                "$%d of money", water, milk, coffeeBeans, cups, money);
        CoffeeMachine.state = CoffeeMachine.currentState.choosingAction;
        CoffeeMachine.questions();
    }

}
