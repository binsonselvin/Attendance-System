// 
// Decompiled by Procyon v0.5.36
// 

package attendance.register.project;

import java.awt.event.ActionEvent;
import java.awt.LayoutManager;
import java.awt.GridLayout;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class SuggestionFrameCS extends JFrame implements ActionListener
{
    JLabel l1;
    JTextArea ta;
    JButton b1;
    String name;
    
    public SuggestionFrameCS(final String name) {
        this.name = name;
        this.setTitle("Suggestion Frame");
        this.l1 = new JLabel("");
        this.ta = new JTextArea("enter your suggestions here.....", 16, 75);
        this.b1 = new JButton("SUBMIT");
        final JPanel p = new JPanel();
        p.add(this.ta);
        p.add(this.b1);
        p.add(this.l1);
        this.b1.addActionListener(this);
        this.add(p);
        this.setLayout(new GridLayout(1, 1));
        this.setBounds(300, 200, 850, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(2);
    }
    
    @Override
    public void actionPerformed(final ActionEvent e) {
        this.l1.setText("Successfully submitted to HOD");
        this.b1.setEnabled(false);
    }
}
