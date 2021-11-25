package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static currentState state = currentState.choosingAction;
    public static fillResources resources = fillResources.water;
    public static void main(String[] args) {
        questions();
    }
    public enum currentState {
        choosingAction, variantCoffee, fillResources, off
    }

    public enum fillResources {
        water, milk, coffeeBeans, cups
    }

    public static void choosing(String input) {
        if (state.equals(currentState.choosingAction)) {
            choosingAction(input);
        } else if (state.equals(currentState.variantCoffee)) {
            CoffeeStatus.variantCoffee(input);
        } else if (state.equals(currentState.fillResources)) {
            if (resources.equals(fillResources.water)) {
                CoffeeStatus.water += Integer.parseInt(input);
                resources = fillResources.milk;
                questions();
            } else if (resources.equals(fillResources.milk)) {
                CoffeeStatus.milk += Integer.parseInt(input);
                resources = fillResources.coffeeBeans;
                questions();
            }else if (resources.equals(fillResources.coffeeBeans)) {
                CoffeeStatus.coffeeBeans += Integer.parseInt(input);
                resources = fillResources.cups;
                questions();
            }else if (resources.equals(fillResources.cups)) {
                CoffeeStatus.cups += Integer.parseInt(input);
                state = currentState.choosingAction;
                questions();
            }
        }
    }

    public static void questions() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = true;
        while (exit) {
            if (state.equals(currentState.choosingAction)) {
                System.out.println("\nWrite action (buy, fill, take, remaining, exit): ");
                choosing(scanner.next());
            } else if (state.equals(currentState.variantCoffee)) {
                System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
                choosing(scanner.next());
            } else if (state.equals(currentState.fillResources)) {
                if (resources.equals(fillResources.water)) {
                    System.out.println("Write how many ml of water you want to add: ");
                    choosing(scanner.next());
                } else if (resources.equals(fillResources.milk)) {
                    System.out.println("Write how many ml of milk you want to add: ");
                    choosing(scanner.next());
                } else if (resources.equals(fillResources.coffeeBeans)) {
                    System.out.println("Write how many grams of coffee beans you want to add: ");
                    choosing(scanner.next());
                } else if (resources.equals(fillResources.cups)) {
                    System.out.println("Write how many disposable cups of coffee you want to add: ");
                    choosing(scanner.next());
                }

            } else if (state.equals(currentState.off)) {
                exit = false;
                break;
            }
        }
    }

    public static void choosingAction(String input) {
        switch (input) {
            case "buy":
                state = currentState.variantCoffee;
                questions();
                break;
            case "fill":
                state = currentState.fillResources;
                questions();
                break;
            case "take":
                CoffeeStatus.money();
                break;
            case "remaining":
                CoffeeStatus.info();
                break;
            case "exit":
                state = currentState.off;
                break;
        }
    }



}
