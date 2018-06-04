import java.util.ArrayList;

public class Cook {

    // inst vars
    public String name;
    private ArrayList<String> ingredientsOnHand;
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
	String[] inv = Restaurant.inventory;
	int indexLastElem = Restaurant.inventory.length - 1;
	
	return binarySearch(inv, str, 0, indexLastElem);
    }


    public int binarySearch(String[] arr, String target, int lo, int hi) {

	// bounds have not crossed
	while (lo <= hi) {
	    int med = (lo + hi) / 2;

	    // if found target
	    if ( arr[med].compareTo(target) == 0 )
		return med;

	    // target < med, look at lower half of data
	    else if ( arr[med].compareTo(target) > 0 )
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
		ingredientsOnHand.add( Restaurant.inventory[index] );
	}
	
	else
	    System.out.println("This item is not in the restaurant's inventory!");
    }


    public String removeIngredient(String str) {

	// takes care of erroneous duplicates
	for (String s : ingredientsOnHand) {
	    if ( s.equals(str) )
		ingredientsOnHand.remove(s);
	}
    }

    
    public boolean cook() {
	// if every item in ingredientsOnHand matches w/ ones
	// as defined by Customer's order
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
