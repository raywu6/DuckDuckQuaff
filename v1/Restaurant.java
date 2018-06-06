import cs1.Keyboard;

import java.util.ArrayList;

import java.util.HashMap;

    
public class Restaurant{

    private String restaurantName, cookName;
    public static ArrayList<String> inventory;
    public static ALQueue<Customer> customerQueue;
    public static HashMap<String,ArrayList<String>> menu;
    private String itemA, itemB, itemC, itemD, itemE;
    private ArrayList<String> aIng, bIng, cIng, dIng, eIng;
    private static Cook adam;

    public Restaurant(){
	inventory = new ArrayList<String>();
	inventory.add("Bacon");
	inventory.add("Black Tea");
	inventory.add("Bread");
	inventory.add("Burger");
	inventory.add("Cheese");
	inventory.add("Ketchup");
	inventory.add("Lettuce");
	inventory.add("Milk");
	inventory.add("Sausage");
	inventory.add("Sugar");
	inventory.add("Tomato");
	//"Bacon", "Black Tea", "Bread", "Burger", "Ketchup", "Lettuce", "Milk", "Sausage", "Sugar", "Tomato"};
	
	customerQueue = new ALQueue<Customer>();
	
	for (int i = 0; i < 10; i++) {
	    Customer fred = new Customer();
	    fred.setOrder();
	    customerQueue.enqueue(fred);
	}
	
	menu = new HashMap<String,ArrayList<String>>(5);
	setupMenu();
    }

    public void setupMenu(){
	itemA = "BLT";
	itemB = "Cheeseburger";
	itemC = "Hamburger";
	itemD = "Hot Dog";
	itemE = "Thai Tea";

	aIng = new ArrayList<String>();
        aIng.add("Bacon");
	aIng.add("Bread");
	aIng.add("Lettuce");
	aIng.add("Tomato");
	
        bIng = new ArrayList<String>();
        bIng.add("Bread");
	bIng.add("Burger");
	bIng.add("Cheese");
	bIng.add("Lettuce");
	bIng.add("Tomato");
	
        cIng = new ArrayList<String>();
        cIng.add("Bread");
	cIng.add("Burger");
	cIng.add("Lettuce");
	cIng.add("Tomato");
	
	dIng = new ArrayList<String>();
        dIng.add("Bread");
	dIng.add("Ketchup");
	dIng.add("Sausage");
	
	eIng = new ArrayList<String>();
	eIng.add("Black Tea");
        eIng.add("Milk");
	eIng.add("Sugar");
        
	menu.put(itemA, aIng);
	menu.put(itemB, bIng);
	menu.put(itemC, cIng);
	menu.put(itemD, dIng);
	menu.put(itemE, eIng);
    }

    public void intro(){
	System.out.println("Have you determined a name for your new restaurant? (Type Yes/No)");
	String a = Keyboard.readString();
	if ( a.equalsIgnoreCase("Yes") ){
	    System.out.println("Okay! What is the name you chose?");
	    String b = Keyboard.readString();    
	    setRestaurantName(b);
	    System.out.println(restaurantName+"? Wonderful name! Good luck with your new restaurant!");
	    return;
	}
	if ( a.equalsIgnoreCase("No") ){
	    System.out.println("No worries, take your time!");
	    intro();
	}    
	else{
	    System.out.println("Sorry I didn't quite get that...");
	    intro();
	}

    }

    
    public void setRestaurantName( String rName ){
	restaurantName = rName;
    }
    
    // public void makeCook(){
    //     System.out.println("\n");
    // 	System.out.println("Now that you have your own restaurant, you'll need a cook. Have you determined a name for your cook? (Type Yes/No)");
    //     System.out.println("\n");

    // 	String a = Keyboard.readString();

    //     System.out.println("\n");

    // 	if ( a.equalsIgnoreCase("Yes") ){
    // 	    System.out.println("Okay! What is your cook's name?");
	    
    // 	    System.out.println("\n");
	
    // 	    String b = Keyboard.readString();
    // 	    cookName = b;
	    
    // 	    myCook = new Cook(b);
    // 	    System.out.println(cookName+"? Welcome to the team! Lets get started by heading over to the dashboard!");
    // 	    return;
    // 	}
    // 	else if ( a.equalsIgnoreCase("No") ){
    // 	    System.out.println("No worries, take your time!");
    // 	    makeCook();
    // 	}    
    // 	else{
    // 	    System.out.println("Sorry I didn't quite get that...");
    // 	    makeCook();
    // 	}

    // }
    
    public void display(){
	System.out.println("Here is your dashboard for today.");
	System.out.println(dashboard());
	System.out.println("Select 1, 2, or 3.");
	int a = Keyboard.readInt();
	if ( a == 1 ){
	    System.out.print("GET RECIPE... ");
	    //Call A: Get recipe
	    Customer nextCust = customerQueue.peekFront();
	    String orderedItem = nextCust.getOrder();
	    ArrayList<String> ingred = menu.get(orderedItem);

	    System.out.println(ingred);
	    
	    return;
	}
	if ( a == 2 ){
	    System.out.println("GATHERING INGREDIENTS...");
	    //Call B: Look for ingredients
	    System.out.println(inventory);  // show inventory to user

	    System.out.print("Select an item to add to your hand... ");
	    String input = Keyboard.readString();
	    adam.addIngredient(input);
	    return;
	}
	if ( a == 3 ){
	    System.out.println("COOK...");
	    //Call C: Cook!
	    adam.cook();
	    return;
	}    
	else{
	    System.out.println("Sorry I didn't quite get that...");
	    dashboard();
	}
    }

    public String dashboard(){
	String retStr = "";
	retStr += "\n";
	retStr += "<  ";
	retStr += restaurantName;
	retStr += "  >";
	retStr += "\n";
	retStr += cookName;
	retStr += "'s Dashboard";
	retStr += "\n";
	retStr += "--------------------";
	retStr += "\n";
	retStr += "(1)|<Get recipe>---";
	retStr += "\n";
	retStr += "(2)|<Gather ingredients>---";
	retStr += "\n";
	retStr += "(3)|<Cook>---";
	retStr += "\n";
	return retStr;
    }
    
    public static void main( String[] args ){
	Restaurant admin = new Restaurant();
	
	System.out.println("Blah blah blah... you got a restaurant blah blah blah");
	admin.intro();

	adam = new Cook();

	while ( ! admin.customerQueue.isEmpty() ) {

	    String formatHand = "Currently in hand: [";
	    for (String item : adam.ingredientsOnHand) 
		formatHand += item + ",";
	    System.out.println( formatHand + "]" );
	   
	    
	    admin.display();
	} // end while loop
    }

}
