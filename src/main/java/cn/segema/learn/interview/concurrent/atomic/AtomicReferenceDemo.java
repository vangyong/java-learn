package cn.segema.learn.interview.concurrent.atomic;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceDemo {
	// 普通引用
	private static Person person;
	// 原子性引用
	private static AtomicReference<Person> atomicReferencePerson;

	public static void main(String[] args) throws InterruptedException {
		person = new Person("Tom", 18);
		atomicReferencePerson = new AtomicReference<Person>(person);

		System.out.println("Atomic Person is " + atomicReferencePerson.get().toString());

		Thread t1 = new Thread(new Task1());
		Thread t2 = new Thread(new Task2());

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		System.out.println("Now Atomic Person is " + atomicReferencePerson.get().toString());
	}

	static class Task1 implements Runnable {
		public void run() {
			atomicReferencePerson.getAndSet(new Person("Tom1", atomicReferencePerson.get().getAge() + 1));
			System.out.println("Thread1 Atomic References " + atomicReferencePerson.get().toString());
		}
	}

	static class Task2 implements Runnable {
		public void run() {
			atomicReferencePerson.getAndSet(new Person("Tom2", atomicReferencePerson.get().getAge() + 2));
			System.out.println("Thread2 Atomic References " + atomicReferencePerson.get().toString());
		}
	}

}
