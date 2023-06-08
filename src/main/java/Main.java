public class Main {

    public static void fifoSet(){
        System.out.println("Fifo: ");
        int faultCount = 0;
        FIFO temp;
        temp = new FIFO(3, PageGenerator.firstReferenceSet());
        faultCount += temp.getPageFaultCount();
        temp = new FIFO(3, PageGenerator.secondReferenceSet());
        faultCount += temp.getPageFaultCount();
        temp = new FIFO(3, PageGenerator.thirdReferenceSet());
        faultCount += temp.getPageFaultCount();

        for(int i = 0; i < 3;i++){
            temp = new FIFO(3 + (i * 2), PageGenerator.randomReferenceSet(10));
            faultCount += temp.getPageFaultCount();
            temp = new FIFO(3 + (i * 2), PageGenerator.randomReferenceSet(15));
            faultCount += temp.getPageFaultCount();
            temp = new FIFO(3 + (i * 2), PageGenerator.randomReferenceSet(20));
            faultCount += temp.getPageFaultCount();
        }

        System.out.println("Fault total: " + faultCount);
    }

    public static void lruSet(){
        System.out.println("LRU: ");
        int faultCount = 0;
        LRU temp;
        temp = new LRU(3, PageGenerator.firstReferenceSet());
        faultCount += temp.getPageFaultCount();
        temp = new LRU(3, PageGenerator.secondReferenceSet());
        faultCount += temp.getPageFaultCount();
        temp = new LRU(3, PageGenerator.thirdReferenceSet());
        faultCount += temp.getPageFaultCount();

        for(int i = 0; i < 3;i++){
            temp = new LRU(3 + (i * 2), PageGenerator.randomReferenceSet(10));
            faultCount += temp.getPageFaultCount();
            temp = new LRU(3 + (i * 2), PageGenerator.randomReferenceSet(15));
            faultCount += temp.getPageFaultCount();
            temp = new LRU(3 + (i * 2), PageGenerator.randomReferenceSet(20));
            faultCount += temp.getPageFaultCount();
        }
        System.out.println("Fault total: " + faultCount);
    }

    public static void optSet(){
        System.out.println("OPT: ");
        int faultCount = 0;
        OPT temp;
        temp = new OPT(3, PageGenerator.firstReferenceSet());
        faultCount += temp.getPageFaultCount();
        temp = new OPT(3, PageGenerator.secondReferenceSet());
        faultCount += temp.getPageFaultCount();
        temp = new OPT(3, PageGenerator.thirdReferenceSet());
        faultCount += temp.getPageFaultCount();

        for(int i = 0; i < 3;i++){
            temp = new OPT(3 + (i * 2), PageGenerator.randomReferenceSet(10));
            faultCount += temp.getPageFaultCount();
            temp = new OPT(3 + (i * 2), PageGenerator.randomReferenceSet(15));
            faultCount += temp.getPageFaultCount();
            temp = new OPT(3 + (i * 2), PageGenerator.randomReferenceSet(20));
            faultCount += temp.getPageFaultCount();
        }

        System.out.println("Fault total: " + faultCount);
    }

    public static void main(String[] args){
//        fifoSet();
//        lruSet();
        optSet();
    }
}
