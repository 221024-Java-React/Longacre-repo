
public class Lab3 {
	
	public String replaceAllSpaces(String word) {
		String newWord = word.replace(' ', '-');
		return newWord;
	}
	
	public boolean containsWord(String input, String search) {
		String newInput = input.toLowerCase();
		String newSearch = search.toLowerCase();
		if(newInput.contains(newSearch)) {
			return true;
		} else {
			return false;
		}
	}
	
	public String[] splitPhoneNumber(String number) {
		String[] newNumber = number.split("-");
		return newNumber;
	}

	public static void main(String[] args) {
		Lab3 l3 = new Lab3();
		System.out.println(l3.replaceAllSpaces("Once Upon a Time"));
		System.out.println(l3.containsWord("Whats up Doc", "what"));
		String[] phoneNumber = l3.splitPhoneNumber("111-222-3333");
		System.out.println(phoneNumber[0] + "," + phoneNumber[1] + "," + phoneNumber[2]);
	}

}
