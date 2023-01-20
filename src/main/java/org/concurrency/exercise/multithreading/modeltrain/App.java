package org.concurrency.exercise.multithreading.modeltrain;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App {
    public static void main(String[] args) {
        BlockingQueue<DataPackage> downloadedData = new ArrayBlockingQueue<>(10);
        DownloadManager downloadManager = new DownloadManager();
        downloadManager.startDownload(10, downloadedData);
        ParallelDataProcessor parallelDataProcessor = new ParallelDataProcessor(downloadedData, 5, 10);
        parallelDataProcessor.process();
    }
}
