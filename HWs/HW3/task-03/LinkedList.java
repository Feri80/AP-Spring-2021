/**
 * This class contains linked list data structure and its methods
 * 
 * @author Farhad Aman  
 * @version 1.0
 */
public class LinkedList
{
    /**
     * first node of the linked list
     */
    private Node first;

    /**
     * current size of the linked list
     */
    private int size;

    /**
     * creates a new empty linked list
     */
    public LinkedList()
    {
        first = null;
        size = 0;
    }

    /**
     * add a new int to the end of linked list
     * @param k
     */
    public void add(int k)
    {
        Node newNode = new Node(k);
        if(size == 0)
        {
            first = newNode;
        }
        else
        {
            Node currentNode = first;
            while(currentNode.getNext() != null)
            {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newNode);
        }
        size++;
    }

    /**
     * returns the int with given index
     */
    public int get(int index)
    {
        Node current = first;
        for(int i = 0; i < index; i++)
        {
            current = current.getNext();
        }
        return current.getValue();
    }

    /**
     * prints all data in linked list
     */
    public void print()
    {
        Node current = first;
        for(int i = 0; i < size; i++)
        {
            System.out.print(current.getValue() + " ");
            current = current.getNext();
        }
        System.out.println();
    }
}
