package challenge;

public class Train {
	public boolean isPalindrome(String word) {
		for(int i = 0; i < word.length()/2 ; i++) {
        	String s1 = word.substring(i, i+1);
        	String s2 = word.substring(word.length()-1-i, word.length()-i);
            if(!s1.equalsIgnoreCase(s2)) {
            	return false;
//                System.out.println("No"); System.exit(0);
            }
        }
		return true;
	}
	
	public static void main (String[] args) {
		System.out.print(new Train().isPalindrome("Deliviled"));
	}
}
