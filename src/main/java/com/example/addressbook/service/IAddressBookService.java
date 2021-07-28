package com.example.addressbook.service;

import com.example.addressbook.dto.AddressBookDTO;
import com.example.addressbook.entity.AddressBook;

import java.util.List;

public interface IAddressBookService {
    AddressBook addInAddressBook(AddressBookDTO addressbookDTO);

    List<AddressBook> getAllPerson();

    AddressBook getPersonById(int id);

    AddressBook updatePersonById(int id, AddressBookDTO addressBookDTO);

    AddressBook deletePersonById(int id);
}
