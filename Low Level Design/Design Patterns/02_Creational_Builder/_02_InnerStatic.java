import java.util.HashMap;
import java.util.Map;

public class _02_InnerStatic {
  public static void main(String[] args) {
    HttpRequest request1 = new HttpRequest
      .HttpRequestBuilder("GET", "http://localhost:8080/users")
      .build();

    System.out.println(request1);

    HttpRequest request2 = new HttpRequest
        .HttpRequestBuilder("POST", "http://localhost:8080/users")
        .body("{\"name\":\"archit\"}")
        .header("Accept", "application/json")
        .header("Authorization", "Bearer Token")
        .timeout(10)
        .build();
      
    System.out.println(request2);

    HttpRequest request3 = new HttpRequest
    .HttpRequestBuilder("GET", "http://localhost:8080/users?id=1")
    .timeout(10)
    .build();
    
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

  private HttpRequest(HttpRequestBuilder builder) {
    this.method = builder.method;
    this.url = builder.url;
    this.body = builder.body;
    this.headers = builder.headers;
    this.timeout = builder.timeout;
  }

  @Override
  public String toString() {
    return "HttpRequest [method=" + method + ", url=" + url + ",\nbody=" 
        + body + ",headers=" + headers + ", timeout=" + timeout + "]";
  }

  public static class HttpRequestBuilder {
    // Required parameters
    private final String method;
    private final String url;

    // Optional parameters - initialized to default values
    private String body = null;
    private Map<String, String> headers = new HashMap<>();
    private Integer timeout = null;

    public HttpRequestBuilder(String method, String url) {
        this.method = method;
        this.url = url;
    }

    public HttpRequestBuilder body(String body) {
        this.body = body;
        return this;
    }

    public HttpRequestBuilder header(String key, String value) {
        this.headers.put(key, value);
        return this;
    }

    public HttpRequestBuilder timeout(int timeout) {
        this.timeout = timeout;
        return this;
    }

    public HttpRequest build() {
        return new HttpRequest(this);
    }
  }
}


