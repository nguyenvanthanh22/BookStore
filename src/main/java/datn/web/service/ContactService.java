package datn.web.service;

import java.util.List;

import datn.web.entity.Contact;
import datn.web.model.ContactModel;

public interface ContactService {
	ContactModel createContact(ContactModel contactModel);

	List<Contact> getListContactPending();

	Contact getContactByContactId(Integer id);

	void approveContact(Integer id);

	void delete(Integer id);

	List<Contact> getListContactChecked();
	
	List<Contact> findAll();
}
