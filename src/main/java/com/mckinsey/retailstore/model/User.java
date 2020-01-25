package com.mckinsey.retailstore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String userName;
    private UserType userType;
    private Date dateOfJoining;
}
