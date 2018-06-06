import cs1.Keyboard;

import java.util.HashMap;

    
public class Restaurant{

    private String restaurantName, cookName;
    public static String[] inventory;
    public ALQueue<Customer> customerList;
    public HashMap<String,String[]> menu;
    public String itemA, itemB, itemC, itemD, itemE;
    public String[] aIng, bIng, cIng, dIng, eIng;

    public Restaurant(){
	String[] inventory = { "Bacon", "Black Tea", "Bread", "Burger", "Ketchup", "Lettuce", "Milk", "Sausage", "Suger", "Tomato" };
	ALQueue<Customer> customerList = new ALQueue<Customer>();
	for (int i = 0; i < 10; i++) {
	    Customer fred = new Customer();
	    fred.setOrder();
	    customerList.enqueue(fred);
	}
	menu = new HashMap<String,String[]>(5);
	setupMenu();
    }

    public void setupMenu(){
	String itemA = "BLT";
	String itemB = "Cheeseburger";
	String itemC = "Hamburger";
	String itemD = "Hot Dog";
	String itemE = "Thai Tea";

	String[] aIng = {"Bacon", "Bread", "Lettuce", "Tomato"};
	String[] bIng = {"Bread", "Burger", "Cheese", "Lettuce", "Tomato"};
	String[] cIng = {"Bread", "Burger", "Lettuce", "Tomato"};
	String[] dIng = {"Bread", "Ketchup", "Sausage"};
	String[] eIng = {"Black Tea", "Milk", "Sugar"};
	
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
    
    public void makeCook(){
        System.out.println("\n");
	System.out.println("Now that you have your own restaurant, you'll need a cook. Have you determined a name for your cook? (Type Yes/No)");
        System.out.println("\n");

	String a = Keyboard.readString();

        System.out.println("\n");

	if ( a.equalsIgnoreCase("Yes") ){
	    System.out.println("Okay! What is your cook's name?");
	    
	    System.out.println("\n");
	
	    String b = Keyboard.readString();
	    cookName = b;
	    Cook myCook = new Cook(b);
	    System.out.println(cookName+"? Welcome to the team! Lets get started by heading over to the dashboard!");
	    return;
	}
	if ( a.equalsIgnoreCase("No") ){
	    System.out.println("No worries, take your time!");
	    makeCook();
	}    
	else{
	    System.out.println("Sorry I didn't quite get that...");
	    makeCook();
	}

    }
    
    public void display(){
	System.out.println("Here is your dashboard for today.");
	System.out.println(dashboard());
	System.out.println("Select 1, 2, or 3.");
	int a = Keyboard.readInt();
	if ( a == 1 ){
	    System.out.println("<A>");
	    //Call A: Get recipe
	    
	    return;
	}
	if ( a == 2 ){
	    System.out.println("<B>");
	    //Call B: Look for ingredients
	    
	    return;
	}
	if ( a == 3 ){
	    System.out.println("<C>");
	    //Call C: Cook!
	    
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
	retStr += "(1)|<A>---";
	retStr += "\n";
	retStr += "(2)|<B>---";
	retStr += "\n";
	retStr += "(3)|<C>---";
	retStr += "\n";
	return retStr;
    }
    
    public static void main( String[] args ){
	Restaurant admin = new Restaurant();

	admin.customerList = new ALQueue<Customer>();
	
	System.out.println("Blah blah blah... you got a restaurant blah blah blah");

	admin.intro();

	admin.makeCook();	
	
	admin.display();

    }

}
