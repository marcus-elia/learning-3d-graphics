public class Testing
{
    public static void main(String[] args)
    {
        testVec3();
    }

    public static void testVec3()
    {
        System.out.println("\nTesting the Vec3 class.");
        boolean passed = true;
        Vec3 v;
        Vec3 exp;

        // Normalize
        v = new Vec3(0, 0, 0);
        v.normalize();
        exp = new Vec3(0,0,0);
        if(!v.is(0, 0, 0, 0.01))
        {
            passed = false;
            System.out.println("FAILED test of normalize on zero vector.");
            System.out.println("Expected " + exp + ", but observed " + v);
        }

        v = new Vec3(1, 2, 1);
        v.normalize();
        exp = new Vec3(1/Math.sqrt(6),2/Math.sqrt(6), 1/Math.sqrt(6));
        if(!v.is(exp, 0.01))
        {
            passed = false;
            System.out.println("FAILED test of normalize on nonzero vector.");
            System.out.println("Expected " + exp + ", but observed " + v);
        }

        // Scalar multiplication
        v = new Vec3(1, 1, 1);
        v.scalarMultiply(2);
        exp = new Vec3(2,2,2);
        if(!v.is(exp, 0.01))
        {
            passed = false;
            System.out.println("FAILED test of scalar multiply.");
            System.out.println("Expected " + exp + ", but observed " + v);
        }

        // Addition
        v = new Vec3(1, 2, 3);
        v.add(new Vec3(3,2,1));
        exp = new Vec3(4,4,4);
        if(!v.is(exp, 0.01))
        {
            passed = false;
            System.out.println("FAILED test of addition.");
            System.out.println("Expected " + exp + ", but observed " + v);
        }

        // Dot product
        v = new Vec3(1, 2, 3);
        double dot = v.dotProduct(new Vec3(3,2,1));
        if(dot != 10)
        {
            passed = false;
            System.out.println("FAILED test of dot product positive.");
            System.out.println("Expected " + 10 + ", but observed " + dot);
        }
        dot = v.dotProduct(new Vec3(-3,2,-1));
        if(dot != -2)
        {
            passed = false;
            System.out.println("FAILED test of dot product negative.");
            System.out.println("Expected " + -2 + ", but observed " + dot);
        }
        dot = v.dotProduct(new Vec3(6, -3, 0));
        if(dot != 0)
        {
            passed = false;
            System.out.println("FAILED test of dot product 0.");
            System.out.println("Expected " + 0 + ", but observed " + dot);
        }

        // Cross product
        v = new Vec3(2, 3, 4);
        Vec3 cross = v.crossProduct(new Vec3(5, 6, 7));
        exp = new Vec3(-3, 6, -3);
        if(!cross.is(exp, 0.01))
        {
            passed = false;
            System.out.println("FAILED test of cross product.");
            System.out.println("Expected " + exp + ", but observed " + cross);
        }


        if(passed)
        {
            System.out.println("All tests passed.");
        }
    }
}
