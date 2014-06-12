package com.thankslife.com;

import java.util.HashMap;

public class TestString implements Runnable {
	public static final HashMap<String, Object> hm = new HashMap<String, Object>();
	static {
		User user = new User();
		user.setName("test1");
		user.setAge("test1");
		user.setSex("test1");
		hm.put("hello", user);

	}

	public void getObject() {
		String name = Thread.currentThread().getName();
		User u =(User)hm.get("hello");
		System.out.println("threadName:"+name+"    user:"+u.getName());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		User user = new User();
		user.setName(name);
		user.setAge(name);
		user.setSex(name);
		hm.put("hello", user);
		System.out.println("threadName:"+name+"   user:"+u.getName()+"  hm:"+((User)hm.get("hello")).getName());
	}

	@Override
	public void run() {
		getObject();

	}

	public static void main(String[] args) {
		for(int i=0;i<100;i++){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			new Thread(new TestString()).start();
		}
	}

}
