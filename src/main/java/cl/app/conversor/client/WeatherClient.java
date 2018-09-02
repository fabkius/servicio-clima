package cl.app.conversor.client;

import cl.app.conversor.dto.WeatherResponseDto;

public interface WeatherClient {
    WeatherResponseDto obtieneClima(String idCity, String days);
}
