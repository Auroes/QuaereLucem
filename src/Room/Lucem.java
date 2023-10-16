package Room;

import MathMethods.Vec;

/** 光线方程 L=O+V*t O为光源点 V为单位化的速度向量 t为时间变量 L为t时刻光子的位置
 *  单个光子所携带的能量为E 其范围为[0,100]
 */
public class Lucem {
    public Vec O;
    public Vec V;
    public double t;
    public byte E;

    /** 构造函数 */
    public Lucem(Vec O,Vec V,double t,byte E){
        this.O = O;
        this.V = V;
        this.t = t;
        this.E = E;
    }
    public Lucem(){}
    /** 返回t时刻光子的位置 */
    public Vec getL(double t){
        return O.Plus(V.nMulti(t));
    }
}
