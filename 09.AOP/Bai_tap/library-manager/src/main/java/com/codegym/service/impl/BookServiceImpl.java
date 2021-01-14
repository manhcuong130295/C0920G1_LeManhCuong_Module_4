package com.codegym.service.impl;

import com.codegym.entity.Books;
import com.codegym.repository.BookRepository;
import com.codegym.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;
    @Override
    public List<Books> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public void save(Books books) {
        bookRepository.save(books);
    }

    @Override
    public Books findById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Books updateAmountBook(String action, Books bookObj) throws Exception {
        if(bookObj.getAmount()<= 0) {
            if(!action.equals("down")){
                bookObj.setAmount(bookObj.getAmount()+1);
            }else {
                throw new Exception("out of stock");
            }
        }else {
            switch (action){
                case "up":
                    bookObj.setAmount(bookObj.getAmount()+1);
                    break;
                case "down":
                    bookObj.setAmount(bookObj.getAmount()-1);
                    break;
            }
        }



        return bookObj;
    }
}
