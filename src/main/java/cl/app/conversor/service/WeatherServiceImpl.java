package cl.app.conversor.service;

import cl.app.conversor.client.WeatherClient;
import cl.app.conversor.dto.ClimaDto;
import cl.app.conversor.dto.DetalleClimaDto;
import cl.app.conversor.dto.WeatherResponseDto;
import cl.app.conversor.exception.ServiceException;
import cl.app.conversor.util.Utilitario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WeatherServiceImpl implements WeatherService {

    private static final String CELSIUS = "C";
    private static final String CELSIUS_GLOSA = "Celsius";
    private static final String FAHRENHEIT = "F";
    private static final String FAHRENHEIT_GLOSA = "Fahrenheit";

    private WeatherClient weatherClient;

    public WeatherServiceImpl(WeatherClient weatherClient){
        this.weatherClient = weatherClient;
    }

    @Override
    public DetalleClimaDto obtieneClima(String idCity, String days, String units) {
        validaRangoDias(days);
        return convertData(weatherClient.obtieneClima(idCity,days),units);
    }

    private void validaRangoDias(String days) {
        if(!Utilitario.isNumeric(days)){
            throw new ServiceException("valor dias no es correcto");
        }
    }

    private DetalleClimaDto convertData(WeatherResponseDto weatherResponseDto, String units) {
        WeatherResponseDto data = Optional.ofNullable(weatherResponseDto)
                .orElseThrow(() -> new ServiceException("el servicio no está disponible"));

        DetalleClimaDto detalleClimaDto = new DetalleClimaDto();
        List<ClimaDto> listClimaDto = new ArrayList<ClimaDto>();

        weatherResponseDto.getForecast().getForecastday().stream()
                .forEach(d->{

                    ClimaDto climaDto = new ClimaDto();
                    climaDto.setDia(d.getDate());

                    switch (units) {
                        case CELSIUS:
                                climaDto.setTempMaxima(d.getDay().getMaxtemp_c());
                                climaDto.setTempMinima(d.getDay().getMintemp_c());
                                climaDto.setMedida(CELSIUS_GLOSA);
                            break;
                        case FAHRENHEIT:
                                climaDto.setTempMaxima(d.getDay().getMaxtemp_f());
                                climaDto.setTempMinima(d.getDay().getMintemp_f());
                                climaDto.setMedida(FAHRENHEIT_GLOSA);
                            break;
                        default:
                               throw new ServiceException("unidad de medida desconocido");
                    }

                    listClimaDto.add(climaDto);
                });

        detalleClimaDto.setPronosticos(listClimaDto);

        return detalleClimaDto;
    }
}
