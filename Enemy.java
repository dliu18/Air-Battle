import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
public class Enemy extends Airplane
{
   private Bullet[] array;
  // constructors
   public Enemy()         //default constructor
   {
      super();
      setXWidth(50);
      setYWidth(89);
      setX((int)(Math.random() * 17));
      setY(getYWidth() * -1);
      setHealth(100);
   }
   public Enemy(int health)
   {
      super();
      setXWidth(50);
      setYWidth(89);
      setX((int)(Math.random() * 17));
      setY(getYWidth() * -1);
      setHealth(health);
   }
   public Enemy(int x, int y)
   {
      setXWidth(50);
      setYWidth(89);
      setX(x);
      setY(y);
      setHealth(100);
   }
	
	
     //	 instance methods

   public void draw(Graphics  myBuffer) 
   {
      ImageIcon superair = new ImageIcon("images/enemy.png");
      myBuffer.drawImage(superair.getImage(), getX(), getY(), getXWidth(), getYWidth(), null);
   }
	
}