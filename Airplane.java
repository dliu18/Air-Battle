import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
public class Airplane
{
   private int myX;   // x and y coordinates of center
   private int myY;
   private int myXWidth;
   private int myYWidth;  
   private int myHealth;
  // constructors
   public Airplane()         //default constructor
   {
      myXWidth = 40;
      myYWidth = 76;
      myX = (int)(Math.random() * 17);
      myY = 0;
      myHealth = 100;
   }
   public Airplane(int health)
   {
      myXWidth = 80;
      myYWidth = 146;
      myX = (int)(Math.random() * 17);
      myY = 0;
      myHealth = health;
   }
   public Airplane(int x, int y, int health)
   {
      myXWidth = 84;
      myYWidth = 150;
      myX = x;
      myY = y;
      myHealth = health;
   }
 // accessor methods
   public int getX() 
   { 
      return myX;
   }
   public int getY()      
   { 
      return myY;
   }
   public int getXWidth() 
   { 
      return myXWidth;
   }
   public int getYWidth()      
   { 
      return myYWidth;
   }
   public int getHealth()
   {
      return myHealth;
   }
     	
// modifier methods
   public void setX(int x)
   {
      myX = x;
   } 
   public void setY(int y)
   {
      myY = y;
   } 
   public void setYWidth(int yWidth)
   {
      myYWidth = yWidth; 
   }
   public void setXWidth(int xWidth)
   {
      myXWidth = xWidth;
   }
   public void setHealth(int health)
   {
      myHealth = health;
   }
	
 //	 instance methods
 
   public int Hit(Bullet[] array)
   {
      for(int z = 0; z <= array.length -1; z++)
         if(array[z] != null)
            if((myX <= array[z].getX()) && (array[z].getX() <= myX + myXWidth) && (myY <= array[z].getY()) && (array[z].getY() <= myY + myYWidth)) //checks every point on the bumper
            {
               System.out.println("-----------" + z);
               return z;
            }            
      return -1;
      
   } 

   public void draw(Graphics  myBuffer) 
   {
      ImageIcon superair = new ImageIcon("images/enemy.jpg");
      myBuffer.drawImage(superair.getImage(), getX(), getY(), null);
   }
	
}