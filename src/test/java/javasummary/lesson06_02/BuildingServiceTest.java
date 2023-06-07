package javasummary.lesson06_02;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class BuildingServiceTest {



        BuildingRepository br = Mockito.mock(BuildingRepository.class);

        BuildingService bs = new BuildingService(br);


        Building building1 = Mockito.mock(Building.class);
        Building building2 = Mockito.mock(Building.class);
        Building building3 = Mockito.mock(Building.class);

        List<Building> buildingList = Arrays.asList(building1, building2, building3);



    @Test
    void increaseCost() {
        when(br.findAll()).thenReturn(buildingList);

        bs.increaseCost(100);
        assertEquals(3, buildingList.size());
    }
}