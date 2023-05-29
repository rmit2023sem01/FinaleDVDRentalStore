package com.example.finale;

public class Items {
    protected String id;
    protected String rentType;
    protected String title;
    protected String loanType;
    protected int stock;
    protected int rentFee;
    protected String rentStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getRentFee() {
        return rentFee;
    }

    public void setRentFee(int rentFee) {
        this.rentFee = rentFee;
    }

    public String getRentStatus() {
        return rentStatus;
    }

    public void setRentStatus(String rentStatus) {
        this.rentStatus = rentStatus;
    }
}

class Dvd extends Items {
    private String genre;
}

class MovieRecord extends Items {
    private String genre;
}

class VideoGame extends Items {

}