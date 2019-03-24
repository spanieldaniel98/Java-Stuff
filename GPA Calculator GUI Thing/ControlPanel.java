import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public abstract class ControlPanel extends JPanel implements ActionListener{
	
    private JButton student1Button, student2Button, student3Button, student4Button;
    
    ControlPanel(Group grp, TopPanel topPanel) {
    	setLayout(new GridLayout(5,1));
    	
        topPanel = new TopPanel(grp);
        topPanel.setBackground(new Color(0, 0, 204));
        topPanel.setPreferredSize(new Dimension(590, 45));
        add(topPanel);
        
        initButtons(grp, topPanel);
    }
    
    public void initButtons(Group grp, TopPanel topPanel) {
    	student1Button = new JButton(); 
    	student2Button = new JButton();
    	student3Button = new JButton();
    	student4Button = new JButton();
    	
    	student1Button.setText(grp.getStudent("member1").getInfo());
    	student2Button.setText(grp.getStudent("member2").getInfo());
    	student3Button.setText(grp.getStudent("member3").getInfo());
    	student4Button.setText(grp.getStudent("member4").getInfo());
    	
        student1Button.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e)
          {
        	actionMethod(grp, topPanel, "member1", student1Button);
          }
        });

        student2Button.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e)
          {
        	  actionMethod(grp, topPanel, "member2", student2Button);
          }
        });
        
        student3Button.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e)
          {
        	  actionMethod(grp, topPanel, "member3", student3Button);
          }
        });
        
        student4Button.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e)
          {
        	  actionMethod(grp, topPanel, "member3", student4Button);
          }
        });
        
        add(student1Button);
        add(student2Button);
        add(student3Button);
        add(student4Button);
    }
    
    public void actionMethod(Group grp, TopPanel topPanel, String student, JButton button) {
    	grp.getStudent(student).semesterGPA();
    	button.setText(grp.getStudent(student).getInfo());
    	topPanel.getavgGPAButton().setText(grp.averageGPA().toString());
    }
}