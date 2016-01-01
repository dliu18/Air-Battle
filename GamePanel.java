   import javax.swing.JOptionPane;
   import javax.swing.*;
   import java.awt.*;
   import java.awt.event.*;
   import java.awt.image.BufferedImage;
   import java.applet.*;
   import java.io.*;
   import java.util.*;

    public class GamePanel extends JPanel
   {
      private JButton start;
      private JButton instructions;
      private JButton credits;
      private JLabel title;
      private BufferedImage myImage;
      private Graphics myBuffer;
      private JPanel menu;
      private JPanel Side;
      private JButton back;
      private JButton back2;
      private Instructions_Page InstructionsPage;
      private Credits_Page CreditsPage;
      private PrizePanel panel;
      private Scoreboard scoreboard;
      private ImageIcon Background;
      private javax.swing.Timer t;
      private int count = 0;
      private String[] names;
      private int[] scores;
      private AudioClip song = Sound.getClip("music.wav");
      private AudioClip song2 = Sound.getClip("win.wav");
   	private AudioClip song3 = Sound.getClip("lose.wav");
      private Scanner infile;
      private Game g = new Game();
      private Instructions i = new Instructions();
      private Credits c = new Credits();
   
   
       public GamePanel() throws Exception
      {
         Sound.loop(song);
      
      
         myImage =  new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
         myBuffer = myImage.getGraphics();
         Background = new ImageIcon("images/background.jpg");
         myBuffer.drawImage(Background.getImage(), 0, 0, 800, 600, null);
         setLayout(new GridLayout(2, 1, 0, 500));
         
      	
         title = new JLabel("Air Battle - The Game");
         title.setFont( new Font ("Monospaced", Font.BOLD, 45));
         title.setForeground(Color.BLACK);
         title.setOpaque(false);
         title.setHorizontalAlignment(SwingConstants.CENTER);
         add(title);
        
         menu = new JPanel();
         menu.setLayout(new GridLayout(1, 3, 30, 0));
         menu.setOpaque(false);
         add(menu);
         
         start = new JButton("Begin The Battle");
         start.setFont(new Font ("Monospaced", Font.BOLD, 20));
         start.setForeground(Color.BLACK);
         start.setBackground(new Color(85, 106, 123));
         start.setHorizontalAlignment(SwingConstants.CENTER);
         start.addActionListener(g);
         menu.add(start);
      
         instructions = new JButton("Instuctions");
         instructions.setFont(new Font ("Monospaced", Font.BOLD, 20));
         instructions.setForeground(Color.BLACK);
         instructions.setBackground(new Color(85, 106, 123));
         instructions.setHorizontalAlignment(SwingConstants.CENTER);
         instructions.addActionListener(i);
         menu.add(instructions);
      
         credits = new JButton("Credits");
         credits.setFont(new Font ("Monospaced", Font.BOLD, 20));
         credits.setForeground(Color.BLACK);
         credits.setBackground(new Color(85, 106, 123));
         credits.setHorizontalAlignment(SwingConstants.CENTER);
         credits.addActionListener(c);
         menu.add(credits);
      
         names = new String[20];
         scores = new int[20];
      
         t = new javax.swing.Timer(5, new Listener());
      	
      }
       public void paintComponent(Graphics g)
      {
         g.drawImage(myImage, 0, 0, 800, 600, null);
      }
   	
       private class Instructions implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
         {
            setLayout(new BorderLayout());
            title.setText("Instructions");
            title.setFont(new Font ("Monospaced", Font.BOLD, 25));
            add(title, BorderLayout.NORTH);
            menu.setLayout(new FlowLayout());
            menu.remove(start);
            menu.remove(instructions);
            menu.remove(credits);
            back = new JButton("Back To Main Menu");
            back.setBackground(new Color (85, 106, 123));
            back.addActionListener(new Back());
            menu.add(back);
            add(menu, BorderLayout.SOUTH);
            InstructionsPage = new Instructions_Page();
            InstructionsPage.setOpaque(false);
            add(InstructionsPage, BorderLayout.CENTER);
         
         }
      }
       private class Credits implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
         {
            setLayout(new BorderLayout());
            title.setText("Credits");
            title.setFont(new Font ("Monospaced", Font.BOLD, 25));
            add(title, BorderLayout.NORTH);
            menu.setLayout(new FlowLayout());
            menu.remove(start);
            menu.remove(instructions);
            menu.remove(credits);
            back2 = new JButton("Back To Main Menu");
            back2.setBackground(new Color (85, 106, 123));
            back2.addActionListener(new Back2());
            menu.add(back2);
            add(menu, BorderLayout.SOUTH);
            CreditsPage = new Credits_Page();
            CreditsPage.setOpaque(false);
            add(CreditsPage, BorderLayout.CENTER);
         
         }
      }
      
       private class Back implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
         {
            setLayout(new GridLayout(2, 1, 0, 500));
            title.setText("Air Battle - The Game");
            title.setFont(new Font ( "Monospaced", Font.BOLD, 45));
            add(title);
            remove(InstructionsPage);
            menu.remove(back);
            menu.setLayout(new GridLayout(1, 3, 30 , 0));
            menu.add(start);
            menu.add(instructions);
            menu.add(credits);
            add(menu);
         }
      }
    
       private class Back2 implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
         {
            setLayout(new GridLayout(2, 1, 0, 500));
            title.setText("Air Battle");
            title.setFont(new Font ( "Monospaced", Font.BOLD, 45));
            add(title);
            remove(CreditsPage);
            menu.remove(back2);
            menu.setLayout(new GridLayout(1, 3, 30 , 0));
            menu.add(start);
            menu.add(instructions);
            menu.add(credits);
            add(menu);
         
         }
      }
   
       private class Game implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
         {
         Sound.stop(song2);
         Sound.stop(song3);
         Sound.loop(song);
            remove(title);
            remove(menu);
            panel = new PrizePanel();
            setLayout(new BorderLayout());
            add(panel, BorderLayout.CENTER);
            scoreboard = new Scoreboard();
            scoreboard.repaint();
            add(scoreboard, BorderLayout.NORTH);
            updateUI();
            panel.setFocusable(true);
            panel.requestFocus();
            t.start();
         	
         }
      }
       private class Listener implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
         {
            scoreboard.setLevel(panel.getLevel());
            scoreboard.setPoints(panel.getHits());
            scoreboard.setHealth(panel.getHealth());
            scoreboard.setBaseHealth(panel.getBaseHealth());
            if(panel.getBossHealth() == 0)
            {
               Background = new ImageIcon("images/Win.jpg");
               myBuffer.drawImage(Background.getImage(), 0, 0, 800, 600, null);	
               remove(panel);
               remove(scoreboard);
               start.setText("Start Over");
               start.setBackground(new Color (230, 120, 23));
               instructions.setText("Save Score");
               instructions.setBackground(new Color (230, 120, 23));
               credits.setText("Quit");
               credits.setBackground(new Color (230, 120, 23));
              	
               add(menu, BorderLayout.SOUTH);
            	
               start.removeActionListener(g);
               credits.removeActionListener(c);
               instructions.removeActionListener(i);
            
            
               start.addActionListener(new Game());
               credits.addActionListener(new Quit());	
               instructions.addActionListener(new Save());
            
            Sound.stop(song);
            Sound.loop(song2);
               repaint();
               t.stop();
            
            }
            if(panel.getHealth() == 0|| panel.getBaseHealth() == 0)
            {
               remove(panel);
               remove(scoreboard);
               Background = new ImageIcon("images/GameOver.jpg");
               myBuffer.drawImage(Background.getImage(), 0, 0, 800, 600, null);	
               start.setText("Start Over");
               start.setBackground(Color.GRAY);
               instructions.setText("Save Score");
               instructions.setBackground(Color.GRAY);
               credits.setText("Quit");
               credits.setBackground(Color.GRAY);
               
               start.removeActionListener(g);
               credits.removeActionListener(c);
               instructions.removeActionListener(i);
            	
               start.addActionListener(new Game());
               credits.addActionListener(new Quit());	
               instructions.addActionListener(new Save());
            
           Sound.stop(song);
           Sound.loop(song3);
               t.stop();
               add(menu, BorderLayout.SOUTH);		
               repaint();
            }
         }
      }
      
       private class Quit implements ActionListener
      {
          public void actionPerformed(ActionEvent e)
         {
            System.exit(0);
         }
      }
      
       private class Save implements ActionListener
      {
          public void actionPerformed(ActionEvent e) 
         {
            try
            {
               System.setOut(new PrintStream(new FileOutputStream("output.txt")));
            }
                catch(FileNotFoundException f)
               {
                  System.exit(0);
               }
            names[count] = JOptionPane.showInputDialog("What Is Your Name?");
            scores[count] = panel.getHits();
            count++;
            int maxIndex = 0;
            String message = "";
            System.out.println("" + count);
            for(int x = 0; x <= names.length -1; x++)
               if( scores[x] != 0)
               {
                  System.out.println(scores[x]);
               }
         
            for(int x = 0; x <= names.length -1; x++)
               if( names[x] != null)
               {
                  System.out.println(names[x]);
               }
            try
            {
               infile = new Scanner(new File ("output.txt"));
            }
                catch(FileNotFoundException g)
               {
                  System.exit(0);
               }
         	
            int x = infile.nextInt();
            int[] temp = new int[x];
            for(int k = 0; k <= temp.length -1; k++)
            {
               temp[k] = infile.nextInt();
            }
            infile.close();
            for(int k = 0; k < temp.length - 1; k++)
            {
               for(int z = 0; z <= temp.length - 1 - k; z++)
               {
                  if(temp[z] > temp[maxIndex])
                     maxIndex = z;
                  
               }
               swap(temp, k, maxIndex);
            }
         
            for(int y =0; y <= temp.length -1; y++)
            {
               for(int k = 0; k<= temp.length -1; k++)
               {
                  if(temp[y] == scores[k] && y != k)
                  {
                     names = swap2(names, y, k);
                     
                  }
               }
            }
            
            for(int a = 0; a <= temp.length -1; a++)
            {
               scores[a] = temp[a];
            }
         
            for(int k =0; k <= temp.length -1; k++)
            {
               message = message + "\n" + (k+1) + "  " + names[k] +  ": " + scores[k];
               if(names[k] == null)
            	return;
            
            
            }
         
            JOptionPane.showMessageDialog(null, message);
         
            start.addActionListener(new Game());
            credits.addActionListener(new Quit());	
            instructions.addActionListener(new Save());
            add(menu, BorderLayout.SOUTH);
            
            updateUI();
         }
         
      }
      
       public void swap(int[] array, int a, int b)
      {
         int temp = array[b];
         array[b] = array[a];
         array[a] = temp;
      }
   
       public String[] swap2(String[] array, int a, int b)
      {
         String temp = array[b];
         array[b] = array[a];
         array[a] = temp;
         return array;
      }
   
   }
