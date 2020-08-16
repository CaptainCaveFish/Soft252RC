package soft252git;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dillonlaskey
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Login extends Page{
    JTextField userName;
    JPasswordField password;
    JButton submit, create;
    JLabel messageLabel;
    User[] users;
    Pagemanager parent;
    Login(Data database,Pagemanager p){
        super("Login",database,null,null);
        parent = p;
        users = info.getUsers();
        userName = new JTextField("");
        userName.setBounds(150, 100, 200, 50);
        password = new JPasswordField();
        password.setBounds(150, 200, 200, 50);
        messageLabel = new JLabel();
        messageLabel.setText("Enter your user Id and password then click login");
        messageLabel.setBounds(100, 300, 350, 50);
        submit = new JButton("Login");
        submit.setBounds(100, 400, 100, 50);
        submit.addActionListener(this);
        create = new JButton("Create");
        create.setBounds(300, 400, 100, 50);
        create.addActionListener(this);
        frame.add(userName);
        frame.add(password);
        frame.add(messageLabel);
        frame.add(submit);
        frame.add(create);
        frame.setVisible(false);
        frame.setVisible(true);
    }
    
    @Override
    protected void action(ActionEvent ae) {
        if (ae.getSource() == submit){
            boolean correct = false;
            String un = userName.getText();
            String pw = password.getText();
            for (User user : users){
                if (un.equals(Integer.toString(user.getID())) && pw.equals(user.getPassWord())) {
                    parent.setUser(user);
                    correct = true;
                    frame.setVisible(false);
                    break;
                } 
            }
            if(correct == false) {
                messageLabel.setText("Incorrect Username or Password");
            }
        }
        else if(ae.getSource() == create){
            child = new NewUser(info,this);
        }
    }
}
