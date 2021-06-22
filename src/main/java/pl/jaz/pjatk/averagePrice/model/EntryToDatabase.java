package pl.jaz.pjatk.averagePrice.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Entity
public class EntryToDatabase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Number ID", required = true, dataType = "Long")
    private Long id;
    @ApiModelProperty(notes = "Currency name", required = true, dataType = "String")
    private String currency;
    @ApiModelProperty(notes = "Number of days", required = true, dataType = "Integer")
    private Integer numberOfDays;
    @ApiModelProperty(notes = "Average prise from number of days", required = true, dataType = "Double")
    private Double averagePrice;
    @ApiModelProperty(notes = "Date and hour when average price was taken", required = true, dataType = "String")
    private final String createdDate = createDate();

    public EntryToDatabase() {
    }

    public EntryToDatabase(String currency, Integer numberOfDays, Double averagePrice) {
        this.currency = currency;
        this.numberOfDays = numberOfDays;
        this.averagePrice = averagePrice;
    }

    private String createDate() {
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy.mm.dd HH");
        return dateFormat.format(date);
    }

    public Long getId() {
        return id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(Integer numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public Double getAveragePrice() {
        return averagePrice;
    }

    public void setAveragePrice(Double averagePrice) {
        this.averagePrice = averagePrice;
    }

    public String getCreatedDate() {
        return createdDate;
    }
}
