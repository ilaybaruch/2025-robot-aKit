package frc.robot.POM_lib.Dashboard;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class DashboardNumber {
    double defaultValue;
    NetworkTableEntry entry;

    final String tableName = "Tunes";

    public DashboardNumber(String name, double defaultValue) {
        entry = NetworkTableInstance.getDefault().getTable(tableName).getEntry(name);
        this.defaultValue = defaultValue;
        entry.setDouble(defaultValue);
    }

    public DashboardNumber(String name) {
        this(name, 0);
    }

    public double get() {
        return entry.getDouble(defaultValue);
    }
}
