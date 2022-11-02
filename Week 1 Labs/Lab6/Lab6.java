
public class Lab6 {

	public static void main (String[] args) {
		
		//Create customer object
		PremiumCustomer rick = new PremiumCustomer("Rick Ross", 500.00, "Flat Screen TV", 350.00, 1826354, 3);
		
		//Print customer info
		System.out.println(rick.toString());
		
		//Add to cart
		rick.addToCart("Xbox Controller", 120.00);
		rick.addToCart("Batteries", 12.95);
		
		//Print new cart items
		System.out.println(rick.toString());
		
		//Buy cart
		rick.buy();
		
		//Check cart
		System.out.println(rick.toString());
		
	}
	
}
