package Lab11;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Lab11 {

	public static void main(String[] args) {

		//Create test object
		Lab11 test = new Lab11();
		
		//Add people to the Person List
		Person p1 = new Person("Andrew", "Stevens", 57);
		Person p2 = new Person("Adam", "Smith", 39);
		Person p3 = new Person("Eric", "Williams", 44);
		Person p4 = new Person("William", "Black", 72);
		Person p5 = new Person("Eric", "Clapton", 87);
		
		List<Person> personList = new ArrayList<Person>();
		
		personList.add(p1);
		personList.add(p2);
		personList.add(p3);
		personList.add(p4);
		personList.add(p5);
	
		test.iteratorFun(personList);
		
	}
	
	public List<String> nameList(List<Person> pList) {
		//Create new list of first names
		List<String> firstNames = new ArrayList<String>();
		
		for(Person p : pList) {
			firstNames.add(p.getFirst());
		}
		
		return firstNames;
	}
	
	
	public void iteratorFun(List<Person> pList) {
		ListIterator<Person> iter = pList.listIterator();
		
		int oldest = 0;
		String nameOfOldest = null;
		
		while(iter.hasNext()) {
			Person check = iter.next();
			
			if(check.getAge() > oldest) {
				oldest = check.getAge();
				nameOfOldest = check.getFirst();
			}
		}
		System.out.println(nameOfOldest + " is the oldest person");
		
	}
	

}
