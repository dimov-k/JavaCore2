import javax.swing.*;
import java.awt.*;


public abstract class BackGround {
    static Color color = Color.WHITE;
    private static final float AMPLITUDE = 255f / 2f;
    private static int red = 1;
    private static int green = 2;
    private static int blue = 3;
    private static float time = 10;

    static void setColorBackground(GameCanvas canvas, float deltaTime){
        color = getNextColor(deltaTime);
        canvas.setBackground(color);
    }

    private static Color getNextColor(float deltaTime){
        time += deltaTime;
        red = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time * 2f));
        green = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time * 3f));
        blue = Math.round(AMPLITUDE + AMPLITUDE * (float) Math.sin(time));
        return color = new Color(red, green, blue);
    }
}
