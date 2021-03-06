package cn.segema.learn.interview.thread;

/**
 * @description 把指定的线程加入到当前线程
 * 如:在线程B中调用了线程A的Join()方法，直到线程A执行完毕后，才会继续执行线程B
 * @author wangyong
 * @createDate 2020/08/30
 */
public class ThreadJoinDemo {

	public static void main(String[] args) throws InterruptedException {
		// 1
		Thread userInfoThread = new Thread(new Runnable() {
			public void run() {
				System.out.println("保存用户信息到用户表开始...");
				try {
					Thread.sleep(1000 * 3);
					System.out.println("1 存用户信息到\"用户\"表 成功");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("保存用户信息到用户表结束...");
			}
		});
		userInfoThread.start();
		System.out.println(userInfoThread.getName());
		System.out.println("用户基本信息线程关闭");
		Thread.interrupted();

		// 2
		Thread attachmentThread = new Thread(new Runnable() {
			public void run() {
				System.out.println("保存附件信息到附件表开始...");
				try {
					Thread.sleep(1000 * 5);
					System.out.println("2 存用户上传附件到\"附件\"表 成功");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("保存附件信息到附件表结束...");
			}
		});
		attachmentThread.start();
		attachmentThread.join();
		System.out.println(attachmentThread.getName());
		System.out.println("附件信息线程关闭");
		Thread.interrupted();

	}
}
