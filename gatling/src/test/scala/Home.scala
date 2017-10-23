import io.gatling.core.Predef._
import io.gatling.http.Predef._

object Home {

  val home = exec(http("home")
    .get("/"))
    .pause(5)
}