package com.seshat.bookcategoryservice.repository;

import com.seshat.bookcategoryservice.model.BookCategory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BookCategoryRepository extends MongoRepository<BookCategory, String>{
}
