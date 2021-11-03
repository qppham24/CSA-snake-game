private Snake snake;
private Box food;
private final int RED = color(255, 0, 0);
private boolean gameIsOver = false;

public void setup()
{
  size(300, 300);
  snake = new Snake();

  // TODO: uncomment after implementing Box
  food = new Box(0, 0, RED);
  food.setRandomPosition();
}

public void draw()
{
  background(0);
  
  if (!gameIsOver)
  {
    fill(255);
    textSize(12);
    textAlign(LEFT);
    // TODO: uncomment after implementing snake.getSize()
    text("Score: " + snake.getSize(), 5, 10);
  
    // TODO: uncomment after implementing food.draw()
    food.draw();
    // TODO: uncomment after implementing snake.draw()
    snake.draw();
    
    // TODO
    if (snake.isHeadCollidingWith(food))
    {
        food.setRandomPosition();
        snake.grow();
    }
    
    // TODO
    if (snake.isHeadCollidingWithSelf())
    {
        gameIsOver = true;
    }
  }
  else
  {
    fill(255);
    textAlign(CENTER);
    textSize(32);
    // TODO: uncomment after implement snake.getSize()
    text("GAME OVER\nSCORE: " + snake.getSize(), width / 2, height / 2);
  }
}

public void keyPressed(KeyEvent event)
{
  int kc = event.getKeyCode();
  
  if (gameIsOver)
  {
    resetGame();
  }
  
  if (kc == UP)
  {
    // TODO: uncomment after implementing snake.setDirection()
    snake.setDirection(0);
  }
  else if (kc == LEFT)
  {
    // TODO: uncomment after implementing snake.setDirection()
    snake.setDirection(3);
  }
  else if (kc == RIGHT)
  {
    // TODO: uncomment after implementing snake.setDirection()
    snake.setDirection(1);
  }
  else if (kc == DOWN)
  {
    // TODO: uncomment after implementing snake.setDirection()
    snake.setDirection(2);
  }
}

public void resetGame()
{
  // TODO
  snake = new Snake();
  food.setRandomPosition();
  gameIsOver = false;
}
