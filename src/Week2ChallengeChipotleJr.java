/*
 * Write a program that will allow a robot to assemble 25 burritos.
 * Use a random generator for each burrito option and build a list of 25 burrito
 * customizations:
 * Rice: white, brown, none
 * Meat: chicken, steak, carnidas, chorizo, sofritas, veggies
 * Beans: pinto, black, none
 * Salsa: mild, medium, hot, none, all
 * Veggies: lettuce, fajita veggies, none, all
 * Cheese: yes/no
 * Guac: yes/no
 * Queso: yes/no
 * Sour cream: yes/no
 * Start with a minimum of 5 ingredients for a burrito. If you still have time
 * at the end, you can add more ingredients.
 * If you finish the project before 3pm then display a price for each burrito.
 * Pricing will be $3.00 plus .50 for each ingredient.
 * Then modify your program to use methods. For example, you can call a method from
 * main whose sole purpose is to calculate the price of the burrito.
 */

import java.util.Random;

public class Week2ChallengeChipotleJr {
    public static void main(String[] args) {
        // initialize ingredients arrays
        String[] RiceArray = {"white rice", "brown rice", "no rice", "all rice"};
        String[] MeatArray = {"chicken", "steak", "carnidas", "chorizo", "sofritas", "veggies"};
        String[] BeanArray = {"pinto beans", "black beans", "no beans", "all beans"};
        String[] SalsaArray = {"mild salsa", "medium salsa", "hot salsa", "no salsa", "all salsa"};
        String[] VeggieArray = {"lettuce", "fajita veggies", "no veggies", "all veggies"};

        int MAX_ORDER = 25;
        String[] allOrder = new String[MAX_ORDER];
        String ingred;

        int szRice = RiceArray.length;
        int szMeat = MeatArray.length;
        int szBean = BeanArray.length;
        int szSalsa = SalsaArray.length;
        int szVeggies = VeggieArray.length;

        for (int i = 0; i < MAX_ORDER; i++) {
            ingred = "";                             // initalized ingred string

            ingred += pickItem(szRice, RiceArray);
            ingred += pickItem(szMeat, MeatArray);
            ingred += pickItem(szBean, BeanArray);
            ingred += pickItem(szSalsa, SalsaArray);
            ingred += pickItem(szVeggies, VeggieArray);

            ingred = ingred + pickItem("cheese");
            ingred = ingred + pickItem("guac");
            ingred = ingred + pickItem("queso");
            allOrder[i] = ingred + pickItem("sour cream"); // save in the Order array
        }

        // compute the price of each burrito and their sum
        double amt = 0, total = 0;
        int idx = 1, size = 0;

        for (String itm : allOrder) {
            // compute the amount for an item
            amt = computeAmount(itm);

            // remove the last delimiter (", ") from an item string
            size = itm.length();
            itm = itm.substring(0, size-2);

            // print out the ingredients for an item
            System.out.printf("\nBurrito %d: %s\n", idx, itm);

            // print out the amount for an item
            System.out.printf("Amount is $%.2f\n", amt);

            // compute the total amount
            total += amt;
            idx++;
        }

        System.out.printf("\nTotal amount for %d burritos is $%.2f\n", MAX_ORDER, total);
    }

    /*
     * This method will get a random item of the given array.
     * If a randomly selected item is "none" then it returns an empty string.
     * Otherwise, it will return a string that is item concatenated with ", "
     * (which will be used as a delimiter later in the program).
     */

    public static String pickItem(int varMax, String[] varArray) {
        String choice = "";
        Random random = new Random();

        // randomly select an item between 0 and max size of the array (not inclusive)
        int idx = random.nextInt(varMax);

        choice = varArray[idx] + ", ";

        return (choice);


    }

    /*
     * This method will randomly either choose an item or not.
     * If it is selected then it will return a string that is passed string
     * concatenated with ", " (which will be used as a delimiter later
     * in the program). Otherwise, it will return an empty string.
     */

    public static String pickItem(String varItem) {
        String choice;
        Random random = new Random();

        // randomly select yes or no
        if (random.nextBoolean())
            choice = varItem + ", ";
        else
            choice = "";

        return (choice);
    }

    /*
     * This method will compute the price of a burrito and print out the ingredients
     * and price of a burrito. The base price of a burrito is $3.00 and each
     * ingredient is $0.50.
     *
     * String varItem has ',' as a item delimiter and ends with ", ".
     */
    public static double computeAmount(String allItems) {
        double totalAmt = 3.00;                   // base price
        int numItems = -1;                        // allItems ends with ", "

        // compute the number of items using ',' as a delimiter
        String items[] = allItems.split(",");
        for (int idx = 0; idx < items.length; idx++){
            if (!items[idx].contains("no")) {
                numItems++;
            }
        }

        totalAmt = totalAmt + (0.5 * numItems);

        return (totalAmt);

    }

}

