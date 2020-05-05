public class PointTransformer
{
    private Vec3 cameraLocation;
    private Vec3 up;
    private Vec3 lookingAt;

    private int windowWidth;
    private int windowHeight;

    private double alpha;  // field of view angle

    int near;
    int far;
    int right;
    int left;

    // Transformation matrices
    Mat4 viewingTransform;

    public PointTransformer(int inputWidth, int inputHeight, Vec3 inputCameraLocation, Vec3 inputCameraLookingAt)
    {
        windowWidth = inputWidth;
        windowHeight = inputHeight;

        cameraLocation = inputCameraLocation;
        up = new Vec3(0, 1, 0);
        lookingAt = new Vec3(0, 0, -1);

        near = -1;
        far = -100;
        right = 5;
        left = 5;
        alpha = Math.PI/4;

        this.makeViewingTransform();
    }

    public void tick()
    {

    }


    // =====================================
    //
    //            Matrix Things
    //
    // =====================================

    public void makeViewingTransform()
    {
        double cotangent = 1 / Math.tan(alpha/2);
        double a = (double)(far + near) / (far - near);
        double b = (double)(2*near*far) / (far - near);
        viewingTransform = new Mat4(new double[]{cotangent, 0, 0, 0,
                0, cotangent, 0, 0,
                0, 0, a, -1,
                0, 0, b, 0});
    }

    // Returns the result of transforming the point p from world space into screen space
    // Just take the x and y coordinates of it
    public Vec4 transform(Vec3 p)
    {
        Vec4 p4 = new Vec4(p.x, p.y, p.z, 1);
        Vec4 product = viewingTransform.leftMultiply(p4);
        product.divideByW();
        return product;
    }
}
