// 
// Decompiled by Procyon v0.5.36
// 

package attendance.register.project;

import java.awt.LayoutManager;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.TableModel;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JFrame;

public class AttendanceFrame extends JFrame
{
    static JLabel rollNoLabel;
    static int cout;
    JButton pBtn;
    JButton aBtn;
    JPanel btnPanel;
    DefaultTableModel model;
    JTable table;
    JScrollPane sp;
    int i;
    
    public static int[] array() {
        final int[] rollNo = new int[50];
        int looprollno = 38001;
        for (int i = 0; i < 50; ++i) {
            rollNo[i] = looprollno;
            ++looprollno;
        }
        return rollNo;
    }
    
    public AttendanceFrame() {
        this.i = 0;
        AttendanceFrame.rollNoLabel = new JLabel("38001");
        this.pBtn = new JButton("PRESENT");
        this.aBtn = new JButton("ABSENT");
        (this.btnPanel = new JPanel()).add(AttendanceFrame.rollNoLabel);
        this.btnPanel.add(this.pBtn);
        this.btnPanel.add(this.aBtn);
        this.table = new JTable();
        final Object[] columns = { "ROLLNO", "STATUS" };
        (this.model = new DefaultTableModel()).setColumnIdentifiers(columns);
        this.table.setRowHeight(18);
        this.table.setBounds(20, 20, 380, 380);
        this.table.setBackground(Color.black);
        this.table.setForeground(Color.YELLOW);
        this.table.setModel(this.model);
        this.sp = new JScrollPane(this.table);
        this.model.setColumnIdentifiers(columns);
        this.add(this.sp);
        this.add(this.btnPanel);
        final Object[] row = new Object[2];
        this.pBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if (AttendanceFrame.this.i < 50) {
                    int[] rollNo = new int[50];
                    rollNo = AttendanceFrame.array();
                    final String convRoll = Integer.toString(rollNo[AttendanceFrame.this.i]);
                    AttendanceFrame.rollNoLabel.setText(Integer.toString(rollNo[AttendanceFrame.this.i]));
                    row[0] = AttendanceFrame.rollNoLabel.getText();
                    row[1] = "PRESENT";
                    AttendanceFrame.this.model.addRow(row);
                    final AttendanceFrame this$0 = AttendanceFrame.this;
                    ++this$0.i;
                }
                else {
                    AttendanceFrame.rollNoLabel.setText("Attendace Over");
                    AttendanceFrame.this.aBtn.setVisible(false);
                    AttendanceFrame.this.pBtn.setVisible(false);
                }
            }
        });
        this.aBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                if (AttendanceFrame.this.i < 50) {
                    int[] rollNo = new int[50];
                    rollNo = AttendanceFrame.array();
                    final String convRoll = Integer.toString(rollNo[AttendanceFrame.this.i]);
                    AttendanceFrame.rollNoLabel.setText(Integer.toString(rollNo[AttendanceFrame.this.i]));
                    row[0] = AttendanceFrame.rollNoLabel.getText();
                    row[1] = "ABSENT";
                    AttendanceFrame.this.model.addRow(row);
                    final AttendanceFrame this$0 = AttendanceFrame.this;
                    ++this$0.i;
                }
                else {
                    AttendanceFrame.this.aBtn.setVisible(false);
                    AttendanceFrame.this.pBtn.setVisible(false);
                }
            }
        });
        this.setLayout(new FlowLayout());
        this.setBounds(430, 100, 500, 550);
        this.setVisible(true);
    }
    
    public static void main(final String[] args) {
        new AttendanceFrame();
    }
    
    static {
        AttendanceFrame.cout = 38001;
    }
}
