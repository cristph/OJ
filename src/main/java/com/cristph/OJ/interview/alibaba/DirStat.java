package com.cristph.OJ.interview.alibaba;

import java.io.IOException;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class DirStat {

    private int maxDepth = 3;
    private AtomicLong totalSize = null;
    private AtomicInteger workingWorkers = null;
    private ArrayBlockingQueue<Path> dirs = null;
    private ExecutorService dirsConsumer = null;
    private ExecutorService statWorkersPool = null;

    public void stat(String filePath) {

        Path path = Paths.get(filePath);
        if (Files.exists(path)) {
            if (Files.isDirectory(path)) {

                startWorkers();

                try {
                    AtomicLong size = new AtomicLong(0L);
                    Files.list(path).forEach(p -> {
                        if (Files.isDirectory(p)) {
                            dirs.offer(p);
                            workingWorkers.getAndIncrement();
                        } else {
                            try {
                                size.addAndGet(getFileSize(p));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    totalSize.addAndGet(size.get());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println(filePath + " is not a directory");
                return;
            }
        } else {
            System.out.println(filePath + " doesn't exist");
            return;
        }

        while (workingWorkers.get() > 0) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("directory [" + filePath + "] total file size is " + totalSize + " Bytes");
        closeThreadPool();
    }

    private long statDir(Path path, int depth) {
        AtomicLong size = new AtomicLong(0L);
        if (depth < maxDepth) {
            try {
                Files.list(path).forEach(p -> {
                    if (Files.isDirectory(p)) {
                        size.addAndGet(statDir(p, depth + 1));
                    } else {
                        try {
                            size.addAndGet(getFileSize(p));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Files.walk(path).forEach(p -> {
                    if (!Files.isDirectory(p)) {
                        try {
                            size.addAndGet(getFileSize(p));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return size.get();
    }

    private static long getFileSize(Path path) throws IOException {
        SeekableByteChannel channel = Files.newByteChannel(path);
        long size = channel.size();
        channel.close();
        return size;
    }

    private void startWorkers() {
        if (dirsConsumer == null) {
            dirsConsumer = Executors.newSingleThreadExecutor();
        }
        if (statWorkersPool == null) {
            statWorkersPool = Executors.newCachedThreadPool();
        }
        if (dirs == null) {
            dirs = new ArrayBlockingQueue<>(1000);
        }
        if (totalSize == null) {
            totalSize = new AtomicLong(0L);
        }
        if (workingWorkers == null) {
            workingWorkers = new AtomicInteger(0);
        }
        dirsConsumer.submit(() -> {
            while (true) {
                Path path = dirs.take();
                statWorkersPool.submit(() -> {
                    totalSize.addAndGet(statDir(path, 1));
                    workingWorkers.getAndDecrement();
                });
            }
        });
    }

    private void closeThreadPool() {
        dirsConsumer.shutdownNow();
        statWorkersPool.shutdownNow();
    }

}
