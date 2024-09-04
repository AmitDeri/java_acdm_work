// Name: Amit Deri; ID: 316443548


package application;

import java.util.Objects;

//constructor for the date as described in the mmn
public class MyDate {
    private int day;
    private int month;
    private int year;

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }


    // equals method for the new date for the mmn
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate that = (MyDate) o;
        return day == that.day && month == that.month && year == that.year;
    }

    // hashCode method for the new date for the mmn
    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }

    // toString method for the new date for the mmn
    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", day, month, year);
    }
}
