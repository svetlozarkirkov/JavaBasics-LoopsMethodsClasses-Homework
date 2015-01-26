
public class Problem3_FullHouse {

	public static void main(String[] args){
		String[] faces = {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
		char[] suits = {'\u2660','\u2665','\u2666','\u2663'};
		int count = 0;
		
		for (int i = 0; i < faces.length; i++){
			for (int j = 0; j < faces.length; j++){
				for (int k = 0; k < suits.length; k++){
					for (int m = k+1; m < suits.length; m++){
						for (int n = m+1; n < suits.length; n++){
							for (int p = 0; p < suits.length; p++){
								for (int q = p+1; q < suits.length; q++){
									if (i != j){
										System.out.printf("( %s%c %s%c %s%c %s%c %s%c )\n",
												faces[i],suits[k],faces[i],suits[m],faces[i],suits[n],
												faces[j],suits[p],faces[j],suits[q]);
										count++;
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(count+ " full houses");
	}
}