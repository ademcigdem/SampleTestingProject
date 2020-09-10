package com.costa.step_definitions;
import com.costa.utilities.*;
import io.cucumber.java.*;
import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import java.util.concurrent.TimeUnit;
import static com.costa.utilities.Utils.*;

public class Hooks {


    @Before
    public void setup(){
        Driver.get().manage().window().maximize();
        Driver.get().get(ConfigurationReader.get("url"));
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot)Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }
        waitFor(2);

        Driver.closeDriver();
    }


}
