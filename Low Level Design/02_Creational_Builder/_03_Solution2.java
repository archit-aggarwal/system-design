import java.util.HashMap;
import java.util.Map;

public class _03_Solution2 {
  public static void main(String[] args) {
    Director director = new Director();

    Builder getRequestBuilder = new HttpGetRequestBuilder();
    director.setBuilder(getRequestBuilder);
    director.build("https://api.example.com/get");
    HttpRequest getRequest = getRequestBuilder.build();
    System.out.println(getRequest);

    Builder postRequestBuilder = new HttpPostRequestBuilder();
    postRequestBuilder.setBody("{\"key\":\"value\"}");
    director.setBuilder(postRequestBuilder);
    director.build("https://api.example.com/post");
    HttpRequest postRequest = postRequestBuilder.build();
    System.out.println(postRequest);
  }
}

class Director {
  private Builder builder;

  public void setBuilder(Builder builder) {
      this.builder = builder;
  }

  public void build(String url) {
      builder.setUrl(url);
      builder.addHeader("Content-Type", "application/json");
      builder.setTimeout(10);
  }
}

interface Builder {
  void setUrl(String url);
  void addHeader(String key, String value);
  void setTimeout(int timeout);
  HttpRequest build();
}

class HttpGetRequestBuilder implements Builder {
  private String url;
  private Map<String, String> headers = new HashMap<>();
  private Integer timeout;

  @Override
  public void setUrl(String url) {
      this.url = url;
  }

  @Override
  public void addHeader(String key, String value) {
      headers.put(key, value);
  }

  @Override
  public void setTimeout(int timeout) {
      this.timeout = timeout;
  }

  @Override
  public HttpRequest build() {
      return new HttpRequest("GET", url, null, headers, timeout);
  }
}

class HttpPostRequestBuilder implements Builder {
  private String url;
  private Map<String, String> headers = new HashMap<>();
  private Integer timeout;
  private String body;

  @Override
  public void setUrl(String url) {
      this.url = url;
  }

  @Override
  public void addHeader(String key, String value) {
      headers.put(key, value);
  }

  @Override
  public void setTimeout(int timeout) {
      this.timeout = timeout;
  }

  public void setBody(String body) {
      this.body = body;
  }

  @Override
  public HttpRequest build() {
      return new HttpRequest("POST", url, body, headers, timeout);
  }
}

class HttpRequest {
  private final String method;
  private final String url;
  private final String body;
  private final Map<String, String> headers;
  private final Integer timeout;

  public HttpRequest(String method, String url, String body, 
            Map<String, String> headers, Integer timeout) {
      this.method = method;
      this.url = url;
      this.body = body;
      this.headers = headers;
      this.timeout = timeout;
  }

  @Override
  public String toString() {
    return "HttpRequest [method=" + method + ", url=" + url + ",\nbody=" 
        + body + ",headers=" + headers + ", timeout=" + timeout + "]";
  }
}


