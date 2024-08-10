class Editor_Problem {
  private String name;
  private String email;

  public Editor_Problem(String name, String email) {
      this.name = name;
      this.email = email;
  }

  public void login() {
      System.out.println(name + " logged in with email: " + email);
  }

  public void editDocument() {
      System.out.println(name + " is editing the document");
  }

  public void viewDocument() {
      System.out.println(name + " is viewing the document");
  }
}


class Viewer_Problem {
  private String name;
  private String email;

  public Viewer_Problem(String name, String email) {
      this.name = name;
      this.email = email;
  }

  public void login() {
      System.out.println(name + " logged in with email: " + email);
  }

  public void viewDocument() {
      System.out.println(name + " is viewing the document");
  }
}

abstract class User {
    protected String name;
    protected String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public void login() {
        System.out.println(name + " logged in with email: " + email);
    }

    public void viewDocument() {
        System.out.println(name + " is viewing the document");
    }

    public abstract void performAction();
}

class Editor extends User {
    public Editor(String name, String email) {
        super(name, email);
    }

    @Override
    public void performAction() {
        System.out.println(name + " is editing the document");
    }
}

class Viewer extends User {
    public Viewer(String name, String email) {
        super(name, email);
    }

    @Override
    public void performAction() {
        System.out.println(name + " is commenting on the document");
    }
}













