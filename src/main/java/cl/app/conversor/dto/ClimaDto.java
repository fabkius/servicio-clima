package cl.app.conversor.dto;

public class ClimaDto {

    String dia;
    String tempMinima;
    String tempMaxima;
    String medida;

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getTempMinima() {
        return tempMinima;
    }

    public void setTempMinima(String tempMinima) {
        this.tempMinima = tempMinima;
    }

    public String getTempMaxima() {
        return tempMaxima;
    }

    public void setTempMaxima(String tempMaxima) {
        this.tempMaxima = tempMaxima;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }
}
