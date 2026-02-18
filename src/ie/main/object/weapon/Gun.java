package ie.main.object.weapon;

import ie.main.Main;
import ie.main.object.entity.bullet.Fire;
import ie.main.object.entity.player.Player;

public class Gun {
    final int maxDistance = 600;
    final int spendElixir = 8;
    final double bulletSpeed = 15;
    final int bulletSize = 10;
    final int damage = 5;
    final Main main;
    final Player player;

    public int getMaxDistance() {
        return maxDistance;
    }

    public Gun(Main main, Player player) {
        this.main = main;
        this.player = player;
    }

    public void shot() {
        if (player.getElixir() <= spendElixir) return;
        double distance = player.getOrbit().getDistance();
        if (player.getOrbit().getDistance() >= maxDistance) {distance = maxDistance;}
        main.addGameEntity(new Fire(bulletSize,player.getX(),player.getY(),-20,player.getOrbit().getAngle(),bulletSpeed,distance,damage,main.getEntityManager().getEnemies()));
        double i = player.getElixir();
        player.setElixir(i - spendElixir);
    }

}
