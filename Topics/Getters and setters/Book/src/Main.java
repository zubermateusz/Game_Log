class Book {

    private String title;
    private int yearOfPublishing;
    private String[] authors;

    public String getTitle() {
        return title;
    }

    public int getYearOfPublishing() {
        return yearOfPublishing;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setTitle(String title) {
        if (title != null) {
            this.title = title;
        }
    }

    public void setYearOfPublishing(int yearOfPublishing) {
        if (yearOfPublishing > 0) {
            this.yearOfPublishing = yearOfPublishing;
        }
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }
}