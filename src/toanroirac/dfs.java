package toanroirac;
import java.util.Scanner;
public class dfs {
	static int n,m;
	static int[][] gr;
	static boolean[][] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		gr = new int[n][m];
		visited = new boolean[n][m];
		for(int i = 0; i<n;i++) {
			for(int j=0;j <m;j++) {
				gr[i][j]= sc.nextInt();
			}
		}
		int count = 0;
		for(int i = 0; i<n;i++) {
			for(int j=0;j <m;j++) {
				if(!visited[i][j] && gr[i][j] == 1) {
					dfss(i,j);
					count++;
				}
			}
		}
		System.out.println("So thanh phan lien thong: " + count);
		
	}
	static int[] dx =  {-1,0,0,1};
	static int[] dy = {0,-1,1,0};
	
	
	public static void dfss(int i,int j){
		visited[i][j] = true;
		for(int k = 0; k < 4; k++) {
			int i1 = i+ dx[k];
			int j1 = j + dy[k];
			if(i1 >= 0 && i1 < n && j1 >=0 && j1<m && !visited[i1][j1] && gr[i1][j1] == 1) {
				dfss(i1,j1);
			}
		}
	}

}
