package com.auction.backend.data.dtos;

import com.auction.backend.data.models.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {

    private String firstName;
    private String lastName;

    public UserDto(User user) {
        firstName = user.getFirstName();
        lastName = user.getLastName();
    }
}
