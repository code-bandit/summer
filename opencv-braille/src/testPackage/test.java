package testPackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.imgproc.Moments;

import testPackage.DataBase.col;


public class test {

	private static class column {
		int[][] columnMatrix;
		column(int columnMatrix[][]){
			this.columnMatrix = columnMatrix;
		}
	}
	
	//Path to the Image
	private static final String imagePath = "/home/ripudaman/Desktop/opencv/test5/";
	private static final String imagePathRead = "/home/ripudaman/Desktop/opencv/";
	
	private static ArrayList<column> list = new ArrayList<>(); 
	
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		// Loads Image and Returns it
		Mat src = Imgcodecs.imread(imagePathRead+"test5.jpeg", Imgcodecs.IMREAD_GRAYSCALE);
		
		Mat dst = new Mat();
		// Median Blur the Image Loaded as GraySacle
		Imgproc.medianBlur(src, dst, 3);
		
		// Threshold the loaded image
		Imgproc.threshold(dst, dst, 127, 255, Imgproc.THRESH_OTSU);
		
		// Save Image
		Imgcodecs.imwrite(imagePath+"test3_result.jpeg", dst);
		
		// Get centroid's to be used
		List<Point> centroidList = new ArrayList<Point>();
		centroidList = getCentroids(dst);
		System.out.println(centroidList);
		System.out.println(centroidList.size());
		Mat mat = new Mat(2082, 3053, 0, new Scalar(255,255,255));
		for(Point p : centroidList) {
			Imgproc.circle(mat, p, 0, new Scalar(0,0,255), 10);
		}
		Imgcodecs.imwrite(imagePath+"test3_result1_size0.jpeg", mat);

//		System.out.println(mat.get(39, 12)[0]);
		
		//Get Top Offset to divide into rows
		for(int i=0; ; i++) {
			Point offset = getTopOffset(mat);
			Point brake = new Point(-1, -1);
			System.out.println("Offset top : "+i);
			if(offset.equals(brake)) {
				break;
			}else {
				System.out.println(offset);
				mat = cropToRow(mat, offset, 80, i);
//				Imgcodecs.imwrite(imagePath+"test3_result1_size1.png", mat);
			}
		}
		
		System.out.println(list.get(0).columnMatrix[2][0]);
		System.out.println(list.size());
//		printList();
		

