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

import java.util.ArrayList;
import java.util.Random;



public class Week2ChallengeChipotleJr {
    // initialize ingredients arrays
    private static String[] RiceArray = {"white rice", "brown rice", "none"};
    private static String[] MeatArray = {"chicken", "steak", "carnidas", "chorizo",
                                         "sofritas", "veggies"};
    private static String[] BeanArray = {"pinto bean", "black bean", "none"};
    private static String[] SalsaArray = {"mild salsa", "medium salsa", "hot salsa", "none", "all salsa"};
    private static String[] VeggieArray = {"lettuce", "fajita veggies", "none", "all veggies"};


    // main program
    public static void main (String[] args){
        int MAX_ORDER = 25;
        int noOrders = 0;
        String[] Order = new String[MAX_ORDER];
        String ingred = "";

        int szRice = RiceArray.length;
        int szMeat = MeatArray.length;
        int szBean = BeanArray.length;
        int szSalsa = SalsaArray.length;
        int szVeggies = VeggieArray.length;

        for (int i = 0; i < MAX_ORDER; i++) {
            // randomly choose each ingredients
            ingred = "Burrito " + (i+1) + ": ";

            ingred += pickItem(szRice, RiceArray);
            ingred += pickItem(szMeat, MeatArray);
            ingred += pickItem(szBean, BeanArray);
            ingred += pickItem(szSalsa, SalsaArray);
            ingred += pickItem(szVeggies, VeggieArray);

            ingred = ingred + pickItem("cheese");
            ingred = ingred + pickItem("guac");
            ingred = ingred + pickItem("queso");
            Order[i] = ingred + pickItem("sour cream"); // save in the Order array
            ingred = "";
        }

        for (String itm : Order)
            System.out.println(itm);
    }


    public static String pickItem(int varMax, String[]varArray){
        String choice="", tmp="";
        Random random = new Random();

        // randomly select rice
        int idx = random.nextInt(varMax);

        tmp = varArray[idx];
        if (tmp.compareToIgnoreCase("none") == 0)
            choice = "";
        else
            choice = tmp + ", ";

        return (choice);
    }

    public static String pickItem(String varItem){
        String choice;
        Random random = new Random();

        // randomly select yes or no
        if (random.nextBoolean())
             choice = varItem + ", ";
        else
             choice = "";

        return (choice);
    }


}
