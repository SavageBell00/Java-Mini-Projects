import java.util.Arrays;

public class Program01{
	public static final String MIN_NUMBER_LETTERS_FLAG = "-minNumberLetters"; // keyword for setting min letters for encryption function
	
	public static final String SECRET_NUMBER_FLAG = "-secretNumber"; // keyword for setting secret number for encryption function 

    public static final String[] lowerAlphabet = new String[]{"a", "b", "c", "d","e","f","g", "h", "i", "j", "k", "l", "m", "n","o","p","q","r","s","t","u","v","w","x","y","z"}; //an array of lower alphabet to compare for char 
	
	public static void main (String[] args) {
		
		
		/**
		 	Possible valid inputs:
			
                     0                1             2         3           4             5			
			encrypt || decrypt,-minNumberLetters, <int>, -secretNumber, <int> "<STRING TO ENCRYPT>"
			encrypt || decrypt, -secretNumber, <int>, "<STRING TO ENCRYPT>"
			encrypt || decrypt, -minNumberLetters, <INT>, "<STRING TO ENCRYPT>"
			encrypt || decrypt , "<STRING TO ENCRYPT>"
		*/
		

		boolean inputError = false;
		boolean encryption = false;
		boolean decryption = false;
		boolean isMinLettersSet = false;  // Flag is -minNumberLetters
		boolean isSecretNumberSet = false; // Flag is -secretNumber
        int secretNumber=13; // setting secret number to 13 incase user does not give one
        int minNumberLetters = 4; // setting the minNumberLetters to 4 in case user does not give one 

		
		// Checking to make sure args is not less than 2, and args[0] equals either decrypt or encrypt.
		
        if (args.length != 2 && args.length != 4 && args.length != 6) { //args length can only be 2, 4, or 6, if not, then the system exits
            printHelpMessage();
            System.exit(0);
        }

		
		// when args has two inputs its going to check for either encrypt || decrypt 
        if (args.length == 2){
			if (args[0].equalsIgnoreCase("encrypt")){
                encryption = true;
                encrypt(args[args.length -1], secretNumber, minNumberLetters);
            } else if (args[0].equalsIgnoreCase("decrypt")) {
                decryption = true;
                decrypt(args[args.length -1], secretNumber, minNumberLetters);}	
			
			// when args length is 4, checking for encrypt || decrypt, -secretNumber || -minNumberLetters, then an int 
        } else if (args.length == 4) { 
			
            if (args[0].equalsIgnoreCase("encrypt") && args[1].equalsIgnoreCase("-secretNumber")) {
				try {
                    secretNumber = Integer.parseInt(args[2]); 
                    encrypt(args[args.length -1], secretNumber, minNumberLetters); 
                    isSecretNumberSet=true;
                } catch (Exception e) {
                    printHelpMessage();
                }
				
            }else if (args[0].equalsIgnoreCase("decrypt") && args[1].equalsIgnoreCase("-secretNumber")) {
                try {
                    secretNumber = Integer.parseInt(args[2]); 
                    decrypt(args[args.length -1], secretNumber, minNumberLetters);
                    isSecretNumberSet=true;
                } catch (Exception e) {
                    printHelpMessage();
                }

            } else if (args[0].equalsIgnoreCase("encrypt") && args[1].equalsIgnoreCase("-minNumberLetters")) {
				try {
					minNumberLetters = Integer.parseInt(args[2]);
					encrypt(args[args.length -1], secretNumber, minNumberLetters); 
					isMinLettersSet=true;
				} catch (Exception e) {
					printHelpMessage();
				}
                
				
            }else if (args[0].equalsIgnoreCase("decrypt") && args[1].equalsIgnoreCase("-minNumberLetters")){
				try {
					minNumberLetters = Integer.parseInt(args[2]);
					decrypt(args[args.length -1],secretNumber, minNumberLetters); 
					isMinLettersSet=true;
					} catch (Exception e) {
						printHelpMessage();
					}
                
            } else {
                inputError = true;		
            }    
        } else { //when args.length equals 6
		
            if (args[0].equalsIgnoreCase("encrypt") && args[1].equalsIgnoreCase("-minNumberLetters") && args[3].equalsIgnoreCase("-secretNumber")) {
				try {
                    minNumberLetters = Integer.parseInt(args[2]);
                    args[3].equalsIgnoreCase("-secretNumber");
                    secretNumber = Integer.parseInt(args[4]);
                    encrypt(args[args.length -1], secretNumber, minNumberLetters); 
                } catch (Exception e) {
                    printHelpMessage();
                }
                    
            } else {
                inputError = true;			
            }
                

            if (args[0].equalsIgnoreCase("decrypt") && args[1].equalsIgnoreCase("-minNumberLetters") && args[3].equalsIgnoreCase("-secretNumber")) {
                try {
                    minNumberLetters = Integer.parseInt(args[2]);
                    args[3].equalsIgnoreCase("-minNumberLetters");
                    secretNumber = Integer.parseInt(args[4]);
                    decrypt(args[args.length -1], secretNumber, minNumberLetters);
                } catch (Exception e) {
                    printHelpMessage();
                }		
            } else {
                inputError = true;
            }  
        }  
	}
	
