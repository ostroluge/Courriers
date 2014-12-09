Project 3 : Courriers
==============
Names:
OSTROWSKI Thomas
LEGROS Matthias

19/11/2014

Summary :
1) Description of the application
2) Code structure
3) Code Samples
4) Known bugs

1)
The application is about inhabitants of a city that are sending letters to each other.
There are differents kinds of letters :
- The simple letters that contains just a text
- The promissary note that contains money; When a promissary note is received, the receiver sends a thanks letter to the sender
- All the letters can be sent as registered, when it happens, the letter costs an extra 15 euros and the receiver sends
a receipt of acknowledgment.
- All the letters can be sent as urgent as well, when it happens the letters costs twice its initial cost

2)
Interface Content :
Text and Money
Abstract class Letter :
SimpleLetter, PromissaryNote, ReceiptOfAcknowledgment, ThanksLetter, DecoratingLetter
Abstract class DecoratingLetter :
RegisteredLetter and UrgentLetter

3)

DecoratingLetter :

public DecoratingLetter(Letter<?> l) {
	super(l.getSender(), l.getReceiver(), l.getContent());
	this.letter = l;
}

PromissaryNote :

public void doAction() {
	System.out.println("\t- "
			+ Double.parseDouble(super.c.toString())
			+ " euros are debited from "
			+ super.sender.getName()
			+ " account whose balance is now "
			+ (super.sender.getBankaccount().getAmount() - Double
					.parseDouble(super.c.toString())));
	System.out.println("\t+ "
			+ super.receiver.getName()
			+ " account is credited with "
			+ Double.parseDouble(super.c.toString())
			+ " euros; its balance is now "
			+ (super.receiver.getBankaccount().getAmount() + Double
					.parseDouble(super.c.toString())));

	super.sender.getBankaccount().debit(
			Double.parseDouble(super.c.toString()));
	super.receiver.getBankaccount().credit(
			Double.parseDouble(super.c.toString()));

	Letter<Content> thks = new ThanksLetter(this);
	super.receiver.sendLetter(thks);
}

City :

public void distributeLetters() {
	List<Letter<?>> postalBag = new ArrayList<Letter<?>>(postBox);
	for (Letter<?> letter : postalBag) {
		letter.getReceiver().receiveLetter(letter);
		postBox.remove(letter);
	}
}

4)
  There is no specific known bug.
