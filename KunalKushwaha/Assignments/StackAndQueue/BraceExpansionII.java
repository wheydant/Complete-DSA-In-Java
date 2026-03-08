package KunalKushwaha.Assignments.StackAndQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BraceExpansionII {
    public List<String> braceExpansionII(String expression) {
       Set<String> res = new HashSet<>();
       Deque<String> q = new ArrayDeque<>();
       q.offer(expression);

       while(!q.isEmpty()){
        String curr = q.poll();
        // { not found
        if (!curr.contains("{")){
            res.add(curr);
            continue;
        }

        //First occurance of {
        int left = curr.indexOf("{");
        int index = left;

        while(index < curr.length() && curr.charAt(index) != '}'){
            //found inner {
            if (curr.charAt(index) == '{')
                left = index;
            index++;
        }
        //index is at the first }
        int right = index;
        //{c, {d,e}}
        String processed = curr.substring(0, left);
        String[] processing = curr.substring(left + 1, right).split(","); //d,e
        String unprocessed = curr.substring(right + 1);

        //Add processing part to the each processed and unprocessed to each processing part for further processing
        for(String part : processing){
            //Crux of the code
            StringBuilder sb = new StringBuilder(processed);
            sb.append(part).append(unprocessed);
            q.offer(sb.toString());
        }
       }

       List<String> resList = new ArrayList<>(res);
       Collections.sort(resList);

       return resList;
    }

	public static void main(String[] args) {
		System.out.println(new BraceExpansionII().braceExpansionII("{a,b}{c,{d,e}}"));
	}
}
