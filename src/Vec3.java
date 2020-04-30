// This class is a vector of doubles with 3 components (x, y, z).
// x, y, and z are public, so this functions as a struct.

public class Vec3
{
    public double x,y,z;

    public Vec3(double inputX, double inputY, double inputZ)
    {
        x = inputX;
        y = inputY;
        z = inputZ;
    }

    // =====================================
    //
    //            Normalizing
    //
    // =====================================
    public double magnitude()
    {
        return Math.sqrt(x*x + y*y + z*z);
    }

    public void normalize()
    {
        double mag = this.magnitude();
        if(mag != 0)
        {
            this.scalarMultiply(1/mag);
        }
    }


    // =====================================
    //
    //          Vector Operations
    //
    // =====================================

    // Multiplies the components of this by a
    public Vec3 scalarMultiply(double a)
    {
        x = x*a;
        y = y*a;
        z = z*a;
        return this;
    }

    // Adds other vector to this
    public Vec3 add(Vec3 v)
    {
        x += v.x;
        y += v.y;
        z += v.z;
        return this;
    }
    public Vec3 subtract(Vec3 v)
    {
        x -= v.x;
        y -= v.y;
        z -= v.z;
        return this;
    }

    // Standard dot product
    public double dotProduct(Vec3 v)
    {
        return x*v.x + y*v.y + z*v.z;
    }

    public Vec3 crossProduct(Vec3 v)
    {
        return new Vec3(y*v.z - v.y*z, v.x*z - x*v.z, x*v.y - v.x*y);
    }


    // =====================================
    //
    //            Static methods
    //
    // =====================================
    public static Vec3 scalarMultiply(double a, Vec3 v)
    {
        return v.scalarMultiply(a);
    }

    public static Vec3 add(Vec3 v1, Vec3 v2)
    {
        return v1.add(v2);
    }

    public static Vec3 subtract(Vec3 v1, Vec3 v2)
    {
        return v1.subtract(v2);
    }

    public static double dotProduct(Vec3 v1, Vec3 v2)
    {
        return v1.dotProduct(v2);
    }

    public static Vec3 crossProduct(Vec3 v1, Vec3 v2)
    {
        return v1.crossProduct(v2);
    }

    // =====================================
    //
    //             Operators
    //
    // =====================================
    // This is an equality test
    public boolean is(double x2, double y2, double z2)
    {
        return x == x2 && y == y2 && z == z2;
    }
    public boolean is(Vec3 v)
    {
        return this.is(v.x, v.y, v.z);
    }

    public String toString()
    {
        return "(" + x + "," + y + "," + z + ")";
    }
}
