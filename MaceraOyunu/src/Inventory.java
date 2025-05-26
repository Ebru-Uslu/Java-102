public class Inventory {
    boolean water;
    boolean food;
    boolean firewood;
    private String armorName;
    private int armorDefence;
    public Weapon weapon;
    private Armor armor;

    public Inventory(){//Başlangıçta sahip olduğu özellikleri yazdırır
        this.weapon=new Weapon("Yumruk",-1,0,0);
        this.armor=new Armor("Paçavra",-1,0,0);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }
}
