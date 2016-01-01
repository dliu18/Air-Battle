   /*****************************************************************
    * A Base is a class that is based off of the bumper class. The base
    * knows how to return its health, set its health, calculate if an enemy
    * has hit the base, and calculate if the base has run out of health.
    * @author
    * @version
    ****************************************************************/
   import java.awt.*;
   import javax.swing.*;
   public class Base
   {
       /************************************************************* 
       * The base's is 800 pixels wide.    
       **************************************************************/
      private final int myXWidth = 800;
      /************************************************************* 
       * The base's is 50 pixels long.    
       **************************************************************/
      private final int myYWidth = 50;
      /************************************************************* 
       * The base's color.
       **************************************************************/
      private Color myColor = Color.BLACK;
      /************************************************************* 
       * The base's starting x-position is 0.
       **************************************************************/
      private final int myX = 0;
      /************************************************************* 
       * The base's starting y-position is 550.
       **************************************************************/
      private final int myY = 550;
      /************************************************************* 
       * The health of the base.
       **************************************************************/
      private int myHealth;
        /************************************************************* 
       * The base's default constructor. 
       * The base starts out with 890 health and it's color is black.        
       **************************************************************/
      public Base()      
      {
         myColor = Color.BLUE;
         myHealth = 890;
      }
      /************************************************************* 
       * Constructs a circle with initial health specified by x. The color 
       * of the base is black.
       * @param health    initial health
       **************************************************************/
      public Base(int health)
      {
         myColor = Color.BLACK;
         myHealth = health;
      }
         // accessor methods  (one for each field) 
        /*************************************************************** 
       * Returns the base's x-position
       * @return     x-position
       **************************************************************/
      public int getX() 
      { 
         return myX;
      }
      /*************************************************************** 
       * Returns the base's y-position
       * @return     y-position
       **************************************************************/
      public int getY()      
      { 
         return myY;
      }
      /*************************************************************** 
       * Returns the base's width
       * @return     width
       **************************************************************/
      public int getXWidth() 
      { 
         return myXWidth;
      }
      /*************************************************************** 
       * Returns the base's length
       * @return     length
       **************************************************************/
      public int getYWidth()      
      { 
         return myYWidth;
      }
      /*************************************************************** 
       * Returns the base's health
       * @return     health
       **************************************************************/
      public int getHealth()
      {
         return myHealth;
      }
       /*************************************************************** 
       * Returns the base's color
       * @return     color
       **************************************************************/
      public Color getColor()
      {
         return myColor;
      }
         /***************************************************************
       * Sets the health to the input number.
       * @param health     assigns health to myHealth
       **************************************************************/
      public void setHealth(int health)
      {
         myHealth = health;
      }
      /***************************************************************
       * Sets the Color to the input color.
       * @param c     assigns c to myColor
       **************************************************************/
      public void setColor(Color c)
      {
         myColor = c;
      }
        /***************************************************************
       * This method draws a rectangular base on the buffer
       * @param myBuffer     The buffer you will draw on
       **************************************************************/
      public void draw(Graphics myBuffer) 
      {
         ImageIcon superair = new ImageIcon("images/flag.jpg");
         myBuffer.drawImage(superair.getImage(), getX(), getY(), getXWidth(), getYWidth(), null);
      } 
      /***************************************************************
       * This method returns true if any part of the enemy plane is inside
       * the base. It also decreases the health when there's a hit.
       * @param myBuffer     The buffer you will draw on
       * @param matrixs    The matrix of enemies that you check for hits. 
        * @param matrix    The enemy that you check for a hit
       **************************************************************/ 
      public boolean Hit(Enemy[] matrixs, Enemy matrix, Graphics myBuffer)
      {
         for(int k = 0; k <= matrixs.length -1; k++)
         {
            if(matrix != null)
            {
               if(matrix.getY() + matrix.getYWidth() >= getY())
               {
                  setHealth(getHealth() - 1);
                  return true;
               } 
            }
         }
         return false;
      }
   	
   	
   	
   	
   	
      public int Hit2(Bullet[][] matrix)
      {
         for(int x = getX(); x <= getX() + getXWidth(); x++)   //starts at upper left corner(x,y)
            for(int y = getY(); y <= getY() + getYWidth(); y++)
               for(int z = 0; z <= matrix.length -1; z++)
               {
                  if(matrix[z][0] != null)
                     if(distance(x, y, matrix[z][0].getX(), matrix[z][0].getY()) <= matrix[z][0].getRadius()) //checks every point on the bumper
                     {
                        return z;
                     
                     }  
                  if(matrix[z][1] != null)
                     if(distance(x, y, matrix[z][1].getX(), matrix[z][1].getY()) <= matrix[z][1].getRadius())
                        return z;
               }          
         return -1;
      
      } 
   
   
   
      private double distance(double x1, double y1, double x2, double y2)
      {
         return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
      }
   
   	
   	
   	
   	
   	
   	  
      /***************************************************************
       * This method returns true if the health of the base is 0. The method
       * draw 8 explosions across the base.
       * @param myBuffer     The buffer you will draw on
       **************************************************************/ 
      public boolean Destoyed(Graphics myBuffer)
      {
         if(getHealth() <= 0)
         {
            for(int r = 0; r < 800; r+= 100)
            
            {
               ImageIcon explosion = new ImageIcon("images/explosion.jpg");
            
               myBuffer.drawImage(explosion.getImage(),r, 530, null);
            }
            return true;
         }
         else
            return false;
      }
   }