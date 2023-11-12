package Calculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Calculator  {
	
	public static void main(String[] args) {
		
		Calculatrice calc= new Calculatrice();
	}

}


class Calculatrice implements ActionListener{
	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10] ;
	JButton[] functionButtons= new JButton[10];
	JButton addButton , subButton, mulButton, divButton;
	JButton decButton, equButton, delButton,clrButton,negButton,funButton;
	JPanel panel;
	// this font is optional, we can not use it 
	Font myFont = new Font("Ink Free", Font.BOLD,30);
	double num1=0,num2=0,result=0;
	char operator;
	
	
	 public Calculatrice () {
		 frame=new JFrame("Calculator");
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.setSize(400,500);
		 frame.setLayout(null);
		 textfield= new JTextField();
		 textfield.setBounds(50,20,300,50);
		 textfield.setFont(myFont);
		 textfield.setBackground(Color.white);
		 
		 
		 addButton= new JButton("+");
		 subButton= new JButton("-");
		 mulButton= new JButton("*");
		 divButton= new JButton("/");
		 decButton= new JButton(".");
		 equButton= new JButton("=");
		 clrButton= new JButton("Clear");
		 delButton= new JButton("Delete");
		 negButton= new JButton("(-)");
		 funButton= new JButton("Fun");

		 functionButtons[0]=addButton;
		 functionButtons[1]=subButton;
		 functionButtons[2]=mulButton;
		 functionButtons[3]=divButton;
		 functionButtons[4]=decButton;
		 functionButtons[5]=equButton;
		 functionButtons[6]=delButton;
		 functionButtons[7]=clrButton;
		 functionButtons[8]=negButton;
		 functionButtons[9]=funButton;

		 
		 for(int i=0 ;i<10; i++) {
			 functionButtons[i].addActionListener(this);
			 functionButtons[i].setFocusable(false);
			 if( functionButtons[i]!=funButton) {
			 functionButtons[i].setFont(myFont);
		  }	 
		 }
		 for(int i=0 ;i<10; i++) {
			 String s= String.valueOf(i);
			 numberButtons[i]= new JButton(s);
			 numberButtons[i].addActionListener(this);
			 numberButtons[i].setFont(myFont);
			 numberButtons[i].setFocusable(false);
		 }
		 funButton.setBounds(50,72,70,35);
		 negButton.setBounds(50,410,90,45);
		 delButton.setBounds(140,410,110,45);
		 clrButton.setBounds(250,410,100,45);
		 
		 
		 
		 // creating a new panel where we will add Buttons
		 panel= new JPanel();
		 panel.setBounds(50,110,300,290);
		 panel.setLayout(new GridLayout(4,4,10,10));
		 //panel.setBackground(Color.CYAN);
		 
		 panel.add(numberButtons[1]);
		 panel.add(numberButtons[2]);
		 panel.add(numberButtons[3]);
		 panel.add(addButton);
		 panel.add(numberButtons[4]);
		 panel.add(numberButtons[5]);
		 panel.add(numberButtons[6]);
		 panel.add(subButton);
		 panel.add(numberButtons[7]);
		 panel.add(numberButtons[8]);
		 panel.add(numberButtons[9]);
		 panel.add(mulButton);
		 panel.add(decButton);
		 panel.add(numberButtons[0]);
		 panel.add(equButton);
		 panel.add(divButton);
		 
		 
		
		 
		 textfield.setEditable(false);
		 frame.add(textfield);
		 frame.add(funButton);
		 frame.add(panel);
		 frame.add(negButton);
		 frame.add(clrButton);
		 frame.add(delButton);
		 frame.setVisible(true);
		 }
	 
	 /// Handling events 
	@Override
	public void actionPerformed(ActionEvent e) {
		 for(int i=0 ;i<10; i++) {
			 if( e.getSource()== numberButtons[i]){
				 textfield.setText(textfield.getText().concat(String.valueOf(i)));
			 }
		 }
		 if( e.getSource()== decButton){
			 textfield.setText(textfield.getText().concat("."));
		 }
		 if( e.getSource()== addButton){
			 String stringValue = String.valueOf(textfield.getText());
			 num1=Double.parseDouble(stringValue);
			 textfield.setText("");
			 operator='+';
		 }
		 if( e.getSource()== subButton){
			 String stringValue = String.valueOf(textfield.getText());
			 num1=Double.parseDouble(stringValue);
			 textfield.setText("");
			 operator='-'; 
		 }
		 if( e.getSource()== mulButton){
			 String stringValue = String.valueOf(textfield.getText());
			 num1=Double.parseDouble(stringValue);
			 textfield.setText("");
			 operator='*';
		 }
		 if( e.getSource()== divButton){
			 String stringValue = String.valueOf(textfield.getText());
			 num1=Double.parseDouble(stringValue);
			 textfield.setText("");
			 operator='/';
		 }
		 
		 if( e.getSource()== equButton){
			 String stringValue = String.valueOf(textfield.getText());
			 num2=Double.parseDouble(stringValue);
			 switch(operator) {
			 
			 case '*':
				 result=num1*num2;
				 break;
			 
			 case '-':
				 result=num1-num2;
				 break;
			 
			 case '+':
				 result=num1+num2;
				 break;
			 case '/':
				 result=num1/num2;
				 break;
			 }
			 
			 textfield.setText(String.valueOf(result));
		 }
		 if( e.getSource()== negButton){
			 double tmp=Double.parseDouble(String.valueOf(textfield.getText()));
			 tmp*=-1;
			 textfield.setText(String.valueOf(tmp));
		 }
		 if( e.getSource()== delButton){
			 String s=textfield.getText();
			 textfield.setText("");
			 for(int i=0 ;i<s.length()-1; i++) {
			 textfield.setText(textfield.getText()+s.charAt(i));
		   }
		 }		 
		 if( e.getSource()== clrButton){
			 textfield.setText("");
		 }
		 if( e.getSource()==funButton){
			 textfield.setText("");
		 }
		 
	}
	
	
	
}
