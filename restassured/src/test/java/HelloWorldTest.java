import static io.restassured.RestAssured.given;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by pawel on 2017-02-15.
 * Based on: https://semaphoreci.com/community/tutorials/testing-rest-endpoints-using-rest-assured
 */
public class HelloWorldTest {
    String baseURL = "http://jsonplaceholder.typicode.com";
    String postsURL = baseURL + "/posts/";
    String userssURL = baseURL + "/users/";

    @Test
    public void testHerokuAppStatusCodes() {
        given().when().get("http://the-internet.herokuapp.com/status_codes/200").then().statusCode(200);

        given().when().get("http://the-internet.herokuapp.com/status_codes/404").then().statusCode(404);

    }

    @Test
    public void testRangeOfValidResources() {
        given().when().get(postsURL + "0").then().statusCode(404);
        given().when().get(postsURL + "1").then().statusCode(200);
        given().when().get(postsURL + "100").then().statusCode(200);
        given().when().get(postsURL + "101").then().statusCode(404);
    }

    @Test
    public void testPostId() {
        Integer id = 3;
        given().when().get(postsURL + id).then().body("id", equalTo(id));
        id = 100;
        given().when().get(postsURL + id).then().body("id", equalTo(id));
    }

    @Test
    public void testUserBody() {
        given().when().get(userssURL + 1).then().
                body("address.street", equalTo("Kulas Light")).
                body("company.name", equalTo("Romaguera-Crona")).
                body("username", equalTo("Bret")).
                statusCode(200);
    }

    @Test
    public void testCreatePostWithMap() {
        Map<String,String> post = new HashMap<>();
        post.put("userId", "1");
        post.put("id", "110");
        post.put("title", "testing post");
        post.put("body", "testing post body");

        given()
                .contentType("application/json")
                .body(post)
        .when().post(postsURL)
        .then().statusCode(201);
    }

    @Test
    public void testCreatePostWithObject1() {
        PostRes postRes = new PostRes(999, 9999, "Title", "Body");

        given().contentType("application/json").body(postRes)
        .when().post(postsURL)
        .then().
                statusCode(201).
                body("title", equalTo("Title"));
    }

    @Test
    public void testCreatePostWithObject2() {
        PostRes postRes = new PostRes(999, 9999, "Title", "Body");

        PostRes postResResponse = given().contentType("application/json").body(postRes)
                .when().post(postsURL).as(PostRes.class);

        assertThat(postRes.getTitle(), equalTo(postResResponse.getTitle()));
    }
}
