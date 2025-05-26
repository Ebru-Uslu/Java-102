import java.util.Scanner;

public class Game {

    Player player;
    Location location;
    Scanner input = new Scanner(System.in);

    public void start() {
        System.out.println("Macera oyununa hoşgeldiniz !");
        System.out.print("Lütfen bir isim giriniz: ");
        String playerName = input.nextLine();
        Player player1 = new Player(playerName);
        System.out.println("Sayın " + player1.getName() + " bu karanlık ve sisli adaya hoşgeldiniz !");
        System.out.println("-------------------");
        player1.selectCharacter();//Oyun başladığında karakterleri getirir

        Location location = null;
        while (true) {
            player1.printInfo();
            System.out.println("Bölgeler: ");
            System.out.println("1.Güvenli ev.Burada düşman yok. \n" +
                    "2.Eşya Dükkanı--> Silah veya zırh satın alabilirsiniz  \n"+
                    "3.Mağara-->Ödül: Yemek,dikkatli ol zombi çıkabilir \n"+
                    "4.Orman-->Ödül: Odun,dikkatli ol vampir çıkabilir \n"+
                    "5.Nehir-->Ödül: Su,dikkatli ol ayı çıkabilir \n"+
                    "0.Çıkış yap --> Oyunu sonlandır"
            );
            System.out.println();
            System.out.print("Lütfen gitmek istediğiniz bölgeyi seçin: ");
            int selectLoc = input.nextInt();
            System.out.println("---------------");
            switch (selectLoc) {
                case 0:
                    location=null;
                    break;
                case 1:
                    location = new SafeHouse(player1);
                    break;
                case 2:
                    location = new ToolStore(player1);
                    break;
                case 3:
                    location=new Cave(player1);
                    break;
                case 4:
                    location=new Forest(player1);
                    break;
                case 5:
                    location=new River(player1);
                    break;
                default:
                   System.out.println("Lütfen geçerli bir bölge girin!");
                    break;
            }
            if(location==null){
                System.out.println("Adaya veda eden yarışmacıııı: "+player1.getName());
                break;
            }
            if (!location.onLocation()) {
                System.out.println("Game over");
                break;
            }
        }

    }
}
