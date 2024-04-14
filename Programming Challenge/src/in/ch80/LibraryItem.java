package in.ch80;

public class LibraryItem {
    private String itemID;
    private String title;
    private String author;

    public void checkOut(){
        System.out.println("Checkout");
    }

    public void returnItem(){
        System.out.println("Item return");
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
