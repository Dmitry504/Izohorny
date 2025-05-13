package org.example;

public class IsoCalc {

    private double temperature; // Кельвин
    private double volume; // м^3
    private double pressure; // Паскаль
    private double mass; // кг
    private double molarMass; // кг/моль

    public double round(double value, int places) {
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    public IsoCalc(double temperature, double volume, double pressure, double mass, double molarMass) {
        this.temperature = temperature + Constants.T_conv; // Цельсии в Кельвины для рассчетов
        this.volume = round((volume / 1000), 8); // Литры в метры кубические
        this.pressure = round((pressure * 1000), 8); // кПа в Па
        this.mass = mass;
        this.molarMass = molarMass;
    }

    public void heatGas(double deltaT) {
        // Нагрев газа при изохорном процессе
        this.temperature += deltaT;
        this.temperature = round(this.temperature, 5);
        this.pressure = round((this.mass * Constants.R * this.temperature) / (this.volume * this.molarMass), 5);
    }

    public double getTemperature() {
        return round(this.temperature - Constants.T_conv, 5); // Обратно в Цельсии для отображения
    }

    public double getPressure() {
        return round((this.pressure / 1000), 5); // Перевод обратно в кПа
    }
}

