package cl.app.conversor.service;

import cl.app.conversor.client.WeatherClientImpl;
import cl.app.conversor.dto.DetalleClimaDto;
import cl.app.conversor.exception.ServiceException;
import cl.app.conversor.fixtures.Fixtures;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;
import java.io.IOException;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isNotNull;
import static org.mockito.ArgumentMatchers.notNull;

@RunWith(SpringRunner.class)
public class WeatherServiceImplTest {

    @Mock
    private WeatherClientImpl weatherClient;

    @InjectMocks
    private WeatherServiceImpl weatherService;

    @Test
    public void deberiaRetornarClimaServiceOK() throws IOException {
        Mockito.when(weatherClient.obtieneClima(any(String.class), any(String.class))).thenReturn(Fixtures.RESPUESTA_WEATHER_CLIENT());
        DetalleClimaDto respuesta = weatherService.obtieneClima("Chile", "1", "C");
        Assert.assertThat(respuesta.getPronosticos().get(0).getDia(),is("2018-09-01"));
        Assert.assertThat(respuesta.getPronosticos().get(0).getTempMinima(),is("5.5"));
        Assert.assertThat(respuesta.getPronosticos().get(0).getTempMaxima(),is("15.5"));
        Assert.assertThat(respuesta.getPronosticos().get(0).getMedida(),is("Celsius"));
    }

    @Test(expected = ServiceException.class)
    public void deberiaRetornarClimaServiceFail() throws IOException {
        Mockito.when(weatherClient.obtieneClima(any(String.class), any(String.class))).thenReturn(null);
         weatherService.obtieneClima("Chile", "1", "C");
    }
}
