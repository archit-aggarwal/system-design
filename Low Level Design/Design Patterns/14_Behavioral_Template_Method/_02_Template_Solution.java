// Abstract Class
abstract class DataProcessor {
  // Template Method
  public final void process() {
      fetchData();
      processData();
      saveData();
  }

  // Steps to be implemented by subclasses
  protected abstract void fetchData();
  protected abstract void processData();

  // Common step with default implementation
  protected void saveData() {
      System.out.println("Saving processed data to database...");
  }
}

// Concrete Subclass for CSV
class CSVDataProcessor extends DataProcessor {
  @Override
  protected void fetchData() {
      System.out.println("Fetching data from CSV...");
  }

  @Override
  protected void processData() {
      System.out.println("Processing CSV data...");
  }
}

// Concrete Subclass for JSON
class JSONDataProcessor extends DataProcessor {
  @Override
  protected void fetchData() {
      System.out.println("Fetching data from JSON...");
  }

  @Override
  protected void processData() {
      System.out.println("Processing JSON data...");
  }
}

public class _02_Template_Solution {
  public static void main(String[] args) {
    DataProcessor csvProcessor = new CSVDataProcessor();
    csvProcessor.process();

    DataProcessor jsonProcessor = new JSONDataProcessor();
    jsonProcessor.process();
  }
}
