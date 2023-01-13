package c14.lambda;

import java.util.ArrayList;
import java.util.List;

public class MethodUseLambda {

	public List<Contact> filterContacts(List<Contact> contacts, TestContact condition) {
		List<Contact> filteredContacts = new ArrayList<>();
		for (Contact contact : contacts) {
			if (condition.test(contact)) {
				filteredContacts.add(contact);
			}
		}
		
		return filteredContacts;
	}
}






