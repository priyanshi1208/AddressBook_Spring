package com.example.addressbook.controller;

import com.example.addressbook.dto.AddressBookDTO;
import com.example.addressbook.dto.ResponseDTO;
import com.example.addressbook.entity.AddressBook;
import com.example.addressbook.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/addressbook")
public class AddressBookController {
    @Autowired
    public IAddressBookService addressBookService;

    /**
     * Calls method to Post data of a particular id and gives Response
     * @param addressbookDTO receives data as AddressBookDTO
     * @return method returns HttpStatus,Data and message to be displayed
     */
    @PostMapping("/post")
    public ResponseEntity<ResponseDTO> addInAddressBook(@Valid @RequestBody AddressBookDTO addressbookDTO){
        AddressBook addressBook=addressBookService.addInAddressBook(addressbookDTO);
        return new ResponseEntity<>(new ResponseDTO("Person successfully added in AddressBook",
                addressBook), HttpStatus.OK);
    }

    /**
     * Calls method to Get all data of AddressBook and gives Response
     * @return HttpResponse,All data of AddressBook and message
     */
    @GetMapping("/get")
    public ResponseEntity<ResponseDTO> getAllPerson(){
        List<AddressBook> addressBookList=addressBookService.getAllPerson();
        return new ResponseEntity<>(new ResponseDTO("Call for Person is Successful",addressBookList),
                HttpStatus.FOUND);
    }

    /**
     * Calls method to Get data of a particular id and gives Response
     * @param id receives id as parameter from url
     * @return HttpResponse,Data of Id and message
     */
    @GetMapping("/get/{id}")
    public ResponseEntity<ResponseDTO> getPersonById(@PathVariable("id") int id){
        AddressBook addressBook=addressBookService.getPersonById(id);
        return new ResponseEntity<>(new ResponseDTO("Call for Person By iD is Successful",addressBook),
                HttpStatus.FOUND);
    }

    /**
     * Calls method to Update data of a particular id and gives Response
     * @param addressBookDTO receives Updated Data in AddressBookDTO
     * @param id receives id from url which is to be updated
     * @return HttpStatus,Updated Data From AddressBook and message
     */
    @PutMapping("/put/{id}")
    public ResponseEntity<ResponseDTO> updatePersonById( @RequestBody AddressBookDTO addressBookDTO,@PathVariable("id") int id){
        AddressBook addressBook=addressBookService.updatePersonById(id,addressBookDTO);
        return new ResponseEntity<>(new ResponseDTO("Update call for person successfull",addressBook),
                HttpStatus.ACCEPTED);
    }

    /**
     * Calls method to delete data and give Response
     * @param id receives id from url to delete
     * @return HttpSttaus,id that is being deleted and message
     */
    @DeleteMapping("/delete/{id}")
    public  ResponseEntity<ResponseDTO> deletePersonById(@PathVariable int id){
        addressBookService.deletePersonById(id);
        return new ResponseEntity<>(new ResponseDTO("Delete call for id successful",id),HttpStatus.GONE);
    }
}
