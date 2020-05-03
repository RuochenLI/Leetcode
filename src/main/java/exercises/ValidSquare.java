package exercises;

/**
 * Created by ruli on 6/2/2017.
 */
public class ValidSquare {

   public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
      int[] p1p2 = createVector(p1, p2);
      int[] p1p3 = createVector(p1, p3);
      int[] p1p4 = createVector(p1, p4);

      return checkConditions(p1p2, p1p3, p1p4)|| checkConditions(p1p2,p1p4,p1p3)
        || checkConditions(p1p4, p1p3, p1p2);
   }

   private static boolean checkConditions(int[] p1, int[] p2, int[] p3) {
      double length1 = length(p1);
      return length1 != 0 && length1 == length(p2) && dotProduct(p1, p2) == 0 && equality(vectorAddition(p1, p2), p3);
   }

   private static int[] vectorAddition(int[] p1, int[] p2) {
      return new int[]{p2[0]+p1[0],p2[1]+p1[1]};
   }

   private static boolean equality(int[] p1, int[] p2) {
      return p1[0] == p2[0] && p1[1] == p2[1];
   }

   private static int dotProduct(int[] p1, int[] p2) {
      return p1[0]*p2[0] + p1[1]*p2[1];
   }

   private static double length(int[] p1) {
      int width = p1[0];
      int height = p1[1];
      return Math.sqrt(width*width + height*height);
   }

   private static int[] createVector(int[] p1, int[] p2) {
      return new int[]{p2[0]-p1[0],p2[1]-p1[1]};
   }
}
