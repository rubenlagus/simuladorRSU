/**
 *   Copyright 2014 Ruben Bermudez
 *
 *   This file is part of SimulacionRSU.
 *
 *   SimulacionRSU is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.
 *
 *   SimulacionRSU is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *   GNU General Public License for more details.
 *
 *   You should have received a copy of the GNU General Public License
 *   along with SimulacionRSU.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.simuladorRSU.simulacion;

/**
 * @author Ruben Bermudez
 */
public class MasterThread implements Runnable {

    private static MasterThread instance = null;
    private static Thread myThread = null;
    private Residuos residuosToFoso = null;
    private boolean finished;
    private boolean suspended;
    private boolean added = false;

    private MasterThread() {
        residuosToFoso = new Residuos(60);
        finished = false;
        suspended = false;
        added = false;
        StaticComponents.getInstance();
    }

    public static MasterThread getInstance() {
        if (instance == null) {
            instance = new MasterThread();
            myThread = new Thread(instance);
        }
        return instance;
    }

    public void start() {

        StaticComponents.getInstance().startThreads();
        StaticComponents.getInstance().addFoso(residuosToFoso);
        added = true;
        synchronized (myThread) {
            myThread = new Thread(instance);
            myThread.start();
        }
    }

    public void stop() {
        StaticComponents.getInstance().stopThreads();
        instance = null;
    }

    public void suspend() {
        StaticComponents.getInstance().suspendThreads();
        suspended = true;
    }

    public void resume() {
        StaticComponents.getInstance().resumeThreads();
        suspended = false;
        synchronized (myThread) {
            myThread.notify();
        }
    }


    public void interruptThread() {
        synchronized (myThread) {
            myThread.interrupt();
        }
    }

    public Residuos getResiduosToFoso() {
        return residuosToFoso;
    }

    public void setResiduosToFoso(Residuos residuosToFoso) {
        this.residuosToFoso = residuosToFoso;
        added = false;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p/>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        while (!finished) {
            try {
                Thread.sleep(1000);
                synchronized (myThread) {
                    while (suspended) {
                        myThread.wait();
                    }
                }
            } catch (InterruptedException e) {
                stop();
            }
            if (!added) {
                StaticComponents.getInstance().addFoso(residuosToFoso);
                added = true;
            }
        }
    }

    public boolean isPaused() {
        return suspended;
    }
}
