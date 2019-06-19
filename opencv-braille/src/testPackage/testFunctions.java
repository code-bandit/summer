package testPackage;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.imgcodecs.Imgcodecs;

public class testFunctions {

	private static final String imagePath = "/home/ripudaman/Desktop/opencv/test2/";
	
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		Mat src = Imgcodecs.imread(imagePath+"test2_result1_row_9.jpg", Imgcodecs.IMREAD_GRAYSCALE);
		Point p = getLeftOffset(src);
		if(p != null) System.out.println(p.x + " " + " " + p.y);
		for(int i=0;;i++) {
		Point leftOffset = getLeftOffset(src);
		Point brake = new Point(-1, -1);		
		System.out.println("Offset left : "+i);
		if(leftOffset.equals(brake)) {
			break;
		}else {				
			src = cropToColumn(src, leftOffset, 50, i);
			if(src == null) break;
		}
	}
	}
	
	private static Point getLeftOffset(Mat src) {
		for(int x=0; x<src.width(); x++) {
			for(int y=0; y<src.height(); y++) {
				double[] pixel = src.get(y, x);
				if(pixel != null && pixel[0] == 0.0) {
							return new Point(x, y);
				}
			}
		}
		return new Point(-1, -1);
	}
	
	private static Mat cropToColumn(Mat src, Point offset, int length, int name) {
		Rect rect;
		System.out.println("SRC WIDTH : " + (src.width()-offset.x));
		if((src.width()-offset.x) > length) {
			rect = new Rect((int)offset.x, 0, length, src.height());
		}else {
			rect = new Rect((int)offset.x, 0, (int)(src.width()-offset.x), src.height());
		}
		Mat mat = new Mat(src, rect);
		Imgcodecs.imwrite(imagePath+name+".jpg", mat);
//		readCol();
		Rect r;
		if(mat.width() != (int)(src.width()-offset.x)) {			
			r= new Rect((int)offset.x+length, 0, src.width()-((int)offset.x+length), src.height());
			Mat newMat = new Mat(src, r);
			return newMat;
		}
		return null;
	}
	
}
