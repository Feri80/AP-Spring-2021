public class LinkedList
{
    private Node first;
    private int size;

    public LinkedList()
    {
        first = null;
        size = 0;
    }

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

    public void addFirst(int k)
    {
        Node newNode = new Node(k);
        if(size == 0)
        {
            first = newNode;
        }
        else
        {
            Node oldFirstNode = first;
            first = newNode;
            first.setNext(oldFirstNode);
        }
        size++;
    }

    public void findMiddle()
    {
        Node currentNode = first;
        if(size == 0)
        {
            System.out.println(-1);
            return;
        }
        int id;
        if(size % 2 == 0)
        {
            id = size / 2 - 1;
        }
        else
        {
            id = size / 2;
        }
        for(int i=0; i<id; i++)
        {
            currentNode = currentNode.getNext();
        }    
        System.out.println(currentNode.getValue());
    }

    public void print()
    {
        Node currentNode = first;
        for(int i=0; i<size; i++)
        {
            System.out.print(currentNode.getValue()+" ");
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }

    public void contains(int k)
    {
        Node currentNode = first;
        for(int i=0; i<size; i++)
        {
            if(currentNode.getValue() == k)
            {
                System.out.println(i);
                return;
            }
            currentNode = currentNode.getNext();
        }
        System.out.println(-1);
    }

    public void removeIndex(int i)
    {
        if(i > size - 1 || i < 0)
        {
            return;
        }
        if(i == 0)
        {
            first = first.getNext();
            size--;
            return;
        }
        Node currentNode = first;
        for(int j=0; j<i-1; j++)
        {
            currentNode = currentNode.getNext();
        }
        currentNode.setNext(currentNode.getNext().getNext());
        size--;
    }

    public void removeMiddle()
    {
        int id;
        if(size % 2 == 0)
        {
            id = size / 2 - 1;
        }
        else
        {
            id = size / 2;
        }
        removeIndex(id);
    }
}
