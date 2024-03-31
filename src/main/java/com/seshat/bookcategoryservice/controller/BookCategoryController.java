package com.seshat.bookcategoryservice.controller;

import com.seshat.bookcategoryservice.model.BookCategory;
import com.seshat.bookcategoryservice.service.BookCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/book-category")
public class BookCategoryController {
    private final BookCategoryService bookCategoryService;

    @GetMapping
    public ResponseEntity<List<BookCategory>> getAllBookCategory() {
        List<BookCategory> bookCategories = this.bookCategoryService.getAllBookCategory();
        return new ResponseEntity<>(bookCategories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookCategory> getBookCategoryById(@PathVariable String id) {
        Optional<BookCategory> bookCategory = this.bookCategoryService.getBookCategoryById(id);
        return bookCategory.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<BookCategory> addBookCategory(@RequestBody BookCategory bookCategory) {
        BookCategory newbookCategory = this.bookCategoryService.addBookCategory(bookCategory);
        return new ResponseEntity<>(newbookCategory, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookCategory> updateBookCategory(@PathVariable String id, @RequestBody BookCategory bookCategory) {
        BookCategory updateBookCategory = this.bookCategoryService.updateBookCategory(id, bookCategory);
        if (updateBookCategory != null) {
            return new ResponseEntity<>(updateBookCategory, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookCategory(@PathVariable String id) {
        this.bookCategoryService.deleteBookCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
