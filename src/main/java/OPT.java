import java.util.ArrayDeque;
import java.util.HashMap;

/**
 * "Optimal" page replacement algorithm. Magic of knowing when something will be needed in the future aside, simply
 * keeping track of future pages is a pain. I think I could do it better if I tried again, but all my original ideas
 * failed because of how Java implements its standard data structures.
 */
public class OPT extends ReplacementAlgorithm {

    protected HashMap<Integer, Node> futureMap;

    protected ArrayDeque<Node> queue;

    /**
     * Basic constructor and driver.
     * @param pageFrameCount How many pages frames are being kept.
     * @param pages The list of page references in the order they are accessed.
     */
    public OPT(int pageFrameCount, int[] pages) {
        super(pageFrameCount);

        this.futureMap = new HashMap<>();
        for (int i = 0; i < pages.length; i++) {
            int page = pages[i];
            if (!futureMap.containsKey(page)) {
                futureMap.put(page, new Node(page));
            }
            futureMap.get(page).addOccurrence(i);
        }

        this.queue = new ArrayDeque<>(pageFrameCount);

        for (int i : pages) {
            nextPage(i);
        }

        System.out.println("Page faults: " + pageFaultCount);
    }

    @Override
    public void nextPage(int pageID) {
        //Gets the current node, then calls next to ensure checks don't include this occurrence.
        Node pageNode = futureMap.get(pageID);
        pageNode.getNext();

        if (!set.contains(pageID)) {

            if (queue.size() >= pageFrameCount) {
                System.out.println(pageID + " replacing value in queue: " + queue);

                //Takes the next node in the queue (which is sure to exist for any frame count > 0). If it has no
                //future references, replaces it. Otherwise, iterate through the other pages in the queue looking for
                //a better page to replace.
                Node temp = queue.peekFirst();
                assert temp != null;
                if (temp.checkNext() != null) {
                    for (Node n : queue) {
                        if (n.checkNext() == null) {
                            temp = n;
                            break;
                        }
                        if (n.checkNext() > temp.checkNext()) {
                            temp = n;
                        }
                    }
                }
                queue.remove(temp);
                set.remove(temp.getPageID());
            } else {
                System.out.println(pageID + " added to loose queue: " + queue);
            }
            pageFaultCount++;
            queue.add(pageNode);
            set.add(pageID);
        } else {
            System.out.println(pageID + " already in queue: " + queue.toString());
        }
    }

    /**
     * Used to group future occurrences with a given page (since pages are just referenced by an ID/integer, rather than
     * an object).
     */
    public static class Node {

        int pageID;

        ArrayDeque<Integer> occurrences;

        public Node(int pageID) {
            this.pageID = pageID;
            occurrences = new ArrayDeque<>();
        }

        public void addOccurrence(int index) {
            occurrences.addLast(index);
        }

        public Integer getNext() {
            return occurrences.removeFirst();
        }

        public Integer checkNext() {
            return occurrences.peekFirst();
        }

        public int getPageID() {
            return pageID;
        }

        public String toString() {
            return String.valueOf(pageID);
        }
    }
}
