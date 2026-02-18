class CartItem {
    String itemName;
    double price;
    int quantity;
    void addItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity += quantity;
        System.out.println("Item added to cart.");
    }
    void removeItem(int quantity) {
        if (quantity <= this.quantity) {
            this.quantity -= quantity;
            System.out.println("Item removed from cart.");
        } else {
            System.out.println("Not enough quantity to remove.");
        }
    }
    void displayTotalCost() {
        double total = price * quantity;
        System.out.println("Item: " + itemName);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Cost: " + total);
    }
    public static void main(String[] args) {
        CartItem c1 = new CartItem();
        c1.addItem("Headphones", 1500, 2);
        c1.displayTotalCost();
        c1.removeItem(1);
        c1.displayTotalCost();
    }
}
