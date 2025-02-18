package factory;

import factory.IMUDAbstractFactory;

public class SciFiMUDFactory implements IMUDAbstractFactory {
    @Override
    public IGameEntity createRoom() {
        return null;
    }

    @Override
    public IGameEntity createNPC() {
        return null;
    }
}
