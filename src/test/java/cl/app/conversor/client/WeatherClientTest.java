package cl.app.conversor.client;

import cl.app.conversor.dto.WeatherResponseDto;
import cl.app.conversor.exception.ServiceException;
import cl.app.conversor.fixtures.Fixtures;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
public class WeatherClientTest {

    @Value("${weather.token}")
    private String tokenValue;

    @Value("${weather.url}")
    private String urlValue;

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private WeatherClientImpl weatherClient;

    @Test
    public void obtieneClimaClientOK() throws IOException {

        ReflectionTestUtils.setField(weatherClient, "urlValue", "http://api.apixu.com/v1/forecast.json?key=");
        ReflectionTestUtils.setField(weatherClient, "tokenValue", "ead2436f9b5f407d982230314180109");

        Mockito.when(restTemplate.getForObject(
                Mockito.any(String.class),
                Mockito.any(Class.class)
        )).thenReturn(Fixtures.RESPUESTA_WEATHER_CLIENT());

        WeatherResponseDto respuesta = weatherClient.obtieneClima("Chile", "1");

        Assert.assertThat(respuesta.getCurrent().getCloud(),is("1"));
        Assert.assertThat(respuesta.getCurrent().getTemp_c(),is("15.5"));
        Assert.assertThat(respuesta.getCurrent().getHumidity(),is("2"));

    }

    @Test(expected = ServiceException.class)
    public void obtieneClimaClientFail() throws IOException {

        ReflectionTestUtils.setField(weatherClient, "urlValue", "http://api.apixu.com/v1/forecast.json?key=");
        ReflectionTestUtils.setField(weatherClient, "tokenValue", "ead2436f9b5f407d982230314180109");

        Mockito.when(restTemplate.getForObject(
                Mockito.any(String.class),
                Mockito.any(Class.class)
        )).thenThrow(RestClientException.class);

       weatherClient.obtieneClima("Chile", "1");
    }
}
