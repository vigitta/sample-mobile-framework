package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest extends BaseTest {

    @Test(description = "Sample description")
    public void sampleTest() {
        Assert.assertTrue(true);
    }

}