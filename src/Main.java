import MathMethods.Equation;
import MathMethods.Vec;
import Room.Body.Panel;
import Room.Lucem;

import java.util.Arrays;

import static MathMethods.CoorTrans.*;

public class Main {
    public static void main(String[] args) {
        Lucem l = new Lucem(new Vec(0,0,0),new Vec(0,1.732,2),0, 100);
        Panel P = new Panel(new Vec(1.06066,0.866,1.06066),new Vec(1.06066,0.866,1.06066),4,0,4);
        System.out.println(P.ifCollide(l));



    }
}