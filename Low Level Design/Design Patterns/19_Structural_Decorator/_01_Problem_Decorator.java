// Base Cloud Storage Service
class CloudStorage {
  public void upload(String data) {
      System.out.println("Uploading: " + data);
  }
}

// Extended class (Encryption added manually)
class EncryptedCloudStorage extends CloudStorage {
  @Override
  public void upload(String data) {
      String encryptedData = encrypt(data);
      super.upload(encryptedData);
  }

  private String encrypt(String data) {
      return "Encrypted(" + data + ")";
  }
}

// Extended class (Compression added manually)
class CompressedCloudStorage extends CloudStorage {
  @Override
  public void upload(String data) {
      String compressedData = compress(data);
      super.upload(compressedData);
  }

  private String compress(String data) {
      return "Compressed(" + data + ")";
  }
}

// If we need both Encryption & Compression, we create another subclass! ❌
class EncryptedCompressedCloudStorage extends CloudStorage {
  @Override
  public void upload(String data) {
      String compressedData = compress(data);
      String encryptedData = encrypt(compressedData);
      super.upload(encryptedData);
  }

  private String compress(String data) {
      return "Compressed(" + data + ")";
  }

  private String encrypt(String data) {
      return "Encrypted(" + data + ")";
  }
}

public class _01_Problem_Decorator {
  public static void main(String[] args) {
    CloudStorage s1 = new CloudStorage();
    CloudStorage s2 = new EncryptedCloudStorage();
    CloudStorage s3 = new CompressedCloudStorage();
    CloudStorage s4 = new EncryptedCompressedCloudStorage();

    s1.upload("D1");
    s2.upload("D2");
    s3.upload("D3");
    s4.upload("D4");
  }
}
