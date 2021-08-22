package solutions;

import java.util.*;

public class ArithmeticSquare {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int iterations = scanner.nextInt();
        scanner.nextLine();

        for (int i = 1; i <= iterations; i++) {
            int[][] grid = new int[3][3];
            String[] firstRow = scanner.nextLine().split(" ");
            for (int index = 0; index < 3; index++) {
                int value = Integer.parseInt(firstRow[index]);
                grid[0][index] = value;
            }

            String[] secondRow = new String[3];
            String[] scannerString = scanner.nextLine().split(" ");
            secondRow[0] = scannerString[0];
            secondRow[2] = scannerString[1];

            for (int index = 0; index < 3; index++) {
                if (index == 1) {
                    continue;
                }
                int value = Integer.parseInt(secondRow[index]);
                grid[1][index] = value;
            }
            String[] thirdRow = scanner.nextLine().split(" ");
            for (int index = 0; index < 3; index++) {
                int value = Integer.parseInt(thirdRow[index]);
                grid[2][index] = value;
            }
            System.out.println("Case #" + i + ": " + countProgressions(grid));
        }
    }

    private static void getOrPut(Map<Integer, List<Result>> sequences, List<Result> result, int B) {
        if (sequences.containsKey(B)) {
            sequences.get(B).addAll(result);
        } else {
            sequences.put(B, result);
        }
    }

    private static Set<Integer> calculatePossibleValuesOfB(int[][] grid) {
        Set<Integer> result = new HashSet<>();
        int B = (grid[0][0] + grid[2][2]) / 2; //diagonal top left
        result.add(B);
        B = (grid[0][1] + grid[2][1]) / 2; //middle column
        result.add(B);
        B = (grid[0][2] + grid[2][0]) / 2; //diagonal top right
        result.add(B);
        B = (grid[1][0] + grid[1][2]) / 2; //middle row
        result.add(B);
        return result;
    }

    private static int countProgressions(int[][] grid) {
        int maxProgression = 0;
        Map<Integer, List<Result>> sequences = new HashMap<>();

        for (Integer B : calculatePossibleValuesOfB(grid)) {
            grid[1][1] = B;
            //check top left diagonal
            int difference5 = grid[0][0] - grid[1][1];
            int difference6 = grid[1][1] - grid[2][2];
            if (difference5 == difference6) {
                List<Result> result = new ArrayList<>();
                result.add(new Result(0, 0));
                result.add(new Result(1, 1));
                result.add(new Result(2, 2));
                sequences.put(B, result);
            }

            //check top right diagonal
            int difference7 = grid[2][0] - grid[1][1];
            int difference8 = grid[1][1] - grid[0][2];
            if (difference7 == difference8) {
                List<Result> result = new ArrayList<>();
                result.add(new Result(2, 0));
                result.add(new Result(1, 1));
                result.add(new Result(0, 2));
                getOrPut(sequences, result, B);
            }
            for (int row = 0; row < 3; row++) {
                int difference1 = grid[row][0] - grid[row][1];
                int difference2 = grid[row][1] - grid[row][2];
                if (difference1 == difference2) {
                    List<Result> result = new ArrayList<>();
                    result.add(new Result(row, 0));
                    result.add(new Result(row, 1));
                    result.add(new Result(row, 2));
                    getOrPut(sequences, result, B);
                }

                int difference3 = grid[0][row] - grid[1][row];
                int difference4 = grid[1][row] - grid[2][row];
                if (difference3 == difference4) {
                    List<Result> result = new ArrayList<>();
                    result.add(new Result(0, row));
                    result.add(new Result(1, row));
                    result.add(new Result(2, row));
                    getOrPut(sequences, result, B);
                }
            }
            if (maxProgression < getMaxLength(sequences)) {
                maxProgression = getMaxLength(sequences);
            }
        }

        return maxProgression;
    }

    private static int getMaxLength(Map<Integer, List<Result>> sequences) {
        return sequences.values().stream().map(List::size).max(Integer::compareTo).orElse(0) / 3; //Divide by three becausee each sequence has three "Results"
    }

    static class Result {
        private final int row;
        private final int column;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Result result = (Result) o;
            return row == result.row && column == result.column;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, column);
        }

        public Result(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}
