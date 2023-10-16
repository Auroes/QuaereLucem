package MathMethods;
import  MathMethods.Vec;
import  Room.Lucem;

/** 几何方程类 */
public class Equation {

    /** 标准方程形式 ax+by+cz+d=0 */
    public double a,b,c,d;
    public double[] abcdEqu = new double[4];


        /* 构造函数 */
        /** 直线一般方程 F=ax+by+cz */
        public Equation(double F, double a, double b, double c){
        }

        /** 直线两点方程 O+V*t*/
        public Equation(){
        }

        /** 平面点法式方程 A(x-x0)+B(y-y0)+C(z-z0)=0 normV(A,B,C) baseV(x0,y0,z0) */
        public Equation(Vec normV,Vec baseV){
            this.a = normV.x();
            this.b = normV.y();
            this.c = normV.z();
            this.d = -normV.Dot(baseV);
            this.abcdEqu[0] = a;
            this.abcdEqu[1] = b;
            this.abcdEqu[2] = c;
            this.abcdEqu[3] = d;
        }

    /** 返回标准方程的系数a,b,c,d */
    public double[] getEqu(){
        return this.abcdEqu;
    }

    /** 联立求解该方程与输入光线参数的方程 */
    public double[] simSolut(Lucem lucem){
        double[] Solution = new double[4];
        double newLt = -(a*lucem.O.x() + b*lucem.O.y() + c*lucem.O.z() + d)/(a*lucem.V.x() + b*lucem.V.y() + c*lucem.V.z());
        Solution[0] = lucem.O.x() + lucem.V.x()*newLt;
        Solution[1] = lucem.O.y() + lucem.V.y()*newLt;
        Solution[2] = lucem.O.z() + lucem.V.z()*newLt;
        Solution[3] = newLt;
        for (int i = 0; i < 4; i++) {
            System.out.println(Solution[i]);
        }
        return Solution;
    }

}
