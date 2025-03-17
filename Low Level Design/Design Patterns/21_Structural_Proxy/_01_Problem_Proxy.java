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

// Client Code - Loads all videos immediately, even if not played
public class _01_Problem_Proxy {
  public static void main(String[] args) {
    Video video = new RealVideo("movie.mp4");
    // Even though video is not played, it's loaded unnecessarily

    video = new RealVideo("trailer.mp4");
    video.play();
  }
}
