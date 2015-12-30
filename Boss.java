   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.awt.image.*;
	
   public class Boss
   {
      private int myX;   // x and y coordinates of center
      private int myY;
      private int myXWidth;
      private int myYWidth;  
      private int myHealth;
      private double dx;
      private final double dy = 5.0;
      private Bullet[][] matrix = new Bullet[200][2];;
   
      public Boss()
      {
         myX = 300;
         myY = 0;
         myXWidth = 200;
         myYWidth = 125;
         myHealth = 1500;

      }
   	
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
      public Bullet[][] getMatrix()
      {
         return matrix;
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
      public void setMatrix(Bullet[][] array)
      {
         matrix = array;
      }
   	
      private double distance(double x1, double y1, double x2, double y2)
      {
         return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
      }
      public void draw(Graphics  myBuffer) 
      {
         ImageIcon superair = new ImageIcon("boss.png");
         myBuffer.drawImage(superair.getImage(), 300, 0, null);
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
   	
      public void shoot()
      {
         for(int x = 0; x <= matrix.length -1; x++)
         {
            if(matrix[x][0] == null && matrix[x][1] == null)
            {
               matrix[x][0] = new Bullet(350, 100);
               matrix[x][1] = new Bullet(450, 100);
               matrix[x][0].setdy(dy);
               matrix[x][1].setdx(Math.random() * 2.8);
               matrix[x][1].setdy(dy);
               matrix[x][0].setdx( matrix[x][1].getdx());
               return;
            
            
            }
         }
      
      }
      
   	public void fire(Graphics myBuffer)
   	{
   	for(int x = 0; x <= matrix.length -1; x++)
   	{
   	if(matrix[x][0] != null)
   	{
   	matrix[x][0].setX(matrix[x][0].getX() - matrix[x][0].getdx() );
   	matrix[x][1].setX(matrix[x][1].getX() + matrix[x][1].getdx());
   	matrix[x][0].setY(5+ matrix[x][0].getY());
   	matrix[x][1].setY(5 + matrix[x][1].getY());
   	matrix[x][0].draw(myBuffer);
   	matrix[x][1].draw(myBuffer);
   	}
   	}
   	}
   
   }