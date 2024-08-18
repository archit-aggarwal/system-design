// Note: Run the code with -ea argument to get Assertion Errors
public class _08_LSP_Example_1_Problem {
  public static void main(String[] args){
    int height = 10, width = 20;

    Rectangle r1 = rectangleFactory();
    r1.setHeight(height);
    r1.setWidth(width);
    assert(height * width == r1.getArea());
    System.out.println("Area : " + r1.getArea());

    Rectangle r2 = rectangleFactory();
    r2.setHeight(height);
    r2.setWidth(width);
    assert(height * width == r2.getArea());
    System.out.println("Area : " + r2.getArea());
  }

  static int requestCount = 0;

  public static Rectangle rectangleFactory(){
    if(requestCount++ % 2 == 0) return new Rectangle();
    else return new Square();
  }
}

class Rectangle {
  private int width;
  private int height;

  Rectangle() {}
  Rectangle(int width, int height){
    this.height = height;
    this.width = width;
  }

  public void setWidth(int width) 
   { this.width = width; }

  public void setHeight(int height) 
   { this.height = height; }

  public int getArea() 
   { return width * height; }
}

class Square extends Rectangle {
  Square() {}
  Square(int side){
    super(side, side);
  }

  @Override
  public void setWidth(int width) {
      super.setWidth(width);
      super.setHeight(width); // Violates LSP
  }

  @Override
  public void setHeight(int height) {
      super.setHeight(height); 
      super.setWidth(height); // Violates LSP
  }
}
