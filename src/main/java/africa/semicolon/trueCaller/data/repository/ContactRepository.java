package africa.semicolon.trueCaller.data.repository;

import africa.semicolon.trueCaller.data.model.Contact;

import java.util.List;

public interface ContactRepository {
    Contact save(Contact contact);
    int count();
    List<Contact> findByName(String Name);
    Contact findById(int id);
    Contact findByPhoneNumber(String phoneNumber);
    void deleteContact(Contact contact);
}
