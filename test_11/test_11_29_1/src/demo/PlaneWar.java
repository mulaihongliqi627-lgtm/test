package demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.List;

public class PlaneWar extends JFrame {

    // 游戏窗口宽和高
    public static final int WIDTH = 400;
    public static final int HEIGHT = 600;

    private GamePanel panel;

    public PlaneWar() {
        setTitle("简易飞机大战 (Java版)");
        setSize(WIDTH, HEIGHT);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 居中显示

        panel = new GamePanel();
        add(panel);
        panel.action(); // 启动游戏逻辑

        setVisible(true);
    }

    public static void main(String[] args) {
        // 在事件分发线程中启动 UI
        SwingUtilities.invokeLater(() -> new PlaneWar());
    }
}

// 游戏主面板
class GamePanel extends JPanel {
    private Hero hero = new Hero(180, 500); // 玩家
    private List<Bullet> bullets = new ArrayList<>(); // 子弹集合
    private List<Enemy> enemies = new ArrayList<>(); // 敌人集合
    private int score = 0;
    private boolean isGameOver = false;
    private Random random = new Random();

    // 按键状态标记
    private boolean left, right, up, down, shooting;

    // 计时器计数
    private int timerIndex = 0;

    public GamePanel() {
        setBackground(Color.BLACK); // 黑色背景，模拟太空

        // 键盘监听
        this.setFocusable(true);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int code = e.getKeyCode();
                if (code == KeyEvent.VK_LEFT) left = true;
                if (code == KeyEvent.VK_RIGHT) right = true;
                if (code == KeyEvent.VK_UP) up = true;
                if (code == KeyEvent.VK_DOWN) down = true;
                if (code == KeyEvent.VK_SPACE) shooting = true;

                // 游戏结束按 R 重启
                if (isGameOver && code == KeyEvent.VK_R) {
                    restart();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                int code = e.getKeyCode();
                if (code == KeyEvent.VK_LEFT) left = false;
                if (code == KeyEvent.VK_RIGHT) right = false;
                if (code == KeyEvent.VK_UP) up = false;
                if (code == KeyEvent.VK_DOWN) down = false;
                if (code == KeyEvent.VK_SPACE) shooting = false;
            }
        });
    }

    // 重启游戏
    private void restart() {
        hero = new Hero(180, 500);
        bullets.clear();
        enemies.clear();
        score = 0;
        isGameOver = false;
        timerIndex = 0;
    }

    // 游戏主循环
    public void action() {
        // 使用线程来控制游戏刷新 (约60帧)
        new Thread(() -> {
            while (true) {
                if (!isGameOver) {
                    step();      // 物体移动
                    checkHit();  // 碰撞检测
                    spawn();     // 生成敌人
                }
                repaint();   // 重绘画面

                try {
                    Thread.sleep(16); // 约 60 FPS
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    // 生成逻辑
    private void spawn() {
        timerIndex++;
        // 每 40 帧生成一个敌人
        if (timerIndex % 40 == 0) {
            enemies.add(new Enemy(random.nextInt(PlaneWar.WIDTH - 30), 0));
        }
        // 每 10 帧且按住空格时生成子弹
        if (shooting && timerIndex % 10 == 0) {
            bullets.add(new Bullet(hero.x + 15, hero.y));
        }
    }

    // 移动逻辑
    private void step() {
        // 移动英雄
        if (left && hero.x > 0) hero.x -= 5;
        if (right && hero.x < PlaneWar.WIDTH - 40) hero.x += 5;
        if (up && hero.y > 0) hero.y -= 5;
        if (down && hero.y < PlaneWar.HEIGHT - 60) hero.y += 5;

        // 移动子弹
        Iterator<Bullet> bit = bullets.iterator();
        while (bit.hasNext()) {
            Bullet b = bit.next();
            b.y -= 10; // 子弹向上飞
            if (b.y < -20) bit.remove(); // 出界移除
        }

        // 移动敌人
        Iterator<Enemy> eit = enemies.iterator();
        while (eit.hasNext()) {
            Enemy e = eit.next();
            e.y += 3; // 敌人向下落
            if (e.y > PlaneWar.HEIGHT) eit.remove(); // 出界移除
        }
    }

    // 碰撞检测
    private void checkHit() {
        Iterator<Enemy> eit = enemies.iterator();
        while (eit.hasNext()) {
            Enemy e = eit.next();
            Rectangle eRect = new Rectangle(e.x, e.y, 30, 30);

            // 1. 检查子弹击中敌人
            Iterator<Bullet> bit = bullets.iterator();
            boolean enemyDead = false;
            while (bit.hasNext()) {
                Bullet b = bit.next();
                Rectangle bRect = new Rectangle(b.x, b.y, 10, 10);
                if (eRect.intersects(bRect)) {
                    bit.remove(); // 移除子弹
                    enemyDead = true;
                    score += 10;
                    break;
                }
            }
            if (enemyDead) {
                eit.remove();
                continue;
            }

            // 2. 检查英雄撞到敌人
            Rectangle hRect = new Rectangle(hero.x, hero.y, 40, 40);
            if (hRect.intersects(eRect)) {
                isGameOver = true;
            }
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g); // 清除背景

        // 画英雄 (绿色飞机)
        g.setColor(Color.GREEN);
        g.fillRect(hero.x, hero.y, 40, 40);
        // 画个小机头
        g.fillRect(hero.x + 15, hero.y - 10, 10, 10);

        // 画子弹 (黄色)
        g.setColor(Color.YELLOW);
        for (Bullet b : bullets) {
            g.fillOval(b.x, b.y, 10, 10);
        }

        // 画敌人 (红色)
        g.setColor(Color.RED);
        for (Enemy e : enemies) {
            g.fillRect(e.x, e.y, 30, 30);
        }

        // 画分数
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + score, 10, 30);

        // 画游戏结束
        if (isGameOver) {
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 40));
            g.drawString("GAME OVER", 70, 300);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString("Press 'R' to Restart", 110, 350);
        }
    }
}

// 简单的实体类
class Hero {
    int x, y;
    Hero(int x, int y) { this.x = x; this.y = y; }
}

class Bullet {
    int x, y;
    Bullet(int x, int y) { this.x = x; this.y = y; }
}

class Enemy {
    int x, y;
    Enemy(int x, int y) { this.x = x; this.y = y; }
}

