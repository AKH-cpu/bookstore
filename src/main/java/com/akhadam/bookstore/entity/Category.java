package com.akhadam.bookstore.entity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "categories")
public class Category {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    private String categoryId;

    @Column(nullable = false, length = 25)
    private String name;

    @OneToMany(mappedBy = "category",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Book> books;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
