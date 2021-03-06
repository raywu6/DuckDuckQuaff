import java.util.ArrayList;

public class Cook {

    // inst vars
    private double timeStartOrder, timeEndOrder, timeOfOrder;
    public ArrayList<String> ingredientsOnHand;
    private double salary;

    // we chose to use an ArrayList
    // b/c its size will be constantly changing...
    
    public Cook() {
	timeStartOrder = timeEndOrder = timeOfOrder = System.currentTimeMillis();
	ingredientsOnHand = new ArrayList<String>();
	salary = 0;
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

	    // calculate tips
	    double tips = 0.0;
	    
	    timeEndOrder = System.currentTimeMillis();
	    timeOfOrder = timeEndOrder - timeStartOrder;
	    timeStartOrder = timeEndOrder;
	    System.out.println( "You completed the order in " + timeOfOrder/1000 + " sec.");

	    // within 8 seconds: $5 tip
	    // every second after... -$1 in tip
	    if (timeOfOrder <= 13000)  {// if within 13 seconds
		if (timeOfOrder <= 8000) 
		    tips = 5;
		else 
		    tips = 5 - (timeOfOrder/1000 - 8);
	    }
	 

	    System.out.printf( "You get $%.2f in tips!\n", tips);
	    salary += tips;
	    
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
    

} // end class Cook
