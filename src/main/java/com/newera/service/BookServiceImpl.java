package com.newera.service;

import com.newera.book.Book;
import com.newera.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bd;

    @Override
    public void processBook() {
        String filePath = "C:\\Users\\Abishekh Gaur\\Downloads\\newerabegins\\newerabegins\\book.txt";
        try {
            Stream<String> lines = Files.lines(Paths.get(filePath));
            lines.forEach(l -> {
                String[] values = l.split(",");
                String id = values[0];
                String name = values[1];
                String price = values[2];
                Book b = new Book();
                b.setBookId(Integer.parseInt(id));
                b.setBookName(name);
                b.setBookPrice(Double.valueOf(price).intValue()); // Convert to Integer

                System.out.println("Attempting to insert book: " + b); // Debugging statement
                int z = bd.insertBook(b);

                if (z > 0) {
                    System.out.println("records inserted...");
                } else {
                    System.out.println("Failed to insert record for: " + b);
                }
                System.out.println("Processed line: " + l);
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
