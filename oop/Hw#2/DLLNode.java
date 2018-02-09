public class DLLNode extends SLLNode
{
    
  SLLNode prev;
  SLLNode next;

    
    public DLLNode(int data, SLLNode prev, SLLNode next)
    {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
    
    public DLLNode(int data)
    {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
    
}
