   import java.awt.*;
	 import java.awt.image.*;
	 import javax.swing.*;
   
    public class Bullet
   {
      private double myX;   // x and y coordinates of center
      private double myY;
      private double myDiameter;
      private Color myColor; 
      private double myRadius;      // pixels to move each time step() is called.
      private double dy;
		private double dx;
     // constructors
       public Bullet()     //default constructor
      {
         myX = 300;
         myY = 300;
         myDiameter = 10;
         myColor = Color.BLACK;
         myRadius = myDiameter/2;
         dy = -3.5;
      }
       public Bullet(double x, double y, double d, Color c)
      {
         myX = x;
         myY = y;
         myDiameter = d;
         myColor = c;
         myRadius = d/2;
         dy = -3.5;
      }
       public Bullet(double x, double y)
      {
         myX = x;
         myY = y;
         myDiameter = 15;
         myColor = Color.BLACK;
         myRadius = 15/2;
         dy = -5;
      }
   	
    // accessor methods
       public double getX() 
      { 
         return myX;
      }
       public double getY()      
      { 
         return myY;
      }
       public double getDiameter() 
      { 
         return myDiameter;
      }
       public Color getColor() 
      { 
         return myColor;
      }
       public double getRadius() 
      { 
         return myRadius;
      }
   // modifier methods
       public void setX(double x)
      {
         myX = x;
      } 
       public void setY(double y)
      {
         myY = y;
      } 
       public void setColor(Color c)
      {
         myColor = c;
      }
       public void setDiameter(double d)
      {
         myDiameter = d;
         myRadius = d/2;
      }
       public void setRadius(double r)
      {
         myRadius = r;
         myDiameter = 2*r;
      }
       public void setdy(double y)
      {
         dy = y;
      }
		public void setdx(double x)
		{
		dx = x;
		}
      //accessor methods
       public double getdy()
      {
         return dy;
      }
		
		public double getdx()
		{
		return dx;
		}
		
    //	 instance methods
       public void move()
      {
         if(getY() > 0)
         {
            setX(getX());
            setY(getY()+ dy); 
         }          
      }
		
		public void baseMove()
		{
		if(getY() < 530)
		{
		setX(getX() + dx);
		setY(getY() + dy);
		}
		}
       public void draw(Graphics myBuffer) 
      {
        ImageIcon fire = new ImageIcon("bullet.png");
         myBuffer.drawImage(fire.getImage(), (int)(myX - myRadius), (int)(myY-myRadius), (int)myDiameter, (int)myDiameter, null);
      }
   }