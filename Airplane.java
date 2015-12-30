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
      private Bullet[] array;
     // constructors
      public Airplane()         //default constructor
      {
         myXWidth = 40;
         myYWidth = 76;
         myX = (int)(Math.random() * 17);
         myY = 0;
         myHealth = 100;
         array = new Bullet[1000];
      }
      public Airplane(int health)
      {
         myXWidth = 80;
         myYWidth = 146;
         myX = (int)(Math.random() * 17);
         myY = 0;
         myHealth = health;
         array = new Bullet[1000];
      }
      public Airplane(int x, int y, int health)
      {
         myXWidth = 84;
         myYWidth = 150;
         myX = x;
         myY = y;
         myHealth = health;
         array = new Bullet[Integer.MAX_VALUE];
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
      public Bullet[] getArray()
      {
         return array;
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
		public void setArray(Bullet[] matrix)
		{
		array = matrix;
		}
		
    //	 instance methods
 
      private double distance(double x1, double y1, double x2, double y2)
      {
         return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
      }
      public void shoot(Graphics myBuffer )
      {
      
         for(int x = 0; x <= array.length - 1; x++)
         {
            if(array[x] == null)
            {
               array[x] = new Bullet(getX(), 460);
               return;
            }
         } 
      
      }
		 public int Hit(Bullet[] array)
      {
         for(int x = getX(); x <= getX() + getXWidth(); x++)   //starts at upper left corner(x,y)
            for(int y = getY(); y <= getY() + getYWidth(); y++)
               for(int z = 0; z <= array.length -1; z++)
                  if(array[z] != null)
                     if(distance(x, y, array[z].getX(), array[z].getY()) <= array[z].getRadius() ) //checks every point on the bumper
                     {
                        return z;
                     }            
         return -1;
      
      } 

      public void draw(Graphics  myBuffer) 
      {
         ImageIcon superair = new ImageIcon("enemy.jpg");
         myBuffer.drawImage(superair.getImage(), getX(), getY(), null);
      }
   	
   }