package j8interface;

import java.util.Arrays;

public interface RegularPolygon {
    int getNumSides();
    int getSideLength();

    static int totalSides(RegularPolygon[] regularPolygons) {
        return Arrays.asList(regularPolygons)
                .stream()
                .mapToInt(RegularPolygon::getNumSides)
                .sum();
    }

    default int getPerimeter() {
        return getNumSides() * getSideLength();
    }

    default double getInteriorAngle() {
        double n = getNumSides();
        return (n - 2.0) * Math.PI / n;
    }
}
