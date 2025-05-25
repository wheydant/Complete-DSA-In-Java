public class CircularQueue {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    int end = 0;
    int front = 0;
    private int size = 0;

    public CircularQueue(int size) {
        this.data = new int[size];
    }

    public CircularQueue() {
        this(DEFAULT_SIZE);
    }

    private boolean isFull(){
        return size == data.length ;
    }

    private boolean isEmpty(){
        return end == 0;
    }

    public boolean insert(int item){
        if(isFull()){
            return false;
        }
        data[end++] = item;
        end = end % data.length;
        size++;
        return true;
    }

    public boolean forceInsert(int item){
        if(isFull()){
            int[] temp = new int[data.length * 2];

            for(int i = 0; i < data.length; i++){
                temp[i] = data[(front + i) % data.length];
            }

            front = 0;
            end = data.length;
            data = temp;
        }
        return insert(item);
    }

    public int remove() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is Empty");
        }
        int removed = data[front++];
        front = front % data.length;
        size--;

        return removed;
    }

    public int front() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is Empty");
        }
        return data[front];
    }

    @Override
    public String toString() {
        if(isEmpty()){
            return "List is empty";

        }
        String retStr = "";
        int i = front;
        do{
            retStr += data[i++] + " ";
            i%=data.length;
        }while(i != end);
        return retStr;
    }
}
