import cs1.Keyboard;

public class Restaurant{

    private String restaurantName;
    public static String[] inventory;
    public ALQueue<Customer> customerList;

    public Restaurant(){
    }
    
    public void setRestaurantName( String rName ){
	restaurantName = rName;
    }

    public void intro(){
	System.out.println("Have you determined a name for your new restaurant? (Type Yes/No)");
	String a = Keyboard.readString();
	if ( a.equalsIgnoreCase("Yes") ){
	    System.out.println("Okay! What is the name you chose?");
	    String b = Keyboard.readString();    
	    setRestaurantName(b);
	    System.out.println(b+"? Wonderful name! Good luck with your new restaurant!");
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

    public void makeCook(){
	//TODO: MAKE COOK FRED FOR THIS
	//	String name = Keyboard.readString();
	//      Cook fred = new Cook(name);
	System.out.println("Now that you have your own restaurant, you'll need a cook. Have you determined a name for your cook? (Type Yes/No)");
	String a = Keyboard.readString();
	if ( a.equalsIgnoreCase("Yes") ){
	    System.out.println("Okay! What is your cook's name?");
	    String b = Keyboard.readString();    
	    Cook myCook = new Cook(b);
	    System.out.println(b+"? Welcome to the team! Lets get started by heading over to the dashboard!");
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
	    //Call A
	    return;
	}
	if ( a == 2 ){
	    System.out.println("<B>");
	    //Call B
	    return;
	}
	if ( a == 3 ){
	    System.out.println("<C>");
	    //Call C
	    return;
	}    
	else{
	    System.out.println("Sorry I didn't quite get that...");
	    dashboard();
	}
    }

    public void A(){
	Customer woosuk = new Customer("I want Hamburger!");
	customerList.enqueue(woosuk);
    }

    public String dashboard(){
	String retStr = "";
	retStr += "\n";
	retStr += restaurantName;
	retStr += " Dashboard";
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
