import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.*;
import java.text.DecimalFormat;

public class LoanCalculator extends JFrame
{
	private static DecimalFormat outputFormatter = new DecimalFormat(".##");
	//Form Elements 
	JTextField Air = new JTextField(15);
	JTextField Noy = new JTextField(15); 
	JTextField La = new JTextField(15); 
	JTextField Mp = new JTextField(15); 
	JTextField Tp = new JTextField(15); 
	JButton Calc = new JButton("Compute Payment");
	
	//Fields
	double annualInterestRate; 
	double loanAmount;
	double monthlyInterestRate;
	double numberOfYears;
	double monthlyPayment;
	double totalPayment;
	
	
	public LoanCalculator()
	{
		//6 row and 2 column
		setLayout(new GridLayout(6,2,5,5));
		
		//row 1
		add(new JLabel("Annual Interest Rate: "));
		add(Air);
		
		//row 2
		add(new JLabel("Number of Years: "));
		add(Noy);
		
		//row 3
		add(new JLabel("Loan Amount: "));
		add(La);
		
		//row 4
		add(new JLabel("Monthly Payment: "));
		add(Mp);
		
		
		//row 5
		add(new JLabel("Total Payment: "));
		add(Tp);
		
		//row 6
		add(new JLabel(""));
		add(Calc);
		
		ComputeListenerClass listener1 = new ComputeListenerClass();
		Calc.addActionListener(listener1);
		
	}
	
	
	public static void main(String[] args)
	{
		LoanCalculator frame = new LoanCalculator();
		frame.setTitle("Parth - Loan Clac - 300986134");
		frame.setSize(350,300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	class ComputeListenerClass implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			annualInterestRate = Double.valueOf(Air.getText()); 
			numberOfYears = Double.valueOf(Noy.getText());
			loanAmount = Double.valueOf(La.getText());
			
			monthlyInterestRate = annualInterestRate / 1200;
			monthlyPayment = loanAmount * monthlyInterestRate / (1 - (1 / Math.pow(1+ monthlyInterestRate, numberOfYears * 12)));
			totalPayment  =  monthlyPayment * numberOfYears * 12;
			
			Tp.setText(String.valueOf(outputFormatter.format(totalPayment)));
			Mp.setText(String.valueOf(outputFormatter.format(monthlyPayment)));
		}
	}
}
