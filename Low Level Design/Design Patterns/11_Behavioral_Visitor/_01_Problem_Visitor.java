abstract class Report {
  String title;

  public Report(String title) 
  { this.title = title; }

  public abstract void generatePDF();
  public abstract void generateExcel();
  public abstract void generateHTML();
}

// Concrete Report Types
class SalesReport extends Report {
  public SalesReport(String title) { super(title); }

  @Override
  public void generatePDF() 
  { System.out.println("Generating PDF for Sales Report: " + title); }

  @Override
  public void generateExcel() 
  { System.out.println("Generating Excel for Sales Report: " + title); }

  @Override
  public void generateHTML() 
  { System.out.println("Generating HTML for Sales Report: " + title); }
}

class InventoryReport extends Report {
  public InventoryReport(String title) { super(title); }

  @Override
  public void generatePDF() 
  { System.out.println("Generating PDF for Inventory Report: " + title); }

  @Override
  public void generateExcel() 
  { System.out.println("Generating Excel for Inventory Report: " + title); }

  @Override
  public void generateHTML() 
  { System.out.println("Generating HTML for Inventory Report: " + title); }
}

class EmployeeReport extends Report {
  public EmployeeReport(String title) { super(title); }

  @Override
  public void generatePDF() 
  { System.out.println("Generating PDF for Employee Report: " + title); }

  @Override
  public void generateExcel() 
  { System.out.println("Generating Excel for Employee Report: " + title); }

  @Override
  public void generateHTML() 
  { System.out.println("Generating HTML for Employee Report: " + title); }
}

public class _01_Problem_Visitor {
  public static void main(String[] args) {
    Report salesReport = new SalesReport("Q1 Sales");
    Report inventoryReport = new InventoryReport("Warehouse Inventory");
    Report employeeReport = new EmployeeReport("Employee Details");

    salesReport.generatePDF();
    inventoryReport.generateExcel();
    employeeReport.generateHTML();
  }
}
