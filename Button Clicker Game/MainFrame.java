import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

// main JFrame containing the game panel
public class MainFrame extends JFrame implements KeyListener {
    
    GamePanel game;
    boolean started;

    // instantiate game panel, set up frame and make visible and focused
    public MainFrame() {
    	super("Lab 09 - A Game");
        MacLayoutSetup();
        
        game = new GamePanel();
        started = false;
        
        getContentPane().add(game, "Center");
        addKeyListener(this);
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e){
            	requestFocus();
            	repaint();
            }
          });
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1200, 600);
        setFocusable(true);
        setVisible(true);
    }
    
    // start game if space bar is pressed
    public void keyPressed(KeyEvent e){ 
        if(e.getKeyCode()==KeyEvent.VK_SPACE && !started){
        	 started = true;
             game.start();
        }
    }
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}

    public void MacLayoutSetup() {
    	// fixes background colour of button not appearing issue on some Macs
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}