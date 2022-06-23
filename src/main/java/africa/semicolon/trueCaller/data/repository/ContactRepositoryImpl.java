package africa.semicolon.trueCaller.data.repository;

import africa.semicolon.trueCaller.data.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactRepositoryImpl implements ContactRepository{
    ArrayList<Contact> contacts = new ArrayList<>();
    @Override
    public Contact save(Contact contact) {
        if(contact.getId() != 0){
            Contact foundContact = contacts.get(contact.getId()-1);
            foundContact.setFirstName(contact.getFirstName());
            foundContact.setLastName(contact.getLastName());
            foundContact.setPhoneNumber(contact.getPhoneNumber());
            return  foundContact;
        }
        else{
        contact.setId(contacts.size()+1);
        contacts.add(contact);
        return contact;}
    }

    @Override
    public int count() {
        return contacts.size();
    }


    @Override
    public List<Contact> findByName(String name) {
        List<Contact> newContacts = new ArrayList<>();
        for (Contact foundContact : contacts) {
            if (name.equals(foundContact.getFirstName()) || name.equals(foundContact.getLastName())) {
                newContacts.add(foundContact);
            }
        }
        return newContacts;
    }

    @Override
    public Contact findById(int id) {
        return contacts.get(id - 1);
    }


    @Override
    public Contact findByPhoneNumber(String phoneNumber) {
        for (Contact foundContact : contacts) {
            if (phoneNumber.equals(foundContact.getPhoneNumber())) {
                return foundContact;
            }
        }
        throw new NullPointerException("Contact not found!");
    }

    @Override
    public void deleteContact(Contact contact) {
        Contact foundContact = findByPhoneNumber(contact.getPhoneNumber());
        contacts.remove(foundContact);
    }
}
