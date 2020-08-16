/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soft252git;

/**
 *
 * @author dillonlaskey
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MedStockVeiwer extends Page{
    JButton cancel;
    JButton[] increases,decreases;
    JPanel panel1,panel2,panel3,panel4;
    Medicine[] meds;
    MedStockVeiwer(Data database, User accessor, Page origin){
        super("Medicine",database,origin,accessor);
        meds = info.getMedStocks();
        increases = new JButton[0];
        decreases = new JButton[0];
        panel1 = new JPanel(new GridLayout(0,1));
        panel2 = new JPanel(new GridLayout(0,1));
        panel3 = new JPanel(new GridLayout(0,1));
        panel4 = new JPanel(new GridLayout(0,1));
        cancel = new JButton("Cancel");
        cancel.addActionListener(this);
        int Y = 20;
        for(Medicine m : meds){
            panel1.add(new JLabel(m.getMed()));
            panel1.setBounds(100, 100, 100, 0+Y);
            panel2.add(new JLabel(Integer.toString(m.getSupply())));
            panel2.setBounds(200, 100, 50, 0+Y);
            JButton decrease = new JButton("-");
            decreases = addB(decreases,decrease);
            decrease.addActionListener(this);
            panel3.add(decrease);
            panel3.setBounds(250, 100, 50, 0+Y);
            JButton increase = new JButton("+");
            increases = addB(increases,increase);
            increase.addActionListener(this);
            panel4.add(increase);
            panel4.setBounds(300, 100, 50, 0+Y);
            Y += 20;
        }
        frame.add(panel1);
        frame.add(panel2);
        frame.add(panel3);
        frame.add(panel4);
        cancel.setBounds(200, 400 + Y, 50, 20);
        frame.add(cancel);
        frame.setSize(500, 500+Y);
        frame.revalidate();
        frame.repaint();
    }
    
    private JButton[] addB(JButton[] list, JButton subject){
        JButton[] output = new JButton[list.length + 1];
        int place = 0;
        for (JButton item : list){
            output[place] = item;
            place += 1;
        }
        output[place] = subject;
        return output;
    }
    
    private void update(){
    frame.remove(panel2);
    int Y = 20;
    panel2.removeAll();
    for(Medicine m : meds){
        panel2.add(new JLabel(Integer.toString(m.getSupply())));
        panel2.setBounds(200, 100, 50, 0+Y);
        Y += 20;
    }
    frame.add(panel2);
    frame.revalidate();
    frame.repaint();
}
    @Override
    protected void action(ActionEvent ae){
        if(cancel == ae.getSource()){
            parent.closeChild();
            frame.setVisible(false);
        }
        int index = 0;
        for(JButton button : increases){
            if(button == ae.getSource()){
                info.raiseMeds(meds[index].getMed(), 1);
                update();
            }
            index += 1;
        }
        index = 0;
        for(JButton button : decreases){
            if(button == ae.getSource()){
                info.lowerMeds(meds[index].getMed(), 1);
                update();
            }
            index += 1;
        }
    }
}
