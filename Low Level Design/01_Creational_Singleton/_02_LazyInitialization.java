/**
 * Lazy initialization mean application will create the instance when it is requested.
However, this can be used when you have non-thread-safe application. 
 * If used in multi threaded applications, it might break.
 * Why? - Because getInstance() might get invoked by two threads concurrently
 * and both will create different instances
 * When to use?  Non thread safe and creating common resource like db connection.
 */
class Logger {
  private static Logger instance;

  private Logger(){}

  public static Logger getInstance() {
    if(instance == null) instance = new Logger();
    return instance;
  }

  public void log(String message) {
    System.out.println(this + " : " + message);
  }
}

public class _02_LazyInitialization extends Thread {
  @Override
  public void run() {
    Logger logger = Logger.getInstance();
    logger.log("Logging From Thread : " + Thread.currentThread());
  }

  public static void main(String[] args){
     Thread t1 = new _02_LazyInitialization();
     Thread t2 = new _02_LazyInitialization();
     Thread t3 = new _02_LazyInitialization();
     Thread t4 = new _02_LazyInitialization();
     Thread t5 = new _02_LazyInitialization();
     Thread t6 = new _02_LazyInitialization();
     Thread t7 = new _02_LazyInitialization();
     Thread t8 = new _02_LazyInitialization();
     
     t1.start();
     t2.start();
     t3.start();
     t4.start();
     t5.start();
     t6.start();
     t7.start();
     t8.start();
  }
}



