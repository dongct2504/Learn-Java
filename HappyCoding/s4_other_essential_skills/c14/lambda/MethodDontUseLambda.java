package c14.lambda;

import java.util.ArrayList;
import java.util.List;

public class MethodDontUseLambda {

	public List<Contact> filterContactsWithoutPhone(List<Contact> contacts) {
		List<Contact> contactsWithoutPhone = new ArrayList<>();
		for (Contact contact : contacts) {
			if (contact.getPhone() == null) {
				contactsWithoutPhone.add(contact);
			}
		}
		
		return contactsWithoutPhone;
	}
}
