package testPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DataBase {

	public class col {
		int[][] colMatrix;
		col(int colMat[][]){
			colMatrix = new int[3][2];
			for(int i=0; i<3; i++) {
				for(int j=0; j<2; j++) {
					colMatrix[i][j] = colMat[i][j];
				}
			}
		}
	}
	Map<col, String> dataList; 
	
	
	DataBase(int n) {
		switch(n) {
			
			case 0:{

				dataList = new HashMap<col, String>();
				int[][] matrix = new int[3][2];
				matrix[0][0]=0;
				matrix[0][1]=1;
				matrix[1][0]=0;
				matrix[1][1]=1;
				matrix[2][0]=1;
				matrix[2][1]=1;
				dataList.put(new col(matrix), "INT");
				break;
			}

			/////////////////////////////////////CASE 1//////////////////////////////////////////////
			case 1:{
				dataList = new HashMap<col, String>();
				int[][] matrix = new int[3][2];
				
				matrix[0][0]=0;
				matrix[0][1]=1;
				matrix[1][0]=0;
				matrix[1][1]=1;
				matrix[2][0]=1;
				matrix[2][1]=1;
				dataList.put(new col(matrix), "INT");

				matrix[0][0]=1;
				matrix[0][1]=0;
				matrix[1][0]=0;
				matrix[1][1]=0;
				matrix[2][0]=0;
				matrix[2][1]=0;
				dataList.put(new col(matrix), "1");
				

				matrix[0][0]=1;
				matrix[0][1]=0;
				matrix[1][0]=1;
				matrix[1][1]=0;
				matrix[2][0]=0;
				matrix[2][1]=0;
				dataList.put(new col(matrix), "2");
				

				matrix[0][0]=1;
				matrix[0][1]=1;
				matrix[1][0]=0;
				matrix[1][1]=0;
				matrix[2][0]=0;
				matrix[2][1]=0;
				dataList.put(new col(matrix), "3");
				

				matrix[0][0]=1;
				matrix[0][1]=1;
				matrix[1][0]=0;
				matrix[1][1]=1;
				matrix[2][0]=0;
				matrix[2][1]=0;
				dataList.put(new col(matrix), "4");
				

				matrix[0][0]=1;
				matrix[0][1]=0;
				matrix[1][0]=0;
				matrix[1][1]=1;
				matrix[2][0]=0;
				matrix[2][1]=0;
				dataList.put(new col(matrix), "5");
				

				matrix[0][0]=1;
				matrix[0][1]=1;
				matrix[1][0]=1;
				matrix[1][1]=0;
				matrix[2][0]=0;
				matrix[2][1]=0;
				dataList.put(new col(matrix), "6");
				

				matrix[0][0]=1;
				matrix[0][1]=1;
				matrix[1][0]=1;
				matrix[1][1]=1;
				matrix[2][0]=0;
				matrix[2][1]=0;
				dataList.put(new col(matrix), "7");
				

				matrix[0][0]=1;
				matrix[0][1]=0;
				matrix[1][0]=1;
				matrix[1][1]=1;
				matrix[2][0]=0;
				matrix[2][1]=0;
				dataList.put(new col(matrix), "8");
				

				matrix[0][0]=0;
				matrix[0][1]=1;
				matrix[1][0]=1;
				matrix[1][1]=0;
				matrix[2][0]=0;
				matrix[2][1]=0;
				dataList.put(new col(matrix), "9");
				

				matrix[0][0]=0;
				matrix[0][1]=1;
				matrix[1][0]=1;
				matrix[1][1]=1;
				matrix[2][0]=0;
				matrix[2][1]=0;
				dataList.put(new col(matrix), "0");
				break;
			}
			/////////////////////////////////////CASE 2//////////////////////////////////////////////
			case 2:{
				dataList = new HashMap<col, String>();
				int[][] matrix = new int[3][2];
				
				matrix[0][0]=0;
				matrix[0][1]=1;
				matrix[1][0]=0;
				matrix[1][1]=1;
				matrix[2][0]=1;
				matrix[2][1]=1;
				dataList.put(new col(matrix), "INT");
				
				matrix[0][0]=1;
				matrix[0][1]=0;
				matrix[1][0]=0;
				matrix[1][1]=0;
				matrix[2][0]=0;
				matrix[2][1]=0;
				dataList.put(new col(matrix), "A");
				
				matrix[0][0]=1;
				matrix[0][1]=0;
				matrix[1][0]=1;
				matrix[1][1]=0;
				matrix[2][0]=0;
				matrix[2][1]=0;
				dataList.put(new col(matrix), "B");
				
				matrix[0][0]=1;
				matrix[0][1]=1;
				matrix[1][0]=0;
				matrix[1][1]=0;
				matrix[2][0]=0;
				matrix[2][1]=0;
				dataList.put(new col(matrix), "C");
				
				matrix[0][0]=1;
				matrix[0][1]=1;
				matrix[1][0]=0;
				matrix[1][1]=1;
				matrix[2][0]=0;
				matrix[2][1]=0;
				dataList.put(new col(matrix), "D");
				
				matrix[0][0]=1;
				matrix[0][1]=0;
				matrix[1][0]=0;
				matrix[1][1]=1;
				matrix[2][0]=0;
				matrix[2][1]=0;
				dataList.put(new col(matrix), "E");
				
				matrix[0][0]=1;
				matrix[0][1]=1;
				matrix[1][0]=1;
				matrix[1][1]=0;
				matrix[2][0]=0;
				matrix[2][1]=0;
				dataList.put(new col(matrix), "F");
				
				matrix[0][0]=1;
				matrix[0][1]=1;
				matrix[1][0]=1;
				matrix[1][1]=1;
				matrix[2][0]=0;
				matrix[2][1]=0;
				dataList.put(new col(matrix), "G");
				
				matrix[0][0]=1;
				matrix[0][1]=0;
				matrix[1][0]=1;
				matrix[1][1]=1;
				matrix[2][0]=0;
				matrix[2][1]=0;
				dataList.put(new col(matrix), "H");
				
				matrix[0][0]=0;
				matrix[0][1]=1;
				matrix[1][0]=1;
				matrix[1][1]=0;
				matrix[2][0]=0;
				matrix[2][1]=0;
				dataList.put(new col(matrix), "I");
				
				matrix[0][0]=0;
				matrix[0][1]=1;
				matrix[1][0]=1;
				matrix[1][1]=1;
				matrix[2][0]=0;
				matrix[2][1]=0;
				dataList.put(new col(matrix), "J");
				
				matrix[0][0]=1;
				matrix[0][1]=0;
				matrix[1][0]=0;
				matrix[1][1]=0;
				matrix[2][0]=1;
				matrix[2][1]=0;
				dataList.put(new col(matrix), "K");

				matrix[0][0]=1;
				matrix[0][1]=0;
				matrix[1][0]=1;
				matrix[1][1]=0;
				matrix[2][0]=1;
				matrix[2][1]=0;
				dataList.put(new col(matrix), "L");
				
				matrix[0][0]=1;
				matrix[0][1]=1;
				matrix[1][0]=0;
				matrix[1][1]=0;
				matrix[2][0]=1;
				matrix[2][1]=0;
				dataList.put(new col(matrix), "M");
				
				matrix[0][0]=1;
				matrix[0][1]=1;
				matrix[1][0]=0;
				matrix[1][1]=1;
				matrix[2][0]=1;
				matrix[2][1]=0;
				dataList.put(new col(matrix), "N");
				
				matrix[0][0]=1;
				matrix[0][1]=0;
				matrix[1][0]=0;
				matrix[1][1]=1;
				matrix[2][0]=1;
				matrix[2][1]=0;
				dataList.put(new col(matrix), "O");
				
				matrix[0][0]=1;
				matrix[0][1]=1;
				matrix[1][0]=1;
				matrix[1][1]=0;
				matrix[2][0]=1;
				matrix[2][1]=0;
				dataList.put(new col(matrix), "P");
				
				matrix[0][0]=1;
				matrix[0][1]=1;
				matrix[1][0]=1;
				matrix[1][1]=1;
				matrix[2][0]=1;
				matrix[2][1]=0;
				dataList.put(new col(matrix), "Q");

				matrix[0][0]=1;
				matrix[0][1]=0;
				matrix[1][0]=1;
				matrix[1][1]=1;
				matrix[2][0]=1;
				matrix[2][1]=0;
				dataList.put(new col(matrix), "R");
				
				matrix[0][0]=0;
				matrix[0][1]=1;
				matrix[1][0]=1;
				matrix[1][1]=0;
				matrix[2][0]=1;
				matrix[2][1]=0;
				dataList.put(new col(matrix), "S");
				
				matrix[0][0]=0;
				matrix[0][1]=1;
				matrix[1][0]=1;
				matrix[1][1]=1;
				matrix[2][0]=1;
				matrix[2][1]=0;
				dataList.put(new col(matrix), "T");

				matrix[0][0]=1;
				matrix[0][1]=0;
				matrix[1][0]=0;
				matrix[1][1]=0;
				matrix[2][0]=1;
				matrix[2][1]=1;
				dataList.put(new col(matrix), "U");

				matrix[0][0]=1;
				matrix[0][1]=0;
				matrix[1][0]=1;
				matrix[1][1]=0;
				matrix[2][0]=1;
				matrix[2][1]=1;
				dataList.put(new col(matrix), "V");

				matrix[0][0]=0;
				matrix[0][1]=1;
				matrix[1][0]=1;
				matrix[1][1]=1;
				matrix[2][0]=0;
				matrix[2][1]=1;
				dataList.put(new col(matrix), "W");

				matrix[0][0]=1;
				matrix[0][1]=1;
				matrix[1][0]=0;
				matrix[1][1]=0;
				matrix[2][0]=1;
				matrix[2][1]=1;
				dataList.put(new col(matrix), "X");

				matrix[0][0]=1;
				matrix[0][1]=1;
				matrix[1][0]=0;
				matrix[1][1]=1;
				matrix[2][0]=1;
				matrix[2][1]=1;
				dataList.put(new col(matrix), "Y");

				matrix[0][0]=1;
				matrix[0][1]=0;
				matrix[1][0]=0;
				matrix[1][1]=1;
				matrix[2][0]=1;
				matrix[2][1]=1;
				dataList.put(new col(matrix), "Z");
				break;
			}
		}
	}
}
