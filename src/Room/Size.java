package Room;
import MathMethods.Vec;

public class Size {

    /** 定义空间的进深（物距），宽和高 */
    public static final double D  = 8_000;
    public static final double rW = 3_000;
    public static final double rH = 4_000;

    /** 定义窗户到墙角水平和纵向距离 */
    public static final double wH  = 1_500;
    public static final double wW =    500;

    /** 定义眼睛的像距，焦距和瞳孔大小 */
    public static final double d   = 25;
    public static final double f   = 20;//17-23
    public static final double iso = 5; //2-8

    /** 定义视网膜的长和宽 */
    public static final double eW  = 16;
    public static final double eH  = 9;

    /** 以透镜坐标为参考 各坐标原点的位置 */
    public  static final Vec oLens = new Vec(0,0,0);
    public  static final Vec oWin  = new Vec(Size.rW/2,-(Size.rH/2),Size.D);
    public  static final Vec oEye  = new Vec(-(Size.eW/2),-(Size.eH/2), -Size.d);
}
