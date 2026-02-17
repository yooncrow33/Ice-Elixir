package ie.main.object.entity.enemy;

public class EnemyConfig {
    private final int maxHp;
    private final double speed;
    private final int dropExp;
    private final int dropElixir;
    private final String enemyName;

    public EnemyConfig(int maxHp, double speed, int dropExp, int dropElixir, String enemyName) {
        this.maxHp = maxHp;
        this.speed = speed;
        this.dropExp = dropExp;
        this.dropElixir = dropElixir;
        this.enemyName = enemyName;
    }

    public int getMaxHp() {return maxHp; }
    public double getSpeed() {return speed; }
    public int getDropExp() {return dropExp; }
    public int getDropElixir() {return dropElixir; }
    public String getEnemyName() {return enemyName; }}