package crud.app.model;

import javax.validation.Valid;
import javax.validation.constraints.*;

public class Car {

    private int id;

    @NotEmpty(message = "Model should not be empty")
    @Size(min = 2, max = 15, message = "Name should be between 2 and 15 characters")
    private String model;

    @NotNull
    @Min(value = 1800, message = "Year should be greater then 1800")
    @Max(value = 2022, message = "Year should be smaller then 2022")
    private int year;

    @NotEmpty(message = "Car cant be without color")
    private String color;

    public Car(int id, String model, int year, String color) {
        this.id = id;
        this.model = model;
        this.year = year;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Car() {
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
