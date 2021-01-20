

import java.util.Stack;

public class SwimmingPoolImp implements SwimmingPool
{
    // stack where will all  the basket be stored
    Stack <Basket> stackBasket ;
    // stack where will all  the cabin be stored
    Stack <Cabin> stackCabin ;

    /**
     * Create a SwimmingPoolImp.
     * @param nbB the number of baskets
     * @param nbC the number of cabins
     */
    public SwimmingPoolImp(Integer nbB,Integer nbC)
    {
        stackBasket   = new Stack <Basket> ();
        stackCabin = new Stack <Cabin> ();
        // we add each baskt and cabin in its stack
        for(int i =1;i<=nbB;i++){ stackBasket.push(new Basket(i));}
        for(int i =1;i<=nbC;i++){ stackCabin.push(new Cabin(i));}
    }

    public synchronized Basket takeBasket()
    {

        // TODO Implement this method
       while(this.getStackBasket().size()==0)
        {
                  try {
                this.wait(); // we wait in case all the baskets are unavailable
            } catch (InterruptedException ie) {
                System.err.println("Probleme : " + ie.getMessage());
            }

        }
        assert(this.getStackBasket().size() != 0);
        return this.stackBasket.pop();
    }

    public synchronized void releaseBasket(Basket b) {
         // if we add a basket on the stack, we notify the gang thread to go
        this.stackBasket.push(b);
        if (this.getStackBasket().size() > 0) {
            this.notifyAll();
        }


    }

    /**
     * the accessor to get the stack of basket
     * @return Stack of Basket
     */
    public Stack<Basket> getStackBasket() {
        return stackBasket;
    }

    /**
     *the accessor to get the stack of cabin
     * @return Stack of Cabin
     */
    public Stack<Cabin> getStackCabin() {
        return stackCabin;
    }

    public synchronized Cabin takeCabin()
    {

       while(this.getStackCabin().size()==0)
        {
                 try {
                this.wait(); // we wait in case all the cabins are unavailable
            } catch (InterruptedException ie) {
                System.err.println("Probleme : " + ie.getMessage());
            }

        }
        assert(this.getStackCabin().size() != 0);
        return this.stackCabin.pop();
    }

    public synchronized void releaseCabin(Cabin c) {
        // if we add a cabin on the stack, we notify the gang thread to go
        this.stackCabin.push(c);
        if (this.getStackCabin().size() >0) {
            this.notifyAll();
        }
    }
}
