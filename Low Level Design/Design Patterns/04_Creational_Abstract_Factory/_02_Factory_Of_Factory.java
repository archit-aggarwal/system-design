class DBFactory {
  // Composition -> 3 + 3 Factory Classes
  private DataFormatFactory dataFormatFactory;
  private DBConnectionFactory dbConnectionFactory;

  public DBFactory(DataFormatFactory dataFormatFactory, DBConnectionFactory dbConnectionFactory) {
    this.dataFormatFactory = dataFormatFactory;
    this.dbConnectionFactory = dbConnectionFactory;
  }

  public void readAndSave() {
    DataFormat dataFormat = dataFormatFactory.createDataFormat();
    dataFormat.read();

    DBConnection dbConnection = dbConnectionFactory.createDBConnection();
    dbConnection.save();
  }
}


interface DataFormatFactory {
  DataFormat createDataFormat();
}

class JsonFormatFactory implements DataFormatFactory {
  @Override
  public DataFormat createDataFormat() {
    return new JsonFormat();
  }
}

class HTMLFormatFactory implements DataFormatFactory {
  @Override
  public DataFormat createDataFormat() {
    return new HTMLFormat();
  }
}

class XMLFormatFactory implements DataFormatFactory {
  @Override
  public DataFormat createDataFormat() {
    return new XMLFormat();
  }
}

interface DBConnectionFactory {
  DBConnection createDBConnection();
}

class PostgresDBFactory implements DBConnectionFactory {
  @Override
  public DBConnection createDBConnection() {
    return new PostgresDB();
  }
}

class MongoDBFactory implements DBConnectionFactory {
  @Override
  public DBConnection createDBConnection() {
    return new MongoDB();
  }
}

class RedisDBFactory implements DBConnectionFactory {
  @Override
  public DBConnection createDBConnection() {
    return new RedisDB();
  }
}

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

public class _02_Factory_Of_Factory {
  public static void main(String[] args) {
    DataFormatFactory dataFormatFactory = new HTMLFormatFactory();
    DBConnectionFactory dbConnectionFactory = new PostgresDBFactory();

    DBFactory dbFactory = new DBFactory(dataFormatFactory, dbConnectionFactory);
    dbFactory.readAndSave();

    dbConnectionFactory = new MongoDBFactory();
    dbFactory = new DBFactory(dataFormatFactory, dbConnectionFactory);
    dbFactory.readAndSave();
  }
}


