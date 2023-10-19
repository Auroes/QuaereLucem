package Stock.Shape;
import  MathMethods.Equation;
import  MathMethods.Vec;
import  Room.Lucem;

/** 球体类 以透镜坐标系为参考 */
public class Ball extends zeroShape {

    public Vec centerV;//球心
    public Vec normV;  //法向量
    public double gR;  //半径
    public Equation globeEqu = new Equation();//定义该球体方程

    /** 构造方法 */
    public Ball(Vec CenterV, Vec normV, double gR){
        this.centerV = CenterV;
        this.normV   = normV;
        this.gR      = gR;
        this.globeEqu = new Equation(this.centerV,this.normV);
    }

    /** 碰撞判断
     *  检测光线是否与球体发生碰撞 */
    public boolean ifCollide(Lucem lucem){
        boolean ifCollide = false;


        return  ifCollide;
    }
}
