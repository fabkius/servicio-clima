package cl.app.conversor.dto;

public class WeatherResponseDto {

    private ForecastDto forecast;

    private LocationDto location;

    private CurrentDto current;

    public ForecastDto getForecast ()
    {
        return forecast;
    }

    public void setForecast (ForecastDto forecast)
    {
        this.forecast = forecast;
    }

    public LocationDto getLocation ()
    {
        return location;
    }

    public void setLocation (LocationDto location)
    {
        this.location = location;
    }

    public CurrentDto getCurrent ()
    {
        return current;
    }

    public void setCurrent (CurrentDto current)
    {
        this.current = current;
    }

    @Override
    public String toString() {
        return "WeatherResponseDto{" +
                "forecast=" + forecast +
                ", location=" + location +
                ", current=" + current +
                '}';
    }
}
