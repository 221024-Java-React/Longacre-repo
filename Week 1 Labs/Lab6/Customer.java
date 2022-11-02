
public abstract class Customer {

	//Variables
	public String name;
	public double balance;
	public String items;
	public double cartCost;
	
	//Constructor
	public Customer(String name, double balance, String items, double cartCost) {
		this.name = name;
		this.balance = balance;
		this.items = items;
		this.cartCost = cartCost;
	}
	
	//Public Concrete Method
	public void addToCart(String item, double cost) {
		this.items = this.items + " " + item;
		this.cartCost = this.cartCost + cost;
	}
	
	//Public Abstract Method
	public abstract void buy();
	
}
