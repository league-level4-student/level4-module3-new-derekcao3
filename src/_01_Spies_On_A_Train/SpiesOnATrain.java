package _01_Spies_On_A_Train;

import java.util.HashMap;

import _00_Intro_to_Linked_Lists.LinkedList;
import _00_Intro_to_Linked_Lists.Node;

public class SpiesOnATrain {

	/*
	 * A spy has made off with important intel from your intelligence agency! You
	 * know the spy is somewhere on this train(LinkedList). Your job is to find the
	 * suspect that matches the description given to you by the list of clues(the
	 * array).
	 * 
	 * Walk through the train, questioning each of the passengers about what they
	 * have seen and return the name of the most likely suspect.
	 * 
	 * The results are randomly generated each time so you should have a general
	 * case solution that carefully compares the clues to each passenger's
	 * testimony. Remember to use String methods to break up the passengers'
	 * statements.
	 */
	String findIntel(LinkedList<TrainCar> train, String[] clues) {

		Node<TrainCar> car = train.getHead();
		String pie1 = "";
		String briefcase1 = "";
		String phone1 = "";
		for (int i = 0; i < clues.length; i++) {

			System.out.println(clues[i]);

			String[] words = clues[i].split(" ");
			for (int j = 0; j < words.length; j++) {
				String w = words[j];
				if (w.equals("pie")) {
					pie1 = words[j - 1];
				} else if (w.equals("phone")) {
					phone1 = words[j - 1];
				} else if (w.equals("briefcase")) {
					briefcase1 = words[j - 1];
				}

			}
			
		}
		System.out.println(pie1);
		System.out.println(phone1);
		System.out.println(briefcase1);
		String name = "";
		while (car != null) {
			String question = car.getValue().questionPassenger();
			String saw = question;
			for (int i = 0; i < saw.length(); i++) {
				if (saw.charAt(i) == 'I') {
					saw = saw.substring(i);
				}
			}
			System.out.println(saw);
			String[] words = saw.split(" ");
			String pie2 = "";
			String briefcase2 = "";
			String phone2 = "";
			
			System.out.println(words.length);
			for (int i = 0; i < words.length; i++) {
				String w = words[i];
				if(w.equals("saw")) {
					name = words[i + 1];
				}
				if (w.equals("pie.")) {
					pie2 = words[i - 1];
					if(pie2.equals(pie1)) {
						name = words[2];
					}
				} else if (w.equals("phone.")) {
					phone2 = words[i - 1];
					if(phone2.equals(phone1)) {
						name = words[2];
					}
				} else if (w.equals("briefcase.")) {
					briefcase2 = words[i - 1];
					if(briefcase2.equals(briefcase1)) {
						name = words[2];
					}
				}
			}
			System.out.println(pie2);
			System.out.println(phone2);
			System.out.println(briefcase2);
			System.out.println(name);
			car = car.getNext();
		}

		return name;

	}

}
