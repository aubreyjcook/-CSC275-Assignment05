import java.util.Comparator;

public class Item {
	String name = "none";
	float weight = 0;
	String value = "none";
	String durability = "none";
	String ID = "none";
			
	Item(){}
	
	//constructor
	public Item(String itemName, float itemWeight, String itemValue, String itemDurability, String itemID) {
		Item item = new Item();
		
		item.name = itemName;
		item.weight = itemWeight;
		item.value = itemValue;
		item.durability = itemDurability;
		item.ID = itemID;
	}
	
	//setter methods
	public void setItemName(String newItemName) {
		this.name = newItemName;
	}
	
	public void setItemWeight(float newItemWeight) {
		this.weight = newItemWeight;
	}
	
	public void setItemValue(String newItemValue) {
		this.value = newItemValue;
	}
	
	public void setItemDurability(String newItemDurability) {
		this.durability = newItemDurability;
	}
	
	public void setItemID(String newItemID) {
		this.ID = newItemID;
	}
	
	//getter methods
	public String getItemName() {
		return name;
	}
	
	public float getItemWeight() {
		return weight;
	}
	
	public String getItemValue() {
		return value;
	}
	
	public String getItemDurability() {
		return durability;
	}
	
	public String getItemID() {
		return ID;
	}

	public static Comparator<Item> ItemNameComparator = new Comparator<Item>() {

		public int compare(Item i1, Item i2) {
		   String itemName1 = i1.getItemName().toUpperCase();
		   String itemName2 = i2.getItemName().toUpperCase();

		   //ascending order
		   //return itemName1.compareTo(itemName2);

		   //descending order
		   return itemName2.compareTo(itemName1);
	    }
	};
}