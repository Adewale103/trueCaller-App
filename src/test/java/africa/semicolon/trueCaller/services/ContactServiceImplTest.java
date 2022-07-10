//package africa.semicolon.trueCaller.services;
//
//import africa.semicolon.trueCaller.data.model.Contact;
//import africa.semicolon.trueCaller.data.repository.ContactRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class ContactServiceImplTest {
//    private ContactService contactService;
//    private ContactRepository contactRepository;
//
//    @BeforeEach
//    void setUp() {
//        contactRepository= new ContactRepositoryImpl();
//        contactService = new ContactServiceImpl();
//    }
//    @Test
//    public void saveContact_findContactReturnsContact(){
//        contactService.addContact("Adewale","Babalola","+2349021806462");
//
//        Contact contact = contactService.findById(1);
//        assertEquals(1,contactRepository.count());
//        assertEquals("Adewale", contact.getFirstName());
//    }
//    @Test
//    public void saveContact_contactCanBeRemovedTest(){
//       Contact contact1 = contactService.addContact("Adewale","Babalola","+2349021806462");
//        Contact contact2 = contactService.addContact("Femi","Ayobami","+2348193893362");
//
//        contactService.removeContact(contact2);
//        assertEquals(1,contactRepository.count());
//
//    }
////    @Test
////    public void saveContact_firstNameCanBeUpdatedTest(){
////        Contact contact1 = contactService.addContact("Adewale","Babalola","+2349021806462");
////        Contact contact2 = contactService.addContact("Femi","Ayobami","+2348193893362");
////
////        contactService.updateFirstName(contact2, "Bayo");
////        assertEquals("Bayo",contact2.getFirstName());
////
////    }
////    @Test
////    public void saveContact_lastNameCanBeUpdatedTest(){
////        Contact contact1 = contactService.addContact("Adewale","Babalola","+2349021806462");
////        Contact contact2 = contactService.addContact("Femi","Ayobami","+2348193893362");
////
////        contactService.updateLastName(contact2, "Ayodeji");
////        assertEquals("Ayodeji",contact2.getLastName());
////    }
////
////    @Test
////    public void saveContact_phoneNumberCanBeUpdatedTest(){
////        Contact contact1 = contactService.addContact("Adewale","Babalola","+2349021806462");
////        Contact contact2 = contactService.addContact("Femi","Ayobami","+2348193893362");
////
////        contactService.updatePhoneNumber(contact2, "08123456788");
////        assertEquals("08123456788",contact2.getPhoneNumber());
////    }
//}