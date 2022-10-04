import java.util.List;
class DrivableTrader <T> extends Trader<Drivable>{
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


    /** A helper method to return the maximum speed of a Drivable object
     *
     * @param object a Drivable object
     * @return The maximum speed of that object
     */
    public int getMaxSpeed(Drivable object){
        return object.getMaxSpeed();
    }

    /** A helper method to return the price for non-tradable but Drivable objects
     *
     * @param object A Drivable object
     * @return The "value price" of the non-tradable object,
     * and 0 if that is tradable, because that tradable has no missing price. 
     *
     */
    public int getMissingPrice(Drivable object){
        if (!(object instanceof Tradable)){
            return super.getSellingPrice(object);
        }
        return 0;
    }

    /** A method to get the selling price of a Drivable object, which will take in
     * a Drivable object and return its price. Return 0 if there is no price.
     *
     * @param object a Drivable object
     *
     * @return the price of the given Drivable object
     */
    @Override
    public int getSellingPrice(Drivable object){
        if (object instanceof Tradable){
            return ((Tradable) object).getPrice() + this.getMaxSpeed(object);
        }
        else {
            return this.getMissingPrice(object);
        }
    }
}
