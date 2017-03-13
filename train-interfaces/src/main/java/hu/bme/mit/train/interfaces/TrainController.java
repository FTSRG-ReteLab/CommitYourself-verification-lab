package hu.bme.mit.train.interfaces;

public interface TrainController {

	void followSpeed();

	int getReferenceSpeed();

	void setReferenceSpeed(int joystickPosition);

	void setSpeedLimit(int speedLimit);

	void setJoystickPosition(int joystickPosition);

}
