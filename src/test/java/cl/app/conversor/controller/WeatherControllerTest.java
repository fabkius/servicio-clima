package cl.app.conversor.controller;

import cl.app.conversor.dto.DetalleClimaDto;
import cl.app.conversor.fixtures.Fixtures;
import cl.app.conversor.service.WeatherServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;

@RunWith(SpringRunner.class)
public class WeatherControllerTest {

    @Mock
    private WeatherServiceImpl weatherService;

    @InjectMocks
    private WeatherController weatherController;

    @Test
    public void deberiaRetornarClimaOK() throws Exception {

        Mockito.when(weatherService.obtieneClima(any(String.class), any(String.class), any(String.class))).thenReturn(Fixtures.RESPUESTA_WEATHER());

        DetalleClimaDto respuesta = weatherController.obtenerClima("Chile","C", "1");

        Assert.assertThat(respuesta.getPronosticos().get(0).getDia(),is("2018-09-01"));
        Assert.assertThat(respuesta.getPronosticos().get(0).getMedida(),is("Celsius"));
        Assert.assertThat(respuesta.getPronosticos().get(0).getTempMaxima(),is("15.5"));
        Assert.assertThat(respuesta.getPronosticos().get(0).getTempMinima(),is("6.8"));

    }

}
