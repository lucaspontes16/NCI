
//This class takes All the variables, constructors, to string, getters and setters
class Vehicles implements Comparable<Object> {
        private int iId;
        private String sName;
        private String sFuel;
        private String sLocation;
        private int iPostcode;
        private long lValue;

        // constructor
        public Vehicles(int iInId, String sInName, String sInFuel, String sInLocation, int iInPostcode, long lInValue) {
            this.iId = iInId;
            this.sName = sInName;
            this.sFuel = sInFuel;
            this.sLocation = sInLocation;
            this.iPostcode = iInPostcode;
            this.lValue = lInValue;
        }

        // the objects can be compared when sorting/searching
        @Override
        public int compareTo(Object obj) {

        /*
		This section compares the appropriate
		column that I wish to sort, in this case was by postcode
         */
            Vehicles myVehicles = (Vehicles) obj;
            return Integer.compare(this.iPostcode, myVehicles.iPostcode); //according to the CA proposal, the
        }

        @Override
        public String toString() {
            return "Vehicle [ID= " + iId + ", Name= " + sName + ", Fuel= "
                    + sFuel + ", Location= " + sLocation + ", Postcode= "
                    + iPostcode + ", Value= " + lValue + "]";
        }

        // getters and setters
        public int getiId() {
            return iId;
        }

        public void setiId(int iId) {
            this.iId = iId;
        }

        public String getsName() {
            return sName;
        }

        public void setsName(String sName) {
            this.sName = sName;
        }

        public String getsFuel() {
            return sFuel;
        }

        public void setsFuel(String sFuel) {
            this.sFuel = sFuel;
        }

        public String getsLocation() {
            return sLocation;
        }

        public void setsLocation(String sLocation) {
            this.sLocation = sLocation;
        }

        public int getiPostcode() {
            return iPostcode;
        }

        public void setiPostcode(int iPostcode) {
            this.iPostcode = iPostcode;
        }

        public long getlValue() {
            return lValue;
        }

        public void setlValue(long lValue) {
            this.lValue = lValue;
        }

    }

