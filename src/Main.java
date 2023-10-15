import MathMethods.Vec;
import static MathMethods.CoorTrans.*;

public class Main {
    public static void main(String[] args) {
        Vec x = winToLens(new Vec(0,0,0));
        System.out.println(x.x()+"\n"+x.y()+"\n"+x.z());
    }
}