package main.java.javamain.CollectionPractice.task2;

import java.util.ArrayList;
import java.util.List;

public class ContactManager {

    private  List<Contact> contacts = new ArrayList<>();


    public List<Contact> getContacts() {
        return contacts;
    }
    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }


    public void addContact(Contact contact) {
        if (!contacts.contains(contact)) {
            contacts.add(contact);
            System.out.println("contact added");
        } else {
            System.out.println("ERROR! such contact exists");
        }
    }

    public void removeContact(Contact contact) {
        contacts.remove(contact);
    }
    public List<Contact> getAllContacts() {
        return contacts.stream().sorted().toList();
    }


    public Contact getContactByName (String name) {
        return contacts.stream()
                .filter(o -> o.getName().equals(name)).findFirst().get();
    }
    public Contact getContactByPhoneNumber(String number) {
        return contacts.stream()
                .filter(o -> o.getPhoneNumber().equals(number))
                .findFirst().get();
    }


}
