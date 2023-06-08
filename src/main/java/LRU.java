import java.util.ArrayDeque;
import java.util.HashSet;

/**
 * Least Recently Used page replacement algorithm. The roles of the queue and set are reversed in this one compared to
 * the others.
 */
public class LRU extends ReplacementAlgorithm {

    protected ArrayDeque<Integer> queue;

    protected HashSet<Integer> queueSet;

    /**
     * Basic constructor and driver.
     * @param pageFrameCount How many pages frames are being kept.
     * @param pages The list of page references in the order they are accessed.
     */
    public LRU(int pageFrameCount, int[] pages) {
        super(pageFrameCount);
        this.queue = new ArrayDeque<>(pageFrameCount);
        this.queueSet = new HashSet<>();

        for (int i : pages) {
            nextPage(i);
        }

        System.out.println("Page faults: " + pageFaultCount);
    }

    @Override
    public void nextPage(int pageID) {
        if(!set.contains(pageID)){
            if (set.size() >= pageFrameCount) {
                System.out.println(pageID + " replacing value in queue: " + set);
                set.remove(queue.removeFirst());
            } else {
                System.out.println(pageID + " added to loose queue: " + queue);
            }
            pageFaultCount++;
            set.add(pageID);
        } else {
            System.out.println(pageID + " already in queue: " + queue.toString());
        }
        queue.remove(pageID);
        queue.addLast(pageID);
    }
}
