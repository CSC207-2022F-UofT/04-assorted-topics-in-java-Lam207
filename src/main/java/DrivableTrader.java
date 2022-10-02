/* TODO: Create a subclass of Trader named DrivableTrader
 * This class should be identical to Trader, except that it takes
 * only Drivable objects in its inventory, wishlist, etc.
 *
 * The sellingPrice returned should also be overridden. The selling price
 * should be equal to the:
 *     Object's price + Object's max speed
 * If the object is Tradable (and Tradable.MISSING_PRICE otherwise.)
 *
 * Look at DomesticatableTrader.java for an example.
 */

import java.util.List;

class DrivableTrader extends Trader<Drivable>{
    /** Constructor of the DrivableTrader class
     *
     * @param inventory the inventory of the trader (from the parent class Trader)
     * @param wishlist  the wishlist of the trader (from the parent class Trader)
     * @param price     the amount of money the trader has (from the parent class Trader)
     */
    public DrivableTrader(List<Drivable> inventory,
                          List<Drivable> wishlist,
                          int price){
        super(inventory, wishlist, price);
    }
    /** Another overridden constructor of the DrivableTrader class
     *
     * @param price     the amount of money the trader has (from the parent class Trader)
     */

    public DrivableTrader(int price){ super(price); }

    /** A method to get the selling price of a Drivable object, which will take in
     * a Drivable object and return its price. Return 0 if there is no price.
     *
     * @param object a Drivable object
     *
     * @return the price of the given Drivable object
     */
    public int sellingPrice(Drivable object){
        if (object instanceof Tradable){
            return ((Tradable) object).getPrice() + object.getMaxSpeed();
        }
        return 0;
    }
}
