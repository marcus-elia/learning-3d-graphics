public class Vec4
{
    public double x,y,z,w;

    public Vec4(double inputX, double inputY, double inputZ, double inputW)
    {
        x = inputX;
        y = inputY;
        z = inputZ;
        w = inputW;
    }

    // =====================================
    //
    //            Normalizing
    //
    // =====================================
    public double magnitude()
    {
        return Math.sqrt(x*x + y*y + z*z + w*w);
    }

    public void normalize()
    {
        double mag = this.magnitude();
        if(mag != 0)
        {
            this.scalarMultiply(1/mag);
        }
    }

    public void divideByW()
    {
        if(w != 0)
        {
            x = x / w;
            y = y / w;
            z = z / w;
            w = 1;
        }
    }

    // =====================================
    //
    //          Vector Operations
    //
    // =====================================

    // Multiplies the components of this by a
    public Vec4 scalarMultiply(double a)
    {
        x = x*a;
        y = y*a;
        z = z*a;
        w = w*a;
        return this;
    }

    // Adds other vector to this
    public Vec4 add(Vec4 v)
    {
        x += v.x;
        y += v.y;
        z += v.z;
        w += v.w;
        return this;
    }
    public Vec4 subtract(Vec4 v)
    {
        x -= v.x;
        y -= v.y;
        z -= v.z;
        w -= v.w;
        return this;
    }

    // Standard dot product
    public double dotProduct(Vec4 v)
    {
        return x*v.x + y*v.y + z*v.z + w*v.w;
    }

    // =====================================
    //
    //            Static methods
    //
    // =====================================
    public static Vec4 scalarMultiply(double a, Vec4 v)
    {
        return v.scalarMultiply(a);
    }

    public static Vec4 add(Vec4 v1, Vec4 v2)
    {
        return v1.add(v2);
    }

    public static Vec4 subtract(Vec4 v1, Vec4 v2)
    {
        return v1.subtract(v2);
    }

    public static double dotProduct(Vec4 v1, Vec4 v2)
    {
        return v1.dotProduct(v2);
    }

    // =====================================
    //
    //             Operators
    //
    // =====================================
    // This is an equality test
    public boolean is(double x2, double y2, double z2, double w2, double tolerance)
    {
        return Math.abs(x - x2) < tolerance &&
                Math.abs(y - y2) < tolerance &&
                Math.abs(z - z2) < tolerance &&
                Math.abs(w - w2) < tolerance;
    }
    public boolean is(Vec4 v, double tolerance)
    {
        return this.is(v.x, v.y, v.z, v.w, tolerance);
    }

    public String toString()
    {
        return "(" + x + "," + y + "," + z + "," + w + ")";
    }
}
