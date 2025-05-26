public class ToolStore extends NormalLocation{
    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation(){
        System.out.println("Mağazaya hoşgeldiniz.");

        boolean showMenu=true;
        while(showMenu){
            System.out.println("1. Silahlar \n" +
                    "2. Zırhlar \n" +
                    "3. Çıkış yap");

            System.out.print("Seçiminiz: ");
            int selectCase=Location.input.nextInt() ;

            while (selectCase<1 || selectCase>3){
                System.out.println("Geçersiz değer,tekrar giriniz: ");
                selectCase=input.nextInt();
            }
            switch (selectCase){
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Bir daha bekleriz.");
                    showMenu=false;
                    break;
            }
        }
        return true;
    }

    public void printWeapon(){//Silahın özelliklerini yazdırır
        System.out.println("-----Silahlar------");
        for(Weapon w:Weapon.weapons()){
            System.out.println("Id: "+w.getId()+
                    "\t Adı: "+w.getName()+
                    "\t Hasar: "+w.getDamage()+
                    "\t Fiyat: "+w.getPrice());
        }
        System.out.println("-> Çıkış yapmak için 0'a basın.");
    }
    public void buyWeapon(){//Silah satın alma işlemleri
        System.out.print("Bir silah seçin: ");
        int selectWeaponID=input.nextInt();

        while (selectWeaponID<0  || selectWeaponID>Weapon.weapons().length){//seçilen numaralar 1-3 arası olmalı
            System.out.print("Geçersiz değer,tekrar giriniz: ");
            selectWeaponID=input.nextInt();
        }

        if(selectWeaponID!=0){
            Weapon selectedWeapon=Weapon.getWeaponObjById(selectWeaponID);
            if(selectedWeapon!=null){
                if(selectedWeapon.getPrice()> this.getPlayer().getMoney()){
                    System.out.println("Yeterli paranız bulunmamaktadır");
                }
                else {
                    //Satın alma işlemlerini gerçekleşir
                    System.out.println(selectedWeapon.getName()+ " silahını satın aldınız.");
                    int balance=this.getPlayer().getMoney()-selectedWeapon.getPrice();
                    this.getPlayer().setMoney(balance);//Bakiye güncellemesi
                    System.out.println("Kalan paranız: "+this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setWeapon(selectedWeapon);//Yeni silah artık satın alınmış olan olur

                }
            }
        }
    }
    public void printArmor(){//Zırhların özelliklerini döngü içinde yazdırır
        System.out.println("-----Zırhlar------");
        for(Armor w:Armor.armors()){
            System.out.println("Id: "+w.getId()+
                    "\t Adı: "+w.getName()+
                    "\t Zırh: "+w.getBlock()+
                    "\t Fiyat: "+w.getPrice());
        }
        System.out.println("-> Çıkış yapmak için 0'a basın.");
    }
    public void buyArmor(){//Zırh satın alma işlemleri
        System.out.print("Bir zırh türü seçin: ");
        int selectArmorID=input.nextInt();

        while (selectArmorID<0 || selectArmorID>Weapon.weapons().length){//seçilen numaralar 1-3 arası olmalı
            System.out.print("Geçersiz değer,tekrar giriniz: ");
            selectArmorID=input.nextInt();
        }
        if(selectArmorID!=0){
            Armor selectedArmor= Armor.getArmorObjById(selectArmorID);//Yeni seçilen zırhı envanterdeki zırhla eşleştirir
            if(selectedArmor!=null){
                if(selectedArmor.getPrice()> this.getPlayer().getMoney()){
                    System.out.println("Yeterli paranız bulunmamaktadır");
                }
                else {
                    //Satın alma işlemlerini gerçekleşir
                    System.out.println(selectedArmor.getName()+ " zırhını satın aldınız.");
                    int balance=this.getPlayer().getMoney()-selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);//Bakiye güncellemesi
                    System.out.println("Kalan paranız: "+this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setArmor(selectedArmor);//Yeni zırh artık satın alınmış olan olur

                }
            }
        }

    }
}
