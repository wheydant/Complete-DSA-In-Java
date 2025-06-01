
public class Queue {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    int end = 0;

    public Queue(int size) {
        this.data = new int[size];
    }

    public Queue() {
        this(DEFAULT_SIZE);
    }

    private boolean isFull(){
        return end == data.length ;
    }

    private boolean isEmpty(){
        return end == 0;
    }

    public boolean insert(int item){
        if(isFull()){
            return false;
        }
        data[end++] = item;
        return true;
    }

    public int remove() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is Empty");
        }
        int removed = data[0];
        for(int i = 1; i < end; i++){
            data[i - 1] = data[i];
        }
        end--;

        return removed;
    }

    public int front() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is Empty");
        }
        return data[0];
    }

    @Override
    public String toString() {
        String retStr = "";
        for(int i = 0;i < end; i++){
            retStr += data[i] + " ";
        }
        return retStr;
    }

    
}
