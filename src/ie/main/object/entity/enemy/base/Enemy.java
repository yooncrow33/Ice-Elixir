package ie.main.object.entity.enemy.base;

import scope.sideScroll.Entity;

public abstract class Enemy extends Entity {
    protected int hp;
    protected final int maxHp;
    protected final EnemyConfig config;
    protected boolean takingDamage = false;
    protected final double speed;
    protected final double stopDistance;
    protected int damageTimer = 0;

    protected double vx = 0; // x축 속도
    protected double vy = 0; // y축 속도
    protected final double acceleration = 0.5; // 가속도 수치
    protected final double friction = 0.92;    // 마찰력 (감속 조절)
    public Enemy(int radius, double x, double y, int layer,double speed,double stopDistance, EnemyConfig enemyConfig) {
        super(radius, x, y, true,true, layer);
        this.config = enemyConfig;
        this.maxHp = config.getMaxHp();
        this.hp = maxHp;
        this.speed = speed;
        this.stopDistance = stopDistance;
    }

    @Override
    public void update(double delta) {
        double dt = delta / (16.0 / 1000.0);
        if (hp <= 0) { remove(); die(); return; }

        double dx = config.getPlayer().getX() - x;
        double dy = config.getPlayer().getY() - y;
        double distance = Math.sqrt(dx * dx + dy * dy);
        double angle = Math.atan2(dy, dx);

        if (distance > stopDistance) {
            // 1. 최고 속도까지 비선형 가속 (점진적으로 속도 증가)
            // 현재 속도에 가속도를 더함 (방향 고려)
            vx += Math.cos(angle) * acceleration * dt;
            vy += Math.sin(angle) * acceleration * dt;
        } else {
            // 2. stopDistance 안쪽이면 서서히 감속 (마찰력 적용)
            // 속도에 1보다 작은 값을 곱해서 에너지를 잃게 만듦
            vx *= friction;
            vy *= friction;

            // 속도가 아주 낮아지면 완전히 멈춤 (떨림 방지)
            if (Math.abs(vx) < 0.1) vx = 0;
            if (Math.abs(vy) < 0.1) vy = 0;
        }

        // 3. 최고 속도 제한 (Speed Limit)
        double currentSpeed = Math.sqrt(vx * vx + vy * vy);
        if (currentSpeed > speed) {
            vx = (vx / currentSpeed) * speed;
            vy = (vy / currentSpeed) * speed;
        }

        // 4. 최종 좌표 업데이트
        x += vx * dt;
        y += vy * dt;
        if (damageTimer > 0) {
            damageTimer--;
            takingDamage = true;
        } else {
            takingDamage = false;
        }
    }

    protected abstract void die();

    public void takeDamage(int value) {
        damageTimer = 5;
        hp -= value;
    }
}
