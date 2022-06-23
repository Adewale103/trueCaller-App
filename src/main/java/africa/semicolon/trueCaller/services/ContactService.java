package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.model.Contact;

import java.util.List;

public interface ContactService {
    Contact addContact(String firstName, String lastName, String phoneNumber);

    Contact findById(int i);

    void removeContact(Contact contact);

    void updateContact(int id, String newFirstName, String newLastName, String newPhoneNumber);

    List<Contact> findByName(String name);
}
