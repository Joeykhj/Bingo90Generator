package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class StripGenerator {

    private final Random random = new Random();

    public int[][] generateBingoStrip() {

        var strip = populateStrip(generateVerifiedStrip());
        System.out.println("------------------------------------------------------");
        int rowCount = 0;
        for (int[] row : strip) {
            var valueConcat = "";
            for (int value : row) {
                var valueString = Integer.toString(value);
                if (value == 0) {
                    valueString = "  ";
                }
                if (valueString.length() == 1) {
                    valueString = " ".concat(valueString);
                }
                valueConcat = valueConcat.concat("[ " + valueString + " ]");
            }
            System.out.println(valueConcat);
            rowCount++;
            if (rowCount == 3) {
                rowCount = 0;
                System.out.println("------------------------------------------------------");
            }
        }

        return strip;
    }

    // Turns 4 numbers out of the rows into 0 And returns the Array
    private int[][] deleteFields(int[][] ticket) {

        var immutableList = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8);
        List<Integer> numbers = new ArrayList<>() {{
            addAll(immutableList);
        }};

        int i = 0;

        for (int row = 0; row < 2; row++) {
            int limit = 4;
            removeRandomField(ticket, immutableList, numbers, row, limit);
        }

        while (i < 4) {
            int randomIndex = random.nextInt(numbers.size());
            var randomColumn = numbers.get(randomIndex);
            if (ticket[0][randomColumn] == 0 && ticket[1][randomColumn] == 0) {
                i--;
            } else {
                ticket[2][randomColumn] = 0;
            }
            i++;
            numbers.remove(randomIndex);
        }
        refreshNumbers(immutableList, numbers);

        for (int row = 3; row < 5; row++) {
            int limit = 4;
            removeRandomField(ticket, immutableList, numbers, row, limit);
        }

        i = 0;
        while (i < 4) {
            int randomIndex = random.nextInt(numbers.size());
            var randomColumn = numbers.get(randomIndex);
            if (ticket[3][randomColumn] == 0 && ticket[4][randomColumn] == 0) {
                i--;
            } else {
                ticket[5][randomColumn] = 0;
            }
            i++;
            numbers.remove(randomIndex);
        }
        refreshNumbers(immutableList, numbers);

        for (int row = 6; row < 8; row++) {
            int limit = 4;
            for (int column = 0; column < 9; column++) {
                int numberOfZeroesInColumn = 0;
                for (int j = 0; j < row; j++) {
                    if (ticket[j][column] == 0) {
                        numberOfZeroesInColumn++;
                    }
                }

                if (row == 6 && numberOfZeroesInColumn < 1) {
                    ticket[row][column] = 0;
                    limit--;
                    numbers.remove(Integer.valueOf(column));
                }

                if (row == 7 && numberOfZeroesInColumn < 2) {
                    ticket[row][column] = 0;
                    limit--;
                    numbers.remove(Integer.valueOf(column));
                }
            }
            removeRandomField(ticket, immutableList, numbers, row, limit);
        }

        i = 0;
        while (i < 4) {
            int randomIndex = random.nextInt(numbers.size());
            var randomColumn = numbers.get(randomIndex);
            if (ticket[6][randomColumn] == 0 && ticket[7][randomColumn] == 0) {
                i--;
            } else {
                ticket[8][randomColumn] = 0;
            }
            i++;
            numbers.remove(randomIndex);
        }
        refreshNumbers(immutableList, numbers);

        for (int row = 9; row < 11; row++) {
            int limit = 4;
            for (int column = 0; column < 9; column++) {
                int numberOfZeroesInColumn = 0;
                for (int j = 0; j < row; j++) {
                    if (ticket[j][column] == 0) {
                        numberOfZeroesInColumn++;
                    }
                }

                if (row == 9 && numberOfZeroesInColumn < 3) {
                    ticket[row][column] = 0;
                    limit--;
                    numbers.remove(Integer.valueOf(column));
                }

                if (row == 10 && numberOfZeroesInColumn < 4) {
                    ticket[row][column] = 0;
                    limit--;
                    numbers.remove(Integer.valueOf(column));
                }
            }
            removeRandomField(ticket, immutableList, numbers, row, limit);
        }

        i = 0;
        while (i < 4) {
            int randomIndex = random.nextInt(numbers.size());
            var randomColumn = numbers.get(randomIndex);
            if (ticket[9][randomColumn] == 0 && ticket[10][randomColumn] == 0) {
                i--;
            } else {
                ticket[11][randomColumn] = 0;
            }
            i++;
            numbers.remove(randomIndex);
        }
        refreshNumbers(immutableList, numbers);

        for (int row = 12; row < 14; row++) {
            int limit = 4;
            for (int column = 0; column < 9; column++) {
                int numberOfZeroesInColumn = 0;
                for (int j = 0; j < row; j++) {
                    if (ticket[j][column] == 0) {
                        numberOfZeroesInColumn++;
                    }
                }

                if (row == 12 && numberOfZeroesInColumn < 5) {
                    ticket[row][column] = 0;
                    limit--;
                    numbers.remove(Integer.valueOf(column));
                }

                if (row == 13 && numberOfZeroesInColumn < 6) {
                    ticket[row][column] = 0;
                    limit--;
                    numbers.remove(Integer.valueOf(column));
                }
            }
            removeRandomField(ticket, immutableList, numbers, row, limit);
        }

        i = 0;
        while (i < 4) {
            int randomIndex = random.nextInt(numbers.size());
            var randomColumn = numbers.get(randomIndex);
            if (ticket[12][randomColumn] == 0 && ticket[13][randomColumn] == 0) {
                i--;
            } else {
                ticket[14][randomColumn] = 0;
            }
            i++;
            numbers.remove(randomIndex);
        }
        refreshNumbers(immutableList, numbers);

        int limit = 4;
        for (int column = 0; column < 9; column++) {
            int numberOfZeroesInColumn = 0;
            for (int j = 0; j < 15; j++) {
                if (ticket[j][column] == 0) {
                    numberOfZeroesInColumn++;
                }
            }

            if (numberOfZeroesInColumn < 7) {
                ticket[15][column] = 0;
                limit--;
                numbers.remove(Integer.valueOf(column));
            }
        }
        removeRandomField(ticket, immutableList, numbers, 15, limit);
        removeRandomField(ticket, immutableList, numbers, 16, 4);

        for (int column = 0; column < 9; column++) {
            int sumOfColumns = 0;
            for (int row = 0; row < 18; row++) {
                if (ticket[row][column] == 1) {
                    sumOfColumns++;
                }
            }
            if (sumOfColumns > 10) {
                ticket[17][column] = 0;
            }
        }
        numbers.clear();
        return ticket;
    }

    // Turns a limit of numbers into 0
    private void removeRandomField(int[][] ticket, List<Integer> immutableList, List<Integer> numbers, int row, int limit) {
        for (int i = 0; i < limit; i++) {
            int randomIndex = random.nextInt(numbers.size());
            var randomColumn = numbers.get(randomIndex);
            ticket[row][randomColumn] = 0;
            numbers.remove(randomIndex);
        }
        refreshNumbers(immutableList, numbers);
    }

    // Generates and returns a 2 Dimensional Array (18 x 9) filled with 1
    private int[][] getFullStrip() {
        var ticket = new int[18][9];
        for (int row = 0; row < 18; row++) {
            for (int column = 0; column < 9; column++) {
                ticket[row][column] = 1;
            }
        }
        return ticket;
    }

    private void refreshNumbers(List<Integer> immutableList, List<Integer> numbers) {
        numbers.clear();
        numbers.addAll(immutableList);
    }

    // Final check to ensure all rows follow the rule of 5 positive numbers
    private int[][] generateVerifiedStrip() {
        var strip = deleteFields(getFullStrip());
        for (int row = 0; row < 18; row++) {
            var sumOfRow = 0;
            for (int column = 0; column < 9; column++) {
                if (strip[row][column] == 1) {
                    sumOfRow++;
                }
            }
            if (sumOfRow != 5) {
                strip = generateVerifiedStrip();
            }
        }
        return strip;
    }

    // Fill strip with numbers
    private int[][] populateStrip(int[][] binaryStrip) {
        populate0And90(binaryStrip);
        populateFirstColumn(binaryStrip);
        populateColumns(binaryStrip);
        return binaryStrip;
    }

    private void populate0And90(int[][] strip) {
        var rowCounter = 0;
        while (rowCounter < 18) {
            if (strip[rowCounter][0] == 1 && strip[rowCounter][8] == 0) {
                if (rowCounter % 3 == 0) { // First row of ticket
                    if(strip[rowCounter][0] + strip[rowCounter + 1][0] + strip[rowCounter + 2][0] > 1) {
                        strip[rowCounter][0] = 0;
                        strip[rowCounter][8] = 90;
                        break;
                    }
                }
                if (rowCounter % 3 == 1) { // Second row of ticket
                    if(strip[rowCounter - 1][0] + strip[rowCounter][0] + strip[rowCounter + 1][0] > 1) {
                        strip[rowCounter][0] = 0;
                        strip[rowCounter][8] = 90;
                        break;
                    }
                }
                if (rowCounter % 3 == 2) { // Third row of ticket
                    if(strip[rowCounter - 2][0] + strip[rowCounter - 1][0] + strip[rowCounter][0] > 1) {
                        strip[rowCounter][0] = 0;
                        strip[rowCounter][8] = 90;
                        break;
                    }
                }
            }
            rowCounter++;
        }
    }

    private void populateFirstColumn(int[][] strip) {
        var immutableList = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        var list = new ArrayList<Integer>() {{
            addAll(immutableList);
        }};
        var rowCounter = 0;
        while (rowCounter < 18) {
            if (strip[rowCounter][0] == 1) {
                if (list.size() < 1) {
                    strip[rowCounter][0] = 1;
                } else {
                    int randomIndex = random.nextInt(list.size());
                    var value = list.get(randomIndex);
                    strip[rowCounter][0] = value;
                    list.remove(randomIndex);
                }
            }
            rowCounter++;
        }
        list.clear();
    }

    // Fill in the rest of the columns
    private void populateColumns(int[][] strip) {
        var immutableList = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> available = new ArrayList<>() {{
            addAll(immutableList);
        }};
        for (var column = 1; column < 9; column++) {
            int finalColumn = column;
            available = available.stream().map(val -> val + (finalColumn * 10)).collect(Collectors.toList());
            var rowCounter = 0;
            while (rowCounter < 18) {
                if (strip[rowCounter][column] == 1) {
                    int randomIndex = random.nextInt(available.size());
                    var value = available.get(randomIndex);
                    strip[rowCounter][column] = value;
                    available.remove(randomIndex);
                }
                rowCounter++;
            }
            available.clear();
            available.addAll(immutableList);
        }
    }
}
