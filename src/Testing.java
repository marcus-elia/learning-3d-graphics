public class Testing
{
    public static void main(String[] args)
    {
        testVec3();
        testVec4();
        testMat4();
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

    public static void testVec4()
    {
        System.out.println("\nTesting the Vec4 class.");
        boolean passed = true;
        Vec4 v;
        Vec4 exp;

        v = new Vec4(2,4,6,2);
        v.divideByW();
        exp = new Vec4(1,2,3,1);
        if(!v.is(exp, 0.01))
        {
            passed = false;
            System.out.println("FAILED test of divide by w != 0.");
            System.out.println("Expected " + exp + ", but observed " + v);
        }
        v = new Vec4(2,4,6,0);
        v.divideByW();
        exp = new Vec4(2,4,6,0);
        if(!v.is(exp, 0.01))
        {
            passed = false;
            System.out.println("FAILED test of divide by w = 0.");
            System.out.println("Expected " + exp + ", but observed " + v);
        }

        if(passed)
        {
            System.out.println("All tests passed.");
        }
    }

    public static void testMat4()
    {
        System.out.println("\nTesting the Mat4 class.");
        boolean passed = true;
        Mat4 m1, m2;
        Mat4 exp;
        Vec4 v;
        Vec4 ans;

        // Left multiply
        m1 = new Mat4(new double[]{1,2,3,4,2,3,4,5,3,4,5,6,4,5,6,7});
        v = new Vec4(1,3,5,7);
        ans = new Vec4(50, 66, 82, 98);
        if(!(m1.leftMultiply(v).is(ans, 0.01)))
        {
            passed = false;
            System.out.println("FAILED left multiplying matrix by vector.");
            System.out.println("Expected " + ans + ", but observed " + m1.leftMultiply(v));
        }

        // Right multiply
        m1 = new Mat4(new double[]{1,2,3,4,2,3,4,5,3,4,5,6,4,5,6,7});
        v = new Vec4(1,3,5,7);
        ans = new Vec4(50, 66, 82, 98);
        if(!(m1.rightMultiply(v).is(ans, 0.01)))
        {
            passed = false;
            System.out.println("FAILED right multiplying matrix by vector.");
            System.out.println("Expected " + ans + ", but observed " + m1.rightMultiply(v));
        }

        // Matrix times matrix
        m1 = new Mat4(new double[]{1,2,3,4,2,3,4,5,3,4,5,6,4,5,6,7});
        m2 = new Mat4(new double[]{4,5,6,7,3,4,5,6,2,3,4,5,1,2,3,4});
        exp = new Mat4(new double[]{60,82,104,126,50,68,86,104,40,54,68,82,30,40,50,60});
        if(!(m1.multiply(m2).is(exp, 0.01)))
        {
            passed = false;
            System.out.println("FAILED multiplying generic matrices.");
            System.out.println("Expected " + exp + ", but observed " + m1.multiply(m2));
        }

        if(passed)
        {
            System.out.println("All tests passed.");
        }
    }
}
