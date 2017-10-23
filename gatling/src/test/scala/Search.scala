import io.gatling.core.Predef._
import io.gatling.http.Predef._

object Search {

  val feeder = Array(
    Map("searchCriterion" -> "Macbook", "bar" -> "bar1"),
    Map("searchCriterion" -> "Asus", "bar" -> "bar2"),
    Map("searchCriterion" -> "Dell", "bar" -> "bar3")).random

  val search = repeat(5, "n") {
    feed(feeder)
      .exec(http("search ${n}")
        .get("/computers?f=${searchCriterion}"))
      .pause(2)
  }
  //    .exec(http("Select")
  //      .get("/computers/6"))
  //    .pause(3)
}