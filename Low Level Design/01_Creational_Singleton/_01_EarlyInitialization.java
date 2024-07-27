/**
 * This is eager initialization concept where as soon as JVM starts the object will be
 * created irrespective of whether it got accessed anywhere in application or not.
 * When to use : One possible usage can be some static cache needed in application which is 
 * required to be loaded during compile-time.
 * Drawback : It consumes resources even if application does not use it.
 */
class Logger {
  private static Logger instance = new Logger();

  static {
    instance.log("Logging From Static Block");
  }

  private Logger(){}

  public static Logger getInstance() {
    return instance;
  }

  public void log(String message) {
    System.out.println(this + " : " + message);
  }
}

public class _01_EarlyInitialization {
  public static void controller(){
    Logger logger = Logger.getInstance();
    logger.log("Logging From Controller Layer");
  }

  public static void service(){
    Logger logger = Logger.getInstance();
    logger.log("Logging From Service Layer");
  }

  public static void main(String[] args){
    controller();
    service();
  }
}

