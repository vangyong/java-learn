package cn.segema.learn.interview.thread;

public class RunnableTest implements Runnable {
	private String taskName;

	public RunnableTest(final String taskName) {
		this.taskName = taskName;
	}

	public void run() {
		System.out.println("Inside " + taskName);
		throw new RuntimeException("RuntimeException from inside " + taskName);
	}
}
