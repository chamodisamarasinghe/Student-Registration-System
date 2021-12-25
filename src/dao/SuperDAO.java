package dao;

import entity.SuperEntity;

import java.util.List;

public interface SuperDAO <Entity extends SuperEntity, Id>{
    public boolean add(Entity entity);
    public boolean update(Entity entity);
    public boolean delete(Id id);
    public Entity find(Id id);
    public List<Entity> findAll();
}
