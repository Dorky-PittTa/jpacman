package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test suite to confirm that {@link Unit}s correctly (de)occupy squares.
 *
 * @author Jeroen Roosen 
 *
 */
class OccupantTest {

    /**
     * The unit under test.
     */
    private Unit unit;

    // sample square
    private Square sqr1;
    private Square sqr2;


    /**
     * Resets the unit under test.
     */
    @BeforeEach
    void setUp() {
        unit = new BasicUnit();
        sqr1 = new BasicSquare();
        sqr2 = new BasicSquare();
    }

    /**
     * Asserts that a unit has no square to start with.
     */
    @Test
    void noStartSquare() {
        // Removed the placeholder:
        assertThat(unit.hasSquare()).isFalse(); //No square
    }

    /**
     * Tests that the unit indeed has the target square as its base after
     * occupation.
     */
    @Test
    void testOccupy() {
        // Removed the placeholder:
        unit.occupy(sqr1);
        assertThat(unit.getSquare()).isEqualTo(sqr1); // check for sqr1
        assertThat(sqr1.getOccupants()).contains(unit); // check unit in sqr1
    }

    /**
     * Test that the unit indeed has the target square as its base after
     * double occupation.
     */
    @Test
    void testReoccupy() {
        // Removed the placeholder:
        unit.occupy(sqr1);
        unit.occupy(sqr2);
        assertThat(unit.getSquare()).isEqualTo(sqr2); // check for sqr2
        assertThat(sqr2.getOccupants()).contains(unit); // check unit in sqr2
        assertThat(sqr1.getOccupants()).doesNotContain(unit); // check unit not in sqr1
    }
}
