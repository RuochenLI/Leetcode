package challenge.year2020.may;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        fill(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    private void fill(final int[][] image, final int y, final int x, final int newColor, final int original) {
        if (y<0 || y >= image.length || x<0 || x>=image[0].length || image[y][x]==newColor || image[y][x] != original)
            return;
        if (image[y][x] == original)image[y][x] = newColor;
        fill(image, y-1, x, newColor, original);
        fill(image, y+1, x, newColor, original);
        fill(image, y, x-1, newColor, original);
        fill(image, y, x+1, newColor, original);
    }
}
