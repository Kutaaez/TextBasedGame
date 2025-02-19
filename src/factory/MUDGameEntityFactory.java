package factory;

import entitites.IGameEntity;

public abstract class MUDGameEntityFactory {
    public abstract IGameEntity creatyEntity(String type, String param);
}
