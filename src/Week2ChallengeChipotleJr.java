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
        int MAX_ORDER = 3;
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

            ingred = ingred + pickRice(szRice);
            ingred = ingred + pickMeat(szMeat);
            ingred = ingred + pickBean(szBean);
            ingred = ingred + pickSalsa(szSalsa);
            ingred = ingred + pickVeggies(szVeggies);
            ingred = ingred + pickCheese();
            ingred = ingred + pickGuac();
            ingred = ingred + pickQueso();

            Order[i]= ingred + pickSourCream();              // save in the Order array
            ingred = "";
        }

        for (String itm : Order)
            System.out.println(itm);
    }

    public static String pickRice(int varMax){
        String choice="", tmp="";
        Random random = new Random();

        // randomly select rice
        int idx = random.nextInt(varMax);

        tmp = RiceArray[idx];
        if (tmp.compareToIgnoreCase("none") == 0)
            choice = "";
        else
            choice = tmp + ", ";

        return (choice);
    }

    public static String pickMeat(int varMax){
        String choice = "";
        Random random = new Random();

        // randomly select meat
        int idx = random.nextInt(varMax);
        choice = MeatArray[idx] + ", ";

        return (choice);
    }

    public static String pickBean(int varMax){
        String choice, tmp;
        Random random = new Random();

        // randomly select beans
        int idx = random.nextInt(varMax);

        tmp = BeanArray[idx];
        if (tmp.compareToIgnoreCase("none") == 0)
            choice = "";
        else
            choice = tmp + ", ";

        return (choice);
    }

    public static String pickSalsa(int varMax){
        String choice, tmp;
        Random random = new Random();

        // randomly select veggies
        int idx = random.nextInt(varMax);

        tmp = SalsaArray[idx];
        if (tmp.compareToIgnoreCase("none") == 0)
            choice = "";
        else
            choice = tmp + ", ";


        return (choice);
    }

    public static String pickVeggies(int varMax){
        String choice="", tmp="";
        Random random = new Random();

        // randomly select veggies
        int idx = random.nextInt(varMax);

        tmp = VeggieArray[idx];
        if (tmp.compareToIgnoreCase("none") == 0)
            choice = "";
        else
            choice = tmp + ", ";

        return (choice);
    }

    public static String pickCheese(){
        String choice;
        Random random = new Random();

        // randomly select Cheese
        if (random.nextBoolean())
             choice = "cheese, ";
        else
             choice = "no cheese, ";

        return (choice);
    }

    public static String pickGuac(){
        String choice;
        Random random = new Random();

        // randomly select Guac
        if (random.nextBoolean())
            choice = "guac, ";
        else
            choice = "no guac, ";

        return (choice);
    }

    public static String pickQueso(){
        String choice;
        Random random = new Random();

        // randomly select Queso
        if (random.nextBoolean())
            choice = "queso, ";
        else
            choice = "no queso, ";

        return (choice);
    }

    public static String pickSourCream(){
        String choice;
        Random random = new Random();

        // randomly select Sour Cream
        if (random.nextBoolean())
            choice = "sour cream";
        else
            choice = "no sour cream";

        return (choice);
    }
}
