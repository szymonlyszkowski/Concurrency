package com.lyszkowski_lisowski.neurons;

import com.lyszkowski_lisowski.interfaces.ActivationFunction;
import com.lyszkowski_lisowski.recursiveNetwork.Resources;

/**
 * Created by szymonidas on 26.10.14.
 */
public class NeuronTwo extends Thread implements ActivationFunction {

  private int neuronCounter;

  public NeuronTwo(int counterValue) {

    neuronCounter = counterValue;
  }

  @Override
  public int activate() {
    int result = neuronCounter-5;
    return result;
  }

  @Override
  public int getCounter() {
    return this.neuronCounter;
  }


  @Override
  public void setCounter(int value) {
    neuronCounter = value;
  }

  @Override
  public void run() {

    while (Resources.SECOND_NEURON.getCounter() > 0) {
      try {
        Resources.SEMAPHORE.acquire();
        System.out.println("Semaphore acquired for neuron 2");
        int output = this.activate();
        Resources.FIRST_NEURON.setCounter(output);
        Resources.THIRD_NEURON.setCounter(output);
        Resources.printNeurons();
        Resources.SEMAPHORE.release();
        System.out.println("Semaphore released from neuron 2");

      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }

  }
}
