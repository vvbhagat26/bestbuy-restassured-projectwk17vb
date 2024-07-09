package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class StoresAssertionTest {

    /**1. Verify the if the total is equal to 1561
     2. Verify the if the stores of limit is equal to 10
     3. Check the single ‘Name’ in the Array list (Inver Grove Heights)
     4. Check the multiple ‘Names’ in the ArrayList (Roseville, Burnsville, Maplewood)
     5. Verify the storied=7 inside storeservices of the third store of second services
     6. Check hash map values ‘createdAt’ inside storeservices map where store name = Roseville
     7. Verify the state = MN of forth store
     8. Verify the store name = Rochester of 9th store
     9. Verify the storeId = 11 for the 6th store
     10. Verify the serviceId = 4 for the 7th store of forth service*/

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI="http://localhost";
        RestAssured.port=3030;
        response = RestAssured.given()
                .when()
                .get("/stores")
                .then().statusCode(200);
    }

    //1.total
    @Test
    public void testTotal() {
        response.body("total",equalTo(1561));
    }

    //2.limit
    @Test
    public void testLimit() {
        response.body("limit",equalTo(10));
    }

    //3.name
    @Test
    public void testName(){
        response.body("data.name",hasItem("Inver Grove Heights"));
    }

    //4.multiple names
    @Test
    public void testNames(){
        response.body("data.name",hasItems("Roseville", "Burnsville", "Maplewood"));
    }
    //5.storeid=7
    @Test
    public void testIdcheck(){
        response.body("data[2].services[1].storeservices.storeId",equalTo(7));
    }
    //6.check hashMap
    @Test
    public void hashMapValues(){
        response.body("data[2].name", equalTo("Roseville"));
        response.body("data[2].createdAt", equalTo("2016-11-17T17:57:05.853Z"));
    }
    //7.MN=fourth store
    @Test
    public void MNForthStore(){
        response.body("data[3].state",equalTo("MN"));
    }
    //8.store name = Rochester of 9th store
    @Test
    public void Rochester(){
        response.body("data[8].name",equalTo("Rochester"));
    }
    //9.storeId = 11 for the 6th store
    @Test
    public void storeId6th(){
        response.body("data[5].id",equalTo(11));
    }
    //10.serviceId = 4 for the 7th store
    @Test
    public void serviceId4th(){
        response.body("data[6].services[3].id",equalTo(4));
    }
}
