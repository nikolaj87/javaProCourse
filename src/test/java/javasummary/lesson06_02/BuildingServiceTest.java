package javasummary.lesson06_02;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BuildingServiceTest {



        BuildingRepository br = Mockito.mock(BuildingRepository.class);

        BuildingService bs = new BuildingService(br);


        Building building1 = Mockito.mock(Building.class);
        Building building2 = Mockito.mock(Building.class);
        Building building3 = new Building("3", 1000);


        List<Building> buildingList = Arrays.asList(building1, building2, building3);



    @Test
    void increaseCost() {
        when(br.findAll()).thenReturn(buildingList);

        int amount = 100;
        int expectedRes = 1100;

        bs.increaseCost(amount);

        assertEquals(expectedRes, building3.getCost());

        verify(br, times(1)).findAll();
        verify(br, times(1)).save(building3);
    }
}