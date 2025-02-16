import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        Scanner scanner = new Scanner(System.in);
        ElevatorController controller = new ElevatorController(3, 5);

        controller.requestElevator(5, 10);
        Thread.sleep(3000);
        controller.requestElevator(1, 7);
        Thread.sleep(3000);
        controller.requestElevator(8, 2);
        Thread.sleep(3000);
        controller.requestElevator(1, 9);

//        new Thread(()->{
//            while(true) {
//                System.out.println("Enter source and destination floor: ");
//                String inpt = scanner.nextLine();
//                String[] values = inpt.split(",");
//                int source = Integer.valueOf(values[0]);
//                int dest = Integer.valueOf(values[1]);
//                controller.requestElevator(source, dest);
//            }
//        }).start();
//
//        scanner.close();
    }
}