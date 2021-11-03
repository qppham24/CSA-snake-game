public class Snake
{
  // TODO: The Big 3
  // 1. instance variables
  private ArrayList<Box> body;
  private int direction;    // 0 = up, 1 = right, 2 = down, 3 = left
  private int timer;
  private final int MOVE_INTERVAL;
  private final int GREEN = color(0,255,0);
  private final int RED = color(255,0,0);

  // 2. constructor
  public Snake() {
      body = new ArrayList<Box>();
      body.add(new Box((float)width/2, (float)height/2, GREEN));
      direction = 0;
      MOVE_INTERVAL = 100;
      timer = 0;
  }
  
  // 3. toString() methods
  public String toString() {
      return "";
  }
  
  // TODO: The Dynamic Duo
  // 4. getters
  public int getDirection() {
      return direction;
  }
  
  public int getSize() {
      return body.size();
  }
  
  // 5. setters
  public void setDirection (int inDirection) {
      direction = inDirection;
  }
  
  // TODO: The Brain
  // 6. algorithm methods
  public void grow() {
      Box tail = body.get(body.size()-1);
      Box newTail = tail.clone();
      float shift = tail.getSideLength();
      
      if (direction == 0)
      {
        // facing up - new tail goes below tail
        newTail.setY( tail.getY() + shift ); 
      }
      else if (direction == 1)
      {
        // facing right - new tail goes to the left
        newTail.setX( tail.getX() - shift);
      }
      else if (direction == 2)
      {
        // facing down - new tail goes above tail
        newTail.setY(tail.getY() - shift);
      }
      else if (direction == 3)
      {
        // facing left - new tail goes to the right
        newTail.setX(tail.getX() + shift);
      }
      
      body.add(newTail);

  }
 
  public boolean isHeadCollidingWith(Box other) {
      return body.get(0).isCollidingWith(other);
  }
 
  public boolean isHeadCollidingWithSelf() {
      for(int i=1; i<body.size(); i++) {
        Box part = body.get(i);
        if(isHeadCollidingWith(part)) {
          return true;
        } 
      }
      return false;
  }
 
  public void draw() {
      if (millis() - timer >= MOVE_INTERVAL)
      {
        /* TODO - move body */
        for (int i=body.size()-1; i>0; i--) {
            Box current = body.get(i);
            Box previous = body.get(i-1);
            current.setX(previous.getX());
            current.setY(previous.getY());
        }
        
        /* TODO - move head */
        Box head = body.get(0);
        if (direction == 0)
        {
          // move up
          head.setY(head.getY() - 20); 
          //
        }
        else if (direction == 1)
        {
          // move right
          head.setX(head.getX() + 20);
          //
        }
        else if (direction == 2)
        {
          // move down
          head.setY(head.getY() + 20);
          //
        }
        else if (direction == 3)
        {
          // move left
          head.setX(head.getX() - 20);
          //
        }
        if (head.getY()<0) {
              head.setY(height-20);
        } else if (head.getX()>width) {
              head.setX(0);
        } else if (head.getY()>height) {
              head.setY(0);
        } else if (head.getX()<0) {
              head.setX(width-20);
        }
        timer = millis(); // reset timer 
      }

      for (Box b : body)
          b.draw();
  }

}
