public class Customer{

    //instance variable
    private String order; //stores what food this customer wants to eat

    //constructor

    public Customer(){
	order = null;
    }

    public Customer(String theOrder){
	order = theOrder; //set the order to the given parameter
    }

    public void setOrder(){
	order = null;
	//TODO: MAKE A RANDOMIZER FOR THE ORDER
    }
    
    /**********************************************************************************************************    
     * accessor method that returns the order of this current customer
     * this will be used to print what food the customer orders in the terminal in the beginning of the game
     * 
     * e.g.)
     *
     * Terminal will print:
     * WELCOME TO THE RESTAURANT
     *
     * 1st Customer wants: hamurger
     *
     * Codified version:
     * SOP("WELCOME TO THE RESTAURANT");
     * SOP(n + "th Customer wants: " + customer0.getOrder() );
     ***********************************************************************************************************/
    public String getOrder(){
	return order;
    }

}
