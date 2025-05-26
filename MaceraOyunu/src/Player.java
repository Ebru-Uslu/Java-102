import java.util.Scanner;

public class Player {
    private Inventory inventory;
    private int damage;
    private int health;
    private int money;
    private String name;
    private  String characterName;
    private int originalHealth;
    Scanner input=new Scanner(System.in);

    public Player(String name) {
        this.name=name;
        this.inventory=new Inventory();
    }
    public void selectCharacter(){//Polimorfizm ile tüm karakterleri tekte döner
        System.out.println("Karakterler: ");
        GameCharacter[] charList= {new Samurai(), new Archer(),new Knight()};//That's the polimorfizm baby
        for(GameCharacter gameChar:charList){
            System.out.println("Id: "+gameChar.getId()+
                    "\t Karakter: "+gameChar.getName()+
                    "\t Hasar: "+gameChar.getDamage()+" " +
                    "\t Sağlık: "+gameChar.getHealth()+
                    "\t Para: "+gameChar.getMoney());
        }
        System.out.println();
        System.out.print("Lütfen bir karakter seçiniz: ");
        int selectChar= input.nextInt();
        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }
        System.out.println("Karakter: "+this.getCharacterName());
        System.out.println("----------------------");
    }
    public void initPlayer(GameCharacter gameCharacter){
        this.setDamage(gameCharacter.getDamage());
        this.setHealth(gameCharacter.getHealth());
        this.setOriginalHealth(gameCharacter.getHealth());
        this.setMoney(gameCharacter.getMoney());
        this.setCharacterName(gameCharacter.getName());
    }

    public void printInfo(){
        System.out.println("Silahınız: "+ this.getInventory().getWeapon().getName()+
                "\t Zırhınız: "+this.inventory.getArmor().getName()+
                "\t Bloklama oranı: "+this.inventory.getArmor().getBlock()+
                "\t Hasarınız: "+ this.getDamage()+
                "\t Sağlık: "+this.getHealth()+
                "\t Para: "+this.getMoney());
        System.out.println("-----------------------");
    }
    public int getTotalDamage(){
        return damage+this.inventory.getWeapon().getDamage();
        //Verilen hasar kendi hasarı+silahın hasarı kadar

    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Weapon getWeapon(){
        return this.getInventory().getWeapon();
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }
}
