class CSVDataProcessor {
  public void process() {
      System.out.println("Fetching data from CSV...");
      System.out.println("Processing CSV data...");
      System.out.println("Saving processed CSV data...");
  }
}

class JSONDataProcessor {
  public void process() {
      System.out.println("Fetching data from JSON...");
      System.out.println("Processing JSON data...");
      System.out.println("Saving processed JSON data...");
  }
}

public class _01_Template_Problem {
  public static void main(String[] args) {
    CSVDataProcessor csvProcessor = new CSVDataProcessor();
    csvProcessor.process();

    JSONDataProcessor jsonProcessor = new JSONDataProcessor();
    jsonProcessor.process();
  }
}
