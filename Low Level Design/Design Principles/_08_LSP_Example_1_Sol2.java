// Note: Run the code with -ea argument to get Assertion Errors
public class _08_LSP_Example_1_Sol2 {
  public static void main(String[] args){
    int height = 10, width = 20;
    Rectangle r1 = new Rectangle();
    r1.setHeight(height);
    r1.setWidth(width);
    assert(height * width == r1.getArea());
    System.out.println("Area : " + r1.getArea());

    int side = 30;
    Square r2 = new Square();
    r2.setSide(side);
    assert(side * side == r2.getArea());
    System.out.println("Area : " + r2.getArea());
  }
}

interface Shape {
  public abstract int getArea();
}

class Rectangle implements Shape{
  private int width;
  private int height;

  public void setWidth(int width) 
   { this.width = width; }

  public void setHeight(int height) 
   { this.height = height; }

  @Override
  public int getArea() 
   { return width * height; }
}

class Square implements Shape {
  private Rectangle rect = new Rectangle();

  public void setSide(int side){
    rect.setHeight(side);
    rect.setWidth(side);
  }

  @Override
  public int getArea() 
   { return rect.getArea(); }
}
