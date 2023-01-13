package c14.lambda;

import java.util.ArrayList;
import java.util.List;

public class Testing {

	public static void main(String[] args) {
		List<Contact> contacts = new ArrayList<>();
		contacts.add(new Contact("Dong", "113@ss", "23432"));
		contacts.add(new Contact("Tay", null, null));
		contacts.add(new Contact("Bac", "sldkfj@slkdfj", null));
		
		useLambda(contacts);
	}
	
	public static void dontUseLambda(List<Contact> contacts) {
		MethodDontUseLambda methodDontUseLambda = new MethodDontUseLambda();

		List<Contact> contactsWithoutPhone = methodDontUseLambda.filterContactsWithoutPhone(contacts);

		printContact(contactsWithoutPhone);
	}
	
	public static void useLambda(List<Contact> contacts) {
		MethodUseLambda methodUseLambda = new MethodUseLambda();

		List<Contact> contactsWithoutEmail = methodUseLambda.filterContacts(contacts, 
				contact -> contact.getEmail() == null || contact.getEmail().isEmpty());
		
		List<Contact> contactsWithoutPhone = methodUseLambda.filterContacts(contacts, 
				contact -> contact.getPhone() == null);

		printContact(contactsWithoutEmail);
		printContact(contactsWithoutPhone);
	}
	
	public static void printContact(List<Contact> contacts) {
		for (Contact contact : contacts) {
			System.out.println(contact.getName());
		}
	}
}









