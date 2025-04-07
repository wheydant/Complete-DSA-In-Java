public class CustomGenericArrayList<T> {
    private Object[] data;
    private static int DEFAULT_SIZE = 110;
    private int size = 0;


    CustomGenericArrayList(){
        //Instance of generic is not possible
        //this.data = new T[DEFAULT_SIZE];
        data = new Object[DEFAULT_SIZE];
        
    }
    
    public void add(int num){
        if(isFull()){
            resize();
        }
        data[size++] = num;
    }

    private boolean isFull(){
        return size == data.length;
    }

    private void resize(){
        Object[] temp = new Object[data.length * 2];

        for(int i = 0; i < data.length; i++){
            temp[i] = data[i];
        }

        data = temp;
    }

    public T remove(){
        T removed = (T)data[size--];
        return removed;
    }

    public T get(int index){
        return (T)data[index];
    }

    public int size(){
        return size;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }

    public void set(int index, int value){
        data[index] = value;
    }


    public static void main(String[] args) {
        CustomGenericArrayList<Integer> arr = new CustomGenericArrayList<>();

        arr.add(1);
        arr.add(2);
        arr.add(3);
        // arr.add("Hero");

        for(int i = 0; i < arr.size(); i++){
            System.out.println(arr.get(i));
        }
    }
}
