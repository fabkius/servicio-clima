package cl.app.conversor.fixtures;

import cl.app.conversor.dto.*;

import java.util.ArrayList;
import java.util.List;

public class Fixtures {

    public static DetalleClimaDto RESPUESTA_WEATHER() {
        DetalleClimaDto detalleClimaDto = new DetalleClimaDto();
        List<ClimaDto> listaClimaDto = new ArrayList<ClimaDto>();
        ClimaDto climaDto = new ClimaDto();

        climaDto.setDia("2018-09-01");
        climaDto.setMedida("Celsius");
        climaDto.setTempMaxima("15.5");
        climaDto.setTempMinima("6.8");

        listaClimaDto.add(climaDto);
        detalleClimaDto.setPronosticos(listaClimaDto);

        return detalleClimaDto;
    }


    public static WeatherResponseDto RESPUESTA_WEATHER_CLIENT() {
        WeatherResponseDto weatherResponseDto = new WeatherResponseDto();
        weatherResponseDto.setCurrent(CREA_CURRENT());
        weatherResponseDto.setForecast(CREA_FORECAST());
        weatherResponseDto.setLocation(CREA_LOCATION());
        return weatherResponseDto;
    }

    private static LocationDto CREA_LOCATION() {
        return new LocationDto();
    }

    private static ForecastDto CREA_FORECAST() {
        ForecastDto forecastDto = new ForecastDto();
        forecastDto.setForecastday(CREA_FORESTDAY());
        return forecastDto;
    }

    private static List<ForecastdayDto> CREA_FORESTDAY() {
        List<ForecastdayDto> listForestDay = new ArrayList<>();
        ForecastdayDto forecastdayDto = new ForecastdayDto();
        forecastdayDto.setDate("2018-09-01");
        forecastdayDto.setDay(CREA_DAY());
        listForestDay.add(forecastdayDto);
        return listForestDay;
    }

    private static DayDto CREA_DAY() {
        DayDto dayDto = new DayDto();
        dayDto.setMaxtemp_c("15.5");
        dayDto.setMintemp_c("5.5");
        return dayDto;
    }

    private static CurrentDto CREA_CURRENT() {
        CurrentDto currentDto = new CurrentDto();
        currentDto.setTemp_c("15.5");
        currentDto.setCloud("1");
        currentDto.setHumidity("2");
        return currentDto;
    }

}
