package supercoder79.supertech112.api.enet;

/**
 * Inherited by any class that can store and use energy
 * @author SuperCoder79
 */
public interface IEnergyMachine {
    /**
     * @return the amount of energy contained
     */
    int getEnergy();

    /**
     * @return the maximum amount of energy able to e stored
     */
    int getMaxEnergy();
}
