package BaiTapLop;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;

public class MyCaesar {
	public static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	private int n;// shift steps (right shift)

	public MyCaesar(int shiftSteps) {
		this.n = shiftSteps;
	}

	// Encrypt a character according to the given shif steps.
	// Encrypt: En(x) = (x + n) mod 26. x represents the index of c in the
	// ALPHABET
	// array
	public char encryptChar(char c) {
		int x = 0;
		char result = 0;
		for (int i = 0; i < ALPHABET.length; i++) {
			if (c == ALPHABET[i]) {
				x = i;
				result = ALPHABET[((x + n) % 26)];
			}
		}
		return result;
	}

	public int encryptNum(int num) {
		return (num + n) % 10;
	}

	public int decryptNum(int num) {
		return (num - n) % 10;
	}

	// Encrypt a text using the above function for encrypting a charater.
	public String encrypt(String input) {
		String output = "";
		for (int i = 0; i < input.length(); i++) {
			output += encryptChar(input.charAt(i));
		}

		return output;
	}

	// Decrypt a character according to the given shif steps.
	// Decrypt: Dn(x) = (x – n) mod 26. x represents the index of c in
	// the ALPHABET array
	public char decryptChar(char c) {
		int x = 0;
		char result = 0;
		for (int i = 0; i < ALPHABET.length; i++) {
			x = i;

			if (c == ALPHABET[i] && x - n >= 0) {
				result = ALPHABET[(x - n) % 26];
			} else if (c == ALPHABET[i] && x - n < 0) {
				result = ALPHABET[(26 - Math.abs(x - n)) % 26];

			}
		}
		return result;

	}

	// Decrypt a encrypted text using the above function for decrypting a
	// charater.
	public String decrypt(String input) {
		String output = "";
		for (int i = 0; i < input.length(); i++) {
			output += decryptChar(input.charAt(i));
		}

		return output;
	}

	public String scanner() {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int index = 0;
		String result = "";

		for (int i = 0; i < s.length(); i++) {
			if (Character.isUpperCase(s.charAt(i))) {
				result += encryptChar(s.charAt(i));
			} else if (Character.isDigit(s.charAt(i))) {
				result += encryptNum(s.charAt(i));
			}else {
				result+=s.charAt(i);
			}
		}
		return result;
	}
	public static void readFile() {
		
		
		
	}

	public static void main(String[] args) {

//		MyCaesar myCaesar = new MyCaesar(3);
//		System.out.println(myCaesar.encryptChar('Z'));
//		System.out.println(myCaesar.decryptChar('L'));
//		System.out.println(myCaesar.encrypt("LANG"));
//		System.out.println(myCaesar.decrypt("LANG"));
//		System.out.println(myCaesar.encryptNum(8));
//		System.out.println(myCaesar.decryptNum(8));
//		System.out.println(myCaesar.scanner());
		File f = new File("D:\\Cope_nam2\\DSA\\src\\BaiTapLop\\MyCaesar.java\\ReadFile.txt");
		try {
			List<String> allTexts = Files.readAllLines(f.toPath(), StandardCharsets.UTF_8);
			for (String line : allTexts) {
				System.out.println(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
