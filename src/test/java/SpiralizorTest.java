import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SpiralizorTest {

    @Test
    void spiralizeTest() throws InterruptedException {
        assertArrayEquals(
                new int[][] {
                        { 1, 1, 1, 1, 1 },
                        { 0, 0, 0, 0, 1 },
                        { 1, 1, 1, 0, 1 },
                        { 1, 0, 0, 0, 1 },
                        { 1, 1, 1, 1, 1 }
                },
                Spiralizor.spiralize(5));

        assertArrayEquals(
                new int[][] {
                        { 1, 1, 1, 1, 1, 1, 1, 1 },
                        { 0, 0, 0, 0, 0, 0, 0, 1 },
                        { 1, 1, 1, 1, 1, 1, 0, 1 },
                        { 1, 0, 0, 0, 0, 1, 0, 1 },
                        { 1, 0, 1, 0, 0, 1, 0, 1 },
                        { 1, 0, 1, 1, 1, 1, 0, 1 },
                        { 1, 0, 0, 0, 0, 0, 0, 1 },
                        { 1, 1, 1, 1, 1, 1, 1, 1 },
                },
                Spiralizor.spiralize(8));
    }

}