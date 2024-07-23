import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Task {
    private String description;
    private boolean isComplete;

    public Task(String description) {
        this.description = description;
        this.isComplete = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isComplete() {
        return isComplete;
    }

    public void markComplete() {
        this.isComplete = true;
    }

    @Override
    public String toString() {
        return description + " [" + (isComplete ? "Complete" : "Incomplete") + "]";
    }
}

class ToDoList {
    private List<Task> tasks;

    public ToDoList() {
        tasks = new ArrayList<>();
    }

    public void addTask(String description) {
        tasks.add(new Task(description));
    }

    public void viewTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public void markTaskComplete(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markComplete();
        }
    }

    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        ToDoList toDoList = new ToDoList();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task as Complete");
            System.out.println("4. Remove Task");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            // Using try-catch to handle non-integer inputs
            int choice = -1;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();
                    toDoList.addTask(description);
                    break;
                case 2:
                    toDoList.viewTasks();
                    break;
                case 3:
                    System.out.print("Enter task number to mark as complete: ");
                    try {
                        int completeIndex = Integer.parseInt(scanner.nextLine()) - 1;
                        toDoList.markTaskComplete(completeIndex);
                    } catch (NumberFormatException | IndexOutOfBoundsException e) {
                        System.out.println("Invalid task number.");
                    }
                    break;
                case 4:
                    System.out.print("Enter task number to remove: ");
                    try {
                        int removeIndex = Integer.parseInt(scanner.nextLine()) - 1;
                        toDoList.removeTask(removeIndex);
                    } catch (NumberFormatException | IndexOutOfBoundsException e) {
                        System.out.println("Invalid task number.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
