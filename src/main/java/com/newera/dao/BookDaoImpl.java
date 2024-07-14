package com.newera.dao;

import com.newera.book.Book;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@Repository
public class BookDaoImpl implements BookDao {
    @Value("${spring.datasource.url}")
    private String DB_URL ;
    @Value("${spring.datasource.username}")
    private  String DB_UNAME ;
    @Value("${spring.datasource.password}")
    private String DB_PWD ;

    @Override
    public int insertBook(Book book) {
        try {
            Connection con = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PWD);
            PreparedStatement ps = con.prepareStatement("INSERT INTO books (book_id, book_name, book_price) VALUES (?, ?, ?)");
            ps.setInt(1, book.getBookId());
            ps.setString(2, book.getBookName());
            ps.setInt(3, book.getBookPrice());
            int i = ps.executeUpdate();

            System.out.println("Database insert result: " + i); // Debugging statement
            return i;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return 0;
    }
}
