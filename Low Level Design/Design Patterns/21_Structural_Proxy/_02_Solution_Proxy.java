// Subject Interface
interface Video {
  void play();
}

// Real Object - Loads file immediately
class RealVideo implements Video {
  private String filename;

  public RealVideo(String filename) {
      this.filename = filename;
      loadVideoFromDisk();  // Expensive operation
  }

  private void loadVideoFromDisk() {
      System.out.println("Loading video from disk: " + filename);
  }

  @Override
  public void play() {
      System.out.println("Playing video: " + filename);
  }
}

// Proxy Class - Loads video only when needed
class VideoProxy implements Video {
  private RealVideo realVideo;
  private String filename;

  public VideoProxy(String filename) {
      this.filename = filename;
  }

  @Override
  public void play() {
      if (realVideo == null) {
          // Load only when needed (Lazy Loading)
          realVideo = new RealVideo(filename);  
      }
      realVideo.play();
  }
}

public class _02_Solution_Proxy {
  public static void main(String[] args) {
    Video video = new VideoProxy("movie.mp4");
    // Since video is not played, it is not loaded

    video = new VideoProxy("trailer.mp4");
    video.play();
  }
}

