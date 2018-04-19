
public class Equipable extends Item {
	String type = "none";
	int quality = 0;
	int defense = 0;
	
Equipable(){}
	
	//constructor
	public Equipable(String EquipableType, int EquipableQuality, int EquipableDefense) {
		Equipable equipable = new Equipable();
		
		equipable.type = EquipableType;
		equipable.quality = EquipableQuality;
		equipable.defense = EquipableDefense;
	}
	
	//setter methods
	public void setEquipableType(String newEquipableType) {
		this.type = newEquipableType;
	}
	
	public void setEquipableQuality(int newEquipableQuality) {
		this.quality = newEquipableQuality;
	}
	
	public void setEquipableStatus(int newEquipableDefense) {
		this.defense = newEquipableDefense;
	}
	
	//getter methods
	public String getEquipableType() {
		return type;
	}
	
	public int getEquipableQuality() {
		return quality;
	}
	
	public int getEquipableDefense() {
		return defense;
	}
}
