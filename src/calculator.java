import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.border.EmptyBorder;



public class calculator extends JFrame implements ActionListener {


    Choice os, so;
    JButton brez;
    JTextField t1, t2;
    JLabel l1, l2;
    ActionListener list ;
    Long value;
    String name="",name2="";



    private JPanel contentPane;
    private JMenu jMenuFile, jMenuHelp;
    private JPanel jMaster, jplBackSpace, jplControl;
    private JLabel jLabelOuput;
    private JButton JbnButtons[];
    private boolean firstInput = true;
    private String numStr1 = "";
    private String numStr2 = "";
    Font f12 = new Font("Times New Roman", 0, 14);
    Font f121 = new Font("Times New Roman", 1, 12);
    private char op;






    public calculator() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(200, 200, 550, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
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

                JbnButtons = new JButton[26];

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
        JbnButtons[18].addActionListener (list);

        JbnButtons[19] = new JButton("log");
        JbnButtons[19].addActionListener (list);

        JbnButtons[23] = new JButton ("cos");
        JbnButtons[24] = new JButton ("sin");
        JbnButtons[25] = new JButton ("tan");

        jplBackSpace = new JPanel();
        jplBackSpace.setLayout(new GridLayout(1, 1, 2, 2));
        JbnButtons[20] = new JButton("Binary Calculator");
        jplBackSpace.add(JbnButtons[20]);
        jplBackSpace.setBackground (Color.yellow);
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
        jPLButtons.add (JbnButtons[23]);
        // Second row
        for (int i = 4; i <= 6; i++) {
            jPLButtons.add(JbnButtons[i]);
        }
        // add button * and x^2
        jPLButtons.add(JbnButtons[14]);
        jPLButtons.add(JbnButtons[18]);
        jPLButtons.add (JbnButtons[24]);
        // Third row
        for (int i = 1; i <= 3; i++) {
            jPLButtons.add(JbnButtons[i]);
        }
        //adds button - and %
        jPLButtons.add(JbnButtons[15]);
        jPLButtons.add(JbnButtons[19]);
        jPLButtons.add (JbnButtons[25]);
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
//         TODO Auto-generated method stub
        String resultStr;
        String str = String.valueOf(e.getActionCommand());

        char ch = str.charAt(0);

        switch(ch)
        {
            case '0': case '1': case '2':
            case '3': case '4': case '5':
            case '6': case '7': case '8':
            case '9': if(firstInput)
            {
                numStr1 = numStr1 + ch;
                jLabelOuput.setText(numStr1);
            }
            else
            {
                numStr2 = numStr2 + ch;
                jLabelOuput.setText(numStr2);
            }
                break;
            case '+': case '-': case '*':  case 'p':                     //Step 4b

            case '/': op = ch;
                firstInput = false;
                break;

            case '=': resultStr = evaluate();                   //Step 4c
                jLabelOuput.setText(resultStr);
                numStr1 = resultStr;
                numStr2 = "";
                firstInput = false;
                break;

            case 'C': jLabelOuput.setText("");                  //Step 4c
                numStr1 = "";
                numStr2 = "";
                firstInput = true;

            case '√':
                jLabelOuput.setText (String.valueOf (Math.sqrt (Double.parseDouble (numStr1))));
                System.out.println (numStr1);
                firstInput = false;
                break;

            case 'l'  :
                jLabelOuput.setText (String.valueOf (Math.log (Double.parseDouble (numStr1))));
                System.out.println (numStr1);
                firstInput = false;
                break;

            case 'c' :
                jLabelOuput.setText (String.valueOf (Math.cos (Double.parseDouble (numStr1))));
                System.out.println (numStr1);
                firstInput = false;
                break;

            case 's':
                jLabelOuput.setText (String.valueOf (Math.sin (Double.parseDouble (numStr1))));
                System.out.println (numStr1);
                firstInput = false;
                break;

            case 't':
                jLabelOuput.setText (String.valueOf (Math.tan(Double.parseDouble (numStr1))));
                System.out.println (numStr1);
                firstInput = false;
                break;
        }

        if (e.getSource () == JbnButtons[20]){
            setVisible (false);

            BinaryCalculator c = new BinaryCalculator("binnary calculator");
            c.setVisible(true);
            c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            c.setSize(720, 150);
            c.setResizable(false);
            c.setLocationRelativeTo(null);

        }

        if (e.getSource () == JbnButtons[18]){

            double numDoub;

            numDoub = Double.parseDouble (numStr1);

//            jLabelOuput.setText (Math.pow (numDoub);
        }

    }


    private String evaluate() {
        double resultat = 0;
        int x = Integer.parseInt(numStr1);
        int y = Integer.parseInt(numStr2);
        double temp = 0;
        switch(op)
        {
            case '+':  resultat = x + y; break;
            case '-':  resultat = x - y; break;
            case '*':   resultat = x * y; break;
            case '/':   resultat = x / y; break;
            case 'p':  resultat = Math.pow (x,y); break;
        }

        temp = resultat;

        return String.valueOf(resultat);
    }






}
