package examples;

public class RotateMatrixby90 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int mat[][] = {{1,2,3},{4,5,6},{7,8,9}};
		printMatrix(mat, 3);
		System.out.println("\n");
		rotate(mat, 3);
		
	}

	
	public static void rotate(int mat[][], int n){
		for(int layer=0;layer<n/2;++layer){
			int first = layer;
			int last = n-1-layer;
			for(int i=first;i<last;++i){
				int offset = i-first;
				int top = mat[first][i];
				mat[first][i] = mat[last-offset][first];
				mat[last-offset][first] = mat[last][last-offset];
				mat[last][last-offset] = mat[i][last];
				mat[i][last] = top;
			}
		}
		
		
		printMatrix(mat,n);
	}
	
	public  static void printMatrix(int mat[][], int n){
	
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(" "+mat[i][j]);
			}
			System.out.println(" ");
		}
	}
}
