
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

	InputStreamReader inr = new InputStreamReader(System.in);
	PrintWriter pw = new PrintWriter(System.out);
	BufferedReader br = new BufferedReader(inr);
	StringTokenizer st = new StringTokenizer("");

	void solve() {
		try {


			br.close();
		}catch(Exception err) {
			System.out.println("err(solve())= "+err);
		}
	}

	public static void main(String[] args) {
		try {
			new Main().solve();
		}catch(Exception err) {
			System.out.println("err(main)= "+err);
		}

	}

	String next() {
		try {
			if(st.hasMoreTokens()) {
			}else {
				st = new StringTokenizer(br.readLine());
			}
		}catch(Exception err) {
			System.out.println("err(next())= "+err);
		}
		return st.nextToken();
	}
	int ni() {
		try {
			return Integer.parseInt(next());
		}catch(Exception err) {
			System.out.println("err(ni())= "+err);
		}
		return 0;
	}
	long nl() {
		try {
			return Long.parseLong(next());
		}catch(Exception err) {
			System.out.println("err(nl())= "+err);
		}
		return 0L;
	}
	int[] ii(int len) {
		int[] numS = new int[len];
		try {
			for(int i=0;i<len;i++) {
				numS[i]= ni();
			}
		}catch(Exception err) {
			System.out.println("err(ii("+len+"))= "+err);
		}
		return numS;
	}

}
