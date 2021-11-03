public class Box
{
  // TODO: The Big 3
  // 1. instance variables
  private float x;
  private float y;
  private float sideLength;
  private int bgColor;
  
  // 2. constructor
  public Box(float initX, float initY, int initBgColor) {
      x = initX;
      y = initY;
      bgColor = initBgColor;
      sideLength = 20;
  }
  
  // 3. toString() methods
  public String toString() {
      return "(" + x + ", " + y + ")";
  }
  
  // TODO: The Dynamic Duo
  // 4. getters
  public float getX() {
      return x;
  }
  
  public float getY() {
      return y;
  }
  
  public float getSideLength() {
      return sideLength;
  }
  
  public int getBgColor() {
      return bgColor;
  }
  
  public float getCentroidX() {
      return x+(sideLength/2);
  }
  
  public float getCentroidY() {
      return y+(sideLength/2);
  }
  
  // 5. setters
  public void setX(float inX) {
      x = inX;
  }
  
  public void setY(float inY) {
      y = inY;
  }
  
  public void setRandomPosition() {
      x = (int) (Math.random() * width);
      y = (int) (Math.random() * height);
  }
  
  // TODO: The Brain
  // 6. algorithm methods
  public Box clone() {
      return new Box(this.getX(), this.getY(), this.getBgColor());
  }
  
  public void draw() {
    fill(bgColor);
    square(x,y,sideLength);
  }

  public boolean isCollidingWith(Box other) {  
    float deltaX = Math.abs(this.getCentroidX() - other.getCentroidX());
    float deltaY = Math.abs(this.getCentroidY() - other.getCentroidY());
    if (deltaX<sideLength && deltaY<sideLength) {
      return true;
    } else {
      return false;
    }
  }

}
