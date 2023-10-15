package MathMethods;
import static Room.Size.*;

public class CoorTrans {

    /** 透镜坐标转窗坐标 */
    public static Vec lensToWin(Vec lensCoor){
        return lensCoor.Minus(oWin.Minus(oLens));
    }
    /** 窗坐标转透镜坐标 */
    public static Vec winToLens(Vec winCoor){
        return winCoor.Plus(oWin.Minus(oLens));
    }
    /** 透镜坐标转柱坐标 */
    public static Vec lensToCylin(Vec lensCoor){
        double r = Math.sqrt(lensCoor.x()*lensCoor.x()+lensCoor.y()*lensCoor.y());
        double θ = Math.atan2(lensCoor.y(),lensCoor.x());
        if (θ < 0) { θ = 2 * Math.PI + θ;}
        return new Vec(r,θ,lensCoor.z());
    }
    /** 柱坐标转透镜坐标 */
    public static Vec cylinToLens(Vec cylinCoor){
        double θ = cylinCoor.y();
        double x = cylinCoor.x() * Math.cos(θ);
        double y = cylinCoor.x() * Math.sin(θ);
        return new Vec(x,y, cylinCoor.z());
    }
    /** 透镜坐标转眼坐标 */
    public static Vec lensToEye(Vec lensCoor){
        return lensCoor.Minus(oEye.Minus(oLens));
    }
    /** 黄斑坐标转眼坐标 */
    public static Vec eyeToLens(Vec eyeCoor){
        return eyeCoor.Plus(oEye.Minus(oLens));
    }
}
