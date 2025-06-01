
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

public class HashMap<K, V> {
    
    private class Entity{
        K key;
        V value;
        public Entity(K key, V value){
            this.key = key;
            this.value = value;
        }
    }

    ArrayList<LinkedList<Entity>> list;
    private int size = 0;
    private float loadFactor = 0.5f;

    public HashMap(){
        list = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            list.add(new LinkedList<>());
        }
    }

    public void put(K key, V value){
        int hash = Math.abs(key.hashCode() % list.size());

        LinkedList<Entity> entities = list.get(hash);
        
        for(Entity entity:entities){
            // If already exists then update it
            if(entity.key.equals(key)){
                entity.value = value;
                return;
            }
        }

        if((float)size / list.size() > loadFactor){
            reHash();
        }

        entities.add(new Entity(key, value));

        size++;
    }

    public void reHash(){
        System.out.println("Rehashing");

        ArrayList<LinkedList<Entity>> old = list;

        list = new ArrayList<>();

        size = 0;
        for(int i = 0; i < old.size(); i++){
            list.add(new LinkedList<Entity>());
        }

        for(LinkedList<Entity> entries : old){
            for(Entity entry : entries){
                // call put function for all the values
                put(entry.key, entry.value);
            }
        }
    }

    public V get(K key){
        int hash = Math.abs(key.hashCode() % list.size());
        LinkedList<Entity> entities = list.get(hash);
        for(Entity entity : entities){
            if(entity.key.equals(key)){
                return entity.value;
            }
        }
        return null;
    }

    public void remove(K key){
        int hash = Math.abs(key.hashCode() % list.size());
        LinkedList<Entity> entities = list.get(hash);
        Entity target = null;
        for(Entity entity : entities){
            if(entity.key.equals(key)){
                target = entity;
                break;
            }
        }

        //Its a linked list so can be removed easily
        entities.remove(target);
        size--;
    }

    public boolean containsKey(K key){
        return get(key) != null;
    }

    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("{ ");
        for(LinkedList<Entity> entities : list){
            for(Entity entity : entities){
                builder.append("[");
                builder.append(entity.key);
                builder.append(" = ");
                builder.append(entity.value);
                builder.append("] ");
            }
        }

        builder.append("}");

        return builder.toString();
    }


    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Mango", "King of fruits");
        map.put("Apple", "Red");
        map.put("Orange", "Orange");

        System.out.println(map);

        map.remove("Apple");

        System.out.println(map);
    }
}
