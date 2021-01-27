//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: ShoppingCart
// Files: ShoppingCart.java
// Course: CS300 Summer 2019
//
// Author: Yuzheng Zhang
// Email: yzhang975@wisc.edu
// Lecturer's Name: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: Kunlun Wang
// Partner Email: kwang358@wisc.edu
// Partner Lecturer's Name: Mouna Kacem
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// _X_ Write-up states that pair programming is allowed for this assignment.
// _X_ We have both read and understand the course Pair Programming Policy.
// _X_ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: NONE
// Online Sources: NONE
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////


import java.util.Arrays;


import java.util.Scanner;



/**

*

 */


 


/**

* @author kunlunwang

*

*/


public class ShoppingCart {


  // defining the final variables

  public static final String catalogSeperator = "+++++++++++++++++++++++++++++++++++++++++++++";


  public static final String catalogColumn = "Item id Description       Price";


  public static final String welcomeMessage =

      "=============   Welcome to the Shopping Cart App   " + "=============";


  public static final String COMMAND = " [P] print the market catalog\n"

      + " [A <index>] add one occurrence of an item to the cart given its identifier\n"

      + " [C] checkout\n" + " [D] display the cart content\n"

      + " [O <index>] number of occurrences of an item in the cart given its identifier\n"

      + " [R <index>] remove one occurrence of an item from the cart given its identifier\n"

      + " [Q]uit the application\n";


  public static final String QUIT = 

  "=============  Thank you for using this App!!!!!  =============";


  // shopping cart max capacity

  private static final int CART_CAPACITY = 20;


  // sales tax

  private static final double TAX_RATE = 0.05;


  // a perfect-size two-dimensional array that stores the available items in the market

  // MARKET_ITEMS[i][0] refers to a String that represents the description of the item

  // identified by index i

  // MARKET_ITEMS[i][1] refers to a String that represents the unit price of the item

  // identified by index i in dollars.

  public static final String[][] MARKET_ITEMS = new String[][] {{"Apple", "$1.59"},

      {"Avocado", "$0.59"}, {"Banana", "$0.49"}, {"Beef", "$3.79"}, {"Blueberry", "$6.89"},

      {"Broccoli", "$1.79"}, {"Butter", "$4.59"}, {"Carrot", "$1.19"}, {"Cereal", "$3.69"},

      {"Cheese", "$3.49"}, {"Chicken", "$5.09"}, {"Chocolate", "$3.19"}, {"Cookie", "$9.5"},

      {"Cucumber", "$0.79"}, {"Eggs", "$3.09"}, {"Grape", "$2.29"}, {"Ice Cream", "$5.39"},

      {"Milk", "$2.09"}, {"Mushroom", "$1.79"}, {"Onion", "$0.79"}, {"Pepper", "$1.99"},

      {"Pizza", "$11.5"}, {"Potato", "$0.69"}, {"Spinach", "$3.09"}, {"Tomato", "$1.79"}};


  /**

   * @param args

   */

 

  /**

   * adds the item with the given identifier index at the end of the cart

   *

   * @param index of the item within the marketItems array

   * @param cart shopping cart

   * @param count number of items present within the cart before this add method is called

   * @return the number of items present in the cart after the item with identifier index is added

   */


  public static int add(int index, String[] cart, int count) {


    // if the cart is full, then print out the warning message

    if (count == cart.length) {


      System.out.print("\"WARNING: The cart is full. You cannot add any new item.\"");


    }


    // if the cart is not full, then add item description to the cart

    else {


      cart[count] = MARKET_ITEMS[index][0];


      ++count;

      

    }


    // return the number of item in the cart after addition

    return count;


  }

  

  /**

   * a private helper method aiming to retrieve the item description 

   * in the market given a certain index

   *

   * @param index the identifier of a given item in the cart 

   * @return itemDescription the item name in the market 

   */

 

  private static String getItemDescription(int index) {


    String itemDescription = MARKET_ITEMS[index][0];


    return itemDescription;


  }

  

  /**

   * Returns how many occurrences of the item with index itemIndex are present in the shopping cart

   *

   * @param itemIndex identifier of the item to count its occurrences in the cart

   * @param cart shopping cart

   * @param count number of items present within the cart

   * @return the number of occurrences of item in the cart

   */


