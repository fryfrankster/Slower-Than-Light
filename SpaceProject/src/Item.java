public class Item {
 
	/** The name of the item */
    private String name;
    
    /** The price of the item */
    private int price;
    
    /** Whether the Item is a food item or medical item */
    private String type;
    
    /** A description of the item */
    private String description;
    
    /**The amount of health a med item restores and hunger the food item restores */
    private int benefit;
   
    /**
     * @return the item's name
     */
    public String getName() {
        return name;
    }
   
    /**
     * @return the price of the item
     */
    public int getPrice() {
        return price;
    }
   
    /**
     * @return the item's description
     */
    public String getDescription() {
        return description;
    }
    
    /**
     * @return The amount of health a med item restores and hunger the food item restores
     */
    public int getBenefit() {
    	return benefit;
    }
    
    /** Returns the items name, description, benefit and price */
    public String getInfo() {
    	return "Item " + name + ": " + description + ": +" + benefit + ": $" + price;
    }
   
    /** 
     * 
     * @param String itemName The name of the item 
     * @param int itemPrice The price of the item 
     * @param int itemBenefit The amount of health a med item restores and hunger the food item restores
     * @param String itemDescription A description of the item
     * @param String itemType  Whether the Item is a food item or medical item
     */
    public Item(String itemName, int itemPrice, int itemBenefit, String itemDescription, String itemType) {
    	benefit = itemBenefit;
        name = itemName;
        type = itemType;
        price = itemPrice;
        description = itemDescription;
       
    }
    
    /**
     * Returns the items type which can be either a FoodItem or a MedicalItem
     * @return the type of the item
     */
    public String getType() {
    	return type;
    }
    
   
   
}
