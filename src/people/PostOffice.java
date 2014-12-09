package people;

import java.util.Random;

import letters.Letter;
import letters.Money;
import letters.PromissaryNote;
import letters.RegisteredLetter;
import letters.SimpleLetter;
import letters.Text;
import letters.UrgentLetter;

public class PostOffice {

	public static void main(String[] args) {

		int nbOfDays = 6;
		int day = 1;
		int indexSender;
		int indexReceiver;
		Random r = new Random();

		City c = new City(
				"Llanfairpwllgwyngyllgogerychwyrndrobwllllantysiliogogogoch");

		for (int i = 1; i < 101; i++) {
			Bankaccount bankAccount = new Bankaccount(5000);
			Inhabitant inh = new Inhabitant("inhabitant-" + i, c, bankAccount);
			c.getInhabitants().add(inh);
		}

		System.out.println("Creating " + c.getName());
		System.out.println("Creating " + c.getInhabitants().size()
				+ " inhabitants");
		System.out.println("Mailing letters for " + nbOfDays + " days");

		for (int i = 0; i < nbOfDays; i++) {
			System.out
					.println("***********************************************");
			System.out.println("Day " + day);
			c.distributeLetters();
			Text defaultText = new Text("bla bla");
			for (int j = 0; j < r.nextInt(3) + 1; j++) {
				int randomNumber = r.nextInt(8) + 1;
				if (randomNumber == 1) {
					indexSender = r.nextInt(99) + 1;
					do {
						indexReceiver = r.nextInt(99) + 1;
					} while (indexSender == indexReceiver);

					Letter<Text> simpleLetter = new SimpleLetter(c
							.getInhabitants().get(indexSender), c
							.getInhabitants().get(indexReceiver), defaultText);

					c.getInhabitants().get(indexSender)
							.sendLetter(simpleLetter);
				}

				if (randomNumber == 2) {
					indexSender = r.nextInt(99) + 1;
					do {
						indexReceiver = r.nextInt(99) + 1;
					} while (indexSender == indexReceiver);

					double money = r.nextInt(500) + 1;
					Money defaultMoney = new Money(money);

					Letter<Money> promissaryNote = new PromissaryNote(c
							.getInhabitants().get(indexSender), c
							.getInhabitants().get(indexReceiver), defaultMoney);

					c.getInhabitants().get(indexSender)
							.sendLetter(promissaryNote);
				}

				if (randomNumber == 3) {
					indexSender = r.nextInt(99) + 1;
					do {
						indexReceiver = r.nextInt(99) + 1;
					} while (indexSender == indexReceiver);

					Letter<Text> simpleLetter = new SimpleLetter(c
							.getInhabitants().get(indexSender), c
							.getInhabitants().get(indexReceiver), defaultText);

					RegisteredLetter<SimpleLetter> registeredLetterSimple = new RegisteredLetter<SimpleLetter>(
							simpleLetter);

					c.getInhabitants().get(indexSender)
							.sendLetter(registeredLetterSimple);
				}

				if (randomNumber == 4) {
					indexSender = r.nextInt(99) + 1;
					do {
						indexReceiver = r.nextInt(99) + 1;
					} while (indexSender == indexReceiver);

					double money = r.nextInt(500) + 1;
					Money defaultMoney = new Money(money);

					Letter<Money> promissaryNote = new PromissaryNote(c
							.getInhabitants().get(indexSender), c
							.getInhabitants().get(indexReceiver), defaultMoney);

					RegisteredLetter<PromissaryNote> registeredLetterPromissary = new RegisteredLetter<PromissaryNote>(
							promissaryNote);

					c.getInhabitants().get(indexSender)
							.sendLetter(registeredLetterPromissary);
				}

				if (randomNumber == 5) {
					indexSender = r.nextInt(99) + 1;
					do {
						indexReceiver = r.nextInt(99) + 1;
					} while (indexSender == indexReceiver);

					Letter<Text> simpleLetter = new SimpleLetter(c
							.getInhabitants().get(indexSender), c
							.getInhabitants().get(indexReceiver), defaultText);

					UrgentLetter<SimpleLetter> urgentLetterSimple = new UrgentLetter<SimpleLetter>(
							simpleLetter);

					c.getInhabitants().get(indexSender)
							.sendLetter(urgentLetterSimple);
				}

				if (randomNumber == 6) {
					indexSender = r.nextInt(99) + 1;
					do {
						indexReceiver = r.nextInt(99) + 1;
					} while (indexSender == indexReceiver);

					double money = r.nextInt(500) + 1;
					Money defaultMoney = new Money(money);

					Letter<Money> promissaryNote = new PromissaryNote(c
							.getInhabitants().get(indexSender), c
							.getInhabitants().get(indexReceiver), defaultMoney);

					UrgentLetter<PromissaryNote> urgentLetterPromissary = new UrgentLetter<PromissaryNote>(
							promissaryNote);

					c.getInhabitants().get(indexSender)
							.sendLetter(urgentLetterPromissary);
				}

				if (randomNumber == 7) {
					indexSender = r.nextInt(99) + 1;
					do {
						indexReceiver = r.nextInt(99) + 1;
					} while (indexSender == indexReceiver);

					Letter<Text> simpleLetter = new SimpleLetter(c
							.getInhabitants().get(indexSender), c
							.getInhabitants().get(indexReceiver), defaultText);

					RegisteredLetter<SimpleLetter> registeredLetterSimple = new RegisteredLetter<SimpleLetter>(
							simpleLetter);

					UrgentLetter<RegisteredLetter<SimpleLetter>> urgentRegisteredSimple = new UrgentLetter<RegisteredLetter<SimpleLetter>>(
							registeredLetterSimple);

					c.getInhabitants().get(indexSender)
							.sendLetter(urgentRegisteredSimple);
				}

				if (randomNumber == 8) {
					indexSender = r.nextInt(99) + 1;
					do {
						indexReceiver = r.nextInt(99) + 1;
					} while (indexSender == indexReceiver);

					double money = r.nextInt(500) + 1;
					Money defaultMoney = new Money(money);

					Letter<Money> promissaryNote = new PromissaryNote(c
							.getInhabitants().get(indexSender), c
							.getInhabitants().get(indexReceiver), defaultMoney);

					RegisteredLetter<PromissaryNote> registeredLetterPromissary = new RegisteredLetter<PromissaryNote>(
							promissaryNote);

					UrgentLetter<RegisteredLetter<PromissaryNote>> urgentRegisteredPromissary = new UrgentLetter<RegisteredLetter<PromissaryNote>>(
							registeredLetterPromissary);

					c.getInhabitants().get(indexSender)
							.sendLetter(urgentRegisteredPromissary);
				}
			}
			day++;
		}

		while (!c.getPostBox().isEmpty()) {
			System.out
					.println("***********************************************");
			System.out.println("Day " + day);
			c.distributeLetters();
			day++;
		}
	}
}
