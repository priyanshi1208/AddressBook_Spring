package com.example.addressbook.service;
import com.example.addressbook.dto.AddressBookDTO;
import com.example.addressbook.entity.AddressBook;
import com.example.addressbook.exception.AddressBookException;
import com.example.addressbook.repository.AddressBookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Slf4j
@Service

public class AddressBookService implements IAddressBookService {
    @Autowired
    public AddressBookRepository addressBookRepository;

    /**
     *Add data in AddressBook
     * @param addressbookDTO
     * @return
     */
    @Override
    public AddressBook addInAddressBook(AddressBookDTO addressbookDTO) {
        AddressBook addressBook=new AddressBook((addressbookDTO));
        log.info("AddressBook Data Added");
        return this.addressBookRepository.save(addressBook);
    }

    /**
     *Gets All the Data from AddressBook
     * @return
     */
    @Override
    public List<AddressBook> getAllPerson() {
        log.info("Showing addressBook data");
        return addressBookRepository.findAll();
    }

    /**
     *Gets Data of a Particular Id of AddressBook
     * @param id
     * @return
     */
    @Override
    public AddressBook getPersonById(int id) {
        return addressBookRepository.findById(id).orElseThrow(()->new AddressBookException(
                "Person with "+id+" doesn't exist"));
    }

    /**
     *Updates data of a particular Id of an AddressBook
     * @param id
     * @param addressBookDTO
     * @return
     */
    @Override
    public AddressBook updatePersonById(int id, AddressBookDTO addressBookDTO) {
        AddressBook addressBook = this.getPersonById(id);
        addressBook.updateInAddressBook(addressBookDTO);
        log.info("AddressBook data updated");
        return addressBookRepository.save(addressBook);
    }

    /**
     *Deletes data of a particular id of an AddressBook
     * @param id
     */
    @Override
    public void deletePersonById(int id) {
        AddressBook addressbook=this.getPersonById(id);
        addressBookRepository.delete(addressbook);
        log.info("AddressBook data deleted");
    }
}
