public class Mat4
{
    public Vec4 col0, col1, col2, col3;

    public static Mat4 identity = new Mat4(new double[]{1,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1});

    public Mat4(double[][] columns)
    {
        col0 = new Vec4(columns[0][0], columns[0][1], columns[0][2], columns[0][3]);
        col1 = new Vec4(columns[1][0], columns[1][1], columns[1][2], columns[1][3]);
        col2 = new Vec4(columns[2][0], columns[2][1], columns[2][2], columns[2][3]);
        col3 = new Vec4(columns[3][0], columns[3][1], columns[3][2], columns[3][3]);
    }
    public Mat4(double[] entries)
    {
        col0 = new Vec4(entries[0], entries[1], entries[2], entries[3]);
        col1 = new Vec4(entries[4], entries[5], entries[6], entries[7]);
        col2 = new Vec4(entries[8], entries[9], entries[10], entries[11]);
        col3 = new Vec4(entries[12], entries[13], entries[14], entries[15]);
    }
    public Mat4(Vec4 inputCol0, Vec4 inputCol1, Vec4 inputCol2, Vec4 inputCol3)
    {
        col0 = inputCol0;
        col1 = inputCol1;
        col2 = inputCol2;
        col3 = inputCol3;
    }

    // =====================================
    //
    //       Matrix-Matrix Operations
    //
    // =====================================
    public Mat4 add(Mat4 m)
    {
        col0.add(m.col0);
        col1.add(m.col1);
        col2.add(m.col2);
        col3.add(m.col3);
        return this;
    }

    public Mat4 subtract(Mat4 m)
    {
        col0.subtract(m.col0);
        col1.subtract(m.col1);
        col2.subtract(m.col2);
        col3.subtract(m.col3);
        return this;
    }


    // =====================================
    //
    //           Multiplication
    //
    // =====================================
    public Vec4 leftMultiply(Vec4 v)
    {
        return new Vec4(v.x*col0.x + v.y*col1.x + v.z*col2.x + v.w*col3.x,
                        v.x*col0.y + v.y*col1.y + v.z*col2.y + v.w*col3.y,
                        v.x*col0.z + v.y*col1.z + v.z*col2.z + v.w*col3.z,
                        v.x*col0.w + v.y*col1.w + v.z*col2.w + v.w*col3.w);
    }

    public Vec4 rightMultiply(Vec4 v)
    {
        return new Vec4(v.dotProduct(col0), v.dotProduct(col1), v.dotProduct(col2), v.dotProduct(col3));
    }

    public Mat4 multiply(Mat4 m)
    {
        return new Mat4(this.leftMultiply(m.col0), this.leftMultiply(m.col1),
                this.leftMultiply(m.col2), this.leftMultiply(m.col3));
    }

    // =====================================
    //
    //           Static Methods
    //
    // =====================================
    public static Vec4 leftMultiply(Mat4 m, Vec4 v)
    {
        return m.leftMultiply(v);
    }
    public static Vec4 rightMultiply(Mat4 m, Vec4 v)
    {
        return m.rightMultiply(v);
    }
    public static Mat4 multiply(Mat4 m1, Mat4 m2)
    {
        return m1.multiply(m2);
    }

    // =====================================
    //
    //             Operators
    //
    // =====================================
    // This is an equality test
    public boolean is(Mat4 m, double tolerance)
    {
        return col0.is(m.col0, tolerance) && col1.is(m.col1, tolerance) &&
                col2.is(m.col2, tolerance) && col3.is(m.col3, tolerance);
    }

    public String toString()
    {
        return col0.toString() + " " + col1.toString() + " " + col2.toString() + " " + col3.toString();
    }
}
