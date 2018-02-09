public class SinglyLinkedList {
    SLLNode head;   
    SLLNode tail; 
    int length;
    

    public SinglyLinkedList(int data) {
        head = new SLLNode(data);
        tail = head;
        length++; 
    }
   
    public boolean isEmpty() {
        return length == 0;
    }
    
     public void addToFront(int data) {
        if(isEmpty()) {
            head = new SLLNode(data);
            tail = head;
        } else {
            head = new SLLNode(data, head);
        }       
        length++;
     }
     
     public void addToEnd(int data) {
        if(isEmpty()) {
            tail = new SLLNode(data);
            head = tail;
        } else {
            tail.next = new SLLNode(data); 
            tail = tail.next;
        }       
        length++;
     }
     
 
     public void addAtPositon(int data, int position) {
    
        if(position < 0 || position > length - 1)
            throw new IllegalArgumentException("Usage: position >= 0 && position <= length - 1");
        
        if(position == 0)
            addToFront(data);
      
        else if(position == length - 1)
            addToEnd(data);
        else {
            int count = 0;
            
            
            SLLNode temp = head;
        
            while(count++ != position - 1) { 
                temp = temp.next;          
            }                              
            
 
            temp.next = new SLLNode(data, temp.next);
      
            length++;
        }
     }
     

      public void deleteEnd() {
          if(isEmpty()) return; 
          else if(length == 1) { 
              head = tail = null; 
              length--;
              return;
          }
          
          SLLNode temp = head; 
     
          while(temp.next != tail) 
            temp = temp.next;
        
    
        temp.next = null; 
        tail = temp;
        length--;
        

      }
      
      public void deleteFront() {
          if(length == 0) return;
          if(length == 1) {
              head = tail = null;
              length--;
              return;
          }
          
          SLLNode temp = head;
          head = head.next;
          temp = null;
          length--;
          
 
      }
      
      public void deleteAtPosition(int position) {
          if(position < 0 || position >= length)
             throw new IllegalArgumentException("Usage: position >= 0 && position <= length - 1");
          else if(position == 0)
            deleteFront(); 
          else if(position == length - 1)
            deleteEnd(); 
          else {
            int count = 0;
            SLLNode temp = head;
       
             
            while(count++ != position - 1) {
                temp = temp.next;
            }
            
            temp.next = temp.next.next;  
            length--;
          }                
      }
      
 	public void deleteRange(int lower_bound, int upper_bound) {
    int counter = 0;
    Node p, n;
	if (lower_bound < 1 || lower_bound > length) 
	{
      return;
    }
       if (upper_bound < 1 || upper_bound > length)
       { 
         return;
       }
 			 if (upper_bound < lower_bound)
 			  {
                Node tmp;
                tmp = prev.next;
                prev.next = tail.next;
                tail.next = tmp;
              }
			if (lower_bound == upper_bound)
			{
			return;
		    }
                while (head != null) 
                {
				if (counter == lower_bound)
				{
					low = prev;
				}
                    if (counter == upper_bound)
                    {
                    high = tail;
					head = head.next;
					counter++;
                   }
          if (prev != 0 && tail != 0) {
          prev.next = tail;
        }
    }

     
     @Override
     public String toString() {
         if(length == 0)
            return "List does not exist";
         
         SLLNode temp = head;
         String printList = "";
         
         while(temp != null) {
            printList += Integer.toString(temp.data) + " ";
            temp = temp.next;
         }
        
        return printList;
     }
    
}
