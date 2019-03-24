import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

public class GamePanel extends JPanel {
    
	int score, countdown, buttonSize, delay;
    JButton button;
    Timer timer;
    JProgressBar progressBar;

    // set up game panel, initialise variables, instantiate timer and add listener
    public GamePanel(){
        super();
        setBackground(Color.white);
        setLayout(null);

        score = 0;
        countdown = 60;
        delay = 1000;
        
        timer = new Timer(delay, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	// decrease countdown by one and update progress bar
            	countdown -= 1;
                progressBar.setValue(countdown);
                
                // move button to random position
                button.setBounds((int)(Math.random() * 620 + 1), (int)(Math.random() * 460 + 1), buttonSize, buttonSize);
                
                // delay decreases by 10ms with each timer tick
                delay -= 10;
                timer.setDelay(delay);
                
                repaint();
            }
         });
        
        button = new JButton("click me");
        buttonSize = 100;
        button.setBounds(300, 20, buttonSize, buttonSize);
        add(button);
        
        progressBar = new JProgressBar(JProgressBar.VERTICAL, 0, 60);
        progressBar.setValue(countdown);
        progressBar.setBounds(700, 20, 30, 550);
        add(progressBar);
    }
    
    // start game, at which point timer starts and action listener is added to button
    public void start() {
    	timer.start();
    	button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
            	if(countdown != 0) {
            		score += 1;
                	buttonSize -= 1;
                	button.setPreferredSize(new Dimension(buttonSize, buttonSize));
            	}
            	repaint();
            }
          });
    }
   
    // repaint method that updates printed lines
    @Override
    public void paintComponent(Graphics g){
    	g.setColor(Color.black);
        super.paintComponent(g);
        
        // if time has run out, display final score
        if(countdown == 0) {
        	timer.stop();
        	g.drawString("Game over! Final score: " + score, 10, 520);
        }
        
        // ...else update game info
        else {
        	g.drawString("score = " + score, 10, 520);
            g.drawString("Press Spacebar to start the game", 10, 540);
            g.drawString("You have " + countdown + " seconds to keep clicking on the button to score", 10, 560);
        }
    }
}