# DuckDuckQuaff :duck:
APCS2 final project, by Seong Hyeon (Ryan) Kim, Woosuk Lee, Raymond Wu

## Wok Wok
### What the user sees
When the user launches the program, they are prompted to input a username for the simulation to refer to. Immediately afterward, the clock begins ticking, and the suggested time of completing all of the tasks in the simulation is indicated. The user receives the first order, and has a user-input menu selection where he or she may check the "recipe" for the order (list of ingredients needed), gather ingredients, or cook the menu item with the ingredients they currently have on hand. After the first customer has been dealt with, the next customer's order is shown, and the process repeats until the user has successfully dealt with all of the customers in the simulation. The clock then stops ticking, and the salary based on how many orders were successfully completed and whether or not the simulation was completed within the suggested time is shown.

### How it works
* When the user launches the program, the username prompt is initiated by calling the `readString()` method in `cs1/Keyboard.java`.
* The clock begins ticking by storing value of the `System.currentTimeMillis()` method in a variable, and the suggested time is calculated based on the amount of customers. 
* The customers are stored in a queue that is implemented in an ArrayList. 
* The user's menu selection is initiated through the `readInt()` method in `cs1/Keyboard.java`. 
* Checking the "recipe" of the first order entails printing the value in the HashMap in which the key is the menu item ordered.
* Gathering ingredients first goes through the criteria of checking whether a user-specified item (`readString()` in `cs1/Keyboard.java`) exists in the Restaurant's `inventory` variable, then adding it to the Cook variable `ingredientsOnHand` if it is not already in said collection. 
* Cooking using the current ingredients on hand entails checking whether each of the items in `ingredientsOnHand` corresponds with one in the value in the HashMap in which the key is the menu item ordered. 
* If so, then the first customer in line is dequeued, and a set amount of money is added to the user's bank. 
* If not, all of the items in the collection `ingredientsOnHand` will be cleared, and the user must regather the ingredients over again before the correct permutation of ingredients is collected. 
* The clock stops ticking when the queue is empty, and the end time is stored in a variable that is bound to the value returned by the `System.currentTimeMillis()` method. 
* If the user has  completed the simulation within the suggested time, a bonus is added to his or her bank. 

### Launch instructions
1. `javac Restauraut.java`
2. `java Restaurant`
