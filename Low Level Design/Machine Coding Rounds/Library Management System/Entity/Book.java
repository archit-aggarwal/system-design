package Entity;

import java.util.List;

public class Book {
  String bookId;
  String title;
  List<String> authors;
  String subject;
  String publishDate;
  
  public String getBookId() {
    return bookId;
  }
  public void setBookId(String bookId) {
    this.bookId = bookId;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public List<String> getAuthors() {
    return authors;
  }
  public void setAuthors(List<String> authors) {
    this.authors = authors;
  }
  public String getSubject() {
    return subject;
  }
  public void setSubject(String subject) {
    this.subject = subject;
  }
  public String getPublishDate() {
    return publishDate;
  }
  public void setPublishDate(String publishDate) {
    this.publishDate = publishDate;
  }
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((title == null) ? 0 : title.hashCode());
    result = prime * result + ((authors == null) ? 0 : authors.hashCode());
    result = prime * result + ((subject == null) ? 0 : subject.hashCode());
    result = prime * result + ((publishDate == null) ? 0 : publishDate.hashCode());
    return result;
  }
  
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Book other = (Book) obj;
    if (title == null) {
      if (other.title != null)
        return false;
    } else if (!title.equals(other.title))
      return false;
    if (authors == null) {
      if (other.authors != null)
        return false;
    } else if (!authors.equals(other.authors))
      return false;
    if (subject == null) {
      if (other.subject != null)
        return false;
    } else if (!subject.equals(other.subject))
      return false;
    if (publishDate == null) {
      if (other.publishDate != null)
        return false;
    } else if (!publishDate.equals(other.publishDate))
      return false;
    return true;
  }
}