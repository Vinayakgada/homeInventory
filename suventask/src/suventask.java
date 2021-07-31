
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.Border;

class Loan {

    JFrame frame;
    JLabel loanbalance;
    JLabel interestrate;
    JLabel numberofpayments;
    JLabel Monthlypayment,Analysis;
    JTextField balancetext,ratetext,numberofpaymentstext,permonthtext;
    JTextArea analysistotal;
    JButton cross1,cross2,newanalysis,Compute,Exit;

    Color lightyellow=new Color(255,255,128);
    boolean computePaymentmonthly=true;


    Loan()
    {
        frame=new JFrame();
        loanbalance=new JLabel("Loan Balance");
        interestrate=new JLabel("Interest Rate");
        numberofpayments=new JLabel("Number of Payments");
        Monthlypayment=new JLabel("Monthly Payment");
        Analysis=new JLabel("Loan Analysis");
        balancetext=new JTextField();
        ratetext=new JTextField();
        numberofpaymentstext=new JTextField();
        permonthtext=new JTextField();
        analysistotal=new JTextArea();
        cross1=new JButton("x");
        cross2=new JButton("x");
        Exit=new JButton("Exit");
        Compute=new JButton("Compute Monthly Payment");
        newanalysis=new JButton("Start new Analysis");
        frame.setTitle("Loan Assistant");
        //frame.setResizable(false);
        frame.getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints gridConstraints;
        frame.pack();
        Dimension screeSize=Toolkit.getDefaultToolkit().getScreenSize();
        //frame.setBounds(400,400,400,400);
        frame.setBounds((int)(0.5*(screeSize.width-frame.getWidth())),(int)(0.5*(screeSize.height-frame.getHeight())),frame.getWidth(),frame.getHeight());
        frame.setVisible(true);
        Font font=new Font("Arial",Font.PLAIN,16);
        loanbalance.setFont(font);
        interestrate.setFont(font);


        gridConstraints=new GridBagConstraints();
        gridConstraints.gridx=0;
        gridConstraints.gridy=0;
        gridConstraints.anchor=GridBagConstraints.WEST;
        gridConstraints.insets=new Insets(10,10,0,0);
        frame.getContentPane().add(loanbalance,gridConstraints);

        balancetext.setFont(font);
        balancetext.setPreferredSize(new Dimension(100,25));
        balancetext.setHorizontalAlignment(SwingConstants.RIGHT);
        gridConstraints=new GridBagConstraints();
        gridConstraints.gridx=1;
        gridConstraints.gridy=0;
        //gridConstraints.anchor=GridBagConstraints.WEST;
        gridConstraints.insets=new Insets(10,10,0,10);
        frame.getContentPane().add(balancetext,gridConstraints);


        balancetext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                balancetext.transferFocus();
            }
        });


        gridConstraints=new GridBagConstraints();
        gridConstraints.gridx=0;
        gridConstraints.gridy=1;
        gridConstraints.anchor=GridBagConstraints.WEST;
        gridConstraints.insets=new Insets(10,10,0,0);
        frame.getContentPane().add(interestrate,gridConstraints);

        ratetext.setFont(font);
        ratetext.setHorizontalAlignment(SwingConstants.RIGHT);
        ratetext.setPreferredSize(new Dimension(100,25));
        gridConstraints=new GridBagConstraints();
        gridConstraints.gridx=1;
        gridConstraints.gridy=1;
        //	gridConstraints.anchor=GridBagConstraints.WEST;
        gridConstraints.insets=new Insets(10,10,0,10);
        frame.getContentPane().add(ratetext,gridConstraints);

        ratetext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                ratetext.transferFocus();
            }
        });


        numberofpayments.setFont(font);
        gridConstraints=new GridBagConstraints();
        gridConstraints.gridx=0;
        gridConstraints.gridy=2;
        gridConstraints.anchor=GridBagConstraints.WEST;
        gridConstraints.insets=new Insets(10,10,0,0);
        frame.getContentPane().add(numberofpayments,gridConstraints);


        numberofpaymentstext.setFont(font);
        numberofpaymentstext.setPreferredSize(new Dimension(100,25));
        numberofpaymentstext.setHorizontalAlignment(SwingConstants.RIGHT);
        gridConstraints=new GridBagConstraints();
        gridConstraints.gridx=1;
        gridConstraints.gridy=2;
        //gridConstraints.anchor=GridBagConstraints.WEST;
        gridConstraints.insets=new Insets(10,10,0,10);
        frame.getContentPane().add(numberofpaymentstext,gridConstraints);

        numberofpaymentstext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                numberofpaymentstext.requestFocus();
            }
        });
        Monthlypayment.setFont(font);
        gridConstraints=new GridBagConstraints();
        gridConstraints.gridx=0;
        gridConstraints.gridy=3;
        gridConstraints.anchor=GridBagConstraints.WEST;
        gridConstraints.insets=new Insets(10,10,0,0);
        frame.getContentPane().add(Monthlypayment,gridConstraints);

        permonthtext.setFont(font);
        permonthtext.setPreferredSize(new Dimension(100,25));
        permonthtext.setHorizontalAlignment(SwingConstants.RIGHT);
        gridConstraints=new GridBagConstraints();
        gridConstraints.gridx=1;
        gridConstraints.gridy=3;
        //gridConstraints.anchor=GridBagConstraints.WEST;
        gridConstraints.insets=new Insets(10,10,0,10);
        frame.getContentPane().add(permonthtext,gridConstraints);

        permonthtext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)
            {
                permonthtext.transferFocus();
            }
        });


        gridConstraints=new GridBagConstraints();
        gridConstraints.gridx=2;
        gridConstraints.gridy=2;
        cross1.setFocusable(false);
        //gridConstraints.anchor=GridBagConstraints.WEST;
        gridConstraints.insets=new Insets(10,0,0,0);
        frame.getContentPane().add(cross1,gridConstraints);

        //cross1.setVisible(true);
        cross2.setVisible(false);
        permonthtext.setBackground(lightyellow);
        cross1.addActionListener(new ActionListener() {;

            public void actionPerformed(ActionEvent e) {


                cross1to2();

            }});


        gridConstraints=new GridBagConstraints();
        gridConstraints.gridx=2;
        gridConstraints.gridy=3;
        cross2.setFocusable(false);
        //gridConstraints.anchor=GridBagConstraints.WEST;
        gridConstraints.insets=new Insets(10,0,0,0);
        frame.getContentPane().add(cross2,gridConstraints);


        cross2.addActionListener(new ActionListener() {;

            public void actionPerformed(ActionEvent e) {


                cross2to1();

            }});




        Compute.setFont(font);
        gridConstraints=new GridBagConstraints();
        gridConstraints.gridx=0;
        gridConstraints.gridy=4;
        gridConstraints.gridwidth=2;
        //	gridConstraints.anchor=GridBagConstraints.WEST;
        gridConstraints.insets=new Insets(10,0,0,0);
        frame.getContentPane().add(Compute,gridConstraints);

        Compute.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {


                Calculate(e);

            }});






        gridConstraints=new GridBagConstraints();
        gridConstraints.gridx=0;
        gridConstraints.gridy=5;
        gridConstraints.gridwidth=2;
        //gridConstraints.anchor=GridBagConstraints.WEST;
        gridConstraints.insets=new Insets(10,0,10,0);
        frame.getContentPane().add(newanalysis,gridConstraints);
        newanalysis.setEnabled(false);


        newanalysis.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                if(computePaymentmonthly)
                    permonthtext.setText(" ");
                else
                    numberofpaymentstext.setText(" ");

                analysistotal.setText(" ");
                Compute.setEnabled(true);
                newanalysis.setEnabled(false);
                balancetext.requestFocus();


            }});



        //label
        Analysis.setFont(font);
        gridConstraints=new GridBagConstraints();
        gridConstraints.gridx=3;
        gridConstraints.gridy=0;
        gridConstraints.anchor=GridBagConstraints.WEST;
        gridConstraints.insets=new Insets(0,10,0,0);
        frame.getContentPane().add(Analysis,gridConstraints);




        //textfield
        analysistotal.setFont(font);
        analysistotal.setFocusable(false);
        analysistotal.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        analysistotal.setFont(new Font("Courier New",Font.PLAIN,14));
        analysistotal.setEditable(false);
        analysistotal.setBackground(Color.WHITE);
        gridConstraints=new GridBagConstraints();
        gridConstraints.gridx=3;
        gridConstraints.gridy=1;
        gridConstraints.gridheight=4;
        //gridConstraints.anchor=GridBagConstraints.WEST;
        gridConstraints.insets=new Insets(0,10,0,10);
        //analysis.setBounds(100, 100,200, 200);
        analysistotal.setPreferredSize(new Dimension(200,150));
        frame.getContentPane().add(analysistotal,gridConstraints);




        gridConstraints=new GridBagConstraints();

        gridConstraints.gridx=3;
        gridConstraints.gridy=5;
        Exit.setFocusable(false);
        //	gridConstraints.anchor=GridBagConstraints.WEST;
        //gridConstraints.insets=new Insets(10,10,0,0);
        frame.getContentPane().add(Exit,gridConstraints);

        Exit.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {


                ExitOperation(e);

            }});


        frame.pack();
        screeSize=Toolkit.getDefaultToolkit().getScreenSize();
        //frame.setBounds(400,400,400,400);
        frame.setBounds((int)(0.5*(screeSize.width-frame.getWidth())),(int)(0.5*(screeSize.height-frame.getHeight())),frame.getWidth(),frame.getHeight());


        //firstmode=given permont calc numberof months
        //second=given numberof months calc permonth

    }

    private void cross1to2()//compute number of months
    {
        cross1.setVisible(false);
        cross2.setVisible(true);
        computePaymentmonthly=false;
        numberofpaymentstext.setBackground(lightyellow);
        numberofpaymentstext.setText("");
        numberofpaymentstext.setEditable(false);
        //computenumberofpayment.setEnabled(false);
        permonthtext.setFocusable(true);
        permonthtext.setEditable(true);
        permonthtext.setBackground(Color.WHITE);
        Compute.setText("Compute Number Of Payments");
        balancetext.requestFocus();



    }



    private void cross2to1()//compute monthlypayment
    {
        cross2.setVisible(false);
        cross1.setVisible(true);
        computePaymentmonthly=true;
        numberofpaymentstext.setEditable(true);
        numberofpaymentstext.setBackground(Color.WHITE);
        numberofpaymentstext.setFocusable(true);
        permonthtext.setBackground(lightyellow);
        permonthtext.setFocusable(false);
        permonthtext.setText("");
        permonthtext.setEditable(false);

        Compute.setText("Compute Monthly Payment");
        balancetext.requestFocus();

    }

    private void ExitOperation(ActionEvent e)
    {
        System.exit(0);
    }




    private void Calculate(ActionEvent e)
    {
        double balance;
        double interestrate;

        double monthlyinterest;
        int months=0;
        double payment;
        double multiplier;
        double loanbalance,finalpayment;

        if(ValidateDecimalNumber(balancetext)) {
            balance=Double.parseDouble(balancetext.getText());
        }
        else
        {
            JOptionPane.showConfirmDialog(null,"Invalid or Empty Loan Balance entry.\nPlease correct.","Balance Input Error",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        if(ValidateDecimalNumber(ratetext)) {
            interestrate=Double.parseDouble(ratetext.getText());
        }
        else
        {
            JOptionPane.showConfirmDialog(null,"Invalid or Empty interest Rate entry.\nPlease correct.","Interest Input Error",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        monthlyinterest=interestrate/12;

        if(computePaymentmonthly)
        {
            if(ValidateDecimalNumber(numberofpaymentstext))
            {
                months=Integer.parseInt(numberofpaymentstext.getText());
            }
            else
            {
                JOptionPane.showConfirmDialog(null,"Invalid or Empty Number Of Payments entry.\nPlease correct.","Number of Payments Input Error",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if(interestrate==0)
                payment=balance/months;
            else
            {
                multiplier=Math.pow(1+monthlyinterest,months);
                payment=balance*monthlyinterest*multiplier/(multiplier-1);
            }

            permonthtext.setText(new DecimalFormat("0.00").format(payment));


        }
        else
        {
            if(ValidateDecimalNumber(permonthtext))
            {
                payment=Double.parseDouble(permonthtext.getText());


                if(payment<=(balance*monthlyinterest+1.0))
                {
                    if(JOptionPane.showConfirmDialog(null,"Minimum payment must be $"+new DecimalFormat("0.00").format((int)(balance*monthlyinterest+1.0))+"\n"+"Do you want to use the minimum payment?","Input Error",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE)==JOptionPane.YES_OPTION){
                        permonthtext.setText(new DecimalFormat("0.00").format((int)(balance*monthlyinterest+1.0)));

                        payment=Double.parseDouble(permonthtext.getText());
                    }
                    else
                    {
                        permonthtext.requestFocus();
                        return;
                    }
                }

            }
            else
            {
                JOptionPane.showConfirmDialog(null,"Invalid or empty Monthly Payment entry.\nPlease Correct.","Payment Input Error",JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            if(interestrate==0)
            {
                months=(int)(balance/payment);
            }
            else
            {
                months=(int) ((Math.log(payment)-Math.log(payment-balance*monthlyinterest))/Math.log(1+monthlyinterest));
            }
            numberofpaymentstext.setText(String.valueOf(months));


        }

        payment=Double.parseDouble(permonthtext.getText());
        analysistotal.setText("Loan Balance:$"+new DecimalFormat("0.00").format(balance));
        analysistotal.append("\n"+"Interest Rate:"+new DecimalFormat("0.00").format(interestrate)+"%");

        loanbalance=balance;
        for(int pn=1;pn<=months-1;pn++)
        {
            loanbalance+=loanbalance*monthlyinterest-payment;
        }
        finalpayment=loanbalance;
        if(finalpayment>payment)
        {
            loanbalance+=loanbalance*monthlyinterest-payment;
            finalpayment=loanbalance;
            months++;
            numberofpaymentstext.setText(String.valueOf(months));
        }
        analysistotal.append("\n\n"+months+" Payments of $"+(new DecimalFormat("0.00").format(payment)));
        analysistotal.append("\nFinal Payment of: $"+(new DecimalFormat("0.00").format(finalpayment)));
        analysistotal.append("\nTotal Payments: $"+(new DecimalFormat("0.00").format((months-1)*payment+finalpayment)));
        analysistotal.append("\nInterest Paid: $"+(new DecimalFormat("0.00").format((months-1)*payment+finalpayment-balance)));;

        Compute.setEnabled(false);
        newanalysis.setEnabled(true);
        newanalysis.requestFocus();



    }

    private  boolean ValidateDecimalNumber(JTextField t)
    {
        String text=t.getText().trim();
        boolean hasDecimal=false;
        boolean valid=true;
        if(text.length()==0) {
            valid=false;
            //return valid;
        }
        else
        {
            for(int i=0;i<text.length();i++)
            {
                if(text.charAt(i)>='0'&&text.charAt(i)<='9')
                    continue;

                else if(text.charAt(i)=='.'&&!hasDecimal)
                    hasDecimal=true;
                else
                    valid=false;
            }
        }
        t.setText(text);
        if(!valid)
            t.requestFocus();

        return valid;

    }


    public static void main(String[] args)
    {
        Loan loan=new Loan();
    }


}
