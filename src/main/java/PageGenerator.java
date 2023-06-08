import java.util.Random;

/**
 * Creates and returns arrays of integers to act as references to pages.
 */
public class PageGenerator {

    /**
     * This is the example used across the three algorithms in the book, so is used in testing because the results are
     * explicitly listed in the book.
     *
     * @return An array of page references.
     */
    public static int[] firstReferenceSet() {
        return new int[]{7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, 1, 7, 0, 1};
    }

    /**
     * @return An array of page references.
     */
    public static int[] secondReferenceSet() {
        return new int[]{8, 1, 0, 7, 3, 0, 3, 4, 5, 3, 5, 2, 0, 6, 8, 4, 8, 1, 5, 3};
    }

    /**
     * @return An array of page references.
     */
    public static int[] thirdReferenceSet() {
        return new int[]{4, 6, 4, 8, 6, 3, 6, 0, 5, 9, 2, 1, 0, 4, 6, 3, 0, 6, 8, 4};
    }

    /**
     * Creates an array of the provided size, with values ranging from 0 to 9 (inclusive)
     *
     * @param size The size of the array to return
     * @return An array representing references to pages.
     */
    public static int[] randomReferenceSet(int size) {
        Random dice = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = dice.nextInt(10);
        }
        return array;
    }


}
