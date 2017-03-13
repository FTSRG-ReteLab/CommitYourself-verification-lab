package hu.bme.mit.train.sensor;
import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;
import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Before;
import org.junit.Test;

public class TrainSensorTest {
    TrainController mockedTC;
    TrainUser mockedTU;
    TrainSensor trainSensor;
    @Before
    public void before() {
        mockedTC = mock(TrainController.class);
        mockedTU = mock(TrainUser.class);
        trainSensor = new TrainSensorImpl(mockedTC, mockedTU);
    }
    @Test
    public void getSpeedLimitTest() {
        trainSensor.overrideSpeedLimit(501);
        assertEquals(501, trainSensor.getSpeedLimit());
    }
    @Test
    public void overrideSpeedLimitTest1() {
        when(mockedTC.getReferenceSpeed()).thenReturn(200);
        trainSensor.overrideSpeedLimit(5);
        verify(mockedTU, times(1)).setAlarmState(true);
    }
    @Test
    public void overrideSpeedLimitTest2() {
        when(mockedTC.getReferenceSpeed()).thenReturn(10);
        trainSensor.overrideSpeedLimit(-1);
        verify(mockedTU, times(1)).setAlarmState(true);
    }
    @Test
    public void overrideSpeedLimitTest3() {
        when(mockedTC.getReferenceSpeed()).thenReturn(10);
        trainSensor.overrideSpeedLimit(600);
        verify(mockedTU, times(1)).setAlarmState(true);
    }
}
