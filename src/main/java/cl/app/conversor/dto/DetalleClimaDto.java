package cl.app.conversor.dto;

import java.util.List;

public class DetalleClimaDto {

    private List<ClimaDto> pronosticos;

    public List<ClimaDto> getPronosticos() {
        return pronosticos;
    }

    public void setPronosticos(List<ClimaDto> pronosticos) {
        this.pronosticos = pronosticos;
    }
}
