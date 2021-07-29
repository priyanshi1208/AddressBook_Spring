package com.example.addressbook.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

public @Data
class AddressBookDTO {
    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message="Name is Invalid")
    public String name;

    @NotEmpty(message = "Phone number can not be empty")
    @Pattern(regexp = "\\d{2}\\d{10}",message = "Phone Number is not Valid")
    public String phoneNumber;

    @NotEmpty(message = "Address cannot be empty")
    public String address;

    @NotEmpty(message = "City field cannot be empty")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message ="City name is not valid")
    public String city;

    @NotEmpty(message = "State field cannot be empty")
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$",message ="State name is not valid")
    public String state;

    @NotEmpty(message = "PinCode cannot be empty")
    public String pinCode;
}
