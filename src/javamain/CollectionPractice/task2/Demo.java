package javamain.CollectionPractice.task2;

public class Demo {
    public static void main(String[] args) {

        ContactManager o = new ContactManager();
        o.addContact(new Contact("nik","123"));
        o.addContact(new Contact("tom","222"));
        o.addContact(new Contact("serg","333"));
        o.addContact(new Contact("vik","321"));

        Contact contact = new Contact("mark","111");
        o.addContact(contact);
        o.addContact(contact);

        System.out.println(o.getAllContacts());
        o.removeContact(contact);
        System.out.println(o.getAllContacts());

        System.out.println(
                o.getContactByName("nik")
        );
        System.out.println(
                o.getContactByPhoneNumber("222")
        );
    }
}
