import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.WindowConstants;

public class MainFrame extends JFrame {
	                                     
    private ControlPanel controlPanel;
    private TopPanel topPanel;
	
    public MainFrame(Group grp) {
        controlPanel=new ControlPanel(grp,topPanel) {
            @Override
            public void actionPerformed(ActionEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }
        };
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(controlPanel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
        );
        
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(controlPanel, GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
        );
        pack();
    }
    
    @SuppressWarnings("unchecked")                         
    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 642, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 366, Short.MAX_VALUE)
        );

        pack();
    }                       
}