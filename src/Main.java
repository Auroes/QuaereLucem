import MathMethods.Equation;
import MathMethods.Vec;
import Room.Body.Panel;

import java.util.Arrays;

import static MathMethods.CoorTrans.*;

public class Main {
    public static void main(String[] args) {
        Panel a = new Panel(new Vec(1,-2,3),new Vec(2,-3,0),2,2,2);
        double[] b= a.panelEqu.getEqu();
        System.out.println(Arrays.toString(a.normV.getVec()));
        System.out.println(a.panelEqu.a);//10
        System.out.println(a.panelEqu.d);
       // System.out.println(a.a+"\n"+a.b+"\n"+a.c+"\n"+a.d);
        System.out.println(" "+b[0]+" "+b[1]+" "+b[2]+" "+b[3]);
    }
}