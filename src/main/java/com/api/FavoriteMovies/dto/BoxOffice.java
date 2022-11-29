package com.api.FavoriteMovies.dto;

public class BoxOffice {
    
    private String budget;
    private String openingWeekendUSA;    
    private String grossUSA;     
    private String cumulativeWorldwideGross;
    
    public String getBudget() {
        return budget;
    }
    public void setBudget(String budget) {
        this.budget = budget;
    }
    public String getOpeningWeekendUSA() {
        return openingWeekendUSA;
    }
    public void setOpeningWeekendUSA(String openingWeekendUSA) {
        this.openingWeekendUSA = openingWeekendUSA;
    }
    public String getGrossUSA() {
        return grossUSA;
    }
    public void setGrossUSA(String grossUSA) {
        this.grossUSA = grossUSA;
    }
    public String getCumulativeWorldwideGross() {
        return cumulativeWorldwideGross;
    }
    public void setCumulativeWorldwideGross(String cumulativeWorldwideGross) {
        this.cumulativeWorldwideGross = cumulativeWorldwideGross;
    }   
    
}
