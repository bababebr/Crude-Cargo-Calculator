package units;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = Api.class)
public class ApiTest {

    @Test
    public void fromApi() {
        Api a = Api.fromApi(33.5);
        assertEquals(0.8571, a.getDensVac(), .1);
    }

    @Test
    public void fromDens() {
        Api a = Api.formDens(0.8571);
        assertEquals(33.5, a.getApi(), .1);
    }

}
