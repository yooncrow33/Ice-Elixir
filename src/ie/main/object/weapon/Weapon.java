package ie.main.object.weapon;

public abstract class Weapon {
    final int maxDistance;
    final int speed;
    final int spendElixir;
    public Weapon(int maxDistance, int speed, int spendElixir) {
        this.maxDistance = maxDistance;
        this.speed = speed;
        this.spendElixir = spendElixir;
    }
}
