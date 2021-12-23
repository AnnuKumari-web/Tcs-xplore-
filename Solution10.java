import java.util.*;

public class Solution10{

  public static void main(String[] args) {
    // code to read values
    Scanner sc = new Scanner(System.in);
    Inventory[] in = new Inventory[4];

    for (int i = 0; i < in.length; i++) {
      String inventoryId = sc.nextLine();
      int maximumQuantity = sc.nextInt();
      sc.nextLine();
      int currentQuantity = sc.nextInt();
      sc.nextLine();
      int threshold = sc.nextInt();
      sc.nextLine();

      in[i] = new Inventory(inventoryId, maximumQuantity, currentQuantity, threshold);
    }

    int limit = sc.nextInt();
    sc.close();
    Inventory[] ans = replenish(limit, in);
    for(int i = 0; i < ans.length; i++) {
      if (ans[i].getThreshold() >= 75) {
        System.out.println(ans[i].getInventoryId() + " " + "Critical Filling");
      }
      else if(ans[i].getThreshold() <= 74 && ans[i].getThreshold() >= 50) {
        System.out.println(ans[i].getInventoryId() + " " + "Moderate Filling");
      } 
      else {
        System.out.println(ans[i].getInventoryId() + " " + "Non-Critical Filling");
      }
    }
  }

  public static Inventory[] replenish(int limit, Inventory[] inventory) {
    // method logic
    Inventory[] result = new Inventory[0];
    for (int i = 0; i < inventory.length; i++) {
      if (inventory[i].getThreshold() <= limit) {
        result = Arrays.copyOf(result, result.length + 1);
        result[result.length - 1] = inventory[i];
      }
    }
    return result;
  }
}

class Inventory {
  // code to build Inventory class
  private String inventoryId;
  private int maximumQuantity;
  private int currentQuantity;
  private int threshold;

  public void setInventoryId(String inventoryId) {
    this.inventoryId = inventoryId;
  }

  public void setMaximumQuantity(int maximumQuantity) {
    this.maximumQuantity = maximumQuantity;
  }

  public void setCurrentQuantity(int currentQuantity) {
    this.currentQuantity = currentQuantity;
  }

  public void setThreshold(int threshold) {
    this.threshold = threshold;
  }

  public String getInventoryId() {
    return inventoryId;
  }

  public int getMaximumQuantity() {
    return maximumQuantity;
  }

  public int getCurrentQuantity() {
    return currentQuantity;
  }

  public int getThreshold() {
    return threshold;
  }

  Inventory(String inventoryId, int maximumQuantity, int currentQuantity, int threshold) {
    this.inventoryId = inventoryId;
    this.maximumQuantity = maximumQuantity;
    this.currentQuantity = currentQuantity;
    this.threshold = threshold;
  }

  Inventory() {

  }
}