package cl.app.conversor.service;

import cl.app.conversor.dto.DetalleClimaDto;

public interface WeatherService {

    DetalleClimaDto obtieneClima(String idCity, String days, String units);
}
