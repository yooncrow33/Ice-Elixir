package ie.launch;

import ie.launch.input.LauncherKeyListener;
import ie.main.Main;
import ie.main.object.entity.player.Player;
import scope.EmptyBase;

import java.awt.*;

public class Launcher extends EmptyBase {

    LauncherKeyListener launcherKeyListener = new LauncherKeyListener(this,this);

    private StringBuilder buffer = new StringBuilder();

    public int sideBarFocus = 0;
    public static String sideStr[] = {"GAME", "PATCH NOTE","EXIT"};
    public int mainFocus = 1;
    public int selectedProfile = 1;

    public boolean isStarting = false;
    public boolean launch = false;
    public double loadProgress = 0.0;
    public double loadSpeed = 2.5; // 1.5초 동안 차오름
    public double fadeOutProgress = 0.0;
    public double fadeOutSpeed = 2.5; // 1.5초 동안 차오름

    String patch_notes = "\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +
            "dev-01 2/22\n" +
            "   - create launcher.\n" +

            "\n";

    public Launcher() {
        super("IE Launcher");
    }

    @Override
    protected void init() {

    }

    @Override
    protected void update(double dt) {
        if (isStarting) {
            loadProgress += dt * (1.0 / loadSpeed); // 시간에 따라 증가
            fadeOutProgress += dt * (1.0 / fadeOutSpeed); // 시간에 따라 증가
            if (loadProgress >= 1.0) {
                loadProgress = 1.0;
                if (launch) return;
                LoadingScreen.showSplashThenLaunchGame(selectedProfile);
                launch = true;
            }
        }
    }

