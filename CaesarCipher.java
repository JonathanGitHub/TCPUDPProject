public class CaesarCipher{
	private String message;

	public String encryption(String message){

		StringBuffer encryptedMessage = new StringBuffer("");
        int length = message.length();
        for (int i = 0; i < length; i++) {
        	char ch = message.charAt(i);
        	if(isLetter(ch)){
        		//int x = Character.getNumericValue(ch);
        		int x = (int)ch;
        		int n = 3;
        		int result = (x + n) % 122;
        		int finalResult;
        		if (result > 90 && result < 97){
        			finalResult = result - 90 + 64;
        		}
        		else if( result < 4) {
        			finalResult = result +  96;
        		}
        		else finalResult = result;
        		//System.out.println(finalResult);
        		//System.out.println(encryptedMessage.append(Character.toChars(finalResult)));
        		encryptedMessage.append(Character.toChars(finalResult));
        		//encryptedMessage.append(Character.toChars(ch + 3));// 'y' will overflow as non-letter
        	}
        	else{
        		encryptedMessage.append(Character.toChars(ch));
        	}
        }
		return encryptedMessage.toString();

	}
	public String decryption(String message){
		//char last = originalMessage.charAt(originalMessage.length() - 1);
		//int flag = Integer.parseInt(Character.toString(last));
		//String message = originalMessage.substring(0, originalMessage.length() - 1);
		StringBuffer decryptedMessage = new StringBuffer("");
        int length = message.length();
        for (int i = 0; i < length; i++) {
        	char ch = message.charAt(i);
        	if(isLetter(ch)){
        		int x = (int)ch;
        		int n = 3;
        		int result = (x - n) % 122;
        		//System.out.println("result = (x - n) % 122  ------>" + result);
        		int finalResult;
        		if (result > 90 && result < 97){
        			finalResult = result + 26;
        		}
        		else if( result < 65) {
        			finalResult = result +  26;
        		}
        		else finalResult = result;
        		decryptedMessage.append(Character.toChars(finalResult));
        	}
        	else{
        		decryptedMessage.append(Character.toChars(ch));
        	}
        }
        return decryptedMessage.toString();
        // if (flag == 0) {
        // 	return "The plan to " + decryptedMessage.toString() + " has been approved!";
        // }
        // else return "The plan to " + decryptedMessage.toString() + " has been rejected!";
		
	}
    public static boolean isLetter(char ch){
    	if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')){
    		return true;
    	}
    	else return false;
    }
	//helper to help you check if a string is an English word or not
	public static boolean isWord(String str){
		//note that "[a-zA-Z]*" will not eliminate empty string, you must use [a-zA-Z]+"
		//you can also use str.matches("[a-zA-Z]* && !element.equals("")
		//regular experssion is very useful!
		if(str.matches("[a-zA-Z]+")){
			return true;
		}
			else return false;
	}


}