import cs1.Keyboard;

public class Restaurant{

    private String restaurantName;
    
    /* Restaurant constructor
     *
     */
    public Restaurant( String rName ){
	restaurantName = rName;
    }

    // public void openMenu() {
	
    //}

    /* This is the introduction
     *
     */
    public void intro(){
	System.out.println("Have you determined a name for your new restaurant?");
	String a = Keyboard.readString();
	if ( a.equalsIgnoreCase("Yes") ){
	    this.Restaurant(a);
	}
	if ( a.equalsIgnoreCase("No") ){
	    System.out.println("No worries, take your time!");
	    intro();
	}    
	else{
	    System.out.println("Sorry I didn't quite get that...");
	}

    }
    
    public static void main( String[] args ){
	Restaurant Admin = new Restaurant();
System.out.println("Blah blah blah... you got a restaurant blah blah blah");
 
	Admin.intro();
	
	String s = Keyboard.readString();
	//Cook(s);	
    }

}
