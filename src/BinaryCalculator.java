
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ItemListener;
import java.lang.*;

public class BinaryCalculator extends JFrame implements ItemListener {
    Choice os, so;
    JButton brez;
    JTextField t1, t2;
    JLabel l1, l2;
    Listener list = new Listener();
    Long value;
    String name="",name2="";


    public BinaryCalculator(String s) {
        super(s);

        setLayout(new FlowLayout());
        brez = new JButton("traduisez");
        t1 = new JTextField(20);
        t2 = new JTextField(20);
        l1 = new JLabel("Entrez votre numéro :                                                                          ");
        l2 = new JLabel("Votre résultat :                                          ");
        Choice os = new Choice();
        Choice so = new Choice();
        os.addItem("()");
        os.addItem("2");
        os.addItem("8");
        os.addItem("10");
        os.addItem("16");
        os.addItemListener(this);
        so.addItem("()");
        so.addItem("2");
        so.addItem("8");
        so.addItem("10");
        so.addItem("16");
        so.addItemListener(this);
        add(l1);
        add(l2);
        add(t1);
        add(os);
        add(so);
        add(t2);
        add(brez);
        brez.addActionListener(list);
        t2.setEditable(false);

        so.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie) {
                if(so.getSelectedItem() == "2"){
                    name2 = "2";
                }
                if(so.getSelectedItem() == "10"){
                    name2 = "10";
                }
                if(so.getSelectedItem() == "8"){
                    name2 = "8";
                }
                if(so.getSelectedItem() == "16"){
                    name2 = "16";
                }
            }
        });

        os.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent ie) {
                if(os.getSelectedItem() == "10"){
                    name = "10";
                }
                if(os.getSelectedItem() == "2"){
                    name = "2";
                }
                if(os.getSelectedItem() == "8"){
                    name = "8";
                }
                if(os.getSelectedItem() == "16"){
                    name = "16";
                }

            }
        });

    }





}
