package com.restful.booker.restfulbookerinfo;

import com.restful.booker.constants.EndPoints;
import com.restful.booker.restfulbookersteps.PingSteps;
import com.restful.booker.testbase.PingTestBase;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(SerenityRunner.class)
public class PingGetTest extends PingTestBase {

    @Steps
    PingSteps pingSteps;

    @Title("This will get the healthCheck")
    @Test
    public void test001() {
        pingSteps.gettingTheHealthCheckDetails()
                .statusCode(201);
    }
}