	// Encryption Method 
	public static String encrypt(String args, int secretNumber, int minNumberLetters) {
	
		int rot13 = secretNumber;
    
       
        String[] wordsToEncrypt = args.split(" ");
        String finalEncryption = "";
       
        for (String word : wordsToEncrypt) { //taking each word and splitting into char to convert into strings
            if(word.length() < minNumberLetters) {
                finalEncryption += word;
                
            } else {
                char[] wordToChar = word.toCharArray();
                String[] characterStrings = new String[wordToChar.length];
                for (int i=0; i < wordToChar.length; i++) {// taking char and putting into string
                    characterStrings[i] = Character.toString(wordToChar[i]);
                }
                String characters;
                
                // a for loop to encrypt characterStrings
                for (int i = 0; i < characterStrings.length; i++) {
                    characters = characterStrings[i];
                    

                    int index = Arrays.asList(lowerAlphabet).indexOf(characters);
                    if((index + secretNumber) >= 26) 
                        finalEncryption += lowerAlphabet[(index+secretNumber)-26];
                    else {
                        finalEncryption += lowerAlphabet[index+secretNumber];
                    }
                }
             }
            
            finalEncryption += " "; //preserving spaces
            
        }
        System.out.print(finalEncryption);
        return finalEncryption;
    }
	
	
	    // Decryption Method 
	public static String decrypt(String args, int secretNumber, int minNumberLetters){
		int rot13 = secretNumber;
		
        String[] wordsToDecrypt = args.split(" ");
        String finalDecryption = "";
       
        for (String word : wordsToDecrypt) { //taking each word and splitting into char to convert into strings

            if(word.length() < minNumberLetters) {
                finalDecryption += word;
                
            } else {
                char[] wordToChar = word.toCharArray();
                String[] characterStrings = new String[wordToChar.length];
                for (int i=0; i < wordToChar.length; i++) {// taking char and putting into string
                    characterStrings[i] = Character.toString(wordToChar[i]);

                }
                String characters;
                
                // a for loop to decrypt characterStrings
                for (int i = 0; i < characterStrings.length; i++) {
                    characters = characterStrings[i];

                    int index = Arrays.asList(lowerAlphabet).indexOf(characters);
                    if((index - secretNumber) < 0) 
                        finalDecryption += lowerAlphabet[(index-secretNumber)+26];
                    else {
                        finalDecryption += lowerAlphabet[index-secretNumber];
                    } 
                }
            }   
            finalDecryption += " "; //preserving spaces
            
        }
        System.out.print(finalDecryption);
        return finalDecryption;
	}
	
	public static void printHelpMessage() {
		System.out.println("Helper Method: Please either start with 'encrypt' or 'decrypt' followed by a sentence in quotations to encrypt or decrypt.");
		System.out.println("Valid inputs: encrypt or decrypt, -minNumberLetters or -secretNumber, follwed by an integer, then string in quotations to encrypt");
	}
}