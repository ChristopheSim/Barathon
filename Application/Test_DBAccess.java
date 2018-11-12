public class Test_DBAccess {
  public static void main(String[] args) {
    // Creation of the database
    DB.CreateDB();


    /*
    Test the different functions:
    - The nearest bar;
    - The list of bars where it is possible to eat in a range of Y kms;
    - The list of the X nearest bar in a range of Y kms;
    */
    DB.NeraestBar();
    DB.BarsToEat(int Y);
    DB.NearbyBars(int X, int Y);

  }
}
