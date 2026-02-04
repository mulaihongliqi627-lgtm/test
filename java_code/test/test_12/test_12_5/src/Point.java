public class Point {
    private double x;
    private double y;
    Point(double x , double y){
        this.x = x;
        this.y = y;
    }
    //1.直接传入对应点左边
    public static Point buildFactoryPoint1(double x, double y){
        Point point = new Point(x,y);//调用自身构造器
        return point;
    }
    //2.使用极坐标方式创建点
    public static Point buildFactoryPoint2(double r,double a){
        //x = r * cos α
        //y = r * sin α
        double x = r * Math.cos(a);
        double y = r * Math.sin(a);
        Point point = new Point(x,y);
        return point;
    }
    @Override
    public String toString() {
        return String.format("x = %.2f,y = %.2f",this.x,this.y);
    }
    public static void main(String[] args) {
        Point point1 = buildFactoryPoint1(1,2);
        Point point2 = buildFactoryPoint2(10,Math.toRadians(30));//半径10，角度30
        System.out.println(point1);
        System.out.println(point2);
    }
}
