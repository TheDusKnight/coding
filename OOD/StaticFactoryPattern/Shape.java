package OOD.StaticFactoryPattern;

enum ShapeType {
    Circle,
    Triangle,
    Square
}

public abstract class Shape {
    ShapeType shapeType;

    public Shape(ShapeType shapeType) {
        this.shapeType = shapeType;
    }

    public abstract void draw(Integer p1, Integer p2);
}

class Triangle extends Shape {
    public Triangle() {
        super(ShapeType.Triangle);
    }

    @Override
    public void draw(Integer p1, Integer p2) {
        System.out.println("Draw triangle.");
    }
}

class Circle extends Shape {
    public Circle() {
        super(ShapeType.Circle);
    }

    @Override
    public void draw(Integer p1, Integer p2) {
        System.out.println("Draw circle.");
    }
}

class Square extends Shape {
    public Square() {
        super(ShapeType.Square);
    }

    @Override
    public void draw(Integer p1, Integer p2) {
        System.out.println("Draw square.");
    }
}

class DrawFactory {
    private DrawFactory() {
    }

    public static Shape getInstance(ShapeType shapeType) {
        switch (shapeType) {
            case Circle:
                return new Circle();
            case Triangle:
                return new Triangle();
            case Square:
                return new Square();
            default:
                return null;
        }
    }
}

class ClientDraw {
    public static void draw(Integer p1, Integer p2, ShapeType shapeType) {
        Shape shape = DrawFactory.getInstance(shapeType);
        shape.draw(p1, p2);
    }

    public static void main(String[] args) {
        draw(1, 2, ShapeType.Triangle);
    }
}