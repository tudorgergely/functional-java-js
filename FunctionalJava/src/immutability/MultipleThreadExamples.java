package immutability;

import immutability.model.ImmutableDog;
import immutability.model.MutableDog;

public class MultipleThreadExamples {

    private MutableDog mutableDog;
    private ImmutableDog immutableDog;

    private Thread1 thread1;
    private Thread2 thread2;

    private class Thread1 extends Thread {

        private MutableDog mutableDog;
        private ImmutableDog immutableDog;

        public Thread1(MutableDog mutableDog, ImmutableDog immutableDog) {
            this.mutableDog = mutableDog;
            this.immutableDog = immutableDog;
        }

        @Override
        public void run() {
            super.run();
            mutableDog.setName("Rex1");
            immutableDog = immutableDog.changeName("Rex1");
//            try {
//                Thread2.sleep(200);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println("Thread1:" + mutableDog.getName() + "<->" + immutableDog.getName());
        }
    }

    private class Thread2 extends Thread {
        private MutableDog mutableDog;
        private ImmutableDog immutableDog;

        public Thread2(MutableDog mutableDog, ImmutableDog immutableDog) {
            this.mutableDog = mutableDog;
            this.immutableDog = immutableDog;
        }

        @Override
        public void run() {
            super.run();
            mutableDog.setName("Rex2");
            immutableDog = immutableDog.changeName("Rex2");
//            try {
//                Thread2.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            System.out.println("Thread2:" + mutableDog.getName() + "<->" + immutableDog.getName());
        }
    }

    public MultipleThreadExamples() {
        mutableDog = new MutableDog();
        mutableDog.setId(1);
        mutableDog.setName("Rex");
        mutableDog.setWeight(12);
        immutableDog = new ImmutableDog(2, "ImmutableRex", 13);
        thread1 = new Thread1(mutableDog, immutableDog);
        thread2 = new Thread2(mutableDog, immutableDog);
    }

    public void executeThreadExamples() throws InterruptedException {
        thread1.start();
        thread2.start();
        mutableDog.setName("HomeRex");
        System.out.println("Main thread: HomeRex<->" + mutableDog.getName());
        thread1.join();
        thread2.join();
    }

}
