package Problem;

public class PadLocalizer {
	
	public static void main(String[] args) {
		localizePad("2015-07-27_17-42-44.png", "2015-07-27_17-42-44b.png", "2015-07-27_17-42-44.png");
	}
	
	public static void localizePad(String originalImageFile, String grassImageFile, String outputImageFile) {
		EdgeDetection.markFHWTEdgeHillTopsInRowsandCols(grassImageFile, outputImageFile);
	}
	public static void localizePadInDir(String originalDir, String grassDir, String outputDir) {
		
	}
}
