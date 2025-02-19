package factory;

import entitites.IGameEntity;

public interface IMUDAbstractFactory {
    IGameEntity createRoom();
    IGameEntity createNPC();
}
