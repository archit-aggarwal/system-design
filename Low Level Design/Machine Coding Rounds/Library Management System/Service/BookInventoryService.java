package Service;

import java.util.*;
import Entity.Account;
import Entity.Admin;
import Entity.Book;

public class BookInventoryService {
  private static BookInventoryService instance;

  private BookInventoryService() {
  }

  public static BookInventoryService getInstance() {
    if(instance == null) {
      synchronized(BookInventoryService.class) {
        if(instance == null) {
          instance = new BookInventoryService();
        }
      }
    }

    return instance;
  }

  private Map<String, Book> booksInventory = new HashMap<>();
  private Map<String, Set<Book>> booksAuthorsMap = new HashMap<>();
  private Map<String, Set<Book>> booksTitlesMap = new HashMap<>();
  private Map<String, Set<Book>> booksSubjectsMap = new HashMap<>();
  private Map<String, Set<Book>> booksDatesMap = new HashMap<>(); 

  public void addBook(Account account, Book book) throws Exception {
    if(account == null || book == null || !(account instanceof Admin)) {
      throw new Exception("Error in Adding Book");
    }

    booksInventory.put(book.getBookId(), book);

    booksAuthorsMap.putIfAbsent(book.getBookId(), new HashSet<>());
    booksAuthorsMap.get(book.getBookId()).add(book);

    booksTitlesMap.putIfAbsent(book.getBookId(), new HashSet<>());
    booksTitlesMap.get(book.getBookId()).add(book);

    booksSubjectsMap.putIfAbsent(book.getBookId(), new HashSet<>());
    booksSubjectsMap.get(book.getBookId()).add(book);

    booksDatesMap.putIfAbsent(book.getBookId(), new HashSet<>());
    booksDatesMap.get(book.getBookId()).add(book);
  }

  public void removeBook(Account account, Book book) throws Exception {
    if(account == null || book == null || !(account instanceof Admin)) {
      throw new Exception("Error in Removing Book");
    }

    booksInventory.remove(book.getBookId());
    booksAuthorsMap.get(book.getBookId()).remove(book);
    booksTitlesMap.get(book.getBookId()).remove(book);
    booksSubjectsMap.get(book.getBookId()).remove(book);
    booksDatesMap.get(book.getBookId()).remove(book);
  }
}
