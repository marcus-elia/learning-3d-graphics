import java.awt.*;

public class GameManager
{

    private int windowWidth;
    private int windowHeight;

    private PointTransformer transform;

    private Vec3[] cubePoints;

    public GameManager(int inputWidth, int inputHeight)
    {
        windowWidth = inputWidth;
        windowHeight = inputHeight;
        transform = new PointTransformer(windowWidth, windowHeight, new Vec3(0,0,0),
                new Vec3(0, 0, -1));
        cubePoints = new Vec3[]{new Vec3(2,10,-10), new Vec3(2, 8, -10),
                                new Vec3(0, 8, -10), new Vec3(0, 10, -10),
                                new Vec3(2,10,-12), new Vec3(2, 8, -12),
                                new Vec3(0, 8, -12), new Vec3(0, 10, -12)};
    }

    public void tick()
    {

    }

    public void render(Graphics2D g2d)
    {
        g2d.setColor(Color.CYAN);
        for(Vec3 v : cubePoints)
        {
            Vec4 tv = transform.transform(v);
            int x = (int)((tv.x + 1)/2 * windowWidth);
            int y = (int)((tv.y + 1)/2 * windowHeight);
            g2d.fillRect(x, y, 1, 1);
        }
    }
}
