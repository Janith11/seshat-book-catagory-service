package com.seshat.bookcategoryservice.service;

import com.seshat.bookcategoryservice.model.BookCategory;
import com.seshat.bookcategoryservice.repository.BookCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class BookCategoryServiceImpl implements BookCategoryService{

    private final BookCategoryRepository bookCategoryRepository;

    @Override
    public List<BookCategory> getAllBookCategory() {
        return this.bookCategoryRepository.findAll();
    }

    @Override
    public Optional<BookCategory> getBookCategoryById(String id) {
        return this.bookCategoryRepository.findById(id);
    }

    @Override
    public BookCategory addBookCategory(BookCategory bookCategory) {
        return this.bookCategoryRepository.save(bookCategory);
    }

    @Override
    public BookCategory updateBookCategory(String id, BookCategory bookCategory) {
        if (this.bookCategoryRepository.existsById(id)) {
            bookCategory.setId(id);
            return this.bookCategoryRepository.save(bookCategory);
        } else {
            return null;
        }
    }

    @Override
    public void deleteBookCategory(String id) {
        this.bookCategoryRepository.deleteById(id);
    }
}