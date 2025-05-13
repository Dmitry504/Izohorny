package org.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
public class IsohornyController {

    @GetMapping("/")
    public String home(Model model) {
        return "isohorny";
    }
    @PostMapping("/")
    @ResponseBody
    public Map<String, Object> IsoCalc(
            @RequestParam double temperature,
            @RequestParam double volume,
            @RequestParam double pressure,
            @RequestParam double massSubstance,
            @RequestParam double molarMass,
            @RequestParam double simTime
            ) {

        // Создаем экземпляр компонента
        IsoCalc gas = new IsoCalc(temperature, volume, pressure, massSubstance, molarMass);
        gas.heatGas(simTime);

        // Возвращаем результат в формате JSON
        Map<String, Object> response = new HashMap<>();
        double newtemp = gas.getTemperature();
        double newpress = gas.getPressure();
        log.info("#яжив");
        log.info("Temperature: {}, Pressure: {}, Volume: {}", newtemp, newpress, volume);
        response.put("gasTemp", newtemp);
        response.put("gasPressure", newpress);

        return response;
    }

}
