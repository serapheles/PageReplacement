import java.util.HashSet;

/**
 * I moved some stuff around and renamed insert to nextPage to better reflect how I conceptually use it. I almost put
 * even more stuff in this class, but the differences between the algorithms was just enough that it didn't make sense.
 */
public abstract class ReplacementAlgorithm {
	// the number of page faults
	protected int pageFaultCount;
	
	// the number of physical page frame
	protected int pageFrameCount;

	//Keeps track of pages with frame references, rather than calling a contains method. Better speed for worse memory.
	protected HashSet<Integer> set;

	/**
	 * @param pageFrameCount - the number of physical page frames
	 */
	public ReplacementAlgorithm(int pageFrameCount) {
		if (pageFrameCount < 0)
			throw new IllegalArgumentException();
		
		this.pageFrameCount = pageFrameCount;
		this.pageFaultCount = 0;
		this.set = new HashSet<>(pageFrameCount);
	}
	
	/**
	 * @return - the number of page faults that occurred.
	 */
	public int getPageFaultCount() {
		return pageFaultCount;
	}

	/**
	 * @param pageID - the page number to be inserted
	 */
	public abstract void nextPage(int pageID);
}
