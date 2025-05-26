public class Armor {
    private String name;
    private int id;
    private int block;
    private int price;


    public Armor(String name, int id, int block, int price){
        this.setName(name);
        this.setId(id);
        this.setBlock(block);
        this.setPrice(price);
    }

    public static Armor[] armors(){ //Zırh seçeneklerini oluşturur
        Armor[] armorList= new Armor[3];
        armorList[0] = new Armor("Hafif",1,1,15);
        armorList[1] = new Armor("Orta",2,3,25);
        armorList[2] = new Armor("Ağır",3,5,40);
        return armorList;
    }

    public static Armor getArmorObjById(int id){
        //Kullanıcıdan alınan id ile zırh id'si uyuşuyorsa zırhı döndürür
        for(Armor w:Armor.armors()){
            if(w.getId()==id){
                return w;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBlock() {
        return block;
    }

    public void setBlock(int block) {
        this.block = block;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
