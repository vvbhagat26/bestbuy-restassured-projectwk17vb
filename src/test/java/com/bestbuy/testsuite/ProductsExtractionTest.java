package com.bestbuy.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ProductsExtractionTest {
    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 3030;
        response = given()
                .when()
                .get("/products")
                .then().statusCode(200);
    }

    //21. Extract the limit
    @Test
    public void limit(){
        int limit = response.extract().path("limit");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of limit is : " + limit);
        System.out.println("------------------End of Test---------------------------");

    }

    //22. Extract the total
    @Test
    public void total() {
        int toTal = response.extract().path("total");

        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The value of total is : " + toTal);
        System.out.println("------------------End of Test---------------------------");
    }

    //23. Extract the name of 5th product
    @Test
    public void nameOf5thProduct(){
        String name5th = response.extract().path("data[4].name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The result is : " + name5th);
        System.out.println("------------------End of Test---------------------------");
    }

    //24. Extract the names of all the products
    @Test
    public void namesOfAllProducts(){
        List<String> namesAll = response.extract().path("data.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The result is : " + namesAll);
        System.out.println("------------------End of Test---------------------------");
    }

    //25. Extract the productId of all the products
    @Test
    public void IdsOfAllProducts(){
        List<Integer> IdsAll = response.extract().path("data.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The result is : " + IdsAll);
        System.out.println("------------------End of Test---------------------------");
    }

    //26. Print the size of the data list
    @Test
    public void sizeOfDataList(){
        List<Integer> sizeOfDataList = response.extract().path("data");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The result is : " + sizeOfDataList.size());
        System.out.println("------------------End of Test---------------------------");
    }

    //27. Get all the value of the product where product name = Energizer - MAX Batteries AA (4-
    //Pack)
    @Test
    public void priceOfEnergizer9(){
        List<HashMap<String,?>> values=response.extract().path("data.findAll{it.name=='Energizer - MAX Batteries AA (4-Pack)'} ");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The result is : " + values);
        System.out.println("------------------End of Test---------------------------");
    }

    //28. Get the model of the product where product name = Energizer - N Cell E90 Batteries (2-
    //Pack)
    @Test
    public void modelOfEnergizerproduct(){
        List<String> modelName = response.extract().path("data.findAll{it.name == 'Energizer - N Cell E90 Batteries (2-Pack)'}.model");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("print model of Product Of Energizer - N Cell E90 Batteries (2-Pack): " + modelName.get(0));
        System.out.println("------------------End of Test---------------------------");
    }

    //29. Get all the categories of 8th products
    @Test
    public void categoriesOf8th(){
        List<HashMap<String,?>> categories = response.extract().path("data[7].categories ");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The result is : " + categories);
        System.out.println("------------------End of Test---------------------------");
    }

    //30. Get categories of the store where product id = 150115
    @Test
    public void categoriesofStore(){
        List<HashMap<String,?>> categoriesofStore=response.extract().path("data.findAll{it.id=='150115'}.categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The result is : " + categoriesofStore);
        System.out.println("------------------End of Test---------------------------");
    }

    //31. Get all the descriptions of all the products
    @Test
    public void descriptionOfAllproducts(){
        List<HashMap<String,?>> descriptionOfAllproducts=response.extract().path("data.description");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The result is : " + descriptionOfAllproducts);
        System.out.println("------------------End of Test---------------------------");
    }

    //32. Get id of all the all categories of all the products
    @Test
    public void getIdofAllCategories() {
        List<Integer> IdAll = response.extract().path("data.categories*.id");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The result is : " + IdAll);
        System.out.println("------------------End of Test---------------------------");
    }

    //33. Find the product names Where type = HardGood
    @Test
    public void productNameIsHardGood() {
        List<String>  productNameIsHardGood= response.extract().path("data.findAll{it.type=='HardGood'}.name");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The result is : " + productNameIsHardGood);
        System.out.println("------------------End of Test---------------------------");
    }

    //34. Find the Total number of categories for the product where product name = Duracell - AA
    @Test
    public void productNameIsDuracellCategories() {
        List<String>  productNameIsDuracellCategories= response.extract().path("data.findAll{it.name=='Duracell - AA 1.5V CopperTop Batteries (4-Pack)'}.categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The result is : " + productNameIsDuracellCategories);
        System.out.println("------------------End of Test---------------------------");
    }

    //35. Find the createdAt for all products whose price < 5.49
    @Test
    public void createdAtproducts() {
        List<String>  createdAtproducts= response.extract().path("data.findAll{it.price<5.49}.createdAt");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The result is : " + createdAtproducts);
        System.out.println("------------------End of Test---------------------------");
    }

    //36. Find the name of all categories Where product name = “Energizer - MAX Batteries AA (4-
    //Pack)”
    @Test
    public void namesOfAllCategoriesOfproduct() {
        List<String>  namesOfAllCategoriesOfproduct= response.extract().path("data.findAll{it.name='Energizer - MAX Batteries AA (4-Pack)'}.categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The result is : " + namesOfAllCategoriesOfproduct);
        System.out.println("------------------End of Test---------------------------");
    }

    //37. Find the manufacturer of all the products
    @Test
    public void namesOfAllManufacturers(){
        List<String> namesOfAllManufacturers=response.extract().path("data.manufacturer");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The result is : " + namesOfAllManufacturers);
        System.out.println("------------------End of Test---------------------------");
    }

    //38. Find the image of products whose manufacturer is = Energizer
    @Test
    public void ImagesOfManufacturerEnergizer(){
        List<String> ImagesOfManufacturerEnergizer=response.extract().path("data.findAll{it.manufacturer=='Energizer'}.image");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The result is : " + ImagesOfManufacturerEnergizer);
        System.out.println("------------------End of Test---------------------------");
    }

    //39. Find the createdAt for all categories products whose price > 5.99
    @Test
    public void createdOfAllCategory(){
        List<String> createdOfAllCategory=response.extract().path("data.findAll{it.price}.categories");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The result is : " + createdOfAllCategory);
        System.out.println("------------------End of Test---------------------------");
    }

    //40. Find the uri of all the products
    @Test
    public void urls(){
        List<String> urls=response.extract().path("data.url");
        System.out.println("------------------StartingTest---------------------------");
        System.out.println("The result is : " +urls);
        System.out.println("------------------End of Test---------------------------");
    }

}
