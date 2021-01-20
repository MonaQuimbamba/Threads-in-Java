
import java.util.Stack;

public interface SwimmingPool {
    /**
     * Obtain a basket for a swimmer to put on his clothes.
     * If no basket is available then the caller is blocked until a basket becomes available
     * @return a free basket
     */
    public Basket takeBasket();

    /**
     * Release a basket when a swimmer leaves the pool
     * @param b the basket to release
     */
    public void releaseBasket(Basket b);

    /**
     * Obtain a cabin for a swimmer to take off their clothes.
     * If no cabin is available then the caller is blocked until a basket becomes available
     * @return a free cabin
     */
    public Cabin takeCabin();

    /**
     * Releases a cabin when it is no longer in use.
     * @param c the cabin to release
     */
    public void releaseCabin(Cabin c);

}
