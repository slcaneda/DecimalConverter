/**
 * @author slcaneda
 * exception class that is thrown when binary string is not valid 
 *
 */
public class BinaryNumberFormatException extends Exception{
	private String message;
	private String letter; 
	
	/**
	 * @param letter - parameter to be stored in letter variable 
	 * constructor of the class
	 */
	public BinaryNumberFormatException(String letter){
		this.letter = letter; 
		message = "Invalid Format for a binary string. Illegal character: "+letter;
	}
	/**
	 * @return String
	 * method that returns an error message 
	 */
	public String error(){
		return message;
	}
	
}
