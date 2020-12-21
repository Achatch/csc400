package CSC400;

public class ClothingItem {
	private String price;
	private String name;
	
	public ClothingItem (String item, String price){
		this.name = item;
		this.price = price;
	}
	public String getName(){
		return this.name;
	}
	public String getPrice(){
		return this.price;
		}
	@Override
	public String toString(){
		return this.name + " " + this.price;
	}
}
