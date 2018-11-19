public class Test_DBAccess {
  public static void main(String[] args) {
    // Creation of the database
    DB.createDB();


    /*
    Test the different functions:
    - The list of bars where it is possible to eat;
    - The nearest bar of the user;
    - The list of the X nearest bar in a range of Y kms;
    */
    ArrayList<Place> barsToEat = DB.BarsToEat();


    ArrayList<User> users = JSONAccess.readUsersJSON("./../data/users.json");
    User user1 = User.findUser(users, "user1")
    Place myPlace = DB.NearestBar(user1);


    ArrayList<Place> nearbyBars = DB.NearbyBars(user1, 3, 110);
  }
}
