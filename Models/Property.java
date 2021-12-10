package Models;

public class Property {
   Boolean posted;
   
   int id;
   String address;
   String type;
   int numBedrooms;
   int numBathrooms;
   Boolean furnished;
   String quadrant;
   String state;

   public Property(int id, String address, String type, 
                  int numBedrooms, int numBathrooms, Boolean furnished, 
                  String quadrant, String state) {
      this.id = id;
      this.address = address;
      this.type = type;
      this.numBedrooms = numBedrooms;
      this.numBathrooms = numBathrooms;
      this.furnished = furnished;
      this.quadrant = quadrant;
      this.state = state;
   }
   
   public int getId() {
      return this.id;
   }

   public String getAddress() {
      return this.address;
   }

   public String getType() {
      return this.type;
   }

   public int getNumBedrooms() {
      return this.numBedrooms;
   }

   public int getNumBathrooms() {
      return this.numBathrooms;
   }

   public Boolean getFurnished() {
      return this.furnished;
   }

   public String getQuadrant() {
      return this.quadrant;
   }

   public String getState() {
      return this.state;
   }

   public void setState(String s) {
      this.state = s;
   }
}
