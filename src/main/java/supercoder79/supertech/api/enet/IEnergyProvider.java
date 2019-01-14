package supercoder79.supertech.api.enet;

/**
 * Inherited by any class that provides energy for the EnergyNetwork
 * @author SuperCoder79
 */
public interface IEnergyProvider {

    /**
     *
     * @param amt amount of energy to extract
     * @return extracted energy
     */
    int extractEnergy(int amt);
}
