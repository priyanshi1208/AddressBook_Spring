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
    @Override
    public AddressBook addInAddressBook(AddressBookDTO addressbookDTO) {
        AddressBook addressBook=new AddressBook((addressbookDTO));
        log.info("AddressBook Data");
        return this.addressBookRepository.save(addressBook);
    }

    @Override
    public List<AddressBook> getAllPerson() {
        return addressBookRepository.findAll();
    }

    @Override
    public AddressBook getPersonById(int id) {
        return addressBookRepository.findById(id).orElseThrow(()->new AddressBookException(
                "Person with"+id+"doesn't exist"));
    }

    @Override
    public AddressBook updatePersonById(int id, AddressBookDTO addressBookDTO) {
        return null;
    }

    @Override
    public AddressBook deletePersonById(int id) {
        return null;
    }
}
