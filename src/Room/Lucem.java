package Room;
import  MathMethods.Vec;

/** 光线方程 L=O+V*t O为光源点 V为单位化的速度向量 t为时间变量 L为t时刻光子的位置
 *  单个光子所携带的能量为E 其范围为[0,100] */
public class Lucem {
    final double C = 299_792_458;//标准真空光速 m/s
    public Vec O;//初始位置
    public Vec D;//单位方向向量
    public double t = 0;//单位时间
    public double L;//末位置
    public double V;//当前光速
    public double f;//光的频率 决定颜色 750_374.74 THz
    public double waveL;//当前波长 400_800 nm
    public int id = 0;//光所在介质类型 初始化为空气（真空）

    /** 构造函数 */
    public Lucem(Vec O,Vec D,double t,double f,double waveL,int id){
        this.O = O;
        this.D = D;
        this.t = t;
        this.f = f;
        this.waveL = waveL;
        this.id = id;
    }
    public Lucem(){}
    /** 返回t时刻光子的位置 */
    public Vec getL(double t){
        return O.Plus(D.nMulti(t));
    }
}
