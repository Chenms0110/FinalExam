package ��ϰ;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

// Java FX�����һ��ṹ������extends Application
public class Hello extends Application{

	// Java FX�����һ��ṹ���и�start����������args.launch
	@Override void start(Stage primaryStage) {
		Button btOK = new Button("OK");
		Scene scene = new Scene (btOK,200,250);
		primaryStage.setTitle();
		primaryStagesetScene(scene);
		primaryStage.show();
	}
	
	// Hello����s1��s2�������󹹳ɣ�����������ϡ�
	String s1 = "Hello";
	ArrayList<Double> s2;
	
	
	// main�����������÷���javaֻ��һ���������ַ������飩
	public static void main(String[] args) {
		byte[] c = new byte[10];
		System.out.println(c.length);
		int[] x = {1,(int)3.1,5,7};
		System.out.println(x.length);
		print(x);
		
		// final�÷�
		final int z = 0;
		
		// String�÷�
		String s = "Hello";
		s == "World";
		s.compareTo("Hello");
		s.equals("Hello");
		
		// �����಻��ֱ��ʵ����
		A a = new A();
		
		// Thread��������д����ȫһ��
		new Thread(new Hello1()).start();
		new Thread(new Runnable() {
			@Override
			public void run(){
				System.out.println("Hello");
			}
		}).start();
		// Lambda���ʽ�÷�
		new Thread(()-> {
			System.out.println("Hello");
		}).start();
	}
	
	// GUI�¼������÷�
	class EnlargeHandler implements EventHandler<ActionEvent>{
		@Override
		public void run() {
			
		}
	}
	
	// Inner Class �� �ڲ�������з������ԣ�����ֱ���á�.��
	private class Hello1 implements Runnable{
		@Override
		public void run() {
			for(int i=0;i<10;i++) {
				System.out.println("Hello World");
			}
		}
	}
	
	// final�÷�
	final private int print(int[] y) {
		// ���ڷ�Χ��forѭ���÷�
		for(int x:y) {
			System.out.println(x);
		}
		return 0;
	}
}

// ������Ķ��巽��������ķ���Ҫ��ǰ���ʾabstract�������class֮ǰҪ��abstract
abstract class A{
	public int i;
	protected int j;
	private int k;
	abstract public int f();
	public void g() {}
}

class B extends A{
	// i? j? k?
	// private int g()? �����ԣ����ܸı���ʿ�������
	
	// �̳г����෽��
	@Override 
	public int f() {
		return 0;
	}
}

class Demo{
	// try-catch-finally���÷����׳��쳣������д��
	public void f() throws Exception{
		// �ӳ������쳣
		throw(new Exception("This is a test"));
	}
	
	public void g() {
		// try-with-resource�÷������Բ��ֶ��ر��ļ�����
		try(FileInputStream fis = new FileInputStream("C:/test.txt")){
			System.out.println(fis.read());
			
			// ���ܵ������ڣ�����������е�����
			DataInputStream dis = new DataInputStream();
			// ���ܵ������ڣ�����������е�����
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			// �������������������İ�ʵ��
			ServerSocket ss = new ServerSocket(8000);
			Socket socket = ss.accept();
			InputStream in = socket.getInputStream();
			ObjectInputStream ois2 = new ObjectInputStream(in);
			
			// �Լ��о�һ�������Դ��ĺ���
			// InetAddress a = InetAddress.
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		/*
		// ����try-with-resource���������̣��ܶ��ġ�
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














