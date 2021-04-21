/**
 * This class contains Stack data structure and its methods
 * 
 * @author Farhad Aman
 * @version 1.0
 */
public class Stack
{
    /**
     * nodes of the stack
     */
    private int[] nodes;

    /**
     * current size of the stack
     */
    private int size;

    /**
     * the maximum size of the stack
     */
    private final int MAX_SIZE = 1000 * 1000;

    /**
     * creates a new empty stack
     */
    public Stack()
    {
        nodes = new int[1000 * 1000 + 10];
        size = 0;
    }

    /**
     * push a new int to the stack
     * @param k
     */
    public void push(int k)
    {
        nodes[size++] = k; 
    }

    /**
     * @return returns and deletes top node of the stack
     */
    public int pop()
    {
        return nodes[--size];
    }

    /**
     * @return returns top node of the stack
     */
    public int peek()
    {
        return nodes[size - 1];
    }

    /**
     * checks if stack is empty
     */
    public boolean isEmpty()
    {
        if(size == 0)
        {
            return true;
        }
        return false;
    }

    /**
     * checks if stack is full
     */
    public boolean isFull()
    {
        if(size == MAX_SIZE)
        {
            return true;
        }
        return false;
    }
}