  public static int occurrencesOf(int itemIndex, String[] cart, int count) {


    // number of occurrence of a certain item

    int numOccur = 0;


    // use for loop to search the entire cart to get the number of a given item

    for (int index = 0; index < count; ++index) {

    

      if (cart[index].equals(getItemDescription(itemIndex))) {


        ++numOccur;


      }


    }


    // return the number of occurrences of a given item

    return numOccur;

    

  }


 


  /**

   * Returns the index of an item within the shopping cart

   *

   * @param item description

   * @param cart Shopping cart

   * @param count number of items present in the shopping cart

   * @return index of the item within the shopping cart, and -1 if the item does not exist in the

   *         cart

   */


  private static int indexOf(String item, String[] cart, int count) {


    int index;


    // create a for loop to search the cart where the description matches up with a certain index

    for (index = 0; index < count; ++index) {


      if (cart[index].equals(item)) {

      

        return index;


      }

      

      }

    

      // if no such an item exists in the cart, then return -1

    

        return -1;


    }


  /**

   * Removes the first (only one) occurrence of itemToRemove if found and returns the number of

   * items in the cart after remove operation is completed either successfully or not

   *

   * @param itemToRemove item to be removed from the cart

   * @param cart Shopping cart

   * @param count number of items present in the shopping cart

   * @return count of item in the cart after removal 

   */

  

  public static int remove(String itemToRemove, String[] cart, int count) {


  // if the result of indexOf is -1 which means that the item is not present in the car

  // then print out the warning message and return the count 

    if (indexOf(itemToRemove, cart, count) == -1) {

    

      System.out.println("WARNING: " + itemToRemove + " not found in the shopping cart.");


      return count;


      // if item is present in the cart, then move the last item in the cart to 

      // the index of removed item, and then set the last item in the cart to null

      // return count -1 

    } else {


      cart[indexOf(itemToRemove, cart, count)] = cart[count - 1];


      cart[count - 1] = null;

      

      return (count - 1);


    }


  }

  

  /**

   * This private helper method serves to get the the item price in a

   * cart give a specific item identifier

   * 

   * @param index the identifier of an item 

   * @return the price of an item in double

   */


  private static double getItemPrice(int index) {

 

// get the item price and store it in a string variable 

    String itemPrice = MARKET_ITEMS[index][1];


    // because the itemPrice contains a $ sign, use substring to get ride of the $

    itemPrice = itemPrice.substring(1);

    

    // convert the string to its double counterpart 

    double doubleItemPrice = Double.valueOf(itemPrice);

    

    return doubleItemPrice;


  }



  /**

   * This private helper method serves to get the identifier of a 

   * certain item 

   * 

   * @param item the item description 

   * @return the identifier of item

   */

  

  private static int getItemIndex(String item) {

 

    int itemIndex = 0;

    

    // create a for loop to search for the corresponding identifier of a certain item

   for (itemIndex = 0; itemIndex < MARKET_ITEMS.length; ++itemIndex) {

   

   

      if (item.equals(MARKET_ITEMS[itemIndex][0])) {

      

    // return the identifier of a item when found 

        return itemIndex;

        

      }


    }

   

    return -1;


  }


 

  /**

   * returns the total value (cost) of the cart without tax in $ (double)

   *

   * @param cart Shopping cart

   * @param count number of items present in the shopping cart

   * @return the total price in double 

   */

  

  public static double getSubTotalPrice(String[] cart, int count) {


    int index = 0;


    // double variable to store item price

    double itemPrice = 0.00;


    // double variable to store the sum of item price

    double sum = 0.00;

    

    // create a for loop to get the individual price for each item in the cart

    for (index = 0; index < count; ++index) {


      itemPrice = getItemPrice(getItemIndex(cart[index]));

      

      // store each individual price to sum 

      sum = sum + itemPrice; 


    }

    

    return sum;


  }


 

  /**

   * prints the Market Catalog (item identifiers, description, and unit prices)

   */


  public static void printMarketCatalog() {

 

// print out the dashed lines which are defined as field variable in the beginning

    System.out.println(catalogSeperator);


    // print out the catalog which is defined as field variable in the beginning

    System.out.println(catalogColumn);


    // print out the dashed lines which are defined as field variable in the beginning

    System.out.println(catalogSeperator);


    int index = 0;

    

    // create a for loop to loop through the MARKET_ITEMS array to print out identifier, item

    // description, and the price 

    for (index = 0; index < MARKET_ITEMS.length; ++index) {


      System.out.println(index + "\t\t" + MARKET_ITEMS[index][0] + "    \t " + MARKET_ITEMS[index][1]);


    }

    

    // print out the dashed lines which are defined as field variable in the beginning

    System.out.println(catalogSeperator);


  }


 

