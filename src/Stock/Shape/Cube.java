package Stock.Shape;
import  MathMethods.Vec;

public class Cube extends zeroShape {
    /** 定义面板数组储存立方体的六个面 */
    public Flat[] flat = new Flat[6];
    double halfCX, halfCY, halfCZ;
    /** 构造方法 以透镜坐标系为参考 */
    public Cube(Vec centerV,double cX,double cY,double cZ){
        halfCX = cX / 2;
        halfCY = cY / 2;
        halfCZ = cZ / 2;
        setPanel(0, centerV, new Vec(0 ,0 ,1 ), cX, cY, 0); // front
        setPanel(1, centerV, new Vec(0 ,0 ,-1), cX, cY, 0); // rear
        setPanel(2, centerV, new Vec(1 ,0 ,0 ), 0, cY, cZ); // left
        setPanel(3, centerV, new Vec(-1,0 ,0 ), 0, cY, cZ); // right
        setPanel(4, centerV, new Vec(0 ,1 ,0 ), cX, 0, cZ); // up
        setPanel(5, centerV, new Vec(0 ,-1,0 ), cX, 0, cZ); // down
        }
    /** 立方体面的构造方法 */
    public void setPanel(int i, Vec centerV, Vec normV, double pX, double pY, double pZ) {
        /** 以法向量为参数构建平板 */
        for (int n = 0; n < 6; n++) {
            flat[i] = new Flat();}
        this.flat[i].normV = normV;
        /** 参考法向量和立方体中心设立各面中心 */
        this.flat[i].baseV = centerV.Plus(new Vec(normV.x() * halfCX, normV.y() * halfCY, normV.z() * halfCZ));
        this.flat[i].pX = pX;
        this.flat[i].pY = pY;
        this.flat[i].pZ = pZ;
    }
}