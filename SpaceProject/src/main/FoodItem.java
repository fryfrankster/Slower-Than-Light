package main;
/**
 * Subclass of type Item, used to store food. Has a name, price, description, hunger increase(benefit) and type
 */
public class FoodItem extends Item {
 
	/**
	 * 
	 * @param itemName The name of the item
	 * @param itemPrice The price of the item
	 * @param itemBenefit The health or hunger the item gives when used
	 * @param itemDescription a description of the item
	 */
    public FoodItem(String itemName, int itemPrice, int itemBenefit, String itemDescription) {
        super(itemName, itemPrice, itemBenefit, itemDescription, "food");
    }
   
}