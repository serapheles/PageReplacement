import java.util.ArrayDeque;

/**
 * First In, First Out page replacement algorithm.
 */
public class FIFO extends ReplacementAlgorithm {

    protected ArrayDeque<Integer> queue;

    /**
     * Basic constructor and driver.
     * @param pageFrameCount How many pages frames are being kept.
     * @param pages The list of page references in the order they are accessed.
     */
    public FIFO(int pageFrameCount, int[] pages) {
        super(pageFrameCount);
        this.queue = new ArrayDeque<>(pageFrameCount);

        for (int i : pages) {
            nextPage(i);
        }
        System.out.println("Page faults: " + getPageFaultCount());
    }

    @Override
    public void nextPage(int pageID) {
        if (!set.contains(pageID)) {
            if (queue.size() >= pageFrameCount) {
                System.out.println(pageID + " replacing value in queue: " + queue);
                set.remove(queue.removeFirst());
            } else {
                System.out.println(pageID + " added to loose queue: " + queue);
            }
            pageFaultCount++;
            queue.addLast(pageID);
            set.add(pageID);
        } else {
            System.out.println(pageID + " already in queue: " + queue.toString());
        }
    }
}
