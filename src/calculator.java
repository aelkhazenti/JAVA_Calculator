import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculator extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JMenu jMenuFile, jMenuHelp;
    private JPanel jMaster, jplBackSpace, jplControl;
    private JLabel jLabelOuput;
    private JButton JbnButtons[];
    private boolean firstInput = true;
    private String numStr1 = "";
    private String numStr2 = "";
    Font f12 = new Font("Times New Roman", 0, 12);
    Font f121 = new Font("Times New Roman", 1, 12);
    private char op;
    ActionListener list ;

    public calculator() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200, 550, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder (5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout (0, 0));
        setContentPane(contentPane);

        // MEnu File
        jMenuFile = new JMenu("File");

        // MEnu Help
        jMenuHelp = new JMenu("Help");

        // Menu Bar
        JMenuBar mb = new JMenuBar();
        mb.add(jMenuFile);
        mb.add(jMenuHelp);
        setJMenuBar(mb);

        // frame componant
        jMaster = new JPanel();
        jLabelOuput = new JLabel("0");

        // add our componante to fram
        getContentPane().add(jLabelOuput, BorderLayout.NORTH);

        JbnButtons = new JButton[23];

        for(int i = 0; i<= 9; i++) {
            JbnButtons[i] = new JButton(String.valueOf(i));
        }


        // Create operator Jbuttons
        JbnButtons[10] = new JButton("+/-");
        JbnButtons[11] = new JButton(".");
        JbnButtons[12] = new JButton("=");
        JbnButtons[13] = new JButton("/");
        JbnButtons[14] = new JButton("*");
        JbnButtons[15] = new JButton("-");
        JbnButtons[16] = new JButton("+");
        JbnButtons[17] = new JButton("√");
        JbnButtons[18] = new JButton("pow");
        JbnButtons[19] = new JButton("log");
        jplBackSpace = new JPanel();
        jplBackSpace.setLayout(new GridLayout(1, 1, 2, 2));
        JbnButtons[20] = new JButton("Backspace");
        jplBackSpace.add(JbnButtons[20]);

        JbnButtons[20].addActionListener (list);
        jplControl = new JPanel();
        jplControl.setLayout(new GridLayout(1, 2, 2, 2));
        JbnButtons[21] = new JButton(" CE ");
        JbnButtons[22] = new JButton("C");
        jplControl.add(JbnButtons[21]);
        jplControl.add(JbnButtons[22]);
        //		Setting all Numbered JButton's to Blue. The rest to Red
        for (int i = 0; i < JbnButtons.length; i++) {
            JbnButtons[i].setFont(f12);
            if (i < 10)
                JbnButtons[i].setForeground(Color.blue);
            else
                JbnButtons[i].setForeground(Color.red);
        }

        JPanel jPLButtons = new JPanel();
        jPLButtons.setLayout(new GridLayout(4, 5, 2, 2));

        // add button to the jPLButtons
        for(int i = 7; i<=9; i++) {
            jPLButtons.add(JbnButtons[i]);
        }


        // add button / and sqrt
        jPLButtons.add(JbnButtons[13]);
        jPLButtons.add(JbnButtons[17]);
        // Second row
        for (int i = 4; i <= 6; i++) {
            jPLButtons.add(JbnButtons[i]);
        }
        // add button * and x^2
        jPLButtons.add(JbnButtons[14]);
        jPLButtons.add(JbnButtons[18]);
        // Third row
        for (int i = 1; i <= 3; i++) {
            jPLButtons.add(JbnButtons[i]);
        }
        //adds button - and %
        jPLButtons.add(JbnButtons[15]);
        jPLButtons.add(JbnButtons[19]);
        //Fourth Row
        // add 0, +/-, ., +, and =
        jPLButtons.add(JbnButtons[0]);
        jPLButtons.add(JbnButtons[10]);
        jPLButtons.add(JbnButtons[11]);
        jPLButtons.add(JbnButtons[16]);
        jPLButtons.add(JbnButtons[12]);

        // JPANEL MASET
        jMaster.setLayout(new BorderLayout());
        jMaster.add(jPLButtons, BorderLayout.SOUTH);
        jMaster.add(jplBackSpace, BorderLayout.WEST);
        jMaster.add(jplControl, BorderLayout.EAST);



        // add componant to frame
        getContentPane().add(jMaster, BorderLayout.SOUTH);
        requestFocus();

        //add listenner to button
        for(int i = 0; i< JbnButtons.length; i++) {
            JbnButtons[i].addActionListener(this);
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


}