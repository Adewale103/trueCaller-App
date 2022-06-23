package africa.semicolon.trueCaller.data.repository;

import africa.semicolon.trueCaller.data.model.Contact;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ContactRepositoryImplTest {
    private ContactRepository contactRepository;

    @BeforeEach
    void setUp() {
        contactRepository = new ContactRepositoryImpl();
    }

    @Test
    public void saveContact_countIsOneTest() {
        Contact contact = new Contact();
        contact.setFirstName("Samson");

        contactRepository.save(contact);
        assertEquals(1, contact.getId());
        assertEquals(1, contactRepository.count());
    }

    @Test
    public void saveContactTwice_countIsTwoTest() {
        Contact contact1 = new Contact();
        contact1.setFirstName("Samson");

        Contact contact2 = new Contact();
        contact2.setFirstName("Adewale");

        contactRepository.save(contact1);
        assertEquals(1, contact1.getId());

        contactRepository.save(contact2);
        assertEquals(2, contact2.getId());

        assertEquals(2, contactRepository.count());
    }

    @Test
    public void saveContact_findByIdReturnsContact() {
        Contact contact1 = new Contact();
        contact1.setFirstName("Samson");
        Contact savedContact1 = contactRepository.save(contact1);

        Contact contact2 = new Contact();
        contact2.setFirstName("Deola");
        Contact savedContact2 = contactRepository.save(contact2);

        Contact foundContact = contactRepository.findById(1);

        assertEquals(1, foundContact.getId());
        assertEquals("Samson", foundContact.getFirstName());
    }

    @Test
    public void saveContact_findByNameReturnsContact() {
        Contact contact1 = new Contact();
        contact1.setFirstName("Samson");
        contact1.setFirstName("John");
        Contact savedContact1 = contactRepository.save(contact1);

        Contact contact2 = new Contact();
        contact2.setFirstName("Deola");
        contact2.setLastName("Peterson");
        Contact savedContact2 = contactRepository.save(contact2);

       List<Contact> foundContact = contactRepository.findByName("Deola");

        assertEquals("[Contact(id=2, firstName=Deola, lastName=Peterson, phoneNumber=null)]", foundContact.toString());

    }

    @Test
    public void saveTwoContactsWithSameName_findByNameReturnsListOfContacts() {
        Contact contact1 = new Contact("Adewale", "Samuel", "09021806462");
        contactRepository.save(contact1);

        Contact contact2 = new Contact("Samuel", "Jackson", "08132456932");
        contactRepository.save(contact2);

        List<Contact> foundContacts = contactRepository.findByName("Samuel");
        assertEquals("[Contact(id=1, firstName=Adewale, lastName=Samuel, phoneNumber=09021806462), Contact(id=2, firstName=Samuel, lastName=Jackson, phoneNumber=08132456932)]", foundContacts.toString());
    }

    @Test
    public void saveContact_FindByPhoneNumberReturnsContact() {
        Contact contact1 = new Contact("Adewale", "Samuel", "09021806462");
        contactRepository.save(contact1);

        Contact contact2 = new Contact("Emmanuel", "Jackson", "08132456932");
        contactRepository.save(contact2);

        Contact foundContact = contactRepository.findByPhoneNumber("09021806462");
        assertEquals("Adewale", foundContact.getFirstName());
        assertEquals(1, foundContact.getId());
    }

    @Test
    public void saveContact_ContactCanBeDeleted() {
        Contact contact1 = new Contact("Adewale", "Samuel", "09021806462");
        contactRepository.save(contact1);

        Contact contact2 = new Contact("Emmanuel", "Jackson", "08132456932");
        contactRepository.save(contact2);

        contactRepository.deleteContact(contact1);
        assertEquals(1, contactRepository.count());

    }
}
