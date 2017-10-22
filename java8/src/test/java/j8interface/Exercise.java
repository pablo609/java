package j8interface;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Exercise {
    @Test
    public void totalSides() {
        Square square1 = new Square(5);
        Square square2 = new Square(6);

        assertThat(RegularPolygon.totalSides(new Square[]{square1, square2}))
                .isEqualTo(8);
    }

    @Test
    public void getPerimeter() {
        EquilateralTriangle triangle = new EquilateralTriangle(5);

        assertThat(triangle.getPerimeter()).isEqualTo(15);
    }
}
