import java.util.Random;

public abstract class BattleLocation extends Location{

    private Monster monster;
    private String award;
    private int maxMonster;
    BattleLocation(Player player, String name,Monster monster,String award,int maxMonster) {
        super(player, name);
        this.monster=monster;
        this.award=award;
        this.maxMonster=maxMonster;
    }

    @Override
    public boolean onLocation() {
        int monsterNum=randomMonsterNumber();
        System.out.println(this.getName()+ "'a hoşgeldiniz.");
        System.out.println("Dikkatli ol! Burada "+monsterNum+" "+this.getMonster().getName()+" yaşıyor.");
        System.out.println("1.Savaş \n"+
                        "2.Kaç");
        System.out.print("Seçiminiz: ");
        int choice=input.nextInt();
        if(choice==1&& combat(monsterNum)){
                System.out.println(this.getName()+" tüm düşmanları yendiniz");
                return true;
        }
        if(this.getPlayer().getHealth()<=0){
            System.out.println("Vehim bir şekilde can verdiniz." );
            return false;
        }
        return true;
    }
    int start() {//Dövüşe kimin başlayacağını %50 olasılıkla belirler
        Random random = new Random();
        int chance = random.nextInt(2);
        if (chance == 0) {
            //Karakterimiz ilk hamleyi yapar
            System.out.println("Dövüşe " + this.getPlayer().getName()+" başlayacak \n");
            return 1;
        } else {
            //Canavar ilk hamleyi yapar
            System.out.println("Dövüşe "+this.getMonster().getName()+ " başlayacak \n");
            return 2;
        }
    }
    public boolean combat(int monsterNum){
        for(int i=1;i <= monsterNum;i++){
            this.getMonster().setHealth(this.getMonster().getOriginalHealth());
            playerStats();
            System.out.println("----------------------");
            monsterStats(i);
            while (this.getPlayer().getHealth()>0 && this.getMonster().getHealth()>0){
                System.out.print("1.Savaş \n"+
                                   "2.Kaç");
                System.out.println();
                System.out.print("Seçiminiz: ");
                int selectCombat=input.nextInt();
                System.out.println("----------------------");

                int first=start();

                if(selectCombat==1){
                    if(first==1){
                        System.out.println("Siz vurdunuz ");
                        this.getMonster().setHealth(this.getMonster().getHealth()-this.getPlayer().getTotalDamage());
                        afterHit();
                        if(this.getMonster().getHealth()>0){
                            System.out.println(this.getMonster().getName()+ " size vurdu!!!!!!!");
                            int monsterDamage=this.getMonster().getDamage()-this.getPlayer().getInventory().getArmor().getBlock();
                            if (monsterDamage < 0) {
                                monsterDamage=0;
                            }
                            if(this.getPlayer().getHealth()-monsterDamage<0){
                                this.getPlayer().setHealth(0);
                            }
                            else{
                                this.getPlayer().setHealth(this.getPlayer().getHealth()-monsterDamage);
                            }
                            afterHit();
                        }
                    }
                    else if(first==2){
                        System.out.println(this.getMonster().getName()+ " size vurdu!!!!!!!");
                        int monsterDamage=this.getMonster().getDamage()-this.getPlayer().getInventory().getArmor().getBlock();
                        afterHit();
                        if(this.getPlayer().getHealth()>0){
                            System.out.println("Siz vurdunuz ");
                            this.getMonster().setHealth(this.getMonster().getHealth()-this.getPlayer().getTotalDamage());

                            if(this.getPlayer().getHealth()-monsterDamage<0){
                                this.getPlayer().setHealth(0);
                            }
                            else{
                                this.getPlayer().setHealth(this.getPlayer().getHealth()-monsterDamage);
                            }
                            if (monsterDamage < 0) {
                                monsterDamage=0;
                            }
                            afterHit();
                        }

                    }

                }
                else{
                    return false;
                }
            }
            if(this.getMonster().getHealth()<this.getPlayer().getHealth()){
                System.out.println("Düşmanı yendinizzz");
                System.out.println(this.getMonster().getAward()+" altın kazandınız");
                this.getPlayer().setMoney(this.getPlayer().getMoney()+this.getMonster().getAward());
                System.out.println("Güncel paranız: "+this.getPlayer().getMoney());
            }
            else {
                return false;
            }
        }
        return true;
    }
    public void afterHit(){
        System.out.println("Canınız: "+this.getPlayer().getHealth());
        System.out.println(this.getMonster().getName()+" canı: "+this.getMonster().getHealth());
        System.out.println();
    }
    public void playerStats(){
        System.out.println("----------------------");
        System.out.println("Oyuncu değerleri: ");
        System.out.println("Sağlık: "+this.getPlayer().getHealth() +"\n"+
                           "Hasar: "+this.getPlayer().getTotalDamage()+"\n"+
                           "Silah: "+this.getPlayer().getInventory().getWeapon().getName()+ "\n"+
                           "Zırh: "+this.getPlayer().getInventory().getArmor().getName()+ "\n"+
                           "Bloklama: "+this.getPlayer().getInventory().getArmor().getBlock()+ "\n"+
                           "Para: "+this.getPlayer().getMoney());
    }
    public void monsterStats(int i){
        System.out.println(i+ ". "+this.getMonster().getName()+ " değerleri: ");
        System.out.println("Sağlık: "+this.getMonster().getHealth() +"\n"+
                           "Hasar: "+this.getMonster().getDamage()+"\n"+
                           "Ödül: "+this.getMonster().getAward());

    }
    public int randomMonsterNumber(){//Bir savaş alanında kaç tane canavar olacağını random bir şekilde belirler
        Random random=new Random();
        int monsterNum=random.nextInt(this.getMaxMonster())+1;//0dan başladığı için bir tane arttırılarak işlem yapar
        return monsterNum;
    }

    public Monster getMonster() {
        return monster;
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public int getMaxMonster() {
        return maxMonster;
    }

    public void setMaxMonster(int maxMonster) {
        this.maxMonster = maxMonster;
    }
}
