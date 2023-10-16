package Room.Body;
import  MathMethods.Vec;

/** 平板类
 *  以透镜坐标系为参考
 */
public class Panel {

    /** 定义平板所在平面的法向量 */
    public Vec normV;

    /** 定义该法向量上平板的基点 */
    public Vec baseV;

    /** 定义该平面在x,y,z上投影矩形的长(x)宽(y)和高(z) */
    public double pX;
    public double pY;
    public double pZ;

    /** 构造方法 */
    public Panel(Vec normV,Vec baseV,double pX,double pY,double pZ){
        this.normV = normV;
        this.baseV = baseV;
        this.pZ = pZ;
    }
}
