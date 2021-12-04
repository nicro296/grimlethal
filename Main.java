
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Main {

	InputStreamReader inr = new InputStreamReader(System.in);
	PrintWriter pw = new PrintWriter(System.out);
	BufferedReader br = new BufferedReader(inr);
	StringTokenizer st = new StringTokenizer("");

	int maxChara =6;//最大対象の数
	int grimShot=5;//2点が5回
	int[] characterLife;//[0]がリーダー
	int[] clTemp;
	int[] target = new int[grimShot];//タゲ管理
	int LCM;//最小公倍数
	int[] LCMI = {1,2,6,12,60,60};

	void solve() {
		try {
			characterLife = ii(maxChara);//半角数字6個、間は半角スペース
			br.close();
//			for(int i=0;i<maxChara;i++) {
//				pw.print(characterLife[i]+",");
//			}
//			pw.println();
			for(int i=maxChara-1;i>=0;i--) {
				if(characterLife[i]!=0) {
					maxChara = i+1;
					break;
				}
			}
//			pw.println(maxChara);
			LCM = LCMI[maxChara-1];
//			pw.println(LCM);

			for(int i=0;i<grimShot;i++) {
				target[i]=0;
			}

			reset();
			int numAll = LCM*LCM*LCM*LCM*LCM;//母数
//			pw.println(numAll);
			int numLose = 0;//負けパターンの大きさ

			do {
				reset();
				numLose += lose();
			}while(nextTarget()) ;

//			pw.println((double)numLose);
//			pw.println((double)numAll);
			pw.println( ((double)numLose/(double)numAll)*100+"%" );
			pw.close();

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





	void reset() {//体力値リセット
		clTemp = new int[maxChara];
		for(int i=0;i<maxChara;i++) {
			clTemp[i] = characterLife[i];
		}
	}

	int lose() {//num=母数(LCM^5)に対する事象(targetの変数)毎の大きさ、リーダーの体力が0の時に値を返す、他は0
		//viewTarget();
		int num=1;
		for(int i=0;i<grimShot;i++) {

			if( clTemp[ target[i] ] <=0) {
				return 0;
			}
			num *= LCM/zan();
//			pw.print(num+",");
			clTemp[ target[i] ] -=2;
		}

		if(clTemp[0]<=0) {
//			pw.println("Yes");
			return num;
		}else {
			return 0;
		}
	}

	int zan() {//残っているキャラクターの数
		int num=0;
		for(int i=0;i<maxChara;i++) {
			if(clTemp[i]>0) {
				num++;
			}
		}
		return num;
	}

	boolean nextTarget() {//targetの取り方全部をローラーする用
		for(int i=grimShot-1;i>=0;i--) {
			if(target[i]<maxChara-1) {
				target[i]++;
				return true;
			}else if(i!=0) {
				target[i]=0;
			}else {
				return false;
			}
		}
		throw new UnsupportedOperationException("ターゲット探索エラー："+target);
	}

	void viewTarget() {
		for(int i=0;i<grimShot;i++) {
//			pw.print(target[i]);
			if(i!=grimShot-1) {
//				pw.print(",");
			}else {
//				pw.println();
			}
		}
	}

}
