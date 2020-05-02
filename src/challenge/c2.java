package challenge;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

/**
 * 
 * Integers K, M and a non-empty array ranks consisting of N integers, not bigger than M, are given.

The leader of the array is a value that occurs in more than half of the elements of the array, and the segment of the array is a sequence of consecutive elements of the array.

You can modify ranks by choosing exactly one segment of length K and increasing by 1 every element within that segment.

The goal is to find all of the numbers that may become a leader after performing exactly one array modification as described above.

Write a function:

class Solution { public int[] solution(int K, int M, int[] ranks); }

that, given integers K and M and an array ranks consisting of N integers, returns an array of all numbers that can become a leader, after increasing by 1 every element of exactly one segment of ranks of length K. The returned array should be sorted in ascending order, and if there is no number that can become a leader, you should return an empty array. Moreover, if there are multiple ways of choosing a segment to turn some number into a leader, then this particular number should appear in an output array only once.

For example, given integers K = 3, M = 5 and the following array ranks:

  ranks[0] = 2
  ranks[1] = 1
  ranks[2] = 3
  ranks[3] = 1
  ranks[4] = 2
  ranks[5] = 2
  ranks[6] = 3
the function should return [2, 3]. If we choose segment ranks[1], ranks[2], ranks[3] then we get the following array ranks:

  ranks[0] = 2
  ranks[1] = 2
  ranks[2] = 4
  ranks[3] = 2
  ranks[4] = 2
  ranks[5] = 2
  ranks[6] = 3
and 2 is the leader of this array. If we choose ranks[3], ranks[4], ranks[5] then ranks will appear as follows:

  ranks[0] = 2
  ranks[1] = 1
  ranks[2] = 3
  ranks[3] = 2
  ranks[4] = 3
  ranks[5] = 3
  ranks[6] = 3
and 3 will be the leader.

And, for example, given integers K = 4, M = 2 and the following array:

  ranks[0] = 1
  ranks[1] = 2
  ranks[2] = 2
  ranks[3] = 1
  ranks[4] = 2
the function should return [2, 3], because choosing a segment ranks[0], ranks[1], ranks[2], ranks[3] and ranks[1], ranks[2], ranks[3], ranks[4] turns 2 and 3 into the leaders, respectively.

Write an efficient algorithm for the following assumptions:

N and M are integers within the range [1..100,000];
K is an integer within the range [1..N];
each element of array ranks is an integer within the range [1..M].
 *
 */

public class c2 {

	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//        double payment = scanner.nextDouble();
//        scanner.close();

		// TODO Auto-generated method stub
		int[] a = {4,0};
		System.out.print(new Solution2().solution( a));
	}

}

class Solution2 {
	/**
	 * 
	 *  public int solution(int[] A) {
        // write your code in Java SE 8
        if(A.length<2) return 0;
        int sum=0;
        for(int i = 0; i<A.length-1; i++) {
            if(i == 0 && A[i]==A[1+i])
            {
                sum++;
                if(i!=A.length-2)
                if(A[i+1]<=A[2+i]) 
                    A[i+1]--;
                else 
                    A[i]--;
            }
            else if(A[i]>A[1+i])
            {
                // if(i!=A.length-2)
                if(i!=0)
                if(A[i-1]>A[i]) {
                    sum++;
                    A[i] = A[1+i] -1;
                }
            }
            else if(A[i]<A[1+i])
            {
                // if(i!=A.length-2)
                if(i!=0)
                if(A[i-1]<A[i]) {
                    sum++;
                    A[i+1] = A[i] -1;
                }
            }
        }
        return sum;
    }
}

class Solution {
    public String solution(int A, int B, int C) {
        // write your code in Java SE 8
        String s = "";
        int longest = 0;
        String z = "c";
        String y = "b";
        String x = "";
        if(A>=B && A>=C) {
            longest=A;
            x = "a";
            
            if(B<C) {
                int t = B;
                B = C;
                C = t;
                y = "c";
                z = "b";
            }
        }
        else if(B>=A && B>=C) {
            longest=B;
            x = "b";
            
            
            if(A<C) {
                B = C;
                C = A;
                y = "c";
                z = "a";
            }
            else {
                B=A;
                y = "a";
                z = "c";
            }
        }
        else if(C>=A && C>=B) {
            longest=C;
            x = "c";
            
            if(B<A) {
                C = B;
                B = A;
                y = "a";
                z = "b";
            }
            else {
               C = A;
                y = "b";
                z = "a";
            }
        }
        
        for(int i=0; i<B; i++) {
            if(longest>1) {
                s +=x;
                s +=x;
                longest -=2;
            }
                
            else if(longest==1){
                s +=x;
                longest -=1;
            }
            s += y;
        }
        for(int i=0; i<C; i++) {
            if(longest>1) {
                s +=x;
                s +=x;
                longest -=2;
            }
                
            else if(longest==1){
                s +=x;
                longest -=1;
            }
            s += z;
        }
        
            if(longest>1) {
                s +=x;
                s +=x;
                longest -=2;
            }
                
            else if(longest==1){
                s +=x;
                longest -=1;
            }
        return s;
    }
    
   }
	 */
	public int solution(int[] ranks) {
	        // write your code in Java SE 8
		Map<Integer, Integer> map=new HashMap();
		Set<Integer> set = new HashSet();

        for(int i=0; i<ranks.length; i++){
            addToMap(map, ranks[i]);
        }
        
        int sum = 0;
        for(int i: map.keySet())
        	if(map.containsKey(i+1))
        		sum += map.get(i);
        return sum;
//        return set.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
	
	private int addToMap(Map<Integer, Integer> map, int i ) {
		Optional<Integer> o= Optional.ofNullable(map.get(i));
		int count = 1;
        if(o.isPresent()) {
        	count = o.get()+1;
        }
        map.put(i, count);
        return count;
	}
	
	private void removeFromMap(Map<Integer, Integer> map, int i ) {
        	map.put(i, map.get(i)-1);
	}
}