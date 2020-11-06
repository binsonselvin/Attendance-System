// 
// Decompiled by Procyon v0.5.36
// 

package attendance.register.project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Icon;
import javax.swing.JPanel;
import java.awt.LayoutManager;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class DepartmentFrame
{
    ImageIcon logo;
    JLabel logoLbl;
    JLabel wishLabel;
    JRadioButton rb1;
    JRadioButton rb2;
    JButton subBtn;
    String teacherName;
    
    public DepartmentFrame() {
        final JFrame f = new JFrame("Department Frame");
        f.setBounds(300, 10, 850, 680);
        f.setLayout(new GridLayout(4, 1));
        f.setDefaultCloseOperation(3);
        final JPanel imgPanel = new JPanel();
        this.logo = new ImageIcon("D://Java/logo.png");
        imgPanel.add(this.logoLbl = new JLabel(this.logo));
        f.add(imgPanel);
        final JPanel wishPanel = new JPanel();
        (this.wishLabel = new JLabel("WELCOME")).setFont(new Font("Consolas", 1, 25));
        wishPanel.add(this.wishLabel);
        f.add(wishPanel);
        final JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new FlowLayout());
        final JRadioButton rb1 = new JRadioButton();
        rb1.setText("IT");
        final JRadioButton rb2 = new JRadioButton();
        rb2.setText("CS");
        radioPanel.add(rb1);
        radioPanel.add(rb2);
        final ButtonGroup group = new ButtonGroup();
        group.add(rb1);
        group.add(rb2);
        f.add(radioPanel);
        final JPanel btnPanel = new JPanel();
        btnPanel.add(this.subBtn = new JButton("SUBMIT"));
        f.add(btnPanel);
        f.setVisible(true);
        this.subBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                System.out.println(group.getSelection());
                if (rb2.isSelected()) {
                    f.dispose();
                    final HomePageLogin homePageLogin = new HomePageLogin();
                }
                if (rb1.isSelected()) {
                    f.dispose();
                    final HomePageLoginIT homePageLoginIT = new HomePageLoginIT();
                }
            }
        });
    }
    
    public static void main(final String[] args) {
        final DepartmentFrame df = new DepartmentFrame();
    }
}
