interface DBFactory {
  public void readAndSave();
}

class JsonToPostgresFactory implements DBFactory {
  @Override
  public void readAndSave() {
    DataFormat dataFormat = new JsonFormat();
    dataFormat.read();

    DBConnection dbConnection = new PostgresDB();
    dbConnection.save();
  }
}

class HTMLToMongoFactory implements DBFactory {
  @Override
  public void readAndSave() {
    DataFormat dataFormat = new HTMLFormat();
    dataFormat.read();

    DBConnection dbConnection = new MongoDB();
    dbConnection.save();
  }
}

// .. total 3 * 3 = 9 factory subclasses 

interface DataFormat {
  public void read();
}

class JsonFormat implements DataFormat {
  @Override
  public void read() {
    System.out.println("Reading Data From JSON Format");
  }
}

class XMLFormat implements DataFormat {
  @Override
  public void read() {
    System.out.println("Reading Data From XML Format");
  }
}

class HTMLFormat implements DataFormat {
  @Override
  public void read() {
    System.out.println("Reading Data From HTML Format");
  }
}

interface DBConnection {
  public void save();
}

class MongoDB implements DBConnection {
  @Override
  public void save() {
    System.out.println("Saving Data in MongoDB");
  }
}

class PostgresDB implements DBConnection {
  @Override
  public void save() {
    System.out.println("Saving Data in PostgresDB");
  }
}

class RedisDB implements DBConnection {
  @Override
  public void save() {
    System.out.println("Saving Data in RedisDB");
  }
}


public class _01_Factory_Method_Problem {
  public static void main(String[] args){
    DBFactory factory1 = new HTMLToMongoFactory();
    factory1.readAndSave();

    DBFactory factory2 = new JsonToPostgresFactory();
    factory2.readAndSave();
  }
}