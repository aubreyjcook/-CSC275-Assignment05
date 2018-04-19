public class Consumable extends Item {
	String type = "none";
	int quality = 0;
	String status = "none";
	
Consumable(){}
	
	//constructor
	public Consumable(String ConsumableType, int ConsumableQuality, String ConsumableStatus) {
		Consumable consumable = new Consumable();
		
		consumable.type = ConsumableType;
		consumable.quality = ConsumableQuality;
		consumable.status = ConsumableStatus;
	}
	
	//setter methods
	public void setConsumableType(String newConsumableType) {
		this.type = newConsumableType;
	}
	
	public void setConsumableQuality(int newConsumableQuality) {
		this.quality = newConsumableQuality;
	}
	
	public void setConsumableStatus(String newConsumableStatus) {
		this.status = newConsumableStatus;
	}
	
	//getter methods
	public String getConsumableType() {
		return type;
	}
	
	public int getConsumableQuality() {
		return quality;
	}
	
	public String getConsumableStatus() {
		return status;
	}

}
