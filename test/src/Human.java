
public class Human implements Valuable{
	public Human(String name, int age){
		this.name = name;
		this.age = age;
	}
	private String name;
	private int age;
	
	public double estimateValue(int month){ //사물의 가치를 return
		return Double.POSITIVE_INFINITY;
	}
	public double estimateValue(){ //사물의 가치를 return
		return Double.POSITIVE_INFINITY;
	}
	public String toString(){
		return String.format("Human name: %s\n registered age: %d", name, age);
	}
}
