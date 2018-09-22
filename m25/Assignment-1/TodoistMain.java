import java.util.Scanner;
import java.util.Arrays;

/**
  * write your code below this comment
  */
class Task {
        private String title;
        private String assignedTo;
        private int timeToComplete;
        private boolean important;
        private boolean urgent;
        private String status;

        Task(String title1, String assigned, int time, boolean imp, boolean urgnt, String status1) {
            this.title = title1;
            this.assignedTo = assigned;
            this.timeToComplete = time;
            this.important = imp;
            this.urgent = urgnt;
            this.status = status1;
        }
        public String getTitle() {
                    return this.title;
                }
        public String getAssignedTo() {
            return this.assignedTo;
        }
        public int getTime() {
            // int t;
            //     if (this.timeToComplete < 0) {
            //         System.out.println("Invalid timeToComplete " + this.timeToComplete);
            //     } else {
            //         t = this.timeToComplete;
            //          return t;
            //     }
            //     }
            //  catch (Exception e) {
                    
            // }
            return this.timeToComplete;
        }
          
        public String getImporatnat() {
            String s = "";
            if(this.important == true) {
                s = "Important";
            } else {
                s = "Not Important";
            }
            return s;
        }
        public String getUrgent() {
            String k = "";
            if(this.urgent == true) {
                k = "Urgent";
            } else {
                k = "Not Urgent";
            }
            return k;
        }
        public String getStatus() {
            String stat = "";
            // if (this.status(!(.equals("todo"))) || this.status(!(.equals("done")))) {
            //     throw new Exception(e);
            // }
            if (this.status.equals("todo")) {
                stat = "todo";
            } 
            // else (this.status.equals("done")){
            //     stat = "done";
            // }
             else {
                stat = "done";
             }
            return stat;
        }

        public String toString () {
            String s = "";
            s = getTitle() + ", " +  getAssignedTo() + ", " + getTime() + ", " + getImporatnat() + ", " + getUrgent() + ", " + getStatus();
            return s;
        }

}

class Todoist {
    private Task[] arr;
    private int size;

    Todoist() {
        arr = new Task[10];
        size = 0;
    }

    public int getSize() {
        return size;
    }
    public void resize(Task item) {
        arr = Arrays.copyOf(arr, arr.length * 2);
        arr[size++] = item;
    }

    public void addTask(Task items) {
        arr[size++] = items;
    }
    public Task getNextTask(String item) {
        return null;
    }
    public Task[] getNextTask(String text, int i) {
        return arr;
    }

    public int totalTime4Completion() {
        return 0;
    }
}
/**
 * Class for todoist main.
 */
public class TodoistMain {

    /**
     * Starts a test.
     */
    public static void startTest() {
        Todoist todo = new Todoist();
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(",");
            switch (tokens[0]) {
                case "task":
                    testTask(tokens);
                break;
                case "add-task":
                    testAddTask(todo, tokens);
                break;
                case "print-todoist":
                    System.out.println(todo);
                break;
                case "get-next":
                    System.out.println(todo.getNextTask(tokens[1]));
                break;
                case "get-next-n":
                    int n = Integer.parseInt(tokens[2]);
                    Task[] tasks = todo.getNextTask(tokens[1], n);
                    System.out.println(Arrays.deepToString(tasks));
                break;
                case "total-time":
                    System.out.println(todo.totalTime4Completion());
                break;
                default:
                break;
            }
        }
    }

    /**
     * method to test add task.
     *
     * @param      todo    The todo
     * @param      tokens  The tokens
     */
    public static void testAddTask(final Todoist todo, final String[] tokens) {
        try {
            todo.addTask(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * method to test the creation of task object.
     *
     * @param      tokens  The tokens
     */
    public static void testTask(final String[] tokens) {
        try {
            System.out.println(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates a task object.
     *
     * @param      tokens     The tokens
     *
     * @return     Task object
     *
     * @throws     Exception  if task inputs are invalid
     */
    public static Task createTask(final String[] tokens) throws Exception {
        String title = tokens[1];
        String assignedTo = tokens[2];
        int timeToComplete = Integer.parseInt(tokens[3]);
        boolean important = tokens[4].equals("y");
        boolean urgent = tokens[5].equals("y");
        String status = tokens[6];
        return new Task(
            title, assignedTo, timeToComplete, important, urgent, status);
    }

    /**
     * main method.
     *
     * @param      args  The command line arguments
     */
    public static void main(final String[] args) {
        startTest();
    }
}
