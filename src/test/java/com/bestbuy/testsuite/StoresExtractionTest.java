package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

public class StoresExtractionTest {
    /**1. Extract the limit
     2. Extract the total
     3. Extract the name of 5th store
     4. Extract the names of all the store
     5. Extract the storeId of all the store
     6. Print the size of the data list
     7. Get all the value of the store where store name = St Cloud
     8. Get the address of the store where store name = Rochester
     9. Get all the services of 8th store
     10. Get storeservices of the store where service name = Windows Store
     11. Get all the storeId of all the store
     12. Get id of all the store
     13. Find the store names Where state = ND
     14. Find the Total number of services for the store where store name = Rochester
     15. Find the createdAt for all services whose name = “Windows Store”
     16. Find the name of all services Where store name = “Fargo”
     17. Find the zip of all the store
     18. Find the zip of store name = Roseville
     19. Find the storeservices details of the service name = Magnolia Home Theater
     20. Find the lat of all the stores*/

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

//    1. Extract the limit
    @Test
    public void limit(){
        int limit=response.extract().path("limit");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");
    }

//     2. Extract the total
    @Test
    public void total(){
        int total=response.extract().path("total");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value  is : " + total);
        System.out.println("------------------End of Test---------------------------");
    }

//     3. Extract the name of 5th store
    @Test
        public void nameFifthStore() {
        String nameFifth = response.extract().path("data[4].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value  is : " + nameFifth);
        System.out.println("------------------End of Test---------------------------");
    }

//     4. Extract the names of all the store
    @Test
    public void namesOfStores(){
        List<String> storeNames=response.extract().path("data.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The sore names is : " + storeNames);
        System.out.println("------------------End of Test---------------------------");
    }
//     5. Extract the storeId of all the store
    @Test
    public void storeIds(){
        List<Integer> storeIds=response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of ids : " + storeIds);
        System.out.println("------------------End of Test---------------------------");
    }


//     6. Print the size of the data list
    @Test
    public void dataSize(){
        List<Integer> dataSize=response.extract().path("data");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value is : " + dataSize.size());
        System.out.println("------------------End of Test---------------------------");
    }
// 7. Get all the value of the store where store name = St Cloud
@Test
public void storeStCloud(){
    List<HashMap<String,?>> storesStCloud =response.extract().path("data.findAll{it.name=='St Cloud'}");
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value is : " + storesStCloud);
    System.out.println("------------------End of Test---------------------------");
}

//     8. Get the address of the store where store name = Rochester
    @Test
        public void storeRochester() {
        List<?> storeRochester = response.extract().path("data.findAll{it.name=='Rochester'}.address");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value is : " + storeRochester);
        System.out.println("------------------End of Test---------------------------");
    }
//     9. Get all the services of 8th store
    @Test
    public void servicesOf8th(){
        List<HashMap<String,?>> servicesOf8th =response.extract().path("data[8].services");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value is : " + servicesOf8th);
        System.out.println("------------------End of Test---------------------------");
    }

//     10. Get storeservices of the store where service name = Windows Store
        @Test
        public void windowsStore(){
    List<HashMap<String,?>>  windowsStore=response.extract().path("data.findAll{it.name=='Windows Store'}");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value is : " + windowsStore);
        System.out.println("------------------End of Test---------------------------");
}
//  11. Get all the storeId of all the store
    @Test
    public void storesIds(){
        List<Integer> storeIds=response.extract().path(("data.id"));
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value is : " + storeIds);
        System.out.println("------------------End of Test---------------------------");
    }

//     12. Get id of all the store
    @Test
    public void allStoresId(){
        List<Integer> id=response.extract().path(("data.id"));
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value is : " + id);
        System.out.println("------------------End of Test---------------------------");
    }

//     13. Find the store names Where state = ND
@Test
public void StoreND(){
    List<String> storeND=response.extract().path(("data.findAll{it.state=='ND'}.name"));
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value is : " + storeND);
    System.out.println("------------------End of Test---------------------------");
}

//     14. Find the Total number of services for the store where store name = Rochester
@Test
public void storeServicesRochester() {
    List<Integer> numberOfServices = response.extract().path("data[8].services");
    numberOfServices.size();
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The number of services for the store where store name Rochester are : " + numberOfServices.size());
    System.out.println("------------------End of Test---------------------------");
}

//     15. Find the createdAt for all services whose name = “Windows Store”
@Test
public void servicesAtWindowStore(){
    List<?> servicesAtWindowStore=response.extract().path(("data.findAll{it.name=='Windows Store'}.createAt"));
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value is : " + servicesAtWindowStore);
    System.out.println("------------------End of Test---------------------------");
}

//     16. Find the name of all services Where store name = “Fargo”
@Test
public void servicesAtFargoStore(){
    List<HashMap<String,?>> servicesAtFargoStore=response.extract().path(("data.findAll{it.name=='Fargo'}"));
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value is : " + servicesAtFargoStore);
    System.out.println("------------------End of Test---------------------------");
}

//     17. Find the zip of all the store
@Test
public void zipOfAllStore(){
    List<Integer> zipOfAllStore=response.extract().path(("data.zip"));
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value is : " + zipOfAllStore);
    System.out.println("------------------End of Test---------------------------");
}

//     18. Find the zip of store name = Roseville
@Test
public void zipOfStoreRoseville(){
    List<Integer> zipOfStoreRoseville=response.extract().path(("data.findAll{it.name=='Roseville'}.zip"));
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value is : " + zipOfStoreRoseville);
    System.out.println("------------------End of Test---------------------------");
}

//     19. Find the storeservices details of the service name = Magnolia Home Theater
@Test
public void storeServiceMagnolia(){
    List<?> storeServiceMagnolia=response.extract().path(("data.findAll{it.service.name=='Magnolia Home Theater'}.storeservices"));
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value is : " + storeServiceMagnolia);
    System.out.println("------------------End of Test---------------------------");
}

//     20. Find the lat of all the stores
@Test
public void latOfAllStores(){
    List<Integer> latOfAllStores=response.extract().path(("data.lat"));
    System.out.println("------------------StartingTest---------------------------");
    System.out.println("The value is : " + latOfAllStores);
    System.out.println("------------------End of Test---------------------------");
}

}
