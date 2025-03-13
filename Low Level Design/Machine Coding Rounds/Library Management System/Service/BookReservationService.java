package Service;

import Entity.Admin;
import Entity.BookItem;
import Entity.Member;

public class BookReservationService {
  BookInventoryService bookInventoryService = BookInventoryService.getInstance();

  // TODO: Apply State Design Pattern
  public void borrowBook(Admin librarian, Member member, BookItem bookItem){
    
  }

  public void returnBook(Admin librarian, Member member, BookItem bookItem) {

  }

  public void reserveBook(Admin librarian, Member member, BookItem bookItem) {

  }
}
