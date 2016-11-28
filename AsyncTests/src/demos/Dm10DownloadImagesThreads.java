package demos;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Dm10DownloadImagesThreads {
    private static void downloadImagesSync() {
        while (true) {
            String urlString;
            synchronized (imageQueue) {
                urlString = imageQueue.poll();
                if (urlString == null) {
                    break;
                }
            }

            try {
                URL url = new URL(urlString);
                int lastSlashIndex = url.toString().lastIndexOf('/');
                String imgName = url.toString().substring(lastSlashIndex + 1) + ".jpg";
                System.out.println("Thread " + Thread.currentThread().getId() + " downloading " + imgName);
                BufferedImage image = ImageIO.read(url);
                File imageAsFile = new File("res/" + imgName);
                ImageIO.write(image, "jpg", imageAsFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private final static Queue<String> imageQueue = new ArrayDeque<>();

    public static void main(String[] args) {
        imageQueue.add("https://softuni.bg/companies/profile/logo/194");
        imageQueue.add("https://softuni.bg/companies/profile/logo/219");
        imageQueue.add("https://softuni.bg/companies/profile/logo/114");
        imageQueue.add("https://softuni.bg/companies/profile/logo/106");
        imageQueue.add("https://softuni.bg/companies/profile/logo/76");

        List<Thread> threadPool = new ArrayList<>();
        int processorCount = Runtime.getRuntime().availableProcessors();
        System.out.println("Thread count: " + processorCount);
        long startTime = System.nanoTime();
        for (int i = 0; i < processorCount; i++) {
            Thread thread = new Thread(() -> downloadImagesSync());
            threadPool.add(thread);
            thread.start();
        }
        for (Thread thread : threadPool) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Elapsed seconds: " + (System.nanoTime() - startTime) / 1000000000d);
    }
}
