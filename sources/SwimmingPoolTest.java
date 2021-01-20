
import java.util.ArrayList;

public class SwimmingPoolTest {
    private static final int bsktMaxNb = 5;  // number of baskets available
    private static final int cabinMaxNb = 2; // number of cabins available
    private static final int swimmerNb = 10; // number of swimmers

    public static void main(String[] args) throws InterruptedException {
        // swimming pool creation
        SwimmingPool pool = new SwimmingPoolImp(bsktMaxNb, cabinMaxNb);
        // swimmer list
        ArrayList<Swimmer> swimmers = new ArrayList<>();
        // get the current time (used to calculate simulation time for information)
        long startTime = System.currentTimeMillis();
        // we create and launch swimmerNb swimmers...
        for(int i=0; i < swimmerNb; i++) {
            Swimmer swimmer = new Swimmer(i,pool);
            swimmers.add(i,swimmer);
            swimmer.start();
        }
        // we are waiting for the swimmers to end their activity
        for(Swimmer s : swimmers) {
            s.join();
        }
        long endTime = System.currentTimeMillis();
        // calculation and display of execution time (for information)
        long timeElapsed = endTime - startTime; //
        System.out.println("Execution time in milliseconds: " + timeElapsed);
    }
}
