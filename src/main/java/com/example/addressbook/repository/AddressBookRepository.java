package com.example.addressbook.repository;

import com.example.addressbook.entity.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressBookRepository extends JpaRepository<AddressBook,Integer> {
}
