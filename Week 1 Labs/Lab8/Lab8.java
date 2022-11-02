package Lab8;

public class Lab8 {

	//Method
	public String reverse(String word) {
		//StringBuilder Object
		StringBuilder reverseWord = new StringBuilder();
		//Store characters in object in reverse order
		for(int i = word.length() - 1; i > -1; i--) {
			reverseWord.append(word.charAt(i));
		}
		//Print reversed word
		return reverseWord.toString();
	}
	
}
