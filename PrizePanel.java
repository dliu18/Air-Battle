   //Name:    Date:
   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.awt.image.*;
   public class PrizePanel extends JPanel
   {
      private static final Color BACKGROUND = new Color(204, 204, 204);
      private BufferedImage myImage;
      private Graphics myBuffer;
      private Good pd;
      private Enemy plane;
      private Timer t; 
      private Base base;
      private double dx;       // pixels to move each time step() is called.
      private double dy;
      private Bullet[] array;
      private Enemy[] matrix = new Enemy[100];
      private int count;
      private int measure = 0;
      private boolean right = false;
      private boolean left = false;
      private boolean gun = false;
      private PanelBackground background;
      private int myLevel = 1;
      private int myHits = 0;
      private int myHealth = 1000;
      private int myBaseHealth = 2000;
      private int measure2 = 0;
      private Boss boss;
		private int bossHealth = 10;
   	
   	   	//constructor   
      public PrizePanel()
      {
         myImage =  new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
         myBuffer = myImage.getGraphics();
         background = new PanelBackground();
         pd = new Good();
         matrix[0] = new Enemy((int)(Math.random()*(800-49)), -89 );
         base = new Base();
         count = 0;
         t = new Timer(5, new Listener());
         t.start();
         addKeyListener(new Key());
         setFocusable(true);
      }
      public void paintComponent(Graphics g)
      {
         g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);
      
      }
      private class Key extends KeyAdapter
      {
         public void keyPressed(KeyEvent e)
         {
            if(e.getKeyCode()== KeyEvent.VK_LEFT && pd.getX() >= 10)
            {
               left = true;
            }
            if(e.getKeyCode()== KeyEvent.VK_RIGHT && pd.getX() <= (800 - pd.getXWidth() - 10))
            {
               right = true;
            
            }
            if(e.getKeyCode()==KeyEvent.VK_SPACE)
               gun = true;
          
         }
         
      }
      
      public int getLevel()
      {
         return myLevel;
      }
   	
      public int getHits()
      {
         return myHits;
      }
   	
      public int getHealth()
      {
         return myHealth;
      }
   	
      public int getBaseHealth()
      {
         return myBaseHealth;
      }
		public int getBossHealth()
		{
		return bossHealth;
		}
      private class Listener implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            measure++;
            background.draw(measure, myBuffer);
            
            //turning and shooting
            check();
         
         // redraw the basics
            pd.draw(myBuffer);
            base.draw(myBuffer);
                  	
         //make a new enemy	
            enemy(); 
         	//check for explosions
            points();
            if(myHits >= 1000)
            {
               for(int x = 0; x <= matrix.length -1; x++)
                  matrix[x] = null;
               t.stop();
               Timer t2 = new Timer(5, new Listener2());
               t2.start();
					myLevel = 2;
            }       
         //move all of the ememies
            move();
         	
         	//move and draw all existing bullets
            bullets();
         
            pd.setArray(array);
            count++;
            repaint();  
         }
      }
      
      private class Listener2 implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
            if(measure2 ==0)
               boss = new Boss();
            measure2++;
            measure++;
            background.draw(measure, myBuffer);
            pd.draw(myBuffer);
            base.draw(myBuffer);
            boss.draw(myBuffer);
            repaint();
         
            check();
         
            points2();
         
            if(measure2 % 20 == 0)
               boss.setY(boss.getY() + 5);
         
            if(measure2 % 5 == 0 || measure2 == 0)
               boss.shoot();
         
            boss.fire(myBuffer);
         
            if(base.Hit2(boss.getMatrix()) != -1)
            {
               Bullet[][] Matrix = boss.getMatrix();
               ImageIcon explosion = new ImageIcon("images/explosion.jpg");
               if(Matrix[base.Hit2(Matrix)][0] != null)
                  myBuffer.drawImage(explosion.getImage(), (int)(Matrix[base.Hit2(Matrix)][0].getX() - 5), (int)(Matrix[base.Hit2(Matrix)][0].getY() - 5), null);
               if(Matrix[base.Hit2(Matrix)][1] != null)
                  myBuffer.drawImage(explosion.getImage(), (int)(Matrix[base.Hit2(Matrix)][1].getX() - 5), (int)(Matrix[base.Hit2(Matrix)][1].getY() - 5), null);
               Matrix[base.Hit2(Matrix)][0] = null;
               Matrix[base.Hit2(Matrix)][1] = null;
               myBaseHealth -= 50;
            }
            int hitResult = pd.Hit(boss.getMatrix()); 
            if(hitResult != -1)
            {
               {
                  Bullet[][] Matrix = boss.getMatrix();
                  Matrix[hitResult][0] = null;
                  Matrix[hitResult][1] = null;
                  myHealth -= 20;
               }
            }
         
            bullets();
         
            pd.setArray(array);
         
         
         
         }
      }
   	
   	
      public void check()
      {
         if(right == true)
         {
            pd.setX(pd.getX()+ 10);
            right = false;
         }
         if(left == true)
         {
            pd.setX(pd.getX()-10);
            left = false;
         }
         if(gun == true)
         {
            gun = false;
            pd.shoot(myBuffer);
         }
      }
      
      public void enemy()
      {
         if(count % 40 == 0 && count != 0)
         {
            for(int x = 1; x <= matrix.length - 1; x++)
            {
               if(matrix[x] == null)
               {
                  matrix[x] = new Enemy((int)(Math.random()*(800-49)), 0);
                  break;
               }
               
            }
         }
      }
      
      public void points()
      {
         for(int k = 0; k <= matrix.length -1; k++)
         {
            array = pd.getArray();
            if(matrix[k] != null && matrix[k].Hit(array) != -1)
            {
               myHits += 547;
               ImageIcon explosion = new ImageIcon("images/explosion.jpg");
               myBuffer.drawImage(explosion.getImage(), matrix[k].getX() - 5, matrix[k].getY() - 5, null);
               int z = matrix[k].Hit(array);
               array[z] = null;
               matrix[k] = null;
                 
            }
         }
      
      }
      
      public void points2()
      {
         array = pd.getArray();
         if(boss.Hit(array) != -1)
         {
            int z = boss.Hit(array);
            myHits += 809;
				bossHealth -= 1; 
            ImageIcon explosion = new ImageIcon("images/explosion.jpg");
            myBuffer.drawImage(explosion.getImage(), (int)(array[z].getX()), (int)(array[z].getY() - 10), null);
            array[z] = null;
                 
         }
      }
      
      public void move()
      {
         for(int x = 0; x <= matrix.length -1; x++)
         {
            if(matrix[x] != null && matrix[x].getY() <= 547)
            {
               if(base.Hit(matrix, matrix[x], myBuffer) == true)
               {
                  ImageIcon explosion = new ImageIcon("images/explosion.jpg");
                  myBuffer.drawImage(explosion.getImage(), matrix[x].getX(), 530, null);
                  myBaseHealth-= 5;
               }
               matrix[x].setY(matrix[x].getY() + 3);
            }
            else
               matrix[x] = null;
         }
         for(int x = 0; x <= matrix.length -1; x++)
         {
            if(matrix[x] != null)
               matrix[x].draw(myBuffer);
         }
      }
      
      public void bullets()
      {
         array = pd.getArray();
         	
         for(int x = array.length-1; x >= 0; x--)
         {
            if(array[x] != null && array[x].getY() >= (array[x].getRadius() * 2))
            {
               array[x].move();
               array[x].draw(myBuffer);
                  
               
            }
         }
            
         for(int x = 0; x <= array.length - 1; x++)
            if(array[x] != null)
               if(array[x].getY() <= 5)
               {
                  array[x] = null ;
                   
               }
         if(pd.collide(matrix, myBuffer) == true)
            myHealth -= 10;
      
      }
   }