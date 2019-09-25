package run.halo.app.utils;

import org.assertj.core.util.Lists;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.*;

public class ListsPartitionTest {

    @Test
    public void testPartition() throws InterruptedException, ExecutionException {
        List<PartitionExample> list = Lists.newArrayList();
        //开启100个线程处理数据
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        //假设100000条数据,100个线程平分处理,就是100000/100=1000;每个线程并发处理1000条数据
        for (int i = 0; i < 100000; i++) {
            PartitionExample partitionExample = new PartitionExample();
            list.add(partitionExample);
        }
        //数据拆分 按照1000条拆分归档
        List<List<PartitionExample>> partition = com.google.common.collect.Lists.partition(list, 1000);
        List<PartitionCall> callList = Lists.newArrayList();
        for (List<PartitionExample> item : partition) {
            PartitionCall call = new PartitionCall(item);
            callList.add(call);
        }
        long start = System.currentTimeMillis();
        List<Future<Integer>> futures = executorService.invokeAll(callList);
        for (Future<Integer> future : futures) {
            future.get();
        }
        System.out.println("耗时:" + (System.currentTimeMillis() - start) + "ms");
    }
}

class PartitionExample {
}

class PartitionCall implements Callable<Integer> {

    private final List<PartitionExample> list;

    PartitionCall(List<PartitionExample> list) {
        this.list = list;
    }

    @Override
    public Integer call() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(Thread.currentThread().getName() + ",i=" + i + ",时间:" + System.currentTimeMillis());
        }
        return 1;
    }
}


class ThreadUnsafeExample {

    private int cnt = 0;

    public void add() {
        cnt++;
    }

    public int get() {
        return cnt;
    }

    public static void main(String[] args) throws InterruptedException {
        final int threadSize = 1000;
        ThreadUnsafeExample example = new ThreadUnsafeExample();
        final CountDownLatch countDownLatch = new CountDownLatch(threadSize);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < threadSize; i++) {
            executorService.execute(() -> {
                example.add();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println(example.get());
    }


}



