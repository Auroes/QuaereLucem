import MathMethods.Equation;
import MathMethods.Vec;
import Room.Body.Cube;

public class Main {
    public static void main(String[] args) {
        //Lucem l = new Lucem(new Vec(0,0,0),new Vec(0,1.732,2),0, 100);
        //Panel P = new Panel(new Vec(1.06066,0.866,1.06066),new Vec(1.06066,0.866,1.06066),4,0,4);
        //System.out.println(P.ifCollide(l));
        Cube a = new Cube(new Vec(1,1,1),2,2,2);
        System.out.println(a.panel[3].normV.x());

    }
}