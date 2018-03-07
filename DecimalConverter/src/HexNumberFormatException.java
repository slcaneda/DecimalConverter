/**
 * @author slcaneda
 * exception class that is thrown when a hexadecimal string is not valid 
 *
 */
public class HexNumberFormatException extends Exception {
	private String message;
	private String letter; 
	
	/**
	 * @param letter - parameter to be stored in letter variable 
	 * constructor of the class
	 */
	public HexNumberFormatException(String letter){
		this.letter = letter; 
		message = "Invalid Format for a hex string. Illegel character: "+letter;
	}
	/**
	 * @return String
	 * method that returns an error message 
	 */
	public String error(){
		return message;
	}
	
	
}
