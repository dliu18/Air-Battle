import java.awt.*;
import javax.swing.*;   
public class Good extends Airplane
{
   private Bullet bullet;
     // constructors
   public Good()         //default constructor
   {
      super();
      setXWidth(45);
      setYWidth(75);
      setX(0);
      setY(460);
      setHealth(100);
   }
   public Good(int health)
   {
      super();
      setXWidth(45);
      setYWidth(75);
      setX(0);
      setY(460);
      setHealth(100);
   }
    //	 instance methods
   public boolean hit(Bullet bullet, Graphics myBuffer)
   {
      for(int x = getX(); x <= getX() + getXWidth(); x++)   //starts at upper left corner(x,y)
         for(int y = getY(); y <= getY() + getYWidth(); y++)
            if(distance(x, y, bullet.getX(), bullet.getY()) <= bullet.getRadius()) //checks every point on the bumper
            {
               setHealth(getHealth() - 10);
               ImageIcon explosion = new ImageIcon("images/explosion.jpg");
               myBuffer.drawImage(explosion.getImage(), 50, 50, null);
               return true;
            }    
      return false;
   }  
   private double distance(double x1, double y1, double x2, double y2)
   {
      return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
   }
   public void draw(Graphics myBuffer) 
   {
      ImageIcon superair = new ImageIcon("images/good.png");
      myBuffer.drawImage(superair.getImage(), getX(), getY(), getXWidth(), getYWidth(),  null);
   }
   public boolean collide(Enemy[] matrix, Graphics myBuffer)
   {
      for(int x = 0; x <= matrix.length -1; x++)
      {
         if(matrix[x] != null)
            if((matrix[x].getX() >= getX() - matrix[x].getXWidth() && matrix[x].getX() <= getX() + matrix[x].getXWidth()) && (matrix[x].getY() >= getY() - matrix[x].getYWidth() && matrix[x].getY() <= 560))
            { 
               ImageIcon explosion = new ImageIcon("images/explosion.jpg");
               myBuffer.drawImage(explosion.getImage(), getX(), 460, null);
               return true;
            }
            
      }
      return false;
      
   }
		
   public int Hit(Bullet[][] matrix)
   {
      for(int x = getX(); x <= getX() + getXWidth(); x++)   //starts at upper left corner(x,y)
         for(int y = getY(); y <= getY() + getYWidth(); y++)
            for(int z = 0; z <= matrix.length -1; z++)
            {
               if(matrix[z][0] != null)
                  if(distance(x, y, matrix[z][0].getX(), matrix[z][0].getY()) <= matrix[z][0].getRadius() ) //checks every point on the bumper
                  {
                     return z;
                  }   
               if(matrix[z][1] != null)
                  if(distance(x, y, matrix[z][1].getX(), matrix[z][1].getY()) <= matrix[z][1].getRadius())
                     return z;
            	
            }         
      return -1;
      
   } 
}

