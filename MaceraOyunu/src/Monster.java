public class Monster {
    private String name;
    private int id;
    private int damage;
    private int health;
    private int award;//Hayvanı öldürünce gelen ödül
    private int originalHealth;

    public Monster(String name,int id,int damage,int health,int award ){
        this.setName(name);
        this.id=id;
        this.damage=damage;
        this.health=health;
        this.setOriginalHealth(health);
        this.setAward(award);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        if(health<0){
            health=0;
        }
        this.health=health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAward() {
        return award;
    }

    public void setAward(int award) {
        this.award = award;
    }

    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }
}
