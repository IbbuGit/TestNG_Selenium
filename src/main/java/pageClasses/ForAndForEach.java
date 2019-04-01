package pageClasses;

public class ForAndForEach {
	public static void main(String args[])
	{ 
		ForAndForEach f=new ForAndForEach();
		f.forLoopAndforEachLoop_Int();
		f.forLoopAndforEachLoop_String();
		f.forLoopAndforEachLoop_Float();

	}
	public int[] numbers()
	{
		int a[]= {13,46,98,24,78};
		return a;
	}
	public String[] alpha()
	{
		String mob[]= {"apple","iphone","mi max","samsung","lenovo"};
		return mob;

	}
	public float[] floatnumbers()
	{
		float fl[]= {12.23f,34.67f,1.765f,5.2345f,1.987f,23.4f};
		return fl;
	}
	public void forLoopAndforEachLoop_Int()
	{
		int b[]=numbers();
		System.out.println("the values are");
		for(int i=0;i<5;i++)
		{
			System.out.println(b[i]);
		}
		System.out.println("the values are ");
		for(int a1:b)
		{
			System.out.println(a1);
		}

	}
	public void forLoopAndforEachLoop_String()
	{
		String mob1[]=alpha();
		System.out.println("the mobiles using for loop" );
		for(int i=0;i<mob1.length;i++)
		{
			System.out.println(mob1[i]);
		}
		System.out.println("the mobile using foreach loop");
		for(String m:mob1)
		{
			System.out.println(m);
		}
	}
	public void forLoopAndforEachLoop_Float()
	{
		float fl[]=floatnumbers();
		System.out.println("the float valuesof mobile are ");
		for(int i=0;i<fl.length;i++)
		{
			System.out.println(fl[i]);
		}
		System.out.println("the float values using foreach loop ");
		for(float F:fl)
		{
			System.out.println(F);
		}
	}

}
