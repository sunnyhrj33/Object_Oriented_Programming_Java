public class LibraryItem {
    private String title;
    private String author;
    private int year;
    LibraryItemType itemType;
    boolean isBorrowed;

    public LibraryItem(String title, String author, int year,LibraryItemType itemType) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.itemType = itemType;

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public LibraryItemType getItemType() {
        return itemType;
    }

    public void setItemType(LibraryItemType itemType) {
        this.itemType = itemType;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }
    public boolean equals(LibraryItem lib){
        if(this.title.equalsIgnoreCase(lib.getTitle()) &&
                this.author.equalsIgnoreCase(lib.getAuthor()) &&
                this.year==lib.getYear() &&
                this.isBorrowed==lib.isBorrowed() &&
                this.itemType==lib.getItemType()){
            return true;
        }
        else{
            return false;
        }
    }
    @Override
    public String toString(){
        return String.format("%s,%s,%d,%s,%s",title,author,year,isBorrowed,itemType);
    }
    }


