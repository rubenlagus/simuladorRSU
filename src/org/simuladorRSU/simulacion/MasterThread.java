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
 * Created by Ruben Bermudez on 09/05/2014.
 */
public class MasterThread implements Runnable {

    private static MasterThread instance = null;
    private static Thread myThread = null;
    private static Residuos residuosToFoso = null;
    private static boolean finished;
    private static boolean suspended;

    private MasterThread() {
        MasterThread.residuosToFoso = new Residuos(10);
        MasterThread.finished = false;
        MasterThread.suspended = false;
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
        synchronized (myThread) {
            myThread = new Thread(instance);
            myThread.start();
        }
    }

    public void stop() {
    	StaticComponents.getInstance().stopThreads();
        MasterThread.finished = true;
    }

    public void suspend() {
    	StaticComponents.getInstance().suspendThreads();
        MasterThread.suspended = true;
    }

    public void resume() {
    	StaticComponents.getInstance().resumeThreads();
        MasterThread.suspended = false;
        synchronized(myThread) {
            myThread.notify();
        }
    }


    public void interruptThread() {
        synchronized (myThread) {
            myThread.interrupt();
        }
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
        while(!finished) {
            try {
                Thread.sleep(1000);
                synchronized(myThread) {
                    while(suspended) {
                        myThread.wait();
                    }
                }
            } catch (InterruptedException e) {
                stop();
            }
            StaticComponents.getInstance().addFoso(residuosToFoso);
        }
    }
    
}
