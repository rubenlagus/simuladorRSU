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
 * Created by Ruben Bermudez on 06/05/2014.
 */
public abstract class Modulo implements Runnable {
    protected Residuos RSU;
    protected boolean finished;
    protected boolean suspended;
    protected Thread myThread;
    private int tiempo;

    public Modulo() {
        this.RSU = new Residuos();
        this.finished = false;
        this.suspended = false;
        this.tiempo = 1000;
        myThread = new Thread(this);
    }

    public Modulo(Residuos RSU) {
        this.RSU = RSU;
        this.finished = false;
        this.suspended = false;
        this.tiempo = 1000;
        myThread = new Thread(this);
    }

    public void suspend() {
        suspended = true;
    }

    public void resume() {
        suspended = false;
    }

    public void start() {
        myThread = new Thread(this);
        finished = false;
        suspended = false;
        synchronized (myThread) {
            myThread.start();
        }
    }

    public void interrupt() {
        synchronized (myThread) {
            myThread.interrupt();
        }
    }

    public void notifyThread() {
        synchronized (myThread) {
            myThread.notify();
        }
    }

    public void setRSU(Residuos RSU) {
    	synchronized (RSU) {
    		this.RSU = RSU;
    	}
    }

    public Residuos getRSU() {
        return this.RSU;
    }
    
    public void setTiempo(int tiempo) {
    	this.tiempo = tiempo;
    }
    
    public int getTiempo() {
    	return this.tiempo;
    }
    
    protected abstract double calcularPorcentaje();

    public abstract void salida();

    public abstract void entrada();
    
    @Override
	public void run() {
		while(!finished) {
            this.entrada();
            try {
                Thread.sleep(tiempo);
                synchronized(myThread) {
                    while (suspended) {
                        myThread.wait();
                    }
                }
            } catch (InterruptedException e) {
                finished = true;
            }
            this.salida();
		}
	}
}
