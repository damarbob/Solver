package id.my.dsm.vrpsolver.model;

import androidx.annotation.Nullable;

import java.util.List;
import java.util.UUID;

public class Vehicle {

    // Basic attributes
    private String id;
    private boolean isDefault;

    // Constraints
    private double capacity;
    private int dispatchLimit;

    // Used for deserialization
    public Vehicle() {
    }

    public Vehicle(Builder builder) {
        this.id = UUID.randomUUID().toString();
        this.isDefault = builder.isDefault;
        this.capacity = builder.capacity;
        this.dispatchLimit = builder.dispatchLimit;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getCapacity() {
        return capacity;
    }

    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public int getDispatchLimit() {
        return dispatchLimit;
    }

    public void setDispatchLimit(int dispatchLimit) {
        this.dispatchLimit = dispatchLimit;
    }

    public static class Builder {

        private boolean isDefault;

        // Constraints
        private double capacity = 1;
        private int dispatchLimit = 1000;

        public Builder() {
        }

        public Builder withDefault(boolean isDefault) {
            this.isDefault = isDefault;
            return this;
        }
        public Builder withCapacity(double capacity) {
            this.capacity = capacity;
            return this;
        }
        public Builder withDispatchLimit(int dispatchLimit) {
            this.dispatchLimit = dispatchLimit;
            return this;
        }

        public Vehicle build() {
            return new Vehicle(this);
        }


    }

    public static class Toolbox {

        /**
         * Get the default vehicle from a List of Vehicle
         * @param vehicles List of Vehicle
         * @return a default Vehicle
         */
        @Nullable
        public static Vehicle getDefaultVehicle(List<Vehicle> vehicles) {

            for (Vehicle v : vehicles) {
                if (v.isDefault())
                    return v; // Return the default vehicle
            }

            // Return the first vehicle REMOVED

            return null; // Return empty
        }

        /**
         * Set the default vehicle and clear the old
         * @param vehicles List of Vehicle
         * @param record Vehicle to be default
         */
        public static void switchDefaultVehicle(List<Vehicle> vehicles, Vehicle record) {

            Vehicle defaultVehicle = Toolbox.getDefaultVehicle(vehicles);

            if (defaultVehicle != null)
                defaultVehicle.setDefault(false);

            record.setDefault(true);

        }

    }

}
