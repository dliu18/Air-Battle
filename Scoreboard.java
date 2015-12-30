   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.awt.image.BufferedImage;

    public class Scoreboard extends JPanel
   {
      private int myLevel;
      private int myPoints;
      private int myHealth;
      private int baseHealth;
      private BufferedImage myImage;
      private Graphics myBuffer;
      private Timer t;
      private JPanel panel;
      private JPanel empty;
      private JLabel label1;
      private JLabel label2;
   
       public Scoreboard()
      {
         setBackground(Color.WHITE);
         setLayout(new BorderLayout());
      
         myLevel = 1;
         myPoints = 0;
         myHealth = 1000;
         baseHealth = 2000;
      	
         myImage =  new BufferedImage(400, 100, BufferedImage.TYPE_INT_RGB);
         myBuffer = myImage.getGraphics();
      
         panel = new JPanel();
         panel.setLayout(new GridLayout(1, 2, 100, 0));
         add(panel, BorderLayout.WEST);
      	
         label1 = new JLabel("Level: 1");
         label1.setForeground(Color.BLACK);
         label1.setFont(new Font ("Monospaced", Font.BOLD, 20));
         label1.setHorizontalAlignment(SwingConstants.CENTER);
         panel.add(label1);
      	
         label2 = new JLabel("Points: 0     ");
         label2.setForeground(Color.BLACK);
         label2.setFont(new Font("Monospaced", Font.PLAIN, 20));
         label2.setHorizontalAlignment(SwingConstants.CENTER);
         panel.add(label2);
      	
         empty = new JPanel();
         empty.setBackground(Color.WHITE);
         empty.setOpaque(true);
         add(empty, BorderLayout.EAST);
      	
         myBuffer.setColor(Color.WHITE);
         myBuffer.fillRect(0, 0, 400, 100);
      	
         myBuffer.setColor(Color.BLACK);
         myBuffer.fillRect(10, 30, 175, 60);
         myBuffer.setColor(Color.RED);
         myBuffer.fillRect(10, 30, 175, 60);
      	
         myBuffer.setColor(Color.BLACK);
         myBuffer.fillRect(210, 30, 175, 60);
         myBuffer.setColor(Color.RED);
         myBuffer.fillRect(210, 30, 175, 60);
      	
         myBuffer.setColor(Color.BLACK);
         myBuffer.setFont(new Font ( "Monopaced", Font.PLAIN, 30));
         myBuffer.drawString("Plane Health: ", 10, 25);
         myBuffer.drawString("Base Health: ", 220, 25);
      	
         t = new Timer(5, new Listener());
         t.start();
      }
      
       public void setLevel(int level)
      {
         myLevel = level;
      }
   	
       public void setPoints(int Points)
      {
         myPoints = Points;
      }
   	
       public void setHealth(int Health)
      {
         myHealth = Health;
      }
   	
       public void setBaseHealth(int Health)
      {
         baseHealth = Health;
      }
   	
       public void paintComponent(Graphics g)
      {
         g.drawImage(myImage, 400, 0, 400, 40, null);
      }
   
       private class Listener implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
         {
            myBuffer.setColor(Color.WHITE);
            myBuffer.fillRect(0, 0, 400, 100);
            
            label1.setText("Level: " + myLevel);
         
            label2.setText("Points: " + myPoints);
         
            myBuffer.setColor(Color.BLACK);
            myBuffer.fillRect(10, 30, 175, 60);
            myBuffer.fillRect(210, 30, 175, 60);
         
            myBuffer.setColor(Color.RED);
            myBuffer.fillRect(10, 30, (int)((double)(myHealth) / 1000.0 * 175.0), 70);
            myBuffer.fillRect(210, 30, (int)((double)(baseHealth) / 2000.0 * 175.0), 70);

         
            myBuffer.setColor(Color.BLACK);
            myBuffer.setFont(new Font ( "Monopaced", Font.PLAIN, 30));
            myBuffer.drawString("Plane Health: ", 10, 25);
            myBuffer.drawString("Base Health: ", 210, 25);
          
            repaint();
         }
      }
   }