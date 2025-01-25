import java.util.ArrayList;
import java.util.List;

abstract class Report {
  String title;

  public Report(String title) 
  { this.title = title; }

  public String getTitle() {
    return this.title;
  }

  abstract void accept(ReportVisitor visitor);
}

class SalesReport extends Report {
  public SalesReport(String title) 
  { super(title); }

  @Override
  public void accept(ReportVisitor visitor) 
  { visitor.visit(this); }
}

class InventoryReport extends Report {
  public InventoryReport(String title) 
  { super(title); }

  @Override
  public void accept(ReportVisitor visitor) 
  { visitor.visit(this); }
}

class EmployeeReport extends Report {
  public EmployeeReport(String title) 
  { super(title); }

  @Override
  public void accept(ReportVisitor visitor) 
  { visitor.visit(this); }
}

interface ReportVisitor {
  void visit(SalesReport salesReport);
  void visit(InventoryReport inventoryReport);
  void visit(EmployeeReport employeeReport);
}

class PDFReportGenerator implements ReportVisitor {
  @Override
  public void visit(SalesReport salesReport) {
      System.out.println("Generating PDF for Sales Report: " 
      + salesReport.getTitle());
  }

  @Override
  public void visit(InventoryReport inventoryReport) {
      System.out.println("Generating PDF for Inventory Report: " 
      + inventoryReport.getTitle());
  }

  @Override
  public void visit(EmployeeReport employeeReport) {
      System.out.println("Generating PDF for Employee Report: " 
      + employeeReport.getTitle());
  }
}

class ExcelReportGenerator implements ReportVisitor {
  @Override
  public void visit(SalesReport salesReport) {
      System.out.println("Generating Excel for Sales Report: " 
      + salesReport.getTitle());
  }

  @Override
  public void visit(InventoryReport inventoryReport) {
      System.out.println("Generating Excel for Inventory Report: " 
      + inventoryReport.getTitle());
  }

  @Override
  public void visit(EmployeeReport employeeReport) {
      System.out.println("Generating Excel for Employee Report: " 
      + employeeReport.getTitle());
  }
}

public class _02_Solution_Visitor {
  public static void main(String[] args) {
    List<Report> reports = new ArrayList<>();
    reports.add(new SalesReport("Q1 Sales"));
    reports.add(new InventoryReport("Warehouse Inventory"));
    reports.add(new EmployeeReport("Employee Details"));

    ReportVisitor pdfGenerator = new PDFReportGenerator();
    ReportVisitor excelGenerator = new ExcelReportGenerator();

    System.out.println("Generating Reports in PDF Format:");
    for (Report report : reports) {
        report.accept(pdfGenerator);
    }

    System.out.println("\nGenerating Reports in Excel Format:");
    for (Report report : reports) {
        report.accept(excelGenerator);
    }
  }
}
