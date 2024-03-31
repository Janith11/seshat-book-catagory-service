package com.seshat.bookcategoryservice.service;

import com.seshat.bookcategoryservice.model.BookCategory;

import java.util.List;
import java.util.Optional;

public interface BookCategoryService {
    List<BookCategory> getAllBookCategory();

    Optional<BookCategory> getBookCategoryById(String id);

    BookCategory addBookCategory(BookCategory bookCategory);

    BookCategory updateBookCategory(String id, BookCategory bookCategory);

    void deleteBookCategory(String id);
}
