package unitsTest;

import com.example.oct.units.api.Api;
import com.example.oct.units.temperature.Temperature;
import com.example.oct.units.vcf.Vcf54A;
import com.example.oct.units.vcf.Vcf6A;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Vcf6A6ATest {

    @Test
    public void vcf6ATest() {
        Api api = Api.fromApi(27.1);
        Temperature temperature = Temperature.fromFahrenheit(112.1);
        Vcf6A vcf6A = new Vcf6A(api, temperature);
        assertEquals(vcf6A.getVcf(),0.9775d, 0.0001);
    }

    @Test
    public void vcf54ATest() {
        Api api = Api.formDens(0.89);
        Temperature temperature = Temperature.fromFahrenheit(112.0);
        Vcf54A vcf54A = new Vcf54A(api, temperature);
        System.out.println(api.getApi());
        System.out.println(temperature.getCelsius());
        System.out.println(vcf54A.getA());
        System.out.println(vcf54A.getB());
        System.out.println(api.getSpecificGravity());
        System.out.println(api.getDensAir());
        assertEquals(vcf54A.getVcf(),0.9238d, 0.0001);
    }

}