package challenge;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;



public class DiverseString {

	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//        double payment = scanner.nextDouble();
//        scanner.close();

		// TODO Auto-generated method stub
		int[] a = {4,0};
//		System.out.print(new Solution().solution(2,3,16));
		System.out.print(fac(6));
	}

	static int fac(int n) {
		int fac=1;
		for(int i = n; i>1; i--)
			fac *=i;
		return fac;
//		return fac(n-1, n);
	}
	static int fac(int n, int fact) {
		if(n==0) return fact;
		return fac(n-1, fact*n);
	}

}

class Solution {
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

	 */
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