package topInterviewQuestionsEasy.linkedlist;

public class Playground {

	class Demo {
		int a;

		public Demo(int v) {
			this.a = v;
		}
	}

	public static void main(String args[]) {
		int i = 5, j = 10;
		System.out.println(i);
		System.out.println(j);
		swap(5, 10);
		System.out.println(i);
		System.out.println(j);
		
		Playground pg = new Playground();
		
		System.out.println();
		Demo d11 = pg.new Demo(1);
		Demo d22 = pg.new Demo(2);
		System.out.println(d11.a);
		System.out.println(d22.a);
		function(d11, d22);
		System.out.println(d11.a);
		System.out.println(d22.a);		
		
		System.out.println();
		Demo d1 = pg.new Demo(1);
		Demo d2 = pg.new Demo(2);
		System.out.println(d1.a);
		System.out.println(d2.a);
		function2(d1, d2);
		System.out.println(d1.a);
		System.out.println(d2.a);
	}

	private static void function(Demo d1, Demo d2) {
		int a;
		a = d1.a;
		d1.a = d2.a;
		d2.a = a;
	}

	private static void function2(Demo d1, Demo d2) {
		Demo temp;
		temp = d1;
		d1 = d2;
		d2 = temp;
	}

	private static void swap(int i, int j) {
		int temp = i;
		j = i;
		j = temp;

	}

}
