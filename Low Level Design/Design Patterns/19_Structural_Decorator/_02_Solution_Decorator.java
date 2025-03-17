// Step 1: Common Interface for Storage Services
interface Storage {
  void upload(String data);
}

// Step 2: Basic Cloud Storage (Original Functionality)
class CloudStorage implements Storage {
  @Override
  public void upload(String data) {
      System.out.println("Uploading: " + data);
  }
}

// Step 3: Abstract Decorator (Wrapper for Cloud Storage)
abstract class StorageDecorator implements Storage {
  protected Storage storage;

  public StorageDecorator(Storage storage) {
      this.storage = storage;
  }

  @Override
  public void upload(String data) {
      storage.upload(data);
  }
}

// Step 4.1: Encryption Decorator
class EncryptionDecorator extends StorageDecorator {
  public EncryptionDecorator(Storage storage) {
      super(storage);
  }

  @Override
  public void upload(String data) {
      String encryptedData = encrypt(data);
      super.upload(encryptedData);
  }

  private String encrypt(String data) {
      return "Encrypted(" + data + ")";
  }
}

// Step 4.2: Compression Decorator
class CompressionDecorator extends StorageDecorator {
  public CompressionDecorator(Storage storage) {
      super(storage);
  }

  @Override
  public void upload(String data) {
      String compressedData = compress(data);
      super.upload(compressedData);
  }

  private String compress(String data) {
      return "Compressed(" + data + ")";
  }
}

// Step 5: Client Code - Applying Multiple Decorators
public class _02_Solution_Decorator {
  public static void main(String[] args) {
      // Basic Cloud Storage
      Storage storage = new CloudStorage();

      System.out.println("\nUploading plain data:");
      storage.upload("File123");

      // Add Encryption
      Storage encryptedStorage = new EncryptionDecorator(storage);
      System.out.println("\nUploading encrypted data:");
      encryptedStorage.upload("File123");

      // Add Compression
      Storage compressedStorage = new CompressionDecorator(storage);
      System.out.println("\nUploading compressed data:");
      compressedStorage.upload("File123");

      // Add Both Compression + Encryption (Order can be changed)
      Storage encryptedCompressedStorage = new EncryptionDecorator(
                                    new CompressionDecorator(storage));
      System.out.println("\nUploading compressed & encrypted data:");
      encryptedCompressedStorage.upload("File123");

      // Another Order: Encrypt First, Then Compress
      Storage compressedEncryptedStorage = new CompressionDecorator(
                                      new EncryptionDecorator(storage));
      System.out.println("\nUploading encrypted & compressed data:");
      compressedEncryptedStorage.upload("File123");
  }  
}

