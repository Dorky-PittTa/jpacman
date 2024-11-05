package nl.tudelft.jpacman.board;

import nl.tudelft.jpacman.sprite.PacManSprites;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions;
import static org.mockito.Mockito;

// Try generate a board
class BoardFactoryTest {

    private BoardFactory boardFactory;
    // Set up mock
    @BeforeEach
    void setUp() {
        PacManSprites spriteStore = mock(PacManSprites.class);
        boardFactory = new BoardFactory(spriteStore);
    }
    // create a normal board
    @Test
    void createBoardCreatesConnectedSquares() {
        //simple 2x2 grid of squares
        Square[][] grid = new Square[2][2];
        grid[0][0] = mock(Square.class);
        grid[0][1] = mock(Square.class);
        grid[1][0] = mock(Square.class);
        grid[1][1] = mock(Square.class);

        Board board = boardFactory.createBoard(grid);

        assertEquals(2, board.getWidth());
        assertEquals(2, board.getHeight());

        // Verify each square is linked to its neighbors
        verify(grid[0][0]).link(grid[0][1], Direction.EAST);
        verify(grid[0][0]).link(grid[1][0], Direction.SOUTH);
        verify(grid[1][1]).link(grid[0][1], Direction.NORTH);
        verify(grid[1][1]).link(grid[1][0], Direction.WEST);
    }
    // create an empty grid
    @Test
    void createBoardWithEmptyGrid() {
        Square[][] grid = new Square[0][0];
        Board board = boardFactory.createBoard(grid);

        assertEquals(0, board.getWidth());
        assertEquals(0, board.getHeight());
    }
    // test null board
    @Test
    void createBoardWithNullGridThrowsAssertionError() {
        assertThrows(AssertionError.class, () -> boardFactory.createBoard(null));
    }
}
