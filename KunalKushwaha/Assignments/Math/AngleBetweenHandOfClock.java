package KunalKushwaha.Assignments.Math;

public class AngleBetweenHandOfClock {
    public double angleClock(int hour, int minutes) {
        double min = 6*minutes;
		//If we write just minutes/60*30 where minutes = 15 ans will be 7 and not 7.5
        double hr = (hour%12)*30 + (double)minutes/60*30;
        double angle = Math.abs(min - hr);

        if(angle > 180) return 360 - angle;

        return angle;
    }
}
