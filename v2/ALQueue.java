/*
  Larry Wong and Ryan Kim (Kimchi gone Wong)
  APCS2 pd8
  HW35 -- ...Nor Do Aussies
  2018-04-15
*/
import java.util.ArrayList;

public class ALQueue<Quasar> implements Queue<Quasar>
{

    //instance vars
    ArrayList<Quasar> _queue;

    // constructor -- initializes instance vars
    public ALQueue()
    {
	_queue = new ArrayList<Quasar>();
    }

    //~~~~~~~~~~~~~~~~~~begin AP subset~~~~~~~~~~~~~~~~~~

    //means of removing an element from collection:
    //Dequeues and returns the first element of the queue.
    //By Duke API: Throws RuntimeException if the size is zero
    //O(n) - it has to move every item up once an item is removed
    public Quasar dequeue()
    { //Start of dequeue
	if (_queue.size() == 0) throw new RuntimeException(); //Cannot remove from nothing

	Quasar retVal = _queue.get(0); //We wish to return the First In (index 0)
	_queue.remove(0); //Proceed to remove the item in 0th index (also shifting every item up one thus the O(n) operation)
	return retVal; //Returned what was removed from queue
    } //End of dequeue

    //means of adding an element to collection:
    //Enqueue an element onto the back of this queue.
    //O(1) - adding to the back is independent of number of elements
    public void enqueue( Quasar x )
    { //Start of enqueue
	_queue.add(x); //Simply adds an iem at the next relevant index thus only requiring O(1) time
    } //End of enqueue

    //Returns true if this queue is empty, otherwise returns false.
    //O(1) - independent of number of elements
    public boolean isEmpty()
    { //Start of isEmpty
	return _queue.size() == 0; //Return true is the size is equal to zero; since it is only a comparison of two items, it is constant time
    } //End of isEmpty

    //Returns the first element of the queue without dequeuing it.
    //By Duke API: Throws RuntimeException if the size is zero
    //O(1) - independent of number of elements
    public Quasar peekFront()
    { //Start of peekFront
	if (_queue.size() == 0) throw new RuntimeException(); //If the queue size is zero, throw an error O(1)

	return _queue.get(0); //Otherwise return whats in the 0th index O(1)
    } //End of peekFront
    
    //~~~~~~~~~~~~~~~~~~~end AP subset~~~~~~~~~~~~~~~~~~~
}
