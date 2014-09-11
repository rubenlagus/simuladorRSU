/*
 * Copyright 2014 Ruben Bermudez
 * This file is part of SimulacionRSU.
 *
 * SimulacionRSU is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * SimulacionRSU is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with SimulacionRSU.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.simuladorRSU.simulacion;

/**
 * @author Ruben Bermudez
 */
public class SalidaRechazo extends Linea implements Runnable {
    Residuos total = new Residuos();
    private boolean finished;
    private boolean suspended;
    private Thread myThread;

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

    @Override
    public void run() {
        while(!finished) {
            try {
                if (Thread.interrupted()) {
                    this.finished = true;
                }
                Residuos aux = this.colaResiduos.poll();
                if (aux != null) {
                    synchronized (total) {
                        total.suma(aux);
                    }
                }
                synchronized (myThread) {
                    while (suspended) {
                        myThread.wait();
                    }
                }
            }catch (InterruptedException e) {
                this.finished = true;
            }

        }
    }

    public Residuos getTotal() {
        synchronized (total) {
            return total;
        }
    }
}
