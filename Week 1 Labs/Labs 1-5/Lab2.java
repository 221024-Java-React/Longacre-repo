
public class Lab2 {

	int add(int x, int y) {
		return x + y;
	}
	
	int sub(int x, int y) {
		return x - y;
	}
	
	double multiply(double x, double y) {
		return x * y;
	}
	
	double divide(double x, double y) {
		return x / y;
	}

	
	public static void main(String[] args) {
		Lab2 l2 = new Lab2();
		System.out.println(l2.add(5,3));
		System.out.println(l2.sub(9, 7));
		System.out.println(l2.multiply(2, 4));
		System.out.println(l2.divide(20, 4));
	}	
}
