import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.GroupLayout;

public class TopPanel extends JPanel {

    private JButton nameButton, stringButton, avgGPAButton;
    
    TopPanel(Group grp) {
    	nameButton = new JButton();
    	stringButton = new JButton();
    	avgGPAButton = new JButton();
        
        nameButton.setText(grp.getName());
        stringButton.setText("Group Average GPA is ");
        avgGPAButton.setText(grp.averageGPA().toString());
        
        GroupLayout TopPanelLayout = new GroupLayout(this);
        setLayout(TopPanelLayout);
        
        TopPanelLayout.setHorizontalGroup(
            TopPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(TopPanelLayout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addComponent(nameButton)
                .addGap(113, 113, 113)
                .addComponent(stringButton)
                .addGap(72, 72, 72)
                .addComponent(avgGPAButton)
                .addContainerGap(124, Short.MAX_VALUE))
        );
        
        TopPanelLayout.setVerticalGroup(
            TopPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(GroupLayout.Alignment.TRAILING, TopPanelLayout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(TopPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(nameButton)
                    .addComponent(stringButton)
                    .addComponent(avgGPAButton))
                .addContainerGap())
        );
    }
    
    public JButton getavgGPAButton() {
        return this.avgGPAButton;
     }
}