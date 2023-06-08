import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


//The first set of pages is the one used in the book, which explicitly says how many faults each method has.
class FaultTests {
    @Test
    void fifoFaultCountTest() {
        FIFO temp = new FIFO(3, PageGenerator.firstReferenceSet());
        assertEquals(15, temp.getPageFaultCount());
    }

    @Test
    void optFaultCountTest() {
        OPT temp = new OPT(3, PageGenerator.firstReferenceSet());
        assertEquals(9, temp.getPageFaultCount());
    }

    @Test
    void lruFaultCountTest() {
        LRU temp = new LRU(3, PageGenerator.firstReferenceSet());
        assertEquals(12, temp.getPageFaultCount());
    }
}