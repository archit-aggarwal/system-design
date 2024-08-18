public class _09_ISP_Example_1 {
  public static void main(String[] args) {
    
  }
}

interface Shape {
  public double getPerimeter();
  public double getArea();
  public double getVolume();
}

class Rectangle implements Shape {
  public int length, breadth;

  @Override
  public double getPerimeter() {
    return 2 * (length + breadth);
  }

  @Override
  public double getArea() {
    return length * breadth;
  }

  @Override
  public double getVolume() {
    throw new UnsupportedOperationException
      ("No Volume");
  }
}

class Cuboid extends Rectangle {
  public int height;

  @Override
  public double getPerimeter() {
    return 4 * (length + breadth + height);
  }

  @Override
  public double getArea() {
    return 2 * (length * breadth + 
      breadth * height + height * length);
  }

  @Override
  public double getVolume() {
    return length * breadth * height;
  }
}


interface Shape2D {
  public double getPerimeter();
  public double getArea();
}

interface Shape3D {
  public double getVolume();
}

class Square implements Shape2D {
  int side;

  @Override
  public double getPerimeter() {
    return 4 * side;
  }

  @Override
  public double getArea() {
    return side * side;
  }
}

class Cube extends Square implements Shape3D {
  @Override
  public double getPerimeter() {
    return 12 * side;
  }

  @Override
  public double getArea() {
    return 6 * side * side;
  }

  @Override
  public double getVolume() {
    return side * side * side;
  }
}