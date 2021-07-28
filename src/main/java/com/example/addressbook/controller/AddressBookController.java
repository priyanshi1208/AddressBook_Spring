package com.example.addressbook.controller;

import com.example.addressbook.dto.AddressBookDTO;
import com.example.addressbook.dto.ResponseDTO;
import com.example.addressbook.entity.AddressBook;
import com.example.addressbook.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
    @Autowired
    public IAddressBookService addressBookService;
    @PostMapping("/post")
    public ResponseEntity<ResponseDTO> addInAddressBook(@RequestBody AddressBookDTO addressbookDTO){
        AddressBook addressBook=addressBookService.addInAddressBook(addressbookDTO);
        return new ResponseEntity<>(new ResponseDTO("Person successfully added in AddressBook",
                addressBook), HttpStatus.OK);
    }
    @GetMapping("/get")
    public ResponseEntity<ResponseDTO> getAllPerson(){
        List<AddressBook> addressBookList=addressBookService.getAllPerson();
        return new ResponseEntity<>(new ResponseDTO("Call for Person is Successful",addressBookList),
                HttpStatus.FOUND);
    }
    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getPersonById(@PathVariable("id") int id){
        AddressBook addressBook=addressBookService.getPersonById(id);
        return new ResponseEntity<>(new ResponseDTO("Call for Person By iD is Successful",addressBook),
                HttpStatus.FOUND);
    }
    @PutMapping("/put/{id}")
    public ResponseEntity<ResponseDTO> updatePersonById( @RequestBody AddressBookDTO addressBookDTO,@PathVariable("id") int id){
        AddressBook addressBook=addressBookService.updatePersonById(id,addressBookDTO);
        return new ResponseEntity<>(new ResponseDTO("Update call for person successfull",addressBook),
                HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<ResponseDTO> deletePersonById(@PathVariable int id){
        AddressBook addressBook=addressBookService.deletePersonById(id);
        return new ResponseEntity<>(new ResponseDTO("Delete call for id successful",addressBook),HttpStatus.GONE);
    }
}
