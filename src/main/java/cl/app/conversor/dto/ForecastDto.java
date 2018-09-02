package cl.app.conversor.dto;

import java.util.List;

public class ForecastDto {

    private List<ForecastdayDto> forecastday;

    public List<ForecastdayDto> getForecastday () {
        return forecastday;
    }

    public void setForecastday (List<ForecastdayDto> forecastday) {
        this.forecastday = forecastday;
    }

    @Override
    public String toString() {
        return "ForecastDto{" +
                "forecastday=" + forecastday +
                '}';
    }
}
