/**
 * This class contains details of a linked list node
 * 
 * @author Farhad Aman  
 * @version 1.0
 */
public class Node 
{
    /**
     * the value of the node
     */
    private int value;

    /**
     * the next node in the linked list
     */
    private Node next;
    
    /**
     * creates a new node with given value
     * @param val
     */
    public Node(int val)
    {
        value = val;
        next = null;
    }

    /**
     * sets the value of the node
     * @param val
     */
    public void setValue(int val) 
    {
        value = val;
    }

    /**
     * returns the value of the node
     * @return value
     */
    public int getValue() 
    {
        return value;    
    }

    /**
     * sets next node
     * @param nxt
     */
    public void setNext(Node nxt) 
    {
        next = nxt;
    }

    /**
     * returns the next node
     * @return next
     */
    public Node getNext() 
    {
        return next;    
    }
}
