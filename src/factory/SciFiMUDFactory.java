package factory;

import entitites.IGameEntity;

public class SciFiMUDFactory  implements IMUDAbstractFactory {
    @Override
    public IGameEntity createRoom() {
        IGameEntity IGameEntity = null;
        return IGameEntity;
    }

    @Override
    public IGameEntity createNPC() {
        return null;
    }
}
