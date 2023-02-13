
package entity;

public class Review {

    public Review(String comment, int rating) {
        this.comment = comment;
        this.rating = rating;
    }


    String comment;
    int rating;


    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return this.rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

   
}
