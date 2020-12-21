package CSC400;

import java.text.DecimalFormat;
import java.util.Random;

public class BoutiqueBagDemo {

	public static void main(String[] args) {
		BagInterface<ClothingItem> adtBag = new ClothingBag<>();
		ClothingItem[] Clothes = new ClothingItem[6];
		String[] colors = {"Blue","Red","Yellow","Green","Purple","Orange"};
		String[] items = {"Socks","Skirt","Jeans","Shirt","Hat","Gloves"};
		Random r = new Random();
		
		DecimalFormat df = new DecimalFormat("#.00");
		int bagCount = 6;
		
		for (int i=0; i != bagCount; i++) {
			String price = df.format(r.nextDouble()+r.nextInt(200-0)+0); // Adds a little fun, some prices may be ridiculous but what of it?
			String item = colors[r.nextInt(6)] + ' ' + items[r.nextInt(6)]; // Randomly generates your clothing item.
			Clothes[i] = new ClothingItem(item, price);
		}
		testAdd(adtBag, Clothes);
	}
	
	private static void testAdd(BagInterface<ClothingItem> adtBag, ClothingItem[] content){
		System.out.println("Adding " + content.length + " items to bag");;
		for (int index = 0; index < content.length; index++){
			if (adtBag.add(content[index]))
			System.out.println(content[index] + " ");
		else
			System.out.print("\nError. Issues with " + content[index]);
			System.out.println();
		displayBag(adtBag);
		}
	}
	
	private static void displayBag(BagInterface<ClothingItem> adtBag){
	System.out.println("Items in Bag:");
	Object[] bagArray = adtBag.toArray();
	for (int index = 0; index < bagArray.length; index++){
		System.out.println(bagArray[index] + " ");
		} 
	System.out.println();
	}

}
