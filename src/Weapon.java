
public class Weapon extends Item {
	String type = "none";
	int quality = 0;
	int damage = 0;
	
Weapon(){}
	
	//constructor
	public Weapon(String WeaponType, int WeaponQuality, int WeaponDamage) {
		Weapon weapon = new Weapon();
		
		weapon.type = WeaponType;
		weapon.quality = WeaponQuality;
		weapon.damage = WeaponDamage;
	}
	
	//setter methods
	public void setWeaponType(String newWeaponType) {
		this.type = newWeaponType;
	}
	
	public void setWeaponQuality(int newWeaponQuality) {
		this.quality = newWeaponQuality;
	}
	
	public void setWeaponDamage(int newWeaponDamage) {
		this.damage = newWeaponDamage;
	}
	
	//getter methods
	public String getWeaponType() {
		return type;
	}
	
	public int getWeaponQuality() {
		return quality;
	}
	
	public int getWeaponDamage() {
		return damage;
	}
}