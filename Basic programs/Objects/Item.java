class Item {
    int itemCode;
    String itemName;
    double price;
    Item(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }
    void displayDetails() {
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Price: " + price);
    }
    double calculateTotalCost(int quantity) {
        return price * quantity;
    }
    public static void main(String[] args) {
        Item i1 = new Item(101, "Notebook", 50);
        i1.displayDetails();
        int quantity = 4;
        System.out.println("Total Cost for " + quantity + " items: " + i1.calculateTotalCost(quantity));
    }
}
