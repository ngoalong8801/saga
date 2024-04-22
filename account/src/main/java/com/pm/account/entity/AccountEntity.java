package com.pm.account.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = AccountEntity.TABLE_NAME)
@Getter
@Setter
public class AccountEntity {
    public static final String TABLE_NAME= "account";
    @Id
    private String email;

    private String name;
    private int balance;
}
