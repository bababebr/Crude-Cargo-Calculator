package units;

import org.junit.jupiter.api.Test;
import tables.TablesEnum;
import units.vcf.Vcf54A;
import units.vcf.Vcf6A;

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
        System.out.println(api.getDensVac());
        System.out.println(api.getDensAir());
        assertEquals(vcf54A.getVcf(),0.9238d, 0.0001);
    }

}
