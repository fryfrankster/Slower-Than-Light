public class FoodItem extends Item {
 
	/**
	 * 
	 * @param String itemName The name of the item
	 * @param int itemPrice The price of the item
	 * @param int itemBenefit The health or hunger the item gives when used
	 * @param String itemDescription a description of the item
	 */
    public FoodItem(String itemName, int itemPrice, int itemBenefit, String itemDescription) {
        super(itemName, itemPrice, itemBenefit, itemDescription, "food");
    }
   
}