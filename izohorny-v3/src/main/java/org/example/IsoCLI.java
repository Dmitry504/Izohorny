package org.example;

import java.util.Scanner;

public class IsoCLI {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите начальную температуру (°C): ");
        double temperature = scanner.nextDouble();
        System.out.print("Введите объем (л): ");
        double volume = scanner.nextDouble();
        System.out.print("Введите давление (кПа): ");
        double pressure = scanner.nextDouble();
        System.out.print("Введите массу (кг): ");
        double mass = scanner.nextDouble();
        System.out.print("Введите молярную массу (кг/моль): ");
        double molarMass = scanner.nextDouble();
        System.out.print("Введите время симуляции (сек): ");
        double timeToSim = scanner.nextDouble();

        IsoCalc gas = new IsoCalc(temperature, volume, pressure, mass, molarMass);

        System.out.println("Начальная температура: " + gas.getTemperature() + " °C");
        System.out.println("Начальное давление: " + gas.getPressure() + " кПа");

        for (int i = 0; i < 10 * timeToSim; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Выполнение симуляции прекращено");
            }
            gas.heatGas(0.1);
            System.out.println("Текущая температура: " + gas.getTemperature() + " °C");
            System.out.println("Текущее давление: " + gas.getPressure() + " кПа");
        }

        scanner.close();
    }
}
