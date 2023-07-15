package unitsTest;


import com.example.oct.units.Temperature;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = Temperature.class)
public class TemperatureTest {

    @Test
    public void temp() {
        Temperature t = Temperature.fromFahrenheit(60);
        assertEquals(t.getCelsius(), 15.5, .1);
    }

    @Test
    public void tempF() {
        Temperature t = Temperature.fromCelius(15.5);
        assertEquals(59.9, t.getFahrenheit(), .1);
    }

}
