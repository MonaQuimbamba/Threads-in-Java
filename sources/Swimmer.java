/**
 * Simulates the behavior of a swimmer in the pool.
 */
public class Swimmer extends Thread {
    private SwimmingPool pool;
    private int num; // id of the swimmer

    /**
     * Create a swimmer.
     * @param num id of the swimmer
     * @param pool the swimming pool used by the swimmer
     */
    public Swimmer(int num, SwimmingPool pool) {
        this.num = num;
        this.pool = pool;
    }

    @Override
    public void run() {

        int i = 0;

                    try {

                        System.out.println("Swimmer " + this.num + " awaits.");
                        Basket bskt = this.pool.takeBasket();
                        System.out.println("Swimmer " + this.num + " takes the basket #" + bskt.getId() + ".");
                        Cabin cab = this.pool.takeCabin();
                        System.out.println("Swimmer " + this.num + " takes a cabin #" + cab.getId() + ".");
                        /* undress... */
                        System.out.println("Swimmer " + this.num + " undresses.");
                        Thread.sleep(1000);
                        this.pool.releaseCabin(cab);
                        System.out.println("Swimmer " + this.num + " releases a cabin #" + cab.getId() + ".");
                        cab = null; // now we cannot use the cabin
                        /* swimming... */
                        System.out.println("Swimmer " + this.num + " swims.");
                        Thread.sleep(3000);
                        cab = this.pool.takeCabin();
                        System.out.println("Swimmer " + this.num + " takes a cabin #" + cab.getId() + ".");
                        /* dress... */
                        System.out.println("Swimmer " + this.num + " dresses.");
                        Thread.sleep(1000);
                        this.pool.releaseCabin(cab);
                        System.out.println("Swimmer " + this.num + " releases a cabin #" + cab.getId() + ".");

                        cab = null; // now we cannot use the cabin
                        this.pool.releaseBasket(bskt);
                        System.out.println("Swimmer " + this.num + " releases a basket #" + bskt.getId() + ".");



                    } catch (InterruptedException ie) {
                        assert (false);
                    }


    }
}
