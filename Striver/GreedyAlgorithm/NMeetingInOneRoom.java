package Striver.GreedyAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;

class NMeetingInOneRoom{
    static class Meet implements Comparable<Meet>{
        int start;
        int end;
        int position;

        
        public Meet(int start, int end, int position) {
            this.start = start;
            this.end = end;
            this.position = position;
        }
        

        @Override
        public String toString() {
            return "Meet [start=" + start + ", end=" + end + ", position=" + position + "]";
        }


        @Override
        public int compareTo(Meet o) {
            return this.end - o.end;
        }
    } 
    static int NMeetingInOneRoom(int[] s, int[] e){
        Meet[] meets = new Meet[s.length];
        for(int i = 0; i < s.length; i++){
            Meet meet = new Meet(s[i], e[i], i);
            meets[i] = meet;
        }
        Arrays.sort(meets);
        System.out.println(Arrays.toString(meets));

        int count = 1, freeTime = meets[0].end;
        ArrayList<Integer> meetingOrder = new ArrayList<>();
        meetingOrder.add(meets[0].position);
        for(int i = 1; i < s.length; i++){
            if(meets[i].start > freeTime){
                count += 1;
                freeTime = meets[i].end;
                meetingOrder.add(meets[i].position);
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] s ={0,3,1,5,5,8};
        int[] e ={5,4,2,9,7,9};

        System.out.println(NMeetingInOneRoom(s,e));
    }
}