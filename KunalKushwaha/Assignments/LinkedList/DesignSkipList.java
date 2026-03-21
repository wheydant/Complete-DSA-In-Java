package KunalKushwaha.Assignments.LinkedList;

import java.util.Random;

public class DesignSkipList {
    private static class Entry {
        private Entry next;
        private Entry prev;
        private Entry up;
        private Entry down;
        private final int value;
        Entry(int value){
            this.value = value;
        }

        void addToChain(Entry e){
            //e1-><-e-><-e2
            this.next = e.next;
            this.prev = e;
            e.next.prev = this;
            e.next = this;
        }
    }

    private Entry head;
    private Entry tail;
    private int height = -1;
    private final Random random = new Random();
    public DesignSkipList() {
        buildLevel();
    }

    private void buildLevel(){
        Entry h = new Entry(Integer.MIN_VALUE);
        Entry t = new Entry(Integer.MAX_VALUE);
        h.next = t;
        t.prev = h;

        if(head == tail){
            //THis happens when both are null
            head = h;
            tail = t;
        }else{
            h.down = head;
            head.up = h;
            t.down = tail;
            tail.up = t;
            head = h;
            tail = t;
        }
        height++;
    }

    private Entry lookupNearest(int target){
        //Start from head and traverse till the bottom to check for nearest value till down
        Entry temp = head;
        while(true){
            while(temp.next.value <= target){
                temp = temp.next;
            }if(temp.down == null){
                break;
            }
            temp = temp.down;
        }

        return temp;
    }
    
    public boolean search(int target) {
        return lookupNearest(target).value == target;
    }
    
    public void add(int num) {
        Entry closetEntry = lookupNearest(num);
        Entry newEntry = new Entry(num);
        //Call newEntry wrt to new Entry and reference to current nearest entry
        newEntry.addToChain(closetEntry);

        // New Levels on the basis of coinflips
        int i = 0;
        while(random.nextBoolean()){
            if(i == height){
                buildLevel();
            }

            //Find entry having level + 1
            while(closetEntry.up == null){
                closetEntry = closetEntry.prev;
            }
            closetEntry = closetEntry.up;
            
            //Create a copy for level + 1
            Entry nextLevelEntry = new Entry(num);
            nextLevelEntry.addToChain(closetEntry);

            nextLevelEntry.down = newEntry;
            newEntry.up = nextLevelEntry;
            newEntry = nextLevelEntry;
            i++;
        }
    }
    
    public boolean erase(int num) {
        //Find the lowest value
        Entry entry = lookupNearest(num);
        if (entry.value != num){
            return false;
        }

        while(true){
            //Delete every row and Traverse upwards to eliminate value from all the level
            entry.prev.next = entry.next;
            entry.next.prev = entry.prev;
            entry = entry.up;
            if (entry == null){
                break;
            }
        }

        return true;
    }
}
