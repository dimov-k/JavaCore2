import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;

public class MainCircles extends JFrame {

    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    Sprite[] sprites = new Sprite[10];


    public static void main(String[] args) {
        new MainCircles();
    }

    private MainCircles() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle("Balloons");
        GameCanvas canvas = new GameCanvas(this);
        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent b) {
                super.mouseClicked(b);
                Sprite[] tmp;
                if (b.getButton() == MouseEvent.BUTTON1) {
                    tmp = Arrays.copyOf(sprites, sprites.length + 1);
                    tmp[tmp.length - 1] = new Ball();
                    sprites = Arrays.copyOf(tmp, tmp.length);
                } else if (b.getButton() == MouseEvent.BUTTON3 && sprites.length > 0) {
                    sprites = Arrays.copyOf(sprites, sprites.length - 1);
                }
            }

        });
        add(canvas);
        initApplication();
        setVisible(true);
    }

    private void initApplication() {
       for (int i = 0; i < sprites.length; i++) {
            sprites[i] = new Ball();
        }
    }


    public void onDrawFrame(GameCanvas canvas, Graphics g, float deltaTime) {
        {
            BackGround.setColorBackground(canvas, deltaTime);
            update(canvas, deltaTime);
            render(canvas, g);
        }
    }

    private void update(GameCanvas canvas, float deltaTime) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }

    private void render(GameCanvas canvas, Graphics g) {
        for (int i = 0; i < sprites.length; i++) {
            sprites[i].render(canvas, g);
        }
    }
}
