// 
// Decompiled by Procyon v0.5.36
// 

package attendance.register.project;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.Component;
import javax.swing.JPanel;
import java.awt.LayoutManager;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.Icon;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class HomePageLogin
{
    ImageIcon logo;
    ImageIcon backicon;
    JLabel logoImg;
    JLabel dateLabel;
    JLabel userLabel;
    JLabel passLabel;
    JLabel statusLabel;
    JTextField userTf;
    JPasswordField passTf;
    JButton loginBtn;
    JButton backBtn;
    
    public static String dateReturn() {
        final Date d = new Date();
        final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        final String date = sdf.format(d);
        return date;
    }
    
    public HomePageLogin() {
        this.logo = new ImageIcon("D:/Java/logo.png");
        this.backicon = new ImageIcon("D:/Java/backicon.png");
        this.logoImg = new JLabel(this.logo, 0);
        final JFrame f = new JFrame("LOGIN FORM");
        f.setBounds(300, 10, 850, 680);
        f.setLayout(new GridLayout(5, 1));
        f.setDefaultCloseOperation(3);
        final JPanel logoPanel = new JPanel();
        logoPanel.add(this.logoImg);
        f.add(logoPanel);
        final JPanel userPanel = new JPanel();
        userPanel.setBorder(new EmptyBorder(30, 100, 0, 100));
        this.userLabel = new JLabel("LOGIN-ID");
        System.out.println(this.userLabel.getFont());
        this.userLabel.setFont(new Font("Consolas", 1, 15));
        this.userLabel.setBorder(new EmptyBorder(0, 0, 0, 10));
        (this.userTf = new JTextField(15)).setSize(30, 30);
        userPanel.add(this.userLabel);
        userPanel.add(this.userTf);
        System.out.println(userPanel.getPreferredSize());
        f.add(userPanel);
        final JPanel passPanel = new JPanel();
        (this.passLabel = new JLabel("PASSWORD")).setFont(new Font("Consolas", 1, 15));
        this.passLabel.setBorder(new EmptyBorder(0, 0, 0, 10));
        this.passTf = new JPasswordField(15);
        passPanel.add(this.passLabel);
        passPanel.add(this.passTf);
        f.add(passPanel);
        final JPanel btnPanel = new JPanel();
        this.loginBtn = new JButton("LOGIN");
        this.backBtn = new JButton("BACK");
        this.loginBtn.setFont(new Font("Consolas", 1, 15));
        this.backBtn.setFont(new Font("Consolas", 1, 15));
        btnPanel.add(this.loginBtn);
        btnPanel.add(this.backBtn);
        this.loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final String username = HomePageLogin.this.userTf.getText();
                final String password = HomePageLogin.this.passTf.getText();
                if (username.equals("Racheal") && password.equals("123456")) {
                    f.dispose();
                    final TeacherFrameCS teacherFrameCS = new TeacherFrameCS(username);
                }
                if (password.equals("") || username.equals("")) {
                    HomePageLogin.this.dateLabel.setForeground(Color.red);
                    HomePageLogin.this.dateLabel.setText("USERNAME or PASSWORD cannot be empty");
                }
            }
        });
        this.backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent ae) {
                f.dispose();
                new DepartmentFrame();
            }
        });
        f.add(btnPanel);
        final JPanel datePanel = new JPanel();
        (this.dateLabel = new JLabel("", 4)).setText("TODAYS DATE: " + dateReturn() + " (*CS DEPARTMENT*)");
        datePanel.add(this.dateLabel);
        f.add(datePanel);
        f.setVisible(true);
    }
}
