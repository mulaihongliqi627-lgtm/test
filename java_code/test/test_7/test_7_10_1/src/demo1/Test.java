package demo1;

public class Test {
    public static void drawMap(Shape shape){
        shape.draw();
    }

    public static void main(String[] args) {
        drawMap(new Cycle());
        drawMap(new Rectangle());
    }
}
