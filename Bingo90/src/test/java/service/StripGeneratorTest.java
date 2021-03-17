package service;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class StripGeneratorTest {

    private StripGenerator sut;

    @Before
    public void before() {
        sut = new StripGenerator();
    }

    @Test
    public void eachRowMustHave5PositiveNumbersAnd4Zeroes() {
        // when
        var strip = sut.generateBingoStrip();

        // then
        for (int row = 0; row < 18; row++) {
            var numberOfZeroes = Arrays.stream(strip[row]).filter(value -> value == 0).count();
            var numberOfPositiveValues = Arrays.stream(strip[row]).filter(value -> value != 0).count();
            assertEquals(numberOfZeroes, 4);
            assertEquals(numberOfPositiveValues, 5);
        }
    }

    @Test
    public void eachColumnInATicketMustHaveANumber() {
        // when
        var strip = sut.generateBingoStrip();

        // then
        for (var column = 0; column < 9; column++) {
            for (var ticket = 0; ticket < 7; ticket = ticket + 3) {
                var numberOfZeroes = 0;
                if (strip[ticket][column] == 0) {
                    numberOfZeroes++;
                }
                if (strip[ticket + 1][column] == 0) {
                    numberOfZeroes++;
                }
                if (strip[ticket + 2][column] == 0) {
                    numberOfZeroes++;
                }
                assertTrue(numberOfZeroes < 3);
            }
        }
    }

    @Test
    public void stripMustNotHaveDuplicates() {
        // when
        var strip = sut.generateBingoStrip();

        // then
        for (int box = 1; box < 91; box++) {
            int finalBox = box;
            var count = Arrays.stream(strip).flatMapToInt(Arrays::stream).filter(value -> value == finalBox).count();
            assertEquals(count, 1);
        }
    }

    @Test
    public void firstColumnMustHave1to9() {
        // when
        var strip = sut.generateBingoStrip();

        // then
        List<Integer> values = new ArrayList<>();
        for (int row = 0; row < 18; row++) {
            if (strip[row][0] != 0) {
                values.add(strip[row][0]);
            }
        }
        for (int i = 1; i <= 9; i ++) {
            int finalI = i;
            var count = values.stream().filter(val -> val == finalI).count();
            assertEquals(count, 1);
        }
    }

    @Test
    public void secondColumnMustHave10to19() {
        // when
        var strip = sut.generateBingoStrip();

        // then
        List<Integer> values = new ArrayList<>();
        for (int row = 0; row < 18; row++) {
            if (strip[row][1] != 0) {
                values.add(strip[row][1]);
            }
        }
        for (int i = 10; i <= 19; i ++) {
            int finalI = i;
            var count = values.stream().filter(val -> val == finalI).count();
            assertEquals(count, 1);
        }
    }

    @Test
    public void thirdColumnMustHave20to29() {
        // when
        var strip = sut.generateBingoStrip();

        // then
        List<Integer> values = new ArrayList<>();
        for (int row = 0; row < 18; row++) {
            if (strip[row][2] != 0) {
                values.add(strip[row][2]);
            }
        }
        for (int i = 20; i <= 29; i ++) {
            int finalI = i;
            var count = values.stream().filter(val -> val == finalI).count();
            assertEquals(count, 1);
        }
    }

    @Test
    public void FourthColumnMustHave30to39() {
        // when
        var strip = sut.generateBingoStrip();

        // then
        List<Integer> values = new ArrayList<>();
        for (int row = 0; row < 18; row++) {
            if (strip[row][3] != 0) {
                values.add(strip[row][3]);
            }
        }
        for (int i = 30; i <= 39; i ++) {
            int finalI = i;
            var count = values.stream().filter(val -> val == finalI).count();
            assertEquals(count, 1);
        }
    }

    @Test
    public void FifthColumnMustHave40to49() {
        // when
        var strip = sut.generateBingoStrip();

        // then
        List<Integer> values = new ArrayList<>();
        for (int row = 0; row < 18; row++) {
            if (strip[row][4] != 0) {
                values.add(strip[row][4]);
            }
        }
        for (int i = 40; i <= 49; i ++) {
            int finalI = i;
            var count = values.stream().filter(val -> val == finalI).count();
            assertEquals(count, 1);
        }
    }

    @Test
    public void SixthColumnMustHave50to59() {
        // when
        var strip = sut.generateBingoStrip();

        // then
        List<Integer> values = new ArrayList<>();
        for (int row = 0; row < 18; row++) {
            if (strip[row][5] != 0) {
                values.add(strip[row][5]);
            }
        }
        for (int i = 50; i <= 59; i ++) {
            int finalI = i;
            var count = values.stream().filter(val -> val == finalI).count();
            assertEquals(count, 1);
        }
    }

    @Test
    public void SeventhColumnMustHave60to69() {
        // when
        var strip = sut.generateBingoStrip();

        // then
        List<Integer> values = new ArrayList<>();
        for (int row = 0; row < 18; row++) {
            if (strip[row][6] != 0) {
                values.add(strip[row][6]);
            }
        }
        for (int i = 60; i <= 69; i ++) {
            int finalI = i;
            var count = values.stream().filter(val -> val == finalI).count();
            assertEquals(count, 1);
        }
    }

    @Test
    public void EighthColumnMustHave70to79() {
        // when
        var strip = sut.generateBingoStrip();

        // then
        List<Integer> values = new ArrayList<>();
        for (int row = 0; row < 18; row++) {
            if (strip[row][7] != 0) {
                values.add(strip[row][7]);
            }
        }
        for (int i = 70; i <= 79; i ++) {
            int finalI = i;
            var count = values.stream().filter(val -> val == finalI).count();
            assertEquals(count, 1);
        }
    }

    @Test
    public void NinthColumnMustHave80to90() {
        // when
        var strip = sut.generateBingoStrip();

        // then
        List<Integer> values = new ArrayList<>();
        for (int row = 0; row < 18; row++) {
            if (strip[row][8] != 0) {
                values.add(strip[row][8]);
            }
        }
        for (int i = 80; i <= 90; i ++) {
            int finalI = i;
            var count = values.stream().filter(val -> val == finalI).count();
            assertEquals(count, 1);
        }
    }
}