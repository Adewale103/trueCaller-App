package africa.semicolon.trueCaller.services;

import africa.semicolon.trueCaller.data.model.Contact;
import africa.semicolon.trueCaller.data.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService{
    @Autowired
    private ContactRepository contactRepository;


    @Override
    public Contact addContact(String firstName, String lastName, String phoneNumber) {
        Contact contact = new Contact(firstName,lastName,phoneNumber);
        contactRepository.save(contact);
        return contact;
    }
    @Override
    public Contact findById(String id) {
        Optional<Contact> found = contactRepository.findById(id);
        if(found.isEmpty()) throw new NullPointerException("Contact not found!");
        return found.get();
    }

    @Override
    public void removeContact(Contact contact) {
        contactRepository.delete(contact);
    }

    @Override
    public void updateContact(String id, String newFirstName, String newLastName, String newPhoneNumber) {
        Contact contactToBeUpdated = new Contact(newFirstName,newLastName,newPhoneNumber);
        contactToBeUpdated.setId(id);
        contactRepository.save(contactToBeUpdated);
    }

    @Override
    public List<Contact> findByName(String name) {
        List<Contact> result = new ArrayList<>();
        result.addAll(contactRepository.findByFirstName(name));
        result.addAll(contactRepository.findByLastName(name));
        return result;
    }
}
