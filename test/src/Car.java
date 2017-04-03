
public class Car implements Valuable {
	public Car(String name, double price){
		this.name = name;
		this.price = price;
	}
	private String name;
	private double price;
	
	public double EstimateValue(int month){
		price = price * 0.8; //구입 후 20% 감가
		for(int i = 0; i < month; i++){
			price = price * 0.99;
		}
		return price;
	}
	public String toString(){
		return String.format("car name: %s\n initial price: %s", name, price);
	}
}
