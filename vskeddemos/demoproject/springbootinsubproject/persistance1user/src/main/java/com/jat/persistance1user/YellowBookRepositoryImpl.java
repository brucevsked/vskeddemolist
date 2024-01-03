package com.jat.persistance1user;

import org.business1user.repository.BookRepository;
import org.business1user.repository.entity.BookEntity;
import org.springframework.stereotype.Service;

@Service(value = "yellowBookRepository")
public class YellowBookRepositoryImpl implements BookRepository {

    @Override
    public void save(BookEntity bookEntity) {
        System.out.println("-----------------here is persistance----------------------------------");
    }
}
