public class DLL extends SinglyLinkedList
{
	int data;
	 DLLNode head;
     DLLNode tail;
 

    public DLL(int data)
    {
        this.head = new DLLNode(data);
    }
    
    public int length()
    {
        return this.length;
    }

    public int getFront()
    {
        return head.data;
    }
    
    public int getBack()
    {
        return tail.data;
    }
    
    @Override
    public void addToFront(int data)
    {
        DLLNode node = new DLLNode(data, head, null);
        length++;
    }
    
    @Override
    public void addToEnd(int data)
    {
        DLLNode node = new DLLNode(data, null, tail);
        length++;
    }
    
    public void addAtPosition(int data, int position)
    {
        if (position < 0 || position > length - 1){
            throw new IllegalArgumentException("Usage: position >= 0 && position <= length - 1");
        }
        
        if (position == 0){
            addToFront(data);
        }
        else if (position == length - 1){
            addToEnd(data);
        }
        else
        {
            int count = 0;
            DLLNode temp = this.head;
            while (count++ != position - 1)
            {
                temp = temp.next;
            }
            
            temp.next = new DLLNode(data, temp.prev, temp.next);
        }
        length++; 
    }   

    public void deleteFront(DLLNode head_ref, DLLNode del)
    {
        if (head == null || del == null) {
            return;
        }
        if (head == del) {
            head = del.next;
        }
        if (del.next != null) {
            del.next.prev = del.prev;
        }
        if (del.prev != null) {
            del.prev.next = del.next;
        }
        return;
    }
     
    public void deleteEnd()
    {
        DLLNode temp = tail;
        if (head.next == null)
            head = null;
        else
            tail.prev.next = null;
        tail = tail.prev;
    }

	public void deleteAtPositon(int position) {
    
    deleteAtPositon result = null;
    assert(position>=1&&position<=count);

    if(position==1){
        if(count==1){
            result = head.getData();
            head = null;
            tail = null;
        }
        else{
            result = head.getData();
            head = head.getNext();
            head.setPrev(null);
        }
    }
    else if(position==count){
        result = tail.getData();
        tail = tail.getPrev();
        tail.setNext(null);
    }
    else{
        Node<deleteAtPositon> current = head;
        int i=1;
        while(current!=null){
            if(i==position){
                Node<deleteAtPositon> prev = current.getPrev();
                Node<deleteAtPositon> next = current.getNext();
                prev.setNext(next);
                next.setPrev(prev);
                break;
               
            }
            current = current.getNext();
            i++;
        }
    }   
    count--;
    return result;   
	}


    public String toString(Dllnode ddlnode)
    {
        while (Dllnode != null) {
            System.out.print(Dllnode.data + " ");
            Dllnode = Dllnode.next;        
    		}
    }

}
