package helpers;

import javax.swing.*;

/**
 * Created by ceosilvajr on 09/10/2015.
 */
public class TimerTask extends SwingWorker<Void, Void> {

    private static final int MILLI_SECOND = 1000;
    private long time;
    private JProgressBar mJProgressBar;


    public TimerTask(JProgressBar jprogressBar, int sec) {
        this.time = sec * MILLI_SECOND;
        this.mJProgressBar = jprogressBar;
    }

    /*
     * Main task. Executed in background thread.
     */
    @Override
    public Void doInBackground() {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    /*
     * Executed in event dispatching thread
     */
    @Override
    public void done() {
        mJProgressBar.setValue(0);
    }
}
