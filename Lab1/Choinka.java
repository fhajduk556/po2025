public class Choinka {
    public static void main(String[] args) {
        int wysokosc = Integer.parseInt(args[0]);
		int x = 1;
		int i = 1;
		
		while (x <= wysokosc) {
			i = 1;
			while (i <= x){
				System.out.print("*");
				i = i + 1;
			}
			System.out.println();
			x = x + 1;
		}
    }
}