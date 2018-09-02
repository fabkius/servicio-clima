package cl.app.conversor.controller;

import cl.app.conversor.dto.DetalleClimaDto;
import org.springframework.web.bind.annotation.*;
import cl.app.conversor.service.WeatherService;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.IOException;

@RestController
@RequestMapping(value="/api")
public class WeatherController {

    private WeatherService weatherService;

    public WeatherController(WeatherService weatherService){
        this.weatherService=weatherService;
    }


    @RequestMapping(value="/weather",method = RequestMethod.GET)
    public DetalleClimaDto obtenerClima(@RequestParam("idCity") String idCity,
                                        @RequestParam("units") String units,
                                        @RequestParam("days") String days) throws IOException {
        return weatherService.obtieneClima(idCity,days,units);
    }
}
