package com.example.retrofittest;

import retrofit2.Retrofit;

public class Book {
    String booktitle;

    public Book(String booktitle) {
        this.booktitle = booktitle;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }
}
