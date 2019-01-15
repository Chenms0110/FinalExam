package 复习;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

// Java FX程序的一般结构，就是extends Application
public class Hello extends Application{

	// Java FX程序的一般结构，有个start，主函数中args.launch
	@Override void start(Stage primaryStage) {
		Button btOK = new Button("OK");
		Scene scene = new Scene (btOK,200,250);
		primaryStage.setTitle();
		primaryStagesetScene(scene);
		primaryStage.show();
	}
	
	// Hello类由s1和s2两个对象构成，这就是类的组合。
	String s1 = "Hello";
	ArrayList<Double> s2;
	
	
	// main函数参数的用法，java只有一个参数（字符串数组）
	public static void main(String[] args) {
		byte[] c = new byte[10];
		System.out.println(c.length);
		int[] x = {1,(int)3.1,5,7};
		System.out.println(x.length);
		print(x);
		
		// final用法
		final int z = 0;
		
		// String用法
		String s = "Hello";
		s == "World";
		s.compareTo("Hello");
		s.equals("Hello");
		
		// 抽象类不能直接实例化
		A a = new A();
		
		// Thread下面三种写法完全一样
		new Thread(new Hello1()).start();
		new Thread(new Runnable() {
			@Override
			public void run(){
				System.out.println("Hello");
			}
		}).start();
		// Lambda表达式用法
		new Thread(()-> {
			System.out.println("Hello");
		}).start();
	}
	
	// GUI事件处理用法
	class EnlargeHandler implements EventHandler<ActionEvent>{
		@Override
		public void run() {
			
		}
	}
	
	// Inner Class ， 内部类可以有访问属性，访问直接用“.”
	private class Hello1 implements Runnable{
		@Override
		public void run() {
			for(int i=0;i<10;i++) {
				System.out.println("Hello World");
			}
		}
	}
	
	// final用法
	final private int print(int[] y) {
		// 基于范围的for循环用法
		for(int x:y) {
			System.out.println(x);
		}
		return 0;
	}
}

// 抽象类的定义方法：抽象的方法要最前面表示abstract，在类的class之前要加abstract
abstract class A{
	public int i;
	protected int j;
	private int k;
	abstract public int f();
	public void g() {}
}

class B extends A{
	// i? j? k?
	// private int g()? 不可以，不能改变访问控制属性
	
	// 继承抽象类方法
	@Override 
	public int f() {
		return 0;
	}
}

class Demo{
	// try-catch-finally的用法，抛出异常声明的写法
	public void f() throws Exception{
		// 扔出来了异常
		throw(new Exception("This is a test"));
	}
	
	public void g() {
		// try-with-resource用法，可以不手动关闭文件流。
		try(FileInputStream fis = new FileInputStream("C:/test.txt")){
			System.out.println(fis.read());
			
			// 不能单独存在，必须绑定在已有的流上
			DataInputStream dis = new DataInputStream();
			// 不能单独存在，必须绑定在已有的流上
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			// 对象输入流与已有流的绑定实例
			ServerSocket ss = new ServerSocket(8000);
			Socket socket = ss.accept();
			InputStream in = socket.getInputStream();
			ObjectInputStream ois2 = new ObjectInputStream(in);
			
			// 自己研究一下下面自带的函数
			// InetAddress a = InetAddress.
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		/*
		// 不用try-with-resource的整体流程，很恶心。
		FileInputStream fis = new FileInputStream("C:/test.txt");
		try {
			f();
			System.out.println(fis.read());
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		*/
	}
	
}














