
import java.util.Arrays;

public class Stack {
    protected int[] data;
    private static final int DEFAULT_SIZE = 10;

    int ptr = -1;

    public Stack(int size) {
        this.data = new int[size];
    }

    public Stack() {
        this(DEFAULT_SIZE);
    }

    public boolean push(int item){
        if(isFull()){
            System.out.println("Stack is full");
            return false;
        }
        ptr++;
        data[ptr] = item;
        return true;
    }

    public boolean forcePush(int item){
        if(isFull()){
            this.data = copy(data);
        }
        ptr++;
        data[ptr] = item;
        return true;
    }

    private int[] copy(int[] data){
        int[] newData = Arrays.copyOf(data, data.length*2);
        return newData;
    }
    @Override
    public String toString() {
        String retStr = "";
        for(int i = 0;i <= ptr; i++){
            retStr += data[i] + " ";
        }
        return retStr;
    }

    public int pop() throws StackException{
        if(isEmpty()){
            throw new StackException("Empty stack");
        }

        return data[ptr--];
    }

    public int peek() throws StackException{
        if(isEmpty()){
            throw new StackException("Empty stack");
        }
        return data[ptr];
    }
    private boolean isFull(){
        return ptr == data.length - 1;
    }

    private boolean isEmpty(){
        return ptr == -1;
    }

    
}
