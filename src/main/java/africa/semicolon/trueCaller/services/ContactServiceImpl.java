package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.model.Contact;
import africa.semicolon.trueCaller.data.repository.ContactRepository;
import africa.semicolon.trueCaller.data.repository.ContactRepositoryImpl;

import java.util.List;

public class ContactServiceImpl implements ContactService{
    private ContactRepository contactRepository = new ContactRepositoryImpl();


    @Override
    public Contact addContact(String firstName, String lastName, String phoneNumber) {
        Contact contact = new Contact(firstName,lastName,phoneNumber);
        contactRepository.save(contact);
        return contact;
    }
    @Override
    public Contact findById(int i) {
        return contactRepository.findById(i);
    }

    @Override
    public void removeContact(Contact contact) {
        contactRepository.deleteContact(contact);
    }

    @Override
    public void updateContact(int id, String newFirstName, String newLastName, String newPhoneNumber) {
        Contact contactToBeUpdated = new Contact(newFirstName,newLastName,newPhoneNumber);
        contactToBeUpdated.setId(id);
        contactRepository.save(contactToBeUpdated);
    }

    @Override
    public List<Contact> findByName(String name) {
        return contactRepository.findByName(name);
    }
}
