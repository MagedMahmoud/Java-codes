public class SLLNode 
{
     int data;
     SLLNode next;
    
    public SLLNode()
    {
        this.data = 0;
        this.next = null;
    }
    public SLLNode(int data) 
    {
        this.data = data;
    }
    
    public SLLNode(int data, SLLNode next) 
    {
        this.data = data;
        this.next = next;
    }
}
