import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

import java.util.Scanner;

public class WordDictionaryRunner {

	public static void main(String[] args) {
		Map<String, Set<String>> dictionary = new HashMap<>();
		String userInput = "-";

		Scanner s = new Scanner(System.in);

		do {
			System.out.println("Please enter the word whose synonyms you want to check. Enter 0 if you want to exit.");

			userInput = s.next();

			if (userInput.equals("0")) {
				break;
			}

			if (!dictionary.containsKey(userInput)) {
				System.out.println(
						"Sorry, the word you entered is not entered in the dictionary. Would you like to enter the synonyms of this word ? (Y/N)");
				char userChoice = s.next().charAt(0);

				String synonym = "-";

				while (Character.toUpperCase(userChoice) == 'Y') {
					System.out.println("Please enter the synonym. Enter 0 to stop entering synonyms.");
					synonym = s.next();

					if (synonym.equals("0")) {
						break;
					}

					if (!dictionary.containsKey(userInput)) {
						Set<String> synonyms = new HashSet<>();
						synonyms.add(synonym);
						dictionary.put(userInput, synonyms);
					} else {
						dictionary.get(userInput).add(synonym);
					}
				}

			} else {
				Set<String> synonyms = dictionary.get(userInput);

				for (String synonym : synonyms) {
					System.out.println(synonym);
				}
			}
		} while (true);

	}

}
