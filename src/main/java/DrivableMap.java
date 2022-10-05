/* Below is the DrivableMap class, which is a map that contains a
 * HashMap mapping Strings to Drivable objects.
 * (Think of Python dictionaries as a comparison -- the concept is
 * similar!)
 *
 * Implement the requested methods as stated in the TODOs. We've
 * created the constructor for you already.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class DrivableMap {
    HashMap<String, Drivable> drivable_map;

    /**
     * A generic constructor that initializes car_map
     * as an empty HashMap.
     */
    public DrivableMap() {
        drivable_map = new HashMap<>();
    }

    /** TODO: Write a method named addDrivable that takes a String (the ID)
     *       and a Drivable object. If the ID string does not appear as a key
     *       in drivable_map, then add the pair to drivable_map.
     *       Return true if the Drivable was added to drivable_map.
     *
     * @param id        the id of a Drivable object
     *        object    a given Drivable object
     *
     * @return True if a new Drivable object is added, and False otherwise.
     */
    public boolean addDrivable(String id, Drivable object){
        if (!drivable_map.containsKey(id)) {
            drivable_map.put(id, object);
            return true;
        }
        return false;
    }




    /** TODO: Write a method named hasFasterThan that takes an int (a speed)
     *       and returns true iff there is at least one item in drivable_map
     *       that has a maxSpeed >= the speed given.
     * You may want to use drivable_map.keys() or drivable_map.values() to
     * iterate through drivable_map.
     * @param speed a given speed
     *
     * @return True if there is any Drivable object that has a higher speed than given
     *         speed, and False otherwise.
     */
    public boolean hasFasterThan(int speed){
        for (String key: drivable_map.keySet()){
            if (drivable_map.get(key).getMaxSpeed() >= speed){
                return true;
            }
        }
        return false;
    }





    /** TODO: Write a method named getTradable that takes no arguments and
     *       returns a List containing all of the Tradable items in
     *       drivable_map.
     *
     * @return a list of Tradable objects.
     */
    public List<Tradable> getTradable(){
        List<Tradable> tradable = new ArrayList<>();
        for (String key: drivable_map.keySet()) {
            if (drivable_map.get(key) instanceof Tradable) {
                Tradable alias = (Tradable) drivable_map.get(key);
                tradable.add(alias);
            }
        }
        return tradable;
    }

    
}
