import java.util.Scanner;

public abstract class Location {
    private Player player;
    private String name;
    public static Scanner input = new Scanner(System.in);

    Location(Player player,String name){
        this.player=player;
        this.name=name;
    }
    public abstract boolean onLocation();//Her class'ta newlendiğinde farklı işlemler gerçekleştireceğinden dolayı abstract oluşturulur

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
