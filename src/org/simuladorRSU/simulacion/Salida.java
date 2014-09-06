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

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Ruben Bermudez on 08/05/2014.
 */
public class Salida implements Runnable {

    private ConcurrentLinkedQueue<Double> material;
    protected double totalMaterial;
    private boolean finished;
    private boolean suspended;
    private Thread myThread;

    public Salida() {
        this.material = new ConcurrentLinkedQueue<Double>();
        this.totalMaterial = 0;
        this.finished = false;
        this.suspended = false;
    }

    public void start() {
        myThread = new Thread(this);
        finished = false;
        suspended = false;
        synchronized (myThread) {
            myThread.start();
        }
    }

    public void notifyThread() {
        synchronized (myThread) {
            myThread.notify();
        }
    }

    public void interrupt() {
        synchronized (myThread) {
            myThread.interrupt();
        }
    }

    public void suspend() {
        suspended = true;
    }

    public void resume() {
        suspended = false;    }

    public void add(double material) {
        this.material.add(material);
    }

    public void DebugInfo(Boolean interrupted) {
        if (interrupted)
            System.out.println("Salida Interrumpida: " + this.totalMaterial);
        else
            System.out.println("Salida: " + this.totalMaterial);
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
                if (Thread.interrupted()) {
                    DebugInfo(true);
                    this.finished = true;
                }
                Double aux = material.poll();
                if (aux != null) {
                    totalMaterial += aux;
                    DebugInfo(false);
                }
                synchronized (myThread) {
                    while (suspended) {
                        myThread.wait();
                    }
                }
            }catch (InterruptedException e) {
                DebugInfo(true);
                this.finished = true;
            }

        }

    }
}
