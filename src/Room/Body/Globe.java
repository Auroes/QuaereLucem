package Room.Body;
import  MathMethods.Equation;
import  MathMethods.Vec;
import  Room.Lucem;

/** 球体类 以透镜坐标系为参考 */
public class Globe {

    /** 定义球体的球心 球体的法向量 */
    public Vec centerV;
    public Vec normV;
    /** 定义球体半径 */
    public double gR;
    /** 定义该球体的方程 */
    public Equation globeEqu = new Equation();

    /** 构造方法 */
    public Globe(Vec CenterV,Vec normV,double gR){
        this.centerV = CenterV;
        this.normV   = normV;
        this.gR      = gR;
        this.globeEqu = new Equation(this.centerV,this.normV);
    }

    /** 碰撞判断
     *  检测光线是否与平板发生碰撞 */
    public boolean ifCollide(Lucem lucem){
        boolean ifCollide = false;

        return  ifCollide;
    }
}
