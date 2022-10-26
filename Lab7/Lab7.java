package Lab7;

import Lab6.PremiumCustomer;

public class Lab7 {

	public static void main(String[] args) {

		//Create new customer object
		PremiumCustomer gerald = new PremiumCustomer("Gerald", 100.00, "Alarm Clock", 25.00, 19234, 1);
		
		//Add items
		gerald.addToCart("Coffee", 14.99);
		gerald.addToCart("Shower matt", 6.95);
		
		//Try and catch block
		try {
			gerald.buy();
		} catch (OverBalanceException e) {
			System.out.println(e);
		}
		
		//Print 
		System.out.println(gerald.toString());
		
		
	}

}
