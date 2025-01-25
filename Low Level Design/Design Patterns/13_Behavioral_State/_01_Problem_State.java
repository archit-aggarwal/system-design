class Elevator {
  private String state = "Idle"; // Current state of the elevator
  private int currentFloor = 0;

  public void requestFloor(int targetFloor) {
      if (state.equals("Idle")) {
          if (targetFloor > currentFloor) {
              state = "Moving Up";
              moveUp(targetFloor);
          } else if (targetFloor < currentFloor) {
              state = "Moving Down";
              moveDown(targetFloor);
          } else {
              openDoor();
          }
      } else if (state.equals("Moving Up") 
            || state.equals("Moving Down")) {
          System.out.println("Elevator is busy. Please wait.");
      } else if (state.equals("Door Open")) {
          System.out.println("Door is already open.");
      }
  }

  private void moveUp(int targetFloor) {
      System.out.println("Moving up...");
      for (int i = currentFloor + 1; i <= targetFloor; i++) {
          System.out.println("Floor " + i);
      }
      currentFloor = targetFloor;
      state = "Door Open";
      openDoor();
  }

  private void moveDown(int targetFloor) {
      System.out.println("Moving down...");
      for (int i = currentFloor - 1; i >= targetFloor; i--) {
          System.out.println("Floor " + i);
      }
      currentFloor = targetFloor;
      state = "Door Open";
      openDoor();
  }

  private void openDoor() {
      System.out.println("Door is opening...");
      state = "Idle";
      System.out.println("Door is closing...");
  }
}

public class _01_Problem_State {
  public static void main(String[] args) {
    Elevator elevator = new Elevator();
    elevator.requestFloor(3);
    elevator.requestFloor(1);
  }  
}
