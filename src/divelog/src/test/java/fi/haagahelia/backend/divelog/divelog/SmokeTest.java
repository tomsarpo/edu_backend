package fi.haagahelia.backend.divelog.divelog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import fi.haagahelia.backend.divelog.web.HomeController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTest {

    @Autowired
    private HomeController hcontroller;

    @Test
    public void contexLoads() throws Exception {
        assertThat(hcontroller).isNotNull();
    }
}

