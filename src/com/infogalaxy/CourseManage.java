package com.infogalaxy;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CourseManage {

    JFrame frame = new JFrame("COURSE MANAGE");
    JPanel panel = new JPanel();

    Font lblFont = new Font("ARIAL",Font.BOLD,13);

    JLabel lblCID = new JLabel("Enter Course ID : ");
    JLabel lblCNAME = new JLabel("Enter Course Name :");
    JLabel lblCFEES = new JLabel("Enter Course Fees :");

    JTextField txtCID = new JTextField();
    JTextField txtCNAME = new JTextField();
    JTextField txtCFEES = new JTextField();

    JButton btnSubmit = new JButton("SUBMIT");
    JButton btnCancel = new JButton("CANCEL");
    JButton btnUpdate = new JButton("UPDATE");
    JButton btnDelete = new JButton("DELETE");



     CourseManage(){

         //Label
         lblCID.setBounds(30,50,150,30);
         lblCID.setFont(lblFont);
         panel.add(lblCID);
         lblCNAME.setBounds(30,100,150,30);
         lblCNAME.setFont(lblFont);
         panel.add(lblCNAME);
         lblCFEES.setBounds(30,150,150,30);
         lblCFEES.setFont(lblFont);
         panel.add(lblCFEES);

         //Textfield
         txtCID.setBounds(180,50,150,30);
         panel.add(txtCID);
         txtCNAME.setBounds(180,100,150,30);
         panel.add(txtCNAME);
         txtCFEES.setBounds(180,150,150,30);
         panel.add(txtCFEES);

         //Button
         btnSubmit.setBounds(70,210,100,35);
         panel.add(btnSubmit);
         btnSubmit.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                DBConn.openCon();
                DBConn.nonSelect("insert into courseinfo values('"+txtCID.getText()+"','"+txtCNAME.getText()+"',"+txtCFEES.getText()+")");
                JOptionPane.showMessageDialog(frame,"Course Info Added Sucessfully...");
                clearComponent();
             }
         });

         btnCancel.setBounds(250,210,100,35);
         panel.add(btnCancel);

         btnUpdate.setBounds(70,255,100,35);
         panel.add(btnUpdate);
         btnUpdate.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 DBConn.openCon();
                 DBConn.nonSelect("update courseinfo set CNAME ='"+txtCNAME.getText()+"',CFEES="+txtCFEES.getText()+"  where CID ='"+txtCID.getText()+"'");
                 JOptionPane.showMessageDialog(frame,"Course Info UPDATED Sucessfully...");
                 clearComponent();
             }
         });

         btnDelete.setBounds(250,255,100,35);
         panel.add(btnDelete);
         btnDelete.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 DBConn.openCon();
                 DBConn.nonSelect("delete from courseinfo where CID='"+txtCID.getText()+"'");
                 JOptionPane.showMessageDialog(frame,"Course Info DELETED Sucessfully...");
                 clearComponent();

             }
         });

        panel.setLayout(null);
        frame.add(panel);
        frame.setLocation(700,10);
        frame.setSize(500,600);
        frame.show();
    }
    public void clearComponent() {
         txtCID.setText(" ");
         txtCNAME.setText(" ");
         txtCFEES.setText(" ");
         txtCID.requestFocus();
    }

    public static void main(String[] args) {
        new CourseManage();
    }
}
