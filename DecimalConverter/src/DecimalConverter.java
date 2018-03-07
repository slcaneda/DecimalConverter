import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * @author slcaneda
 * @version 4.6
 * class that takes a binary or hex input as string and converts to decimal string 
 */
public class DecimalConverter {
	/**
	 * main method that sets up the GUI and invokes methods that will do the conversion 
	 */
	public static void main(String[] args){
		
		// set size of window and add a title
		JFrame window = new JFrame("Lab: Exceptional Handling");
		window.setSize(600,400);
		
		//set size of panel
		JPanel region = new JPanel(new GridLayout(15,15));
		
		//create labels
		JLabel binary = new JLabel("Binary String");
		JLabel hex = new JLabel("Hexadecimal String");
		JLabel decimal1 = new JLabel("Decimal String");
		JLabel decimal2 = new JLabel("Decimal String");
		
		//create text fields
		JTextField input1 = new JTextField(30);
		JTextField input2 = new JTextField(30);
		JTextField output1 = new JTextField(30);
		JTextField output2 = new JTextField(30);
		
		//create buttons
		JButton button1 = new JButton("Convert to Decimal");
		JButton button2 = new JButton("Convert to Decimal");
		
		//add to the panel
		window.add(region);
		region.add(binary);
		region.add(input1);
		region.add(decimal1);
		region.add(output1);
		region.add(button1, BorderLayout.CENTER);
		region.add(hex);
		region.add(input2);
		region.add(decimal2);
		region.add(output2);
		region.add(button2, BorderLayout.SOUTH);
		window.setVisible(true);
		
        // safe exit
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// event when button 1 is pressed 
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String binaryText = input1.getText();
				String convert = parseBinary(binaryText);
				output1.setText(convert);
			}
		});
		
		// event when button 2 is pressed
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String hexText = input2.getText();
				String convert = parseHex(hexText);
				output2.setText(convert);
			}
		});
		
		
	}
	
	/**
	 * @return string
	 * main method that converts binary string to decimal string
	 * @param num the string of binary numbers to be converted into decimal form as a string
	 */
	public static String parseBinary(String num){
		try{
			
			String[] array = num.split("(?!^)");
			
			// check if proper
            boolean check;
            for(int i = 0; i < num.length(); i++){
            	check = array[i].matches("[01]+");
            	if(check == false){
                	throw new BinaryNumberFormatException(array[i]); 
                }
            }
            
			int converted = Integer.parseInt(num,2);
			String backToString = Integer.toString(converted);
			return backToString;
			
			
		}catch(BinaryNumberFormatException wrong){
			return wrong.error();
		}
		
	}
	
	/**
	 * @return String
	 * main method that converts hex string to decimal string
     * @param hex the string of hexadecimal numbers to be converted into decimal form as a string
     */
	public static String parseHex(String hex){
		try{
			
			String[] array = hex.split("(?!^)");
			String wrongChar; 
			
			// check if proper
            boolean check;
            for(int i = 0; i < hex.length(); i++){
            	check = array[i].matches("-?[0-9a-fA-F]+");
            	if(check == false){
                	throw new HexNumberFormatException(array[i]); 
                }
            }
			
			int converted = Integer.parseInt(hex,16);
			String backToString = Integer.toString(converted);
			return backToString;
			
			
		}catch(HexNumberFormatException wrong){
			return wrong.error();
		}
		
	}
	
	
	
}
