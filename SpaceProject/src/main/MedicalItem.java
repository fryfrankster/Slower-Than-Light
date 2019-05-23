package main;
/**
 * Subclass of type Item, used to store Medicine. Has a name, price, boolean showing if cures space plague, description, health increase(benefit) and type
 */
public class MedicalItem extends Item {
   
	/**A boolean representing whether or not the item cures the space plague */
    private boolean curesSpacePlauge;
 
    /**
	 * 
	 * @param itemName The name of the item
	 * @param itemPrice The price of the item
	 * @param itemBenefit The health or hunger the item gives when used
	 * @param itemDescription a description of the item
	 * @param curesPlague a boolean representing whether or not the item cures the space plague
	 */
    public MedicalItem(String itemName, int itemPrice, Integer itemBenefit, String itemDescription, boolean curesPlague) {
        super(itemName, itemPrice, itemBenefit, itemDescription, "medical");
        curesSpacePlauge = curesPlague;
    }
   
    /**
     * Checks if the item cures the space plague
     * @return a boolean representing if the item cures the space plague.
     */
    public boolean doesCurePlauge() {
        return curesSpacePlauge;
    }

}