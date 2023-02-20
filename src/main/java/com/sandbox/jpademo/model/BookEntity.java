package com.sandbox.jpademo.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Builder
@Setter
@Getter
public class BookEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String author;
    private int publicationYear;
    private double price;
}
