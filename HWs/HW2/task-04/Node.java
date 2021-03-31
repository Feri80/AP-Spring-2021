public class Node 
{
    private int value;
    private Node next;
    
    public Node(int val)
    {
        value = val;
        next = null;
    }

    public void setValue(int val) 
    {
        value = val;
    }

    public int getValue() 
    {
        return value;    
    }

    public void setNext(Node nxt) 
    {
        next = nxt;
    }

    public Node getNext() 
    {
        return next;    
    }
}
