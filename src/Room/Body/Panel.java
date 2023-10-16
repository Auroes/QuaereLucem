package Room.Body;
import  MathMethods.Equation;
import  MathMethods.Vec;
import  Room.Lucem;

/** 平板类
 *  以透镜坐标系为参考
 */
public class Panel {

    /** 定义平板所在平面的法向量 该法向量上平板的基点 */
    public Vec normV;
    public Vec baseV;

    /** 定义该平面在x,y,z上投影矩形的长(x)宽(y)和高(z) */
    public double pX;
    public double pY;
    public double pZ;

    /** 定义该平面的方程 */
    public Equation panelEqu = new Equation();

    /** 构造方法 */
    public Panel(Vec normV,Vec baseV,double pX,double pY,double pZ){
        this.normV = normV;
        this.baseV = baseV;
        this.pX = pX;
        this.pY = pY;
        this.pZ = pZ;
        this.panelEqu = new Equation(this.normV,this.baseV);
    }
    /** 碰撞判断
     *  检测光线是否与平板发生碰撞
     */
    public boolean ifCollide(Lucem lucem){
        boolean ifCollide = false;

        /** 先判断光线是否与平板所在的平面平行 */
        if(Math.abs(this.normV.Dot(lucem.V)) < 0.1) {//光线的速度向量与平面的法向量垂直时则平行
            return ifCollide;//直接返回不发生碰撞
        }
        else{
            return ifCollide;
        }


       // return  ifCollide;
    }
}