    @Override
    protected void render(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setColor(new Color(30,30,30));
        g.fillRect(-2000,-2000,7000,7000);
        g.setColor(new Color(50,50,50));
        g.fillRect(0,0,300,1080);
        g.setColor(Color.DARK_GRAY);
        g.setFont(new Font("Dialog", Font.ITALIC, 16));
        g.drawString("ARROW TO MOVE  |  ENTER TO SELECT | P/L TO MOVE TAB", 350, 1080 - 50);
        for (int i = 0; i < 3; i++) {
            int raw = 100;
            if (i == sideBarFocus) g.setColor(new Color(70,70,70)); else g.setColor(new Color(140,140,140));
            g.fillRect(0,raw*i,300,raw - 10);
            if (i == sideBarFocus) g.setColor(new Color(240,240,240)); else g.setColor(new Color(70,70,70));
            g.setFont(new Font("Impact", Font.BOLD, 30));
            g.drawString(sideStr[i], 10,raw*i + 35);
        }
        int center = ((1920-300)/2) + 300;
        switch (sideBarFocus) {
            case 0 :
                g.setColor(new Color(160,160,160));
                g.fillRoundRect(center-(1420/2), 30,1420,140,30,30);
                g.setColor(new Color(45,45,45));
                g.setFont(new Font("Impact", Font.BOLD, 124));
                g.drawString("Ice & Elixir",850,150);

                if (mainFocus == 0) {g.setColor(new Color(130,190,130));g.fillRect(center - 210/2, 295,210,100);}
                g.setColor(new Color(80,190,30));
                g.fillRect(center - 200/2, 300,200,90);
                g.setColor(new Color(50,50,50));
                g.drawRect(center - 190/2,305,190,80);
                g.setFont(new Font("Impact", Font.PLAIN, 80));
                g.drawString("GO", center - 190/2 + 50,375);

                for (int i = 0; i < 1; i++) {
                    int raw = 65;
                    int sx = center-750/2;
                    final int LABEL_WIDTH = 350;     // 설정 이름 영역 가로폭
                    final int SELECTOR_WIDTH = 400;  // 설정값 선택 영역 가로폭
                    int currentY = 600 + (i * raw);
                    boolean isFocused = (mainFocus == 1); // 현재 선택된 항목인지 확인

                    // 포커스된 항목 하이라이트 배경
                    if (isFocused) {
                        g.setColor(new Color(240,240,240,30)); // 아주 연한 레드 배경
                        g.fillRect(sx - 20, currentY - 40, LABEL_WIDTH + SELECTOR_WIDTH + 40, raw - 5);
                        g.setColor(new Color(150,150,150)); // 포커스된 항목은 레드
                    } else {
                        g.setColor(new Color(70,70,70)); // 비활성 항목은 그레이
                    }

                    // A. 설정 이름 (Label)
                    g.setFont(new Font("Impact", Font.PLAIN, 28));
                    g.drawString("Profile", sx, currentY);

                    // B. 좌우 화살표 및 값 (Selector)
                    int selectorX = sx + LABEL_WIDTH;

                    // 왼쪽 화살표 [<]
                    g.setFont(new Font("Monospaced", Font.BOLD, 30));
                    g.drawString("<", selectorX, currentY);

                    // 현재 값 (중앙 정렬 느낌을 위해 Monospaced 권장)
                    g.setColor(isFocused ? new Color(210,210,210) : Color.DARK_GRAY);
                    g.setFont(new Font("Monospaced", Font.BOLD, 24));
                    // 값의 길이에 상관없이 일정 위치에 출력
                    g.drawString(selectedProfile + "", selectorX + 50, currentY - 2);

                    // 오른쪽 화살표 [>]
                    if (isFocused) {
                        g.setColor(new Color(150,150,150)); // 포커스된 항목은 레드
                    } else {
                        g.setColor(new Color(70,70,70)); // 비활성 항목은 그레이
                    }
                    g.setFont(new Font("Monospaced", Font.BOLD, 30));
                    g.drawString(">", selectorX + SELECTOR_WIDTH - 30, currentY);
                }
                break;
            case 1 :
                String input = buffer.toString().trim();
                if (input.isEmpty()) {
                    return;
                }

// 1. 줄바꿈(\n)을 기준으로 문자열을 나눕니다.
                String[] patchLines = input.split("\n");

// 2. 각 줄을 순회하며 패치노트 리스트에 추가합니다.
                for (String line : patchLines) {
                    String trimmedLine = line.trim();
                    if (!trimmedLine.isEmpty()) {
                        // 앞에 글머리 기호(•)를 붙여 가성비 있게 출력
                        //logs.add("  • " + trimmedLine);
                    }
                }
                break;
            case 2 :

                break;
            default:

                break;
        }

        if (isStarting) {
            g2d.setColor(new Color(0, 0, 0, (int)(loadProgress * 255)));
            g2d.fillRect(-10000, -10000, 1000000, 1000000);

            float thickness = 15f; // 테두리 두께
            g2d.setStroke(new BasicStroke(thickness));
            g2d.setColor(new Color(80, 190, 30)); // 진행 중인 테두리 색상 (초록색)

            int width = 1920;  // 실제 창 너비
            int height = 1080; // 실제 창 높이

            // 전체 둘레 대비 현재 진행 거리
            double totalPerimeter = (width + height) * 2;
            double currentPos = totalPerimeter * loadProgress;

            // 상단 (왼쪽 -> 오른쪽)
            if (currentPos > 0) {
                int x2 = (int) Math.min(width, currentPos);
                g2d.drawLine(0, 0, x2, 0);
            }
            // 우측 (위 -> 아래)
            if (currentPos > width) {
                int y2 = (int) Math.min(height, currentPos - width);
                g2d.drawLine(width, 0, width, y2);
            }
            // 하단 (오른쪽 -> 왼쪽)
            if (currentPos > width + height) {
                int x2 = (int) Math.max(0, width - (currentPos - width - height));
                g2d.drawLine(width, height, x2, height);
            }
            // 좌측 (아래 -> 위)
            if (currentPos > (width * 2) + height) {
                int y2 = (int) Math.max(0, height - (currentPos - (width * 2) - height));
                g2d.drawLine(0, height, 0, y2);
            }

            // [옵션] 화면 전체에 약간의 오버레이(글로우 효과) 추가
            //g2d.setColor(new Color(80, 190, 30, (int)(loadProgress * 50)));
            //g2d.fillRect(0, 0, width, height);
        }
    }

    public void launch() {
        isStarting = true;
    }

    public static void main(String[] args) {
        new Launcher();
    }
}
