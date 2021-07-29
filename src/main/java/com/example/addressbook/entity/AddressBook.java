package com.example.addressbook.entity;

import com.example.addressbook.dto.AddressBookDTO;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
/** Represents a AddressBook.
 * @author ayuanshi
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "addressbook")
public @Data class AddressBook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String address;
    private String city;
    private String state;
    @Column(name = "pin_code")
    private String pinCode;
    public AddressBook( AddressBookDTO addressBookDTO){
        updateInAddressBook(addressBookDTO);
    }

    /**
     * Updates data of AddressBook
     * @param addressBookDTO receives data that is to be updated in the AddressBook
     */
    public void updateInAddressBook(AddressBookDTO addressBookDTO) {
        this.name=addressBookDTO.name;
        this.phoneNumber=addressBookDTO.phoneNumber;
        this.address=addressBookDTO.address;
        this.city=addressBookDTO.city;
        this.state=addressBookDTO.state;
        this.pinCode=addressBookDTO.pinCode;
    }
}
