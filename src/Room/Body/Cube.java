package Room.Body;
import  MathMethods.Vec;

public class Cube {
    /** 定义立方体的四个面 */
    public Panel front = new Panel(new Vec(0,0,1));
    public Panel rear  = new Panel(new Vec(0,0,1));
    public Panel left  = new Panel(new Vec(1,0,0));
    public Panel right = new Panel(new Vec(1,0,0));
    public Panel up    = new Panel(new Vec(0,1,0));
    public Panel down  = new Panel(new Vec(0,1,0));
    /** 构造函数 以透镜坐标系为参考 */
    public Cube(Vec centerV,double cX,double cY,double cZ){
        front.baseV = centerV.Minus(new Vec(0,0,cZ/2));
        rear.baseV  = centerV.Plus (new Vec(0,0,cZ/2));
        left.baseV  = centerV.Minus(new Vec(cX/2,0,0));
        right.baseV = centerV.Plus (new Vec(cX/2,0,0));
        up.baseV    = centerV.Plus (new Vec(0,0,cY/2));
        down.baseV  = centerV.Plus (new Vec(0,0,cY/2));
        front.pX = cX;
        front.pY = cY;
        front.pZ = 0;
        rear.pX  = cX;
        rear.pY  = cY;
        rear.pZ  = 0;
        left.pX  = 0;
        left.pY  = cY;
        left.pZ  = cZ;
        right.pX = 0;
        right.pY = cY;
        right.pZ = cZ;
        up.pX    = cX;
        up.pY    = 0;
        up.pZ    = cZ;
        down.pX  = cX;
        down.pY  = 0;
        down.pZ  = cZ;
    }
}
