package Lab9;

public class Lab9 {
	
	//Calculate Bonuses Method
	public int[] calculateBonuses(char[] characters) {
		
		int i = 0;
		//Create new array of bonuses the same length as the character array in the arguments
		int[] bonuses = new int[characters.length];
		do {
			switch(characters[i]) {
				case 'A':
					bonuses[i] = 5000;
					break;
					
				case 'B':
					bonuses[i] = 2500;
					break;
					
				case 'C':
					bonuses[i] = 1000;
					break;
					
				case 'D':
					bonuses[i] = 500;
					break;
					
				case 'F':
					bonuses[i] = 0;
					break;
					
				default:
					break;
			}
			i++;
		} while(i < characters.length);
		
		return bonuses;
	
	}
	
}
