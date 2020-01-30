/* SELF ASSESSMENT

 1. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?

        Mark out of 5: 4
        Comment: For loop variables could have been better

 2. Did I indent the code appropriately?

        Mark out of 5: 5
        Comment:  Code indented properly

 3. Did I write the createCipher function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20: 20
        Comment:  Function correct

 4. Did I write the encrypt function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20:  
        Comment: Function correct

 5. Did I write the decrypt function correctly (parameters, return type and function body) and invoke it correctly?

       Mark out of 20: 20  
        Comment: Function correct

 6. Did I write the main function body correctly (repeatedly obtaining a string and encrypting it and then decrypting the encrypted version)?

       Mark out of 25: 25
        Comment: Didn't have an escape parameter as could be encoded

 7. How well did I complete this self-assessment?

        Mark out of 5: 5
        Comment: Self assesment completed

 Total Mark out of 100 (Add all the previous marks): 99

*/ 
import java.lang.Math;
import java.util.Scanner;
public class Cipher {
	final static char[] ALPHABET_ARRAY = "abcdefghijklmnopqrstuvwxyz ".toCharArray();
	public static void main(String[] args) 
	{
		while(true) {
			System.out.print("Please enter a plain text (alphabetical) message to be encrypted: ");
			Scanner inputScanner = new Scanner(System.in);
			char[] cipher = createCipher();
			if(inputScanner.hasNextLine()) {
				String unencryptedString = inputScanner.nextLine();
				String encryptedString = encrypt(unencryptedString, cipher);
				System.out.println("Your message is now encrypted as " + encryptedString);
				String decryptedMessage = decrypt(encryptedString, cipher);
				System.out.println("Your message has been decrypted. Your message was " + decryptedMessage);
			}
		}

	}
	
	public static char[] createCipher()
	{
		char[] characterArray = "abcdefghijklmnopqrstuvwxyz ".toCharArray();
		char[] cipher = new char[27];
		for(int count = 0; count <= 26; count++)
		{
			int randomNumber = (int) Math.floor(Math.random() * (27-count));
			cipher[count] = characterArray[randomNumber];
			characterArray[randomNumber] = 0;
			char[] tempCharArray = new char[(27-(count+1))];
			int newCount = 0;
			int tempArrayCount = 0;
			while(tempArrayCount < tempCharArray.length) 
			{
				if(characterArray[newCount] != 0) 
				{
					tempCharArray[tempArrayCount] = characterArray[newCount];
					newCount++;
					tempArrayCount++;
				}
				else
				{
					newCount++;
				}
			}
			characterArray = new char[27-(count+1)];
			System.arraycopy(tempCharArray, 0, characterArray, 0, 27-(count+1));
		}
		return cipher;
	}
	
	public static String encrypt(String plainTextPhrase, char[] cipher)
	{
		char[] phraseAsCharArray = plainTextPhrase.toLowerCase().toCharArray();
		String encryptedPhrase = "";
		for(int index = 0; index < phraseAsCharArray.length; index++)
		{
			for(int count = 0; count < 27; count++) 
			{
				if(phraseAsCharArray[index] == ALPHABET_ARRAY[count])
				{
					encryptedPhrase += cipher[count];
				}
			}
		}
		return encryptedPhrase;
	}
	
	public static String decrypt(String encryptedPhrase, char[] cipher)
	{
		char[] phraseAsCharArray = encryptedPhrase.toCharArray();
		String decryptedPhrase = "";
		for(int index = 0; index < phraseAsCharArray.length; index++)
		{
			for(int count = 0; count < 27; count++) 
			{
				if(phraseAsCharArray[index] == cipher[count])
				{
					decryptedPhrase += ALPHABET_ARRAY[count];
				}
			}
		}
		return decryptedPhrase;
	}
}


