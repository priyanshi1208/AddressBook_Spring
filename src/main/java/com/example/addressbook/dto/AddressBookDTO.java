package com.example.addressbook.dto;

import lombok.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public @ToString class AddressBookDTO {
    @NotEmpty(message = "Name cannot be Empty")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$",message = "Name Invalid")
    public String name;
    @NotBlank(message = "Phone number cannot be empty")
    @Pattern(regexp = "")
    public String phoneNumber;
    @NotBlank(message = "Address cannot be blank")
    public String address;
    @NotBlank(message = "City cannot be blank")
    public String city;
    @NotBlank(message = "State cannot be blank")
    public String state;
    @Pattern(regexp="")
    @NotBlank(message="Pin code cannot be blank")
    public String pinCode;
}
