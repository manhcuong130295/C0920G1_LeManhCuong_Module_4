package com.codegym.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Bill {
    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @Parameter(name = "sequence_name", value = "user_sequence"),
                    @Parameter(name = "initial_value", value = "10000"),
                    @Parameter(name = "increment_size", value = "1")
            }
    )
    private int idBill;
    @ManyToOne
    @JoinColumn(name="id_book")
    Books books;
    @ManyToOne
    @JoinColumn(name="id_card")
    LibCard libCard;
    String rentDate;

    public Bill() {
    }

    public int getIdBill() {
        return idBill;
    }

    public void setIdBill(int idBill) {
        this.idBill = idBill;
    }

    public Books getBooks() {
        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    public LibCard getLibCard() {
        return libCard;
    }

    public void setLibCard(LibCard libCard) {
        this.libCard = libCard;
    }

    public String getRentDate() {
        return rentDate;
    }

    public void setRentDate(String rentDate) {
        this.rentDate = rentDate;
    }
}