		//Answer String
		String brailleToText = ""; 
		brailleToText = getAnswer();
		System.out.println(brailleToText);
	}
	
	//Returns List of centroid's
	private static List<Point> getCentroids(Mat src) {
		List<MatOfPoint> contours = new ArrayList<MatOfPoint>();    
	    Imgproc.findContours(src, contours, new Mat(), Imgproc.RETR_LIST,Imgproc.CHAIN_APPROX_SIMPLE);
	    List<Moments> mu = new ArrayList<Moments>(contours.size());
	    List<Point> centroids = new ArrayList<Point>();
	    for (int i = 0; i < contours.size(); i++) {
	        mu.add(i, Imgproc.moments(contours.get(i), false));
	        Moments p = mu.get(i);
	        int x = (int) (p.get_m10() / p.get_m00());
	        int y = (int) (p.get_m01() / p.get_m00());
	        centroids.add(new Point(x, y));
	    }
		centroids.remove(centroids.size()-1);
	    return centroids;
	}
	
	//Crop to row and use cropToCol() on the cropped row
	private static Mat cropToRow(Mat src, Point offset, int length, int name) {
		Rect rect = new Rect(0, (int)offset.y, src.width(), length);
		Mat mat = new Mat(src, rect);
		Mat colMat = mat;
		for(int i=0;;i++) {
			Point leftOffset = getLeftOffset(colMat);
			Point brake = new Point(-1, -1);		
			System.out.println("Offset left : "+i);
			if(leftOffset.equals(brake)) {
				break;
			}else {				
				colMat = cropToColumn(colMat, leftOffset, 42, i);
				if(colMat == null) break;
			}
		}
		Imgcodecs.imwrite(imagePath+"test3_result1_row_"+name+".jpeg", mat);
		Rect r = new Rect(0, (int)offset.y + length, src.width(), src.height()-((int)offset.y + length));
		Mat newMat = new Mat(src, r);
		return newMat;
	}
	
	//Crop to Column and use readCol() on the cropped column
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
		readCol(mat);
		Rect r;
		if(mat.width() != (int)(src.width()-offset.x)) {			
			r= new Rect((int)offset.x+length, 0, src.width()-((int)offset.x+length), src.height());
			Mat newMat = new Mat(src, r);
			return newMat;
		}
		return null;
	}
	
	//Read the cell using this function
	private static void readCol(Mat src){
        int matrix[][] = new int[3][2];
        Rect r1 = new Rect(0, 0, src.width()/2, src.height()/3);
        Rect r2 = new Rect(src.width()/2, 0, src.width()/2, src.height()/3);
        Rect r3 = new Rect(0, src.height()/3, src.width()/2, src.height()/3);
        Rect r4 = new Rect(src.width()/2, src.height()/3, src.width()/2, src.height()/3);
        Rect r5 = new Rect(0, 2*src.height()/3, src.width()/2, src.height()/3);
        Rect r6 = new Rect(src.width()/2, 2*src.height()/3, src.width()/2, src.height()/3);
        Mat m1 = new Mat(src, r1);
        Mat m2 = new Mat(src, r2);
        Mat m3 = new Mat(src, r3);
        Mat m4 = new Mat(src, r4);
        Mat m5 = new Mat(src, r5);
        Mat m6 = new Mat(src, r6);
        for(int i=0; i<m1.width(); i++){
            for(int j=0; j<m1.height(); j++){
                double[] pixel = m1.get(i, j);
                if(pixel != null && pixel[0] == 0.0){
                    matrix[0][0] = 1;
                    break;
                }else if(pixel != null && pixel[0] != 0.0){
                    matrix[0][0] = 0;
                }
            }
            if(matrix[0][0] == 1) break;
        }
        for(int i=0; i<m2.width(); i++){
            for(int j=0; j<m2.height(); j++){
                double[] pixel = m2.get(i, j);
                if(pixel != null && pixel[0] == 0.0){
                    matrix[0][1] = 1;
                    break;
                }else if(pixel != null && pixel[0] != 0.0){
                    matrix[0][1] = 0;
                }
            }
            if(matrix[0][1] == 1) break;
        }
        for(int i=0; i<m3.width(); i++){
            for(int j=0; j<m3.height(); j++){
                double[] pixel = m3.get(i, j);
                if(pixel != null && pixel[0] == 0.0){
                    matrix[1][0] = 1;
                    break;
                }else if(pixel != null && pixel[0] != 0.0){
                    matrix[1][0] = 0;
                }
            }
            if(matrix[1][0] == 1) break;
        }
        for(int i=0; i<m4.width(); i++){
            for(int j=0; j<m4.height(); j++){
                double[] pixel = m4.get(i, j);
                if(pixel != null && pixel[0] == 0.0){
                    matrix[1][1] = 1;
                    break;
                }else if(pixel != null && pixel[0] != 0.0){
                matrix[1][1] = 0;
                }
            }
            if(matrix[1][1] == 1) break;
        }
        for(int i=0; i<m5.width(); i++){
            for(int j=0; j<m5.height(); j++){
                double[] pixel = m5.get(i, j);
                if(pixel != null && pixel[0] == 0.0){
                    matrix[2][0] = 1;
                    break;
                }else if(pixel != null && pixel[0] != 0.0){
                    matrix[2][0] = 0;
                }
            }
            if(matrix[2][0] == 1) break;
        }
        for(int i=0; i<m6.width(); i++){
            for(int j=0; j<m6.height(); j++){
                double[] pixel = m6.get(i, j);
                if(pixel != null && pixel[0] == 0.0){
                    matrix[2][1] = 1;
                    break;
                }else if(pixel != null && pixel[0] != 0.0){
                    matrix[2][1] = 0;
                }
            }
            if(matrix[2][1] == 1) break;
        }
        column c = new column(matrix);
        list.add(c);
//        checkMatrix(matrix);
    }
    private static String getAnswer(){
    	String res="";
    	DataBase db = new DataBase(2);
    	for(column colMat : list) {
//    		for(int i=0; i<db.dataList.size(); i++) {
//    			String temp = db.dataList.get(colMat);
//    			System.out.println(colMat+"   "+db.dataList);
//    			if(temp!=null) {
//    				res = res + temp + " ";
//    			}
//    		}
    		for ( Entry<col, String> e : db.dataList.entrySet() ) {
    		    col key = e.getKey();
    		    String val = e.getValue();
//    			for(int i=0; i<3; i++) {
//    				for(int j=0; j<2; j++) {
//    					System.out.print(key.colMatrix[i][j]+" ");
//    				}
//    				System.out.println();
//    			}
//				System.out.println();
    			
    		    if(equals(key, colMat)) {
    		    	int check = checkSpecial(val); 
    		    	if(check != -1) db = new DataBase(check);
    		    	else res = res + val + " ";
//    		    	System.out.println(val);
    		    	break;
    		    }
    		}
    	}
    	return res;
    }
	
    private static boolean equals(col c, column cc) {
    	for(int i=0; i<3; i++) {
    		for(int j=0; j<2; j++) {
    			if(c.colMatrix[i][j] != cc.columnMatrix[i][j]) {
    				return false;
    			}
    		}
    	}
    	return true;
    }
    
    private static int checkSpecial(String val) {
    	if(val.equals("INT")) return 1;
    	else return -1;
    }
    
	/** Start of offset functions */
	private static Point getTopOffset(Mat src) {
		for(int y=0; y<src.height(); y++) {
			for(int x=0; x<src.width(); x++) {
				// src.get(int row, int col)  we have to give row number and column number 
				double[] pixel = src.get(y, x);
				if(pixel != null && pixel[0] == 0.0) {
//					System.out.println(pixel[0]+" "+x+" "+y);
					return new Point(x, y);
				}
			}
		}
		return new Point(-1, -1);
	}
	
	private static Point getLeftOffset(Mat src) {
		for(int x=0; x<src.width(); x++) {
			for(int y=0; y<src.height(); y++) {
				// src.get(int row, int col)  we have to give row number and column number 
				double[] pixel = src.get(y, x);
				if(pixel != null && pixel[0] == 0.0) {
							return new Point(x, y);
				}
			}
		}
		return new Point(-1, -1);
	}
	
	/** End of Offset Functions */
	
	private static void printList() {
		for(column item : list) {
			for(int i=0; i<3; i++) {
				for(int j=0; j<2; j++) {
					System.out.print(item.columnMatrix[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
    
}

