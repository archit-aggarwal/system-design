package Entity;

public class BookItem extends Book {
  String barCodeId;
  String rack;
  BookItemStatus status;
  
  public String getBarCodeId() {
    return barCodeId;
  }
  public void setBarCodeId(String barCodeId) {
    this.barCodeId = barCodeId;
  }
  public String getRack() {
    return rack;
  }
  public void setRack(String rack) {
    this.rack = rack;
  }
  public BookItemStatus getStatus() {
    return status;
  }
  public void setStatus(BookItemStatus status) {
    this.status = status;
  }
  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }
}
