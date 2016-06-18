package hayoc;

import com.google.inject.Guice;
import com.google.inject.Injector;
import hayoc.setup.WebOfBeliefModule;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by hayoc on 1/06/2016.
 */
public class Main {

    public static void main(String[] args) {
        WebOfBeliefModule module = new WebOfBeliefModule();
        Injector injector = Guice.createInjector(module);

        injector.getInstance(Main.class).runWoB();
    }

    private void runWoB() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.submit(() -> {
            System.out.println("Executed");
        });

        try {
            System.out.println("attempt to shutdown executor");
            executor.shutdown();
            executor.awaitTermination(5, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("tasks interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executor.shutdownNow();
            System.out.println("shutdown finished");
        }
    }


}
