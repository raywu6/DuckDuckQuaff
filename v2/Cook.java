import java.util.ArrayList;

public class Cook {

    // inst vars
    public String name; // *************************8  if not used delete...
    public ArrayList<String> ingredientsOnHand;
    private double salary;

    // we chose to use an ArrayList
    // b/c its size will be constantly changing...
    
    public Cook() {
	name = "John Doe";
	ingredientsOnHand = new ArrayList<String>();
	salary = 0;
    }

    public Cook (String myName) {
	this();          // call default constructor
	name = myName;   // overwrite default name with specified name
    }


    public void setMoney (double amt) {
	salary += amt;
    }

    
    public double getMoney() {
	return salary;
    }


    public int find(String str) {
	ArrayList<String> inv = Restaurant.inventory;
	int indexLastElem = Restaurant.inventory.size() - 1;
	
	return binarySearch(inv, str, 0, indexLastElem);
    }


    public int binarySearch(ArrayList<String> arr, String target, int lo, int hi) {
	// case-INSENSITIVE
	target = target.toLowerCase();

	// bounds have not crossed
	while (lo <= hi) {
	    int med = (lo + hi) / 2;

	    // if found target
	    if ( arr.get(med).toLowerCase().compareTo(target) == 0 )
		return med;

	    // target < med, look at lower half of data
	    else if ( arr.get(med).toLowerCase().compareTo(target) > 0 )
		hi = med - 1;

	    // target > med, look at upper half of data
	    else
		lo = med + 1;
	}

	return -1;  // target not found
    }

    
    public void addIngredient(String str) {

	int index = find(str);
	
	// if str is valid item in restaurant's inventory
	if ( index != -1 ) {

	    // if already have ingredient in hand
	    if ( ingredientsOnHand.contains(str) )
		System.out.println("You already have this item!");
	    
	    else
		ingredientsOnHand.add( Restaurant.inventory.get(index) );
	}
	
	else
	    System.out.println("This item is not in the restaurant's inventory!");
	
    }


    public String removeIngredient(String str) {

	String retStr = "";
	
	// takes care of erroneous duplicates
	for (String s : ingredientsOnHand) {
	    
	    if ( s.equals(str) ) {
		retStr = s;
		ingredientsOnHand.remove(s);
	    }
	} // end for-loop

	return retStr;
    }


    public boolean cook() {

	// if every item in ingredientsOnHand matches w/ ones
	// defined by Customer's order	
	
        if ( matching( ingredientsOnHand,
		       Restaurant.menu.get(getNextOrder()) ) ) {
	    System.out.println("Success! Customer dequeued. +$10");
	    setMoney(10);
	    Restaurant.customerQueue.dequeue();
	    ingredientsOnHand.clear();

	    return true;
	}

	// reach here means false

	System.out.println("The items you have do not make the item the customer ordered!");
	System.out.println("Your hand's ingredients has been cleared...");
	System.out.println("The customer is still waiting for his order...");

	ingredientsOnHand.clear();

	return false;
	    

    }


    // helper method for cook()
    public static boolean matching (ArrayList<String> arr1, ArrayList<String> arr2) {

	boolean found;

	if ( arr1.size() != arr2.size() )
	    return false;

	// else ... reach here means sizes are same
	
	for (String s1 : arr1) {
	    found = false;
	    
	    for (String s2 : arr2) {
		if ( s1.equals(s2) )
		    found = true;
		
	    }

	    if (found == false)
		return false;
	}

	return true;
    }
    
	

    // helper method for cook()
    public static String getNextOrder() {
	
	Customer custObj = Restaurant.customerQueue.peekFront();
	String order = custObj.getOrder();
	

	return order;
    }
    

    // for testing only
    public static void main (String[] args) {
	Cook a = new Cook();
	System.out.println("name: " + a.name);
	System.out.println("salary: " + a.salary);

	Cook b = new Cook("Fred");
	System.out.println("name: " + b.name);
	System.out.println("salary: " + b.salary);
	
    } // end main method
	
} // end class Cook
