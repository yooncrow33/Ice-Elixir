package ie.main.object.entity.player.graphics;

import ie.main.object.entity.player.Player;
import scope.sideScroll.Entity;
import ie.main.view.IMouse;
import java.awt.*;
import java.awt.geom.AffineTransform;

public class Orbit extends Entity {
    private final IMouse iMouse;
    private final Player player;

    // 계산된 결과값 (필드에 저장해서 어디서든 꺼내 씀)
    private double angle;
    private double distance;

    private final int AIM_HEIGHT = 7;

    double renderX;
    double renderY;

    public Orbit(IMouse iMouse, Player player) {
        // 반지름 0, 위치 0,0, 충돌 안함, 업데이트 함, 최상단 레이어 100
        super(0, 0, 0, false, true, 100);
        this.iMouse = iMouse;
        this.player = player;
    }

    @Override
    public void update(double dt) {
        // 엔티티 자체 좌표는 플레이어와 동기화 (혹시 모를 로직용)
        this.x = player.getX();
        this.y = player.getY();

        double dx = iMouse.getVirtualMouseX() - renderX;
        double dy = iMouse.getVirtualMouseY() - renderY;

        // 네가 말한 대로 계산식 분리 및 정밀도 보정
        this.distance = Math.hypot(dx, dy);
        this.angle = Math.atan2(dy, dx);
    }

    // --- [각도/거리 Getter] 다른 곳에서 총 쏠 때 이거 써라 ---
    public double getAngle() { return this.angle; }
    public double getDistance() { return this.distance; }

    @Override
    public void render(Graphics g, double renderX, double renderY) {
        // 1. 카메라 좌표(renderX/Y)와 가상 마우스 좌표의 차이로 실시간 계산
        // renderX/Y는 이미 카메라와 화면 중앙 보정이 끝난 플레이어의 '화면 위치'임
        this.renderX = renderX;
        this.renderY = renderY;

        Graphics2D g2d = (Graphics2D) g;

        // 선이 튀지 않게 안티앨리어싱 적용

        AffineTransform oldTransform = g2d.getTransform();

        // 2. 플레이어 위치로 좌표계 이동 및 회전
        g2d.translate(renderX, renderY);
        g2d.rotate(this.angle);

        final int START_OFFSET = player.getRadius() + 40;

        // 3. 조준선 그리기 (네 로직 그대로)
        double normalLength = Math.min(this.distance, player.getGun().getMaxDistance()) - START_OFFSET;

        // A. 일반 사거리 (회색)
        if (normalLength > 0) {
            g2d.setColor(new Color(128, 128, 128, 128));
            g2d.fillRect(START_OFFSET, -AIM_HEIGHT / 2, (int) Math.ceil(normalLength), AIM_HEIGHT);
        }

        // B. 사거리 초과 (빨간색)
        if (this.distance > player.getGun().getMaxDistance()) {
            double redLength = this.distance - player.getGun().getMaxDistance();
            g2d.setColor(new Color(255, 0, 0, 128));
            g2d.fillRect((int) player.getGun().getMaxDistance(), -AIM_HEIGHT / 2, (int) Math.ceil(redLength), AIM_HEIGHT);
        }

        g2d.setTransform(oldTransform);
    }
}