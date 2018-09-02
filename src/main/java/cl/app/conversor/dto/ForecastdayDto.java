package cl.app.conversor.dto;

public class ForecastdayDto {

    private AstroDto astro;

    private DayDto day;

    private String date;

    private String date_epoch;

    public AstroDto getAstro () {
        return astro;
    }

    public void setAstro (AstroDto astro) {
        this.astro = astro;
    }

    public DayDto getDay () {
        return day;
    }

    public void setDay (DayDto day) {
        this.day = day;
    }

    public String getDate () {
        return date;
    }

    public void setDate (String date) {
        this.date = date;
    }

    public String getDate_epoch () {
        return date_epoch;
    }

    public void setDate_epoch (String date_epoch) {
        this.date_epoch = date_epoch;
    }

    @Override
    public String toString() {
        return "ForecastdayDto{" +
                "astro=" + astro +
                ", day=" + day +
                ", date='" + date + '\'' +
                ", date_epoch='" + date_epoch + '\'' +
                '}';
    }
}
