import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;

/**
 * To avoid delays/latencies, we can remove synchronization at method level and introduce it at block level. However, now instance null check needs to be made two times, once before acquiring the lock, and once within the synchronized block, as context switch between threads can happen at any time.
 * Drawback -> Singleton can still break if there is serialization/deserialization done
  or if private constructor is accessed using reflection API
 * NOTE -> Serializability Safety can be resolved by adding 
 * protected Object readResolve() {
        return instance;
    }
 * but Reflection API issue cannot be resolved in Logger Class
 */
class Logger implements Serializable {
  private static Logger instance;

  private Logger(){}

  public static Logger getInstance() {
    if(instance == null) {
      synchronized(Logger.class){
        if(instance == null){
          instance = new Logger();
        }
      }
    }
    return instance;
  }

  public void log(String message) {
    System.out.println(this + " : " + message);
  }
}

public class _04_DoubleLocking extends Thread {
  @Override
  public void run() {
    Logger logger = Logger.getInstance();
    logger.log("Logging From Thread : " + Thread.currentThread());
  }

  public static void threadSafety(){
     Thread t1 = new _04_DoubleLocking();
     Thread t2 = new _04_DoubleLocking();
     Thread t3 = new _04_DoubleLocking();
     Thread t4 = new _04_DoubleLocking();
     Thread t5 = new _04_DoubleLocking();
     Thread t6 = new _04_DoubleLocking();
     Thread t7 = new _04_DoubleLocking();
     Thread t8 = new _04_DoubleLocking();
     
     t1.start();
     t2.start();
     t3.start();
     t4.start();
     t5.start();
     t6.start();
     t7.start();
     t8.start();
  }

  public static void serializableSafety() throws Exception{
    Logger singleton1 = Logger.getInstance();
    
    ObjectOutputStream outputStream = 
      new ObjectOutputStream(new FileOutputStream("object.obj"));
    outputStream.writeObject(singleton1);
    outputStream.close();

    ObjectInputStream inputStream = 
      new ObjectInputStream(new FileInputStream("object.obj"));
    Logger singleton2 = (Logger) inputStream.readObject();
    inputStream.close();

    singleton1.log("Logging From Object Before Serialization");
    singleton2.log("Logging From Object After Serialization");
  }

  @SuppressWarnings("all")
  public static void reflectionSafety() throws Exception {
    Logger singleton1 = Logger.getInstance();

    Constructor[] constructors = Logger.class.getDeclaredConstructors();
    Constructor constructor = constructors[0];
    constructor.setAccessible(true);
    Logger singleton2 = (Logger) constructor.newInstance();

    singleton1.log("Logging From Object Using getInstance() Method");
    singleton2.log("Logging From Object Using Reflection API");
  }

  public static void main(String[] args) throws Exception{
    // threadSafety();
    serializableSafety();
    reflectionSafety();
  }
}
