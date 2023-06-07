package javasummary.lesson06_02;

import java.util.List;

public interface BuildingRepository {

    public List<Building> findAll();

    public void deleteByName(String name);

    public void save(Building building);


}