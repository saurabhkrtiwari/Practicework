package collection;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueDemo {
    public static void main(String[] args) {
        BlockingQueue<Integer> integers = new LinkedBlockingQueue<>();

        Producer producer = new Producer(integers);
        Consumer consumer = new Consumer(integers);

        Thread produerThread =new Thread(producer);
        Thread consumerThread =new Thread(consumer);
        produerThread.start();
        consumerThread.start();
    }




}

class Producer implements Runnable{

    BlockingQueue<Integer> obj;

    public Producer(BlockingQueue<Integer> obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            try {
                obj.put(i+1);

                System.out.println("Produced " + i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Consumer implements Runnable{

    BlockingQueue<Integer> obj;

    public Consumer(BlockingQueue<Integer> obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        int take =-1;
        while (take!=10){
            try {
                take = obj.take();
                System.out.println("Taken "+ take);

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            Thread.sleep(100L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}