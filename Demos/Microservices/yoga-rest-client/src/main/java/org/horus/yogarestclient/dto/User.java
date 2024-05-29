package org.horus.yogarestclient.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.horus.yogarestclient.enums.Role;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor // Remove ?
@NoArgsConstructor // Remove ?
public class User {
    private UUID id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private Date dateOfBirth;
    private Role role;

    public User(String firstName, String lastName, String phone, String email, Date dateOfBirth, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.role = role;
    }
}
