// 
// Decompiled by Procyon v0.5.36
// 

package attendance.register.project;

import java.awt.Font;
import java.awt.FlowLayout;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.Icon;
import java.awt.LayoutManager;
import java.awt.GridLayout;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.ImageIcon;

public class TeacherFrameIT
{
    ImageIcon logo;
    JFrame tFrame;
    JButton attMarkBtn;
    JButton viewRecordBtn;
    JButton suggBtn;
    JLabel wishLabel;
    JLabel logoImg;
    JLabel timerLabel;
    JLabel classLabel;
    JComboBox cb;
    JComboBox cb_subject;
    private HomePageLogin hpl;
    String name;
    
    public void showDateTime() {
        final Date date = new Date();
        final SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        final String dateTime = sd.format(date);
        this.timerLabel.setText(dateTime);
    }
    
    public void setDateTime() {
        new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent ae) {
                TeacherFrameIT.this.showDateTime();
            }
        }).start();
    }
    
    public String returnMonth() {
        final Date date = new Date();
        final SimpleDateFormat sdf = new SimpleDateFormat("MM");
        final String month = sdf.format(date);
        return month;
    }
    
    public TeacherFrameIT(final String name) {
        this.name = name;
        (this.tFrame = new JFrame()).setBounds(300, 10, 850, 680);
        this.tFrame.setLayout(new GridLayout(5, 1));
        this.tFrame.setVisible(true);
        this.tFrame.setDefaultCloseOperation(2);
        this.logo = new ImageIcon("D:/Java/logo.png");
        this.logoImg = new JLabel(this.logo, 0);
        final JPanel imgPanel = new JPanel();
        imgPanel.add(this.logoImg);
        this.tFrame.add(imgPanel);
        final JPanel timePanel = new JPanel();
        this.timerLabel = new JLabel("", 0);
        this.setDateTime();
        timePanel.add(this.timerLabel);
        this.tFrame.add(timePanel);
        this.attMarkBtn = new JButton("Mark-ATTD");
        this.viewRecordBtn = new JButton("VIEW-RECORD");
        this.suggBtn = new JButton("any mistake?");
        final String[] classArrayCS = { "FYIT", "SYIT", "TYIT" };
        final String[] it_sem1 = { "COD", "Prog with Python-I", "FOSS", "Database sys.", "D.Maths", "D.Stats", "Soft Skills" };
        final String[] it_sem2 = { "Prog with C", "Prog with Pyhton-II", "Linux", "Data Structure", "Calculus", "Stats methods and Hypo testing", "Green Technologies" };
        final String[] it_sem3 = { "TOC", "Core Java", "OS", "DBMS", "CGT", "IOT", "WP" };
        final String[] it_sem4 = { "FOA", "Adv.Java", "CN", "SE", "LA using Python", ".NET", "Android Devp." };
        final String[] it_sem5 = { "AI", "ST & QA", "INS", "WS", "GP" };
        final String[] it_sem6 = { "Cloud Computing", "Cyber Forensics", "Info retrieval", "Data Science", "Ethical Hacking" };
        this.classLabel = new JLabel("CLASS");
        this.cb_subject = new JComboBox();
        this.cb = new JComboBox(classArrayCS);
        final JPanel classPanel = new JPanel();
        classPanel.add(this.classLabel);
        classPanel.add(this.cb);
        this.tFrame.add(classPanel);
        final JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout());
        btnPanel.add(this.attMarkBtn);
        btnPanel.add(this.viewRecordBtn);
        btnPanel.add(this.suggBtn);
        this.tFrame.add(btnPanel);
        final JPanel wishPanel = new JPanel();
        (this.wishLabel = new JLabel("WELCOME " + name.toUpperCase() + " MAM")).setFont(new Font("Consolas", 1, 20));
        wishPanel.add(this.wishLabel);
        this.tFrame.add(wishPanel);
        this.attMarkBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent ae) {
                new AttendanceFrame();
            }
        });
        this.suggBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final SuggestionFrameIT sf = new SuggestionFrameIT(name);
            }
        });
    }
}
