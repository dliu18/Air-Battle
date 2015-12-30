   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.awt.image.*;
   public class Enemy extends Airplane
   {
      private int myX;   // x and y coordinates of center
      private int myY;
      private int myXWidth;
      private int myYWidth;  
      private int myHealth;
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
         myXWidth = 50;
         myYWidth = 89;
         myX = x;
         myY = y;
         myHealth = 100;
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
    //	 instance methods
           private double distance(double x1, double y1, double x2, double y2)
      {
         return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
      }
      public void shoot(Graphics myBuffer)
      {
    
         for(int x = 0; x <= array.length - 1; x++)
         {
            if(array[x] == null)
            {
               array[x] = new Bullet(getX(), getY());
               return;
            }
         } 
      
      }
      public void draw(Graphics  myBuffer) 
      {
         ImageIcon superair = new ImageIcon("enemy.png");
         myBuffer.drawImage(superair.getImage(), getX(), getY(), getXWidth(), getYWidth(), null);
      }
   	
   }