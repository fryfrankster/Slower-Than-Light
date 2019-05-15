public class MedicalItem extends Item {
   
	/**A boolean representing whether or not the item cures the space plague */
    private boolean curesSpacePlauge;
 
    /**
	 * 
	 * @param String itemName The name of the item
	 * @param int itemPrice The price of the item
	 * @param int itemBenefit The health or hunger the item gives when used
	 * @param String itemDescription a description of the item
	 * @param boolean curesPlague a boolean representing whether or not the item cures the space plague
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