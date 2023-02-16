package c14.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MethodUsePredicate {

	public List<Contact> filterContacts(List<Contact> contacts, Predicate<Contact> condition) {
		List<Contact> filteredContacts = new ArrayList<>();
		for (Contact contact : contacts) {
			if (condition.test(contact)) {
				filteredContacts.add(contact);
			}
		}
		
		return filteredContacts;
	}
}
