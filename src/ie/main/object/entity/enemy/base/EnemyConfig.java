package ie.main.object.entity.enemy.base;

import ie.main.manager.EntityManager;
import ie.main.manager.OptionManager;
import ie.main.object.entity.player.Player;

public class EnemyConfig {
    private final int maxHp;
    private final double speed;
    private final int dropExp;
    private final int dropElixir;
    private final String enemyName;
    private final Player player;
    private final OptionManager optionManager;
    private final EntityManager entityManager;
    private final int life;

    public EnemyConfig(int maxHp, double speed, int dropExp, int dropElixir, String enemyName, Player player, OptionManager optionManager, EntityManager entityManager, int life) {
        this.maxHp = maxHp;
        this.speed = speed;
        this.dropExp = dropExp;
        this.dropElixir = dropElixir;
        this.enemyName = enemyName;
        this.player = player;
        this.optionManager = optionManager;
        this.entityManager = entityManager;
        this.life = life;
    }

    public EntityManager getEntityManager() {return entityManager; }
    public Player getPlayer() {return player; }
    public OptionManager getOptionManager() {return optionManager; }
    public int getLife() {return life; }
    public int getMaxHp() {return maxHp; }
    public double getSpeed() {return speed; }
    public int getDropExp() {return dropExp; }
    public int getDropElixir() {return dropElixir; }
    public String getEnemyName() {return enemyName; }}