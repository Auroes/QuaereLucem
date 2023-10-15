package MathMethods;

public class Vec {

    /** 定义向量坐标 */
    public double[] v = new double[3];

    /** 构造函数 */
    public Vec(){ v[0] = 0;v[1] = 0;v[2] = 0;}
    public Vec(double x,double y,double z){
        v[0] = x;
        v[1] = y;
        v[2] = z;
    }
    /** 获取三维坐标中任意维度的索引 返回对应坐标的值 */
    public double x(){
        return v[0];
    }
    public double y(){
        return v[1];
    }
    public double z(){
        return v[2];
    }

    /** 向量求和 */
    public Vec Plus(Vec a, Vec b){
        return new Vec(a.v[0] + b.v[0],a.v[1] + b.v[1],a.v[2] + b.v[2]);
    }
    public Vec Plus(Vec A)
    {
        return new Vec(v[0] + A.v[0], v[1] + A.v[1], v[2] + A.v[2]);
    }

    /** 向量做差 */
    public Vec Minus(Vec a, Vec b){
        return new Vec(a.v[0]-b.v[0],a.v[1]-b.v[1],a.v[2]-b.v[2]);
    }
    public Vec Minus(Vec A){
        return new Vec(v[0]-A.v[0],v[1]-A.v[1],v[2]-A.v[2]);
    }

    /** 向量相乘 */
    public Vec vMulti(Vec a,Vec b){
        return new Vec(a.v[0]*b.v[0],a.v[1]*b.v[1],a.v[2]*b.v[2]);
    }
    public Vec vMulti(Vec a){
        return new Vec(v[0]*a.v[0],v[1]*a.v[1],v[2]*a.v[2]);
    }

    /** 向量数乘 */
    public Vec nMulti(Vec a, double n){
        return new Vec(a.v[0]*n,a.v[1]*n,a.v[2]*n);
    }
    public Vec nMulti(double n){
        return new Vec(v[0]*n,v[1]*n,v[2]*n );
    }

    /** 向量的模长 */
    public double Length(){
        return (double)Math.sqrt(Math.pow((double)v[0],2)+Math.pow((double)v[1],2)+Math.pow((double)v[2],2));
    }
    /** 向量模长的平方 */
    public double Length2(){
        return (double)(Math.pow((double)v[0],2)+Math.pow((double)v[1],2)+Math.pow((double)v[2],2));
    }
    /** 向量单位化 */
    public Vec Unit(Vec a){
        double Model = a.Length();
        return new Vec(a.x()/Model,a.y()/Model,a.z()/Model);
    }
    public Vec Unit(){
        double Model = this.Length();
        return new Vec(v[0]/Model,v[1]/Model,v[2]/Model);
    }
    /** 向量的点乘 */
    public double Dot(Vec a,Vec b){
        return (a.x() * b.x() + a.y() * b.y() + a.z() * b.z());
    }
    public double Dot(Vec a)
    {
        return (v[0]* a.v[0] + v[1] * a.v[1] + v[2] * a.v[2]);
    }

    /** 向量的叉乘 */
    public Vec Cross(Vec a, Vec b){
        return new Vec(a.y()*b.z()-a.z()*b.y(),a.z()*b.x()-a.x()*b.z(),a.x()*b.y()-a.y()*b.x());
    }
    public Vec Cross(Vec a){
        return new Vec(v[1]*a.z()-v[2]*a.y(),v[2]*a.x()-v[0]*a.z(),v[0]*a.y()-v[1]*a.x());
    }
}
