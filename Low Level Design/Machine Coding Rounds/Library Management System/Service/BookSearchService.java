package Service;

import java.util.*;
import Entity.Book;

public interface BookSearchService {
  BookInventoryService service = BookInventoryService.getInstance();
  
  List<Book> searchByAuthor(String author);
  List<Book> searchByTitle(String title);
  List<Book> searchBySubject(String subject);
  List<Book> searchByPublishDate(String date);
}
