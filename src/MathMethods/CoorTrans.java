package MathMethods;
import static Room.Size.oLens;
import static Room.Size.oWin;

public class CoorTrans {

    public static Vec lensToWin(Vec lensCoor){
        return lensCoor.Plus(oWin.Minus(oLens));
    }
    public static Vec winToLens(Vec winCoor){
        return winCoor.Minus(oWin.Minus(oLens));
    }
    public static Vec winToCylin(Vec lensCoor){
        Vec winCoor = new Vec();
        return winCoor;
    }
    public static Vec cylinToWin(Vec lensCoor){
        Vec winCoor = new Vec();
        return winCoor;
    }
    public static Vec eyeToWin(Vec lensCoor){
        Vec winCoor = new Vec();
        return winCoor;
    }
    public static Vec winToEye(Vec lensCoor){
        Vec winCoor = new Vec();
        return winCoor;
    }
}
