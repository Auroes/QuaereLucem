import MathMethods.Vec;
import static MathMethods.CoorTrans.lensToWin;
import static MathMethods.CoorTrans.winToLens;

public class Main {
    public static void main(String[] args) {
        Vec x = winToLens(new Vec(1000,2000,3000));
        System.out.println(x.x()+"\n"+x.y()+"\n"+x.z());
    }
}