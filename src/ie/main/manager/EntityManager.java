package ie.main.manager;

import ie.main.Main;
import ie.main.object.entity.enemy.base.Enemy;
import ie.main.object.entity.enemy.base.EnemyConfig;
import ie.main.object.entity.enemy.Minion;
import ie.main.object.entity.item.ElixirItem;
import ie.main.object.entity.item.base.Item;

import java.util.Random;

import java.util.ArrayList;

public class EntityManager implements IItem {
    final Main main;
    final Random random = new Random();

    EnemyConfig minionConfig;

    ArrayList<Enemy> enemies = new ArrayList<>();
    ArrayList<Item> items = new ArrayList<>();

    final int minionCoolTime = 30;
    int minionCool = 0;
    public EntityManager(Main main) {
        this.main = main;
        minionConfig = new EnemyConfig(60, 5, 200, 2, "minion",main.player, main.optionManager, this,120*60);
    }

    public void update() {
        enemies.removeIf(enemy -> enemy.isRemove());

        if (minionCool >= minionCoolTime) {
            Minion m = new Minion(getSpawnX(),getSpawnY(),minionConfig);
            main.addGameEntity(m);
            enemies.add(m);
            minionCool = 0;
            System.out.println("Spawn");
        } else {minionCool ++;}
       //R System.out.println("update");
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies;
    }

    public double getSpawnX() {return random.nextDouble(19200) - 9600;}
    public double getSpawnY() {return random.nextDouble(10800) - 5040;}

    @Override
    public void addItem(double x,double y,EnemyConfig enemyConfig) {
        main.addGameEntity(new ElixirItem(x,y,enemyConfig));
    }
}