  /**

   * print out the item within a cart

   *

   * @param cart Shopping cart

   * @param count number of items present in the shopping cart

   * @return void

   */

  

  public static void displayCartContent(String[] cart, int count) {


    int index = 0;

    

    // string to store the entire string literal

    String sum = "";

    

    // string to store each individual item

    String item = "";


    // create a for loop to store each item to item string

    // and every other item is concat to item string and stored in sum string 

    for (index = 0; index < count; ++index) {

    

      item = cart[index];


      sum = sum + item + ", ";

      

    }

    

    System.out.println("Cart Content: " + sum);


  }


 

  /**

   * This is the main method for ShoppingCart.java, it consists of a while loop which keeps 

   * reading in the user input until the user chooses to quit. The while loop is formed by multiple if and else 

   * if statement to consider each different input a user might input. The Scanner object to read from System.in. 

   *

   * @param args unused

   */

  public static void main(String[] args) {


    String[] cart = new String[CART_CAPACITY];

    

    System.out.println(welcomeMessage + "\n");

    

    Scanner scnr = new Scanner(System.in);


    int count = 0;


    // string to store the next user input 

    String readNextCommand = "";


    // boolean to keep track of when quit is input 

    boolean bl = true;


    // use while loop to keep reading user input until quit 

    while (bl) {


      System.out.println("");


      System.out.println("COMMAND MENU:");


      System.out.println(COMMAND);


      System.out.print("ENTER COMMAND: ");


      readNextCommand = scnr.next();


      // if user input is P or p, then print the catalog 

      if (readNextCommand.equals("P") || readNextCommand.equals("p")) {


        printMarketCatalog();


      }


      // else if user input is A or a, add the specified item to the cart 

      else if ((readNextCommand.charAt(0) == ('a') || readNextCommand.charAt(0) == ('A'))


          && (scnr.hasNextInt() == true)) {


        int addIndex = 0;


        addIndex = scnr.nextInt();


        count = add(addIndex, cart, count);


      }


      // else if user input is C or c, calculate total price 

      else if (readNextCommand.equals("C") || readNextCommand.equals("c")) {


        double totalPrice = getSubTotalPrice(cart, count);


        String sumPrice = String.format("%.2f", totalPrice);


        double doubleTotalPrice = Double.valueOf(sumPrice);


        double tax = TAX_RATE * doubleTotalPrice;


        String sumTax = String.format("%.2f", tax);


        double doubleTotalTax = Double.valueOf(sumTax);


        double total = doubleTotalPrice + doubleTotalTax;


        System.out.println("#items: " + count + " Subtotal: $" + sumPrice + " Tax: $" + sumTax

            + " TOTAL: $" + total);


      }


      // else if user input is D or d, display the cart items

      else if (readNextCommand.equals("D") || readNextCommand.equals("d")) {


        displayCartContent(cart, count);


      }

      

      // else if user input is O or o, count the occurrence of a certain item

      else if ((readNextCommand.equals("O") || readNextCommand.equals("o"))


          && (scnr.hasNextInt() == true)) {


        int occuranceIndex = scnr.nextInt();


        int numOccur = 0;


        String itemName = "";


        numOccur = occurrencesOf(occuranceIndex, cart, count);


        itemName = getItemDescription(occuranceIndex);


        System.out.println("The number of occurrences of " + itemName + " (id #" + occuranceIndex


            + ") is: " + numOccur);


      }

      // else if user input is R or r, remove the specified item from the cart 

      else if ((readNextCommand.equals("R") || readNextCommand.equals("r"))


          && (scnr.hasNextInt() == true)) {


        int identifier = scnr.nextInt();


        String itemToRemove = getItemDescription(identifier);


        count = remove(itemToRemove, cart, count);


      }

      

      // else if user input is Q or q, end the game

      else if ((readNextCommand.equals("Q") || readNextCommand.equals("q"))) {


        scnr.close();


        System.out.println(QUIT);


        bl = false;


        break;


      }


    }


  }


}

