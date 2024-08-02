import java.util.*;

public class save_01_Problem {
  public static void main(String[] args) {
    HttpRequest request1 = new HttpRequest("GET", "http://localhost:8080/users");

    System.out.println(request1);

    Map<String, String> headers = new HashMap<>();
    headers.put("Accept", "application/json");

    HttpRequest request2 = new HttpRequest("POST", "http://localhost:8080/users", 
      "{\"name\":\"archit\"}", headers, 10);

    System.out.println(request2);

    HttpRequest request3 = new HttpRequest("GET", "http://localhost:8080/users?id=1", 10);

    System.out.println(request3);
  }
}

class HttpRequest {
    // Required parameters
    private final String method;
    private final String url;

    // Optional parameters
    private final String body;
    private final Map<String, String> headers;
    private final Integer timeout;

    public HttpRequest(String method, String url, String body, 
              Map<String, String> headers, int timeout) {
      this.method = method;
      this.url = url;
      this.body = body;
      this.headers = headers;
      this.timeout = timeout;
    }

    public HttpRequest(String method, String url){
      this.method = method;
      this.url = url;
      this.body = null;
      this.headers = null;
      this.timeout = null;
    }

    public HttpRequest(String method, String url, int timeout){
      this.method = method;
      this.url = url;
      this.body = null;
      this.headers = null;
      this.timeout = timeout;
    }

    // ... and more combinations of constructors

    @Override
    public String toString() {
      return "HttpRequest [method=" + method + ", url=" + url + ",\nbody=" 
          + body + ",headers=" + headers + ", timeout=" + timeout + "]";
    }
}


